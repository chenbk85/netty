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
package io.netty.example.http.upload;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.logging.InternalLogger;
import io.netty.logging.InternalLoggerFactory;
import io.netty.util.CharsetUtil;

/**
 * Handler that just dumps the contents of the response from the server
 */
public class HttpUploadClientHandler extends ChannelInboundMessageHandlerAdapter<Object> {

    private static final InternalLogger logger = InternalLoggerFactory.getInstance(HttpUploadClientHandler.class);

    private boolean readingChunks;

    @Override
    public void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;

            logger.info("STATUS: " + response.getStatus());
            logger.info("VERSION: " + response.getProtocolVersion());

            if (!response.getHeaderNames().isEmpty()) {
                for (String name : response.getHeaderNames()) {
                    for (String value : response.getHeaders(name)) {
                        logger.info("HEADER: " + name + " = " + value);
                    }
                }
            }

            if (response.getStatus().getCode() == 200 && HttpHeaders.isTransferEncodingChunked(response)) {
                readingChunks = true;
                logger.info("CHUNKED CONTENT {");
            } else {
                logger.info("CONTENT {");
            }
        }
        if (msg instanceof HttpContent) {
            HttpContent chunk = (HttpContent) msg;
            logger.info(chunk.getContent().toString(CharsetUtil.UTF_8));

            if (chunk instanceof LastHttpContent) {
                if (readingChunks) {
                    logger.info("} END OF CHUNKED CONTENT");
                } else {
                    logger.info("} END OF CONTENT");
                }
                readingChunks = false;
            } else {
                logger.info(chunk.getContent().toString(CharsetUtil.UTF_8));
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
