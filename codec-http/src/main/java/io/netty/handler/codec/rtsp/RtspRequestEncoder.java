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
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;

/**
 * Encodes an RTSP request represented in {@link io.netty.handler.codec.http.HttpRequest} into
 * a {@link ByteBuf}.

 */
public class RtspRequestEncoder extends RtspObjectEncoder<HttpRequest> {

    @Override
    protected void encodeInitialLine(ByteBuf buf, HttpRequest request)
            throws Exception {
        buf.writeBytes(request.getMethod().toString().getBytes(CharsetUtil.US_ASCII));
        buf.writeByte((byte) ' ');
        buf.writeBytes(request.getUri().getBytes(CharsetUtil.UTF_8));
        buf.writeByte((byte) ' ');
        buf.writeBytes(request.getProtocolVersion().toString().getBytes(CharsetUtil.US_ASCII));
        buf.writeByte((byte) '\r');
        buf.writeByte((byte) '\n');
    }
}
