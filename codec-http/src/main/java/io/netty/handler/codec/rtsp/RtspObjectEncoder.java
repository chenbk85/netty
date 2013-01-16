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
package io.netty.handler.codec.rtsp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectEncoder;

/**
 * Encodes an RTSP message represented in {@link io.netty.handler.codec.http.HttpMessage} into
 * a {@link ByteBuf}.

 *
 * @apiviz.landmark
 */
@Sharable
public abstract class RtspObjectEncoder<H extends HttpMessage> extends HttpObjectEncoder<H> {

    /**
     * Creates a new instance.
     */
    protected RtspObjectEncoder() {
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg,
            ByteBuf out) throws Exception {
        // Ignore unrelated message types such as HttpChunk.
        if (!(msg instanceof HttpMessage)) {
            throw new UnsupportedMessageTypeException(msg, HttpMessage.class);
        }

        super.encode(ctx, msg, out);
    }
}
