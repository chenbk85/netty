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


/**
 * An interface that defines a HTTP message, providing common properties for
 * {@link HttpRequest} and {@link HttpResponse}.
 * @see HttpResponse
 * @see HttpRequest
 * @see HttpHeaders
 *
 * @apiviz.landmark
 * @apiviz.has io.netty.handler.codec.http.HttpChunk oneway - - is followed by
 */
public interface HttpMessage extends HttpObject {

    /**
     * Returns the protocol version of this {@link HttpMessage}
     *
     * @return The protocol version
     */
    HttpVersion getProtocolVersion();

    /**
     * Sets the protocol version of this {@link HttpMessage}
     *
     * @param version The version to set
     */
    void setProtocolVersion(HttpVersion version);

    HttpHeaders headers();
}
