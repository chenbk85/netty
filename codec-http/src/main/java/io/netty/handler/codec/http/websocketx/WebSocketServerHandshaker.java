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
package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpRequestWithEntityWithEntity;
import io.netty.util.internal.StringUtil;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Base class for server side web socket opening and closing handshakes
 */
public abstract class WebSocketServerHandshaker {

    private static final String[] EMPTY_ARRAY = new String[0];

    private final String webSocketUrl;

    private final String[] subprotocols;

    private final WebSocketVersion version;

    private final int maxFramePayloadLength;

    private String selectedSubprotocol;

    /**
     * Constructor specifying the destination web socket location
     *
     * @param version
     *            the protocol version
     * @param webSocketUrl
     *            URL for web socket communications. e.g "ws://myhost.com/mypath". Subsequent web socket frames will be
     *            sent to this URL.
     * @param subprotocols
     *            CSV of supported protocols. Null if sub protocols not supported.
     * @param maxFramePayloadLength
     *            Maximum length of a frame's payload
     */
    protected WebSocketServerHandshaker(
            WebSocketVersion version, String webSocketUrl, String subprotocols,
            int maxFramePayloadLength) {
        this.version = version;
        this.webSocketUrl = webSocketUrl;
        if (subprotocols != null) {
            String[] subprotocolArray = StringUtil.split(subprotocols, ',');
            for (int i = 0; i < subprotocolArray.length; i++) {
                subprotocolArray[i] = subprotocolArray[i].trim();
            }
            this.subprotocols = subprotocolArray;
        } else {
            this.subprotocols = EMPTY_ARRAY;
        }
        this.maxFramePayloadLength = maxFramePayloadLength;
    }

    /**
     * Returns the URL of the web socket
     */
    public String getWebSocketUrl() {
        return webSocketUrl;
    }

    /**
     * Returns the CSV of supported sub protocols
     */
    public Set<String> getSubprotocols() {
        Set<String> ret = new LinkedHashSet<String>();
        Collections.addAll(ret, subprotocols);
        return ret;
    }

    /**
     * Returns the version of the specification being supported
     */
    public WebSocketVersion getVersion() {
        return version;
    }

    /**
     * Gets the maximum length for any frame's payload.
     *
     * @return The maximum length for a frame's payload
     */
    public int getMaxFramePayloadLength() {
        return maxFramePayloadLength;
    }

    /**
     * Performs the opening handshake
     *
     * @param channel
     *            Channel
     * @param req
     *            HTTP Request
     */
    public ChannelFuture handshake(Channel channel, HttpRequestWithEntityWithEntity req) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return handshake(channel, req, channel.newPromise());
    }

    /**
     * Performs the opening handshake
     *
     * @param channel
     *            Channel
     * @param req
     *            HTTP Request
     * @param promise
     *            the {@link ChannelPromise} to be notified when the opening handshake is done
     */
    public abstract ChannelFuture handshake(Channel channel, HttpRequestWithEntityWithEntity req, ChannelPromise promise);

    /**
     * Performs the closing handshake
     *
     * @param channel
     *            Channel
     * @param frame
     *            Closing Frame that was received
     */
    public ChannelFuture close(Channel channel, CloseWebSocketFrame frame) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return close(channel, frame, channel.newPromise());
    }

    /**
     * Performs the closing handshake
     *
     * @param channel
     *            Channel
     * @param frame
     *            Closing Frame that was received
     * @param promise
     *            the {@link ChannelPromise} to be notified when the closing handshake is done
     */
    public abstract ChannelFuture close(Channel channel, CloseWebSocketFrame frame, ChannelPromise promise);

    /**
     * Selects the first matching supported sub protocol
     *
     * @param requestedSubprotocols
     *            CSV of protocols to be supported. e.g. "chat, superchat"
     * @return First matching supported sub protocol. Null if not found.
     */
    protected String selectSubprotocol(String requestedSubprotocols) {
        if (requestedSubprotocols == null || subprotocols.length == 0) {
            return null;
        }

        String[] requestedSubprotocolArray = StringUtil.split(requestedSubprotocols, ',');
        for (String p: requestedSubprotocolArray) {
            String requestedSubprotocol = p.trim();

            for (String supportedSubprotocol: subprotocols) {
                if (requestedSubprotocol.equals(supportedSubprotocol)) {
                    return requestedSubprotocol;
                }
            }
        }

        // No match found
        return null;
    }

    /**
     * Returns the selected subprotocol. Null if no subprotocol has been selected.
     * <p>
     * This is only available AFTER <tt>handshake()</tt> has been called.
     * </p>
     */
    public String getSelectedSubprotocol() {
        return selectedSubprotocol;
    }

    protected void setSelectedSubprotocol(String value) {
        selectedSubprotocol = value;
    }

}
