/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedByteChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.CharsetUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class HttpInvalidMessageTest {

    private final Random rnd = new Random();

    @Test
    public void testRequestWithBadInitialLine() throws Exception {
        EmbeddedByteChannel ch = new EmbeddedByteChannel(new HttpRequestDecoder());
        ch.writeInbound(Unpooled.copiedBuffer("GET / HTTP/1.0 with extra\r\n", CharsetUtil.UTF_8));
        HttpRequestHeader req = (HttpRequestHeader) ch.readInbound();
        DecoderResult dr = req.getDecoderResult();
        Assert.assertFalse(dr.isSuccess());
        Assert.assertFalse(dr.isPartialFailure());
        ensureInboundTrafficDiscarded(ch);
    }

    @Test
    public void testRequestWithBadHeader() throws Exception {
        EmbeddedByteChannel ch = new EmbeddedByteChannel(new HttpRequestDecoder());
        ch.writeInbound(Unpooled.copiedBuffer("GET /maybe-something HTTP/1.0\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("Good_Name: Good Value\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("Bad=Name: Bad Value\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("\r\n", CharsetUtil.UTF_8));
        HttpRequestHeader req = (HttpRequestHeader) ch.readInbound();
        DecoderResult dr = req.getDecoderResult();
        Assert.assertFalse(dr.isSuccess());
        Assert.assertTrue(dr.isPartialFailure());
        Assert.assertEquals("Good Value", req.getHeader("Good_Name"));
        Assert.assertEquals("/maybe-something", req.getUri());
        ensureInboundTrafficDiscarded(ch);
    }

    @Test
    public void testResponseWithBadInitialLine() throws Exception {
        EmbeddedByteChannel ch = new EmbeddedByteChannel(new HttpResponseDecoder());
        ch.writeInbound(Unpooled.copiedBuffer("HTTP/1.0 BAD_CODE Bad Server\r\n", CharsetUtil.UTF_8));
        HttpResponseHeader res = (HttpResponseHeader) ch.readInbound();
        DecoderResult dr = res.getDecoderResult();
        Assert.assertFalse(dr.isSuccess());
        Assert.assertFalse(dr.isPartialFailure());
        ensureInboundTrafficDiscarded(ch);
    }

    @Test
    public void testResponseWithBadHeader() throws Exception {
        EmbeddedByteChannel ch = new EmbeddedByteChannel(new HttpResponseDecoder());
        ch.writeInbound(Unpooled.copiedBuffer("HTTP/1.0 200 Maybe OK\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("Good_Name: Good Value\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("Bad=Name: Bad Value\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("\r\n", CharsetUtil.UTF_8));
        HttpResponseHeader res = (HttpResponseHeader) ch.readInbound();
        DecoderResult dr = res.getDecoderResult();
        Assert.assertFalse(dr.isSuccess());
        Assert.assertTrue(dr.isPartialFailure());
        Assert.assertEquals("Maybe OK", res.getStatus().getReasonPhrase());
        Assert.assertEquals("Good Value", res.getHeader("Good_Name"));
        ensureInboundTrafficDiscarded(ch);
    }

    @Test
    public void testBadChunk() throws Exception {
        EmbeddedByteChannel ch = new EmbeddedByteChannel(new HttpRequestDecoder());
        ch.writeInbound(Unpooled.copiedBuffer("GET / HTTP/1.0\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("Transfer-Encoding: chunked\r\n\r\n", CharsetUtil.UTF_8));
        ch.writeInbound(Unpooled.copiedBuffer("BAD_LENGTH\r\n", CharsetUtil.UTF_8));

        HttpRequestHeader req = (HttpRequestHeader) ch.readInbound();
        Assert.assertTrue(req.getDecoderResult().isSuccess());

        HttpContent chunk = (HttpContent) ch.readInbound();
        DecoderResult dr = chunk.getDecoderResult();
        Assert.assertFalse(dr.isSuccess());
        Assert.assertFalse(dr.isPartialFailure());
        ensureInboundTrafficDiscarded(ch);
    }

    private void ensureInboundTrafficDiscarded(EmbeddedByteChannel ch) {
        // Generate a lot of random traffic to ensure that it's discarded silently.
        byte[] data = new byte[1048576];
        rnd.nextBytes(data);

        ByteBuf buf = Unpooled.wrappedBuffer(data);
        for (int i = 0; i < 4096; i ++) {
            buf.setIndex(0, data.length);
            ch.writeInbound(buf);
            ch.checkException();
            Assert.assertNull(ch.readInbound());
        }
    }
}
