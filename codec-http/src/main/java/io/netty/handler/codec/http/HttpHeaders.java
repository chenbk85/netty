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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * Provides the constants for the standard HTTP header names and values and
 * commonly used utility methods that accesses an {@link HttpMessage}.
 * @apiviz.landmark
 * @apiviz.stereotype static
 */
public class HttpHeaders {

    /**
     * Standard and CORS HTTP header names.
     * For CORS headers, see
     * https://developer.mozilla.org/en-US/docs/HTTP_access_control
     *
     * @apiviz.stereotype static
     */
    public static final class Names {
        /**
         * {@code "Accept"}
         */
        public static final String ACCEPT = "Accept";
        /**
         * {@code "Accept-Charset"}
         */
        public static final String ACCEPT_CHARSET = "Accept-Charset";
        /**
         * {@code "Accept-Encoding"}
         */
        public static final String ACCEPT_ENCODING = "Accept-Encoding";
        /**
         * {@code "Accept-Language"}
         */
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        /**
         * {@code "Accept-Ranges"}
         */
        public static final String ACCEPT_RANGES = "Accept-Ranges";
        /**
         * {@code "Accept-Patch"}
         */
        public static final String ACCEPT_PATCH = "Accept-Patch";
        /**
         * {@code "Access-Control-Allow-Credentials"}
         */
        public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
        /**
         * {@code "Access-Control-Allow-Headers"}
         */
        public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
        /**
         * {@code "Access-Control-Allow-Methods"}
         */
        public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
        /**
         * {@code "Access-Control-Allow-Origin"}
         */
        public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        /**
         * {@code "Access-Control-Expose-Headers"}
         */
        public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
        /**
         * {@code "Access-Control-Max-Age"}
         */
        public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
        /**
         * {@code "Access-Control-Request-Headers"}
         */
        public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
        /**
         * {@code "Access-Control-Request-Method"}
         */
        public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
        /**
         * {@code "Age"}
         */
        public static final String AGE = "Age";
        /**
         * {@code "Allow"}
         */
        public static final String ALLOW = "Allow";
        /**
         * {@code "Authorization"}
         */
        public static final String AUTHORIZATION = "Authorization";
        /**
         * {@code "Cache-Control"}
         */
        public static final String CACHE_CONTROL = "Cache-Control";
        /**
         * {@code "Connection"}
         */
        public static final String CONNECTION = "Connection";
        /**
         * {@code "Content-Base"}
         */
        public static final String CONTENT_BASE = "Content-Base";
        /**
         * {@code "Content-Encoding"}
         */
        public static final String CONTENT_ENCODING = "Content-Encoding";
        /**
         * {@code "Content-Language"}
         */
        public static final String CONTENT_LANGUAGE = "Content-Language";
        /**
         * {@code "Content-Length"}
         */
        public static final String CONTENT_LENGTH = "Content-Length";
        /**
         * {@code "Content-Location"}
         */
        public static final String CONTENT_LOCATION = "Content-Location";
        /**
         * {@code "Content-Transfer-Encoding"}
         */
        public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
        /**
         * {@code "Content-MD5"}
         */
        public static final String CONTENT_MD5 = "Content-MD5";
        /**
         * {@code "Content-Range"}
         */
        public static final String CONTENT_RANGE = "Content-Range";
        /**
         * {@code "Content-Type"}
         */
        public static final String CONTENT_TYPE = "Content-Type";
        /**
         * {@code "Cookie"}
         */
        public static final String COOKIE = "Cookie";
        /**
         * {@code "Date"}
         */
        public static final String DATE = "Date";
        /**
         * {@code "ETag"}
         */
        public static final String ETAG = "ETag";
        /**
         * {@code "Expect"}
         */
        public static final String EXPECT = "Expect";
        /**
         * {@code "Expires"}
         */
        public static final String EXPIRES = "Expires";
        /**
         * {@code "From"}
         */
        public static final String FROM = "From";
        /**
         * {@code "Host"}
         */
        public static final String HOST = "Host";
        /**
         * {@code "If-Match"}
         */
        public static final String IF_MATCH = "If-Match";
        /**
         * {@code "If-Modified-Since"}
         */
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        /**
         * {@code "If-None-Match"}
         */
        public static final String IF_NONE_MATCH = "If-None-Match";
        /**
         * {@code "If-Range"}
         */
        public static final String IF_RANGE = "If-Range";
        /**
         * {@code "If-Unmodified-Since"}
         */
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        /**
         * {@code "Last-Modified"}
         */
        public static final String LAST_MODIFIED = "Last-Modified";
        /**
         * {@code "Location"}
         */
        public static final String LOCATION = "Location";
        /**
         * {@code "Max-Forwards"}
         */
        public static final String MAX_FORWARDS = "Max-Forwards";
        /**
         * {@code "Origin"}
         */
        public static final String ORIGIN = "Origin";
        /**
         * {@code "Pragma"}
         */
        public static final String PRAGMA = "Pragma";
        /**
         * {@code "Proxy-Authenticate"}
         */
        public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
        /**
         * {@code "Proxy-Authorization"}
         */
        public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
        /**
         * {@code "Range"}
         */
        public static final String RANGE = "Range";
        /**
         * {@code "Referer"}
         */
        public static final String REFERER = "Referer";
        /**
         * {@code "Retry-After"}
         */
        public static final String RETRY_AFTER = "Retry-After";
        /**
         * {@code "Sec-WebSocket-Key1"}
         */
        public static final String SEC_WEBSOCKET_KEY1 = "Sec-WebSocket-Key1";
        /**
         * {@code "Sec-WebSocket-Key2"}
         */
        public static final String SEC_WEBSOCKET_KEY2 = "Sec-WebSocket-Key2";
        /**
         * {@code "Sec-WebSocket-Location"}
         */
        public static final String SEC_WEBSOCKET_LOCATION = "Sec-WebSocket-Location";
        /**
         * {@code "Sec-WebSocket-Origin"}
         */
        public static final String SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin";
        /**
         * {@code "Sec-WebSocket-Protocol"}
         */
        public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
        /**
         * {@code "Sec-WebSocket-Version"}
         */
        public static final String SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
        /**
         * {@code "Sec-WebSocket-Key"}
         */
        public static final String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
        /**
         * {@code "Sec-WebSocket-Accept"}
         */
        public static final String SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
        /**
         * {@code "Server"}
         */
        public static final String SERVER = "Server";
        /**
         * {@code "Set-Cookie"}
         */
        public static final String SET_COOKIE = "Set-Cookie";
        /**
         * {@code "Set-Cookie2"}
         */
        public static final String SET_COOKIE2 = "Set-Cookie2";
        /**
         * {@code "TE"}
         */
        public static final String TE = "TE";
        /**
         * {@code "Trailer"}
         */
        public static final String TRAILER = "Trailer";
        /**
         * {@code "Transfer-Encoding"}
         */
        public static final String TRANSFER_ENCODING = "Transfer-Encoding";
        /**
         * {@code "Upgrade"}
         */
        public static final String UPGRADE = "Upgrade";
        /**
         * {@code "User-Agent"}
         */
        public static final String USER_AGENT = "User-Agent";
        /**
         * {@code "Vary"}
         */
        public static final String VARY = "Vary";
        /**
         * {@code "Via"}
         */
        public static final String VIA = "Via";
        /**
         * {@code "Warning"}
         */
        public static final String WARNING = "Warning";
        /**
         * {@code "WebSocket-Location"}
         */
        public static final String WEBSOCKET_LOCATION = "WebSocket-Location";
        /**
         * {@code "WebSocket-Origin"}
         */
        public static final String WEBSOCKET_ORIGIN = "WebSocket-Origin";
        /**
         * {@code "WebSocket-Protocol"}
         */
        public static final String WEBSOCKET_PROTOCOL = "WebSocket-Protocol";
        /**
         * {@code "WWW-Authenticate"}
         */
        public static final String WWW_AUTHENTICATE = "WWW-Authenticate";

        private Names() {
        }
    }

    /**
     * Standard HTTP header values.
     * @apiviz.stereotype static
     */
    public static final class Values {
        /**
         * {@code "application/x-www-form-urlencoded"}
         */
         public static final String APPLICATION_X_WWW_FORM_URLENCODED =
             "application/x-www-form-urlencoded";
        /**
         * {@code "base64"}
         */
        public static final String BASE64 = "base64";
        /**
         * {@code "binary"}
         */
        public static final String BINARY = "binary";
        /**
         * {@code "boundary"}
         */
        public static final String BOUNDARY = "boundary";
        /**
         * {@code "bytes"}
         */
        public static final String BYTES = "bytes";
        /**
         * {@code "charset"}
         */
        public static final String CHARSET = "charset";
        /**
         * {@code "chunked"}
         */
        public static final String CHUNKED = "chunked";
        /**
         * {@code "close"}
         */
        public static final String CLOSE = "close";
        /**
         * {@code "compress"}
         */
        public static final String COMPRESS = "compress";
        /**
         * {@code "100-continue"}
         */
        public static final String CONTINUE =  "100-continue";
        /**
         * {@code "deflate"}
         */
        public static final String DEFLATE = "deflate";
        /**
         * {@code "gzip"}
         */
        public static final String GZIP = "gzip";
        /**
         * {@code "identity"}
         */
        public static final String IDENTITY = "identity";
        /**
         * {@code "keep-alive"}
         */
        public static final String KEEP_ALIVE = "keep-alive";
        /**
         * {@code "max-age"}
         */
        public static final String MAX_AGE = "max-age";
        /**
         * {@code "max-stale"}
         */
        public static final String MAX_STALE = "max-stale";
        /**
         * {@code "min-fresh"}
         */
        public static final String MIN_FRESH = "min-fresh";
        /**
         * {@code "multipart/form-data"}
         */
        public static final String MULTIPART_FORM_DATA = "multipart/form-data";
        /**
         * {@code "must-revalidate"}
         */
        public static final String MUST_REVALIDATE = "must-revalidate";
        /**
         * {@code "no-cache"}
         */
        public static final String NO_CACHE = "no-cache";
        /**
         * {@code "no-store"}
         */
        public static final String NO_STORE = "no-store";
        /**
         * {@code "no-transform"}
         */
        public static final String NO_TRANSFORM = "no-transform";
        /**
         * {@code "none"}
         */
        public static final String NONE = "none";
        /**
         * {@code "only-if-cached"}
         */
        public static final String ONLY_IF_CACHED = "only-if-cached";
        /**
         * {@code "private"}
         */
        public static final String PRIVATE = "private";
        /**
         * {@code "proxy-revalidate"}
         */
        public static final String PROXY_REVALIDATE = "proxy-revalidate";
        /**
         * {@code "public"}
         */
        public static final String PUBLIC = "public";
        /**
         * {@code "quoted-printable"}
         */
        public static final String QUOTED_PRINTABLE = "quoted-printable";
        /**
         * {@code "s-maxage"}
         */
        public static final String S_MAXAGE = "s-maxage";
        /**
         * {@code "trailers"}
         */
        public static final String TRAILERS = "trailers";
        /**
         * {@code "Upgrade"}
         */
        public static final String UPGRADE = "Upgrade";
        /**
         * {@code "WebSocket"}
         */
        public static final String WEBSOCKET = "WebSocket";

        private Values() {
        }
    }

    /**
     * Returns {@code true} if and only if the connection can remain open and
     * thus 'kept alive'.  This methods respects the value of the
     * {@code "Connection"} header first and then the return value of
     * {@link HttpVersion#isKeepAliveDefault()}.
     */
    public static boolean isKeepAlive(HttpMessage message) {
        String connection = message.getHeader(Names.CONNECTION);
        if (Values.CLOSE.equalsIgnoreCase(connection)) {
            return false;
        }

        if (message.getProtocolVersion().isKeepAliveDefault()) {
            return !Values.CLOSE.equalsIgnoreCase(connection);
        } else {
            return Values.KEEP_ALIVE.equalsIgnoreCase(connection);
        }
    }

    /**
     * Sets the value of the {@code "Connection"} header depending on the
     * protocol version of the specified message.  This method sets or removes
     * the {@code "Connection"} header depending on what the default keep alive
     * mode of the message's protocol version is, as specified by
     * {@link HttpVersion#isKeepAliveDefault()}.
     * <ul>
     * <li>If the connection is kept alive by default:
     *     <ul>
     *     <li>set to {@code "close"} if {@code keepAlive} is {@code false}.</li>
     *     <li>remove otherwise.</li>
     *     </ul></li>
     * <li>If the connection is closed by default:
     *     <ul>
     *     <li>set to {@code "keep-alive"} if {@code keepAlive} is {@code true}.</li>
     *     <li>remove otherwise.</li>
     *     </ul></li>
     * </ul>
     */
    public static void setKeepAlive(HttpMessage message, boolean keepAlive) {
        if (message.getProtocolVersion().isKeepAliveDefault()) {
            if (keepAlive) {
                message.removeHeader(Names.CONNECTION);
            } else {
                message.setHeader(Names.CONNECTION, Values.CLOSE);
            }
        } else {
            if (keepAlive) {
                message.setHeader(Names.CONNECTION, Values.KEEP_ALIVE);
            } else {
                message.removeHeader(Names.CONNECTION);
            }
        }
    }

    /**
     * Returns the header value with the specified header name.  If there are
     * more than one header value for the specified header name, the first
     * value is returned.
     *
     * @return the header value or {@code null} if there is no such header
     */
    public static String getHeader(HttpMessage message, String name) {
        return message.getHeader(name);
    }

    /**
     * Returns the header value with the specified header name.  If there are
     * more than one header value for the specified header name, the first
     * value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header
     */
    public static String getHeader(HttpMessage message, String name, String defaultValue) {
        String value = message.getHeader(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Sets a new header with the specified name and value.  If there is an
     * existing header with the same name, the existing header is removed.
     * If the specified value is not a {@link String}, it is converted into a
     * {@link String} by {@link Object#toString()}, except for {@link Date}
     * and {@link Calendar} which are formatted to the date format defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     */
    public static void setHeader(HttpMessage message, String name, Object value) {
        message.setHeader(name, value);
    }

    /**
     * Sets a new header with the specified name and values.  If there is an
     * existing header with the same name, the existing header is removed.
     * This method can be represented approximately as the following code:
     * <pre>
     * removeHeader(message, name);
     * for (Object v: values) {
     *     if (v == null) {
     *         break;
     *     }
     *     addHeader(message, name, v);
     * }
     * </pre>
     */
    public static void setHeader(HttpMessage message, String name, Iterable<?> values) {
        message.setHeader(name, values);
    }

    /**
     * Adds a new header with the specified name and value.
     * If the specified value is not a {@link String}, it is converted into a
     * {@link String} by {@link Object#toString()}, except for {@link Date}
     * and {@link Calendar} which are formatted to the date format defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     */
    public static void addHeader(HttpMessage message, String name, Object value) {
        message.addHeader(name, value);
    }

    /**
     * Removes the header with the specified name.
     */
    public static void removeHeader(HttpMessage message, String name) {
        message.removeHeader(name);
    }

    /**
     * Removes all headers from the specified message.
     */
    public static void clearHeaders(HttpMessage message) {
        message.clearHeaders();
    }

    /**
     * Returns the integer header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value
     * @throws NumberFormatException
     *         if there is no such header or the header value is not a number
     */
    public static int getIntHeader(HttpMessage message, String name) {
        String value = getHeader(message, name);
        if (value == null) {
            throw new NumberFormatException("header not found: " + name);
        }
        return Integer.parseInt(value);
    }

    /**
     * Returns the integer header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header or the header value is not a number
     */
    public static int getIntHeader(HttpMessage message, String name, int defaultValue) {
        String value = getHeader(message, name);
        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Sets a new integer header with the specified name and value.  If there
     * is an existing header with the same name, the existing header is removed.
     */
    public static void setIntHeader(HttpMessage message, String name, int value) {
        message.setHeader(name, value);
    }

    /**
     * Sets a new integer header with the specified name and values.  If there
     * is an existing header with the same name, the existing header is removed.
     */
    public static void setIntHeader(HttpMessage message, String name, Iterable<Integer> values) {
        message.setHeader(name, values);
    }

    /**
     * Adds a new integer header with the specified name and value.
     */
    public static void addIntHeader(HttpMessage message, String name, int value) {
        message.addHeader(name, value);
    }

    /**
     * Returns the date header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value
     * @throws ParseException
     *         if there is no such header or the header value is not a formatted date
     */
    public static Date getDateHeader(HttpMessage message, String name) throws ParseException {
        String value = getHeader(message, name);
        if (value == null) {
            throw new ParseException("header not found: " + name, 0);
        }
        return new HttpHeaderDateFormat().parse(value);
    }

    /**
     * Returns the date header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header or the header value is not a formatted date
     */
    public static Date getDateHeader(HttpMessage message, String name, Date defaultValue) {
        final String value = getHeader(message, name);
        if (value == null) {
            return defaultValue;
        }

        try {
            return new HttpHeaderDateFormat().parse(value);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

    /**
     * Sets a new date header with the specified name and value.  If there
     * is an existing header with the same name, the existing header is removed.
     * The specified value is formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void setDateHeader(HttpMessage message, String name, Date value) {
        if (value != null) {
            message.setHeader(name, new HttpHeaderDateFormat().format(value));
        } else {
            message.setHeader(name, null);
        }
    }

    /**
     * Sets a new date header with the specified name and values.  If there
     * is an existing header with the same name, the existing header is removed.
     * The specified values are formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void setDateHeader(HttpMessage message, String name, Iterable<Date> values) {
        message.setHeader(name, values);
    }

    /**
     * Adds a new date header with the specified name and value.  The specified
     * value is formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void addDateHeader(HttpMessage message, String name, Date value) {
        message.addHeader(name, value);
    }

    /**
     * Returns the length of the content.  Please note that this value is
     * not retrieved from {@link HttpContent#getContent()} but from the
     * {@code "Content-Length"} header, and thus they are independent from each
     * other.
     *
     * @return the content length
     *
     * @throws NumberFormatException
     *         if the message does not have the {@code "Content-Length"} header
     *         or its value is not a number
     */
    public static long getContentLength(HttpMessage message) {
        String value = getHeader(message, Names.CONTENT_LENGTH);
        if (value != null) {
            return Long.parseLong(value);
        }

        // We know the content length if it's a Web Socket message even if
        // Content-Length header is missing.
        long webSocketContentLength = getWebSocketContentLength(message);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }

        // Otherwise we don't.
        throw new NumberFormatException("header not found: " + Names.CONTENT_LENGTH);
    }

    /**
     * Returns the length of the content.  Please note that this value is
     * not retrieved from {@link HttpContent#getContent()} but from the
     * {@code "Content-Length"} header, and thus they are independent from each
     * other.
     *
     * @return the content length or {@code defaultValue} if this message does
     *         not have the {@code "Content-Length"} header or its value is not
     *         a number
     */
    public static long getContentLength(HttpMessage message, long defaultValue) {
        String contentLength = message.getHeader(Names.CONTENT_LENGTH);
        if (contentLength != null) {
            try {
                return Long.parseLong(contentLength);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }

        // We know the content length if it's a Web Socket message even if
        // Content-Length header is missing.
        long webSocketContentLength = getWebSocketContentLength(message);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }

        // Otherwise we don't.
        return defaultValue;
    }

    /**
     * Returns the content length of the specified web socket message.  If the
     * specified message is not a web socket message, {@code -1} is returned.
     */
    private static int getWebSocketContentLength(HttpMessage message) {
        // WebSockset messages have constant content-lengths.
        if (message instanceof HttpRequest) {
            HttpRequest req = (HttpRequest) message;
            if (HttpMethod.GET.equals(req.getMethod()) &&
                req.containsHeader(Names.SEC_WEBSOCKET_KEY1) &&
                req.containsHeader(Names.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
        } else if (message instanceof HttpResponse) {
            HttpResponse res = (HttpResponse) message;
            if (res.getStatus().getCode() == 101 &&
                res.containsHeader(Names.SEC_WEBSOCKET_ORIGIN) &&
                res.containsHeader(Names.SEC_WEBSOCKET_LOCATION)) {
                return 16;
            }
        }

        // Not a web socket message
        return -1;
    }

    /**
     * Sets the {@code "Content-Length"} header.
     */
    public static void setContentLength(HttpMessage message, long length) {
        message.setHeader(Names.CONTENT_LENGTH, length);
    }

    /**
     * Returns the value of the {@code "Host"} header.
     */
    public static String getHost(HttpMessage message) {
        return message.getHeader(Names.HOST);
    }

    /**
     * Returns the value of the {@code "Host"} header.  If there is no such
     * header, the {@code defaultValue} is returned.
     */
    public static String getHost(HttpMessage message, String defaultValue) {
        return getHeader(message, Names.HOST, defaultValue);
    }

    /**
     * Sets the {@code "Host"} header.
     */
    public static void setHost(HttpMessage message, String value) {
        message.setHeader(Names.HOST, value);
    }

    /**
     * Returns the value of the {@code "Date"} header.
     *
     * @throws ParseException
     *         if there is no such header or the header value is not a formatted date
     */
    public static Date getDate(HttpMessage message) throws ParseException {
        return getDateHeader(message, Names.DATE);
    }

    /**
     * Returns the value of the {@code "Date"} header. If there is no such
     * header or the header is not a formatted date, the {@code defaultValue}
     * is returned.
     */
    public static Date getDate(HttpMessage message, Date defaultValue) {
        return getDateHeader(message, Names.DATE, defaultValue);
    }

    /**
     * Sets the {@code "Date"} header.
     */
    public static void setDate(HttpMessage message, Date value) {
        if (value != null) {
            message.setHeader(Names.DATE, new HttpHeaderDateFormat().format(value));
        } else {
            message.setHeader(Names.DATE, null);
        }
    }

    /**
     * Returns {@code true} if and only if the specified message contains the
     * {@code "Expect: 100-continue"} header.
     */
    public static boolean is100ContinueExpected(HttpMessage message) {
        // Expect: 100-continue is for requests only.
        if (!(message instanceof HttpRequest)) {
            return false;
        }

        // It works only on HTTP/1.1 or later.
        if (message.getProtocolVersion().compareTo(HttpVersion.HTTP_1_1) < 0) {
            return false;
        }

        // In most cases, there will be one or zero 'Expect' header.
        String value = message.getHeader(Names.EXPECT);
        if (value == null) {
            return false;
        }
        if (Values.CONTINUE.equalsIgnoreCase(value)) {
            return true;
        }

        // Multiple 'Expect' headers.  Search through them.
        for (String v: message.getHeaders(Names.EXPECT)) {
            if (Values.CONTINUE.equalsIgnoreCase(v)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the {@code "Expect: 100-continue"} header to the specified message.
     * If there is any existing {@code "Expect"} header, they are replaced with
     * the new one.
     */
    public static void set100ContinueExpected(HttpMessage message) {
        set100ContinueExpected(message, true);
    }

    /**
     * Sets or removes the {@code "Expect: 100-continue"} header to / from the
     * specified message.  If the specified {@code value} is {@code true},
     * the {@code "Expect: 100-continue"} header is set and all other previous
     * {@code "Expect"} headers are removed.  Otherwise, all {@code "Expect"}
     * headers are removed completely.
     */
    public static void set100ContinueExpected(HttpMessage message, boolean set) {
        if (set) {
            message.setHeader(Names.EXPECT, Values.CONTINUE);
        } else {
            message.removeHeader(Names.EXPECT);
        }
    }

    /**
     * Set the headers on the dst like they are set on the src
     */
    public static void setHeaders(HttpMessage src, HttpMessage dst) {
        for (String name: src.getHeaderNames()) {
            dst.setHeader(name, src.getHeaders(name));
        }
    }
    /**
     * Validates the name of a header
     *
     * @param headerName The header name being validated
     */
    static void validateHeaderName(String headerName) {
        //Check to see if the name is null
        if (headerName == null) {
            throw new NullPointerException("Header names cannot be null");
        }
        //Go through each of the characters in the name
        for (int index = 0; index < headerName.length(); index ++) {
            //Actually get the character
            char character = headerName.charAt(index);

            //Check to see if the character is not an ASCII character
            if (character > 127) {
                throw new IllegalArgumentException(
                        "Header name cannot contain non-ASCII characters: " + headerName);
            }

            //Check for prohibited characters.
            switch (character) {
                case '\t': case '\n': case 0x0b: case '\f': case '\r':
                case ' ':  case ',':  case ':':  case ';':  case '=':
                    throw new IllegalArgumentException(
                            "Header name cannot contain the following prohibited characters: " +
                                    "=,;: \\t\\r\\n\\v\\f: " + headerName);
            }
        }
    }

    /**
     * Validates the specified header value
     *
     * @param headerValue The value being validated
     */
    static void validateHeaderValue(String headerValue) {
        //Check to see if the value is null
        if (headerValue == null) {
            throw new NullPointerException("Header values cannot be null");
        }

        /*
         * Set up the state of the validation
         *
         * States are as follows:
         *
         * 0: Previous character was neither CR nor LF
         * 1: The previous character was CR
         * 2: The previous character was LF
         */
        int state = 0;

        //Start looping through each of the character

        for (int index = 0; index < headerValue.length(); index ++) {
            char character = headerValue.charAt(index);

            //Check the absolutely prohibited characters.
            switch (character) {
                case 0x0b: // Vertical tab
                    throw new IllegalArgumentException(
                            "Header value contains a prohibited character '\\v': " + headerValue);
                case '\f':
                    throw new IllegalArgumentException(
                            "Header value contains a prohibited character '\\f': " + headerValue);
            }

            // Check the CRLF (HT | SP) pattern
            switch (state) {
                case 0:
                    switch (character) {
                        case '\r':
                            state = 1;
                            break;
                        case '\n':
                            state = 2;
                            break;
                    }
                    break;
                case 1:
                    switch (character) {
                        case '\n':
                            state = 2;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Only '\\n' is allowed after '\\r': " + headerValue);
                    }
                    break;
                case 2:
                    switch (character) {
                        case '\t': case ' ':
                            state = 0;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Only ' ' and '\\t' are allowed after '\\n': " + headerValue);
                    }
            }
        }

        if (state != 0) {
            throw new IllegalArgumentException(
                    "Header value must not end with '\\r' or '\\n':" + headerValue);
        }
    }

    /**
     * Checks to see if the transfer encoding in a specified {@link HttpMessage} is chunked
     *
     * @param message The message to check
     * @return True if transfer encoding is chunked, otherwise false
     */
    public static boolean isTransferEncodingChunked(HttpMessage message) {
        List<String> transferEncodingHeaders = message.getHeaders(Names.TRANSFER_ENCODING);
        if (transferEncodingHeaders.isEmpty()) {
            return false;
        }

        for (String value: transferEncodingHeaders) {
            if (value.equalsIgnoreCase(Values.CHUNKED)) {
                return true;
            }
        }
        return false;
    }

    public static void removeTransferEncodingChunked(HttpMessage m) {
        List<String> values = m.getHeaders(Names.TRANSFER_ENCODING);
        values.remove(Values.CHUNKED);
        if (values.isEmpty()) {
            m.removeHeader(Names.TRANSFER_ENCODING);
        } else {
            m.setHeader(Names.TRANSFER_ENCODING, values);
        }
    }

    public static void setTransferEncodingChunked(HttpMessage m) {
        addHeader(m, Names.TRANSFER_ENCODING, Values.CHUNKED);
        removeHeader(m, Names.CONTENT_LENGTH);
    }

    public static boolean isContentLengthSet(HttpMessage m) {
        List<String> contentLength = m.getHeaders(Names.CONTENT_LENGTH);
        return !contentLength.isEmpty();
    }

    private static final int BUCKET_SIZE = 17;

    private static int hash(String name) {
        int h = 0;
        for (int i = name.length() - 1; i >= 0; i --) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            h = 31 * h + c;
        }

        if (h > 0) {
            return h;
        } else if (h == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return -h;
        }
    }

    private static boolean eq(String name1, String name2) {
        int nameLen = name1.length();
        if (nameLen != name2.length()) {
            return false;
        }

        for (int i = nameLen - 1; i >= 0; i --) {
            char c1 = name1.charAt(i);
            char c2 = name2.charAt(i);
            if (c1 != c2) {
                if (c1 >= 'A' && c1 <= 'Z') {
                    c1 += 32;
                }
                if (c2 >= 'A' && c2 <= 'Z') {
                    c2 += 32;
                }
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int index(int hash) {
        return hash % BUCKET_SIZE;
    }

    private final HeaderEntry[] entries = new HeaderEntry[BUCKET_SIZE];
    private final HeaderEntry head = new HeaderEntry(-1, null, null);

    HttpHeaders() {
        head.before = head.after = head;
    }

    void validateHeaderName0(String headerName) {
        validateHeaderName(headerName);
    }

    void addHeader(final String name, final Object value) {
        validateHeaderName0(name);
        String strVal = toString(value);
        validateHeaderValue(strVal);
        int h = hash(name);
        int i = index(h);
        addHeader0(h, i, name, strVal);
    }

    private void addHeader0(int h, int i, final String name, final String value) {
        // Update the hash table.
        HeaderEntry e = entries[i];
        HeaderEntry newEntry;
        entries[i] = newEntry = new HeaderEntry(h, name, value);
        newEntry.next = e;

        // Update the linked list.
        newEntry.addBefore(head);
    }

    void removeHeader(final String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        int h = hash(name);
        int i = index(h);
        removeHeader0(h, i, name);
    }

    private void removeHeader0(int h, int i, String name) {
        HeaderEntry e = entries[i];
        if (e == null) {
            return;
        }

        for (;;) {
            if (e.hash == h && eq(name, e.key)) {
                e.remove();
                HeaderEntry next = e.next;
                if (next != null) {
                    entries[i] = next;
                    e = next;
                } else {
                    entries[i] = null;
                    return;
                }
            } else {
                break;
            }
        }

        for (;;) {
            HeaderEntry next = e.next;
            if (next == null) {
                break;
            }
            if (next.hash == h && eq(name, next.key)) {
                e.next = next.next;
                next.remove();
            } else {
                e = next;
            }
        }
    }

    void setHeader(final String name, final Object value) {
        validateHeaderName0(name);
        String strVal = toString(value);
        validateHeaderValue(strVal);
        int h = hash(name);
        int i = index(h);
        removeHeader0(h, i, name);
        addHeader0(h, i, name, strVal);
    }

    void setHeader(final String name, final Iterable<?> values) {
        if (values == null) {
            throw new NullPointerException("values");
        }

        validateHeaderName0(name);

        int h = hash(name);
        int i = index(h);

        removeHeader0(h, i, name);
        for (Object v: values) {
            if (v == null) {
                break;
            }
            String strVal = toString(v);
            validateHeaderValue(strVal);
            addHeader0(h, i, name, strVal);
        }
    }

    void clearHeaders() {
        for (int i = 0; i < entries.length; i ++) {
            entries[i] = null;
        }
        head.before = head.after = head;
    }

    String getHeader(final String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }

        int h = hash(name);
        int i = index(h);
        HeaderEntry e = entries[i];
        while (e != null) {
            if (e.hash == h && eq(name, e.key)) {
                return e.value;
            }

            e = e.next;
        }
        return null;
    }

    List<String> getHeaders(final String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }

        LinkedList<String> values = new LinkedList<String>();

        int h = hash(name);
        int i = index(h);
        HeaderEntry e = entries[i];
        while (e != null) {
            if (e.hash == h && eq(name, e.key)) {
                values.addFirst(e.value);
            }
            e = e.next;
        }
        return values;
    }

    List<Map.Entry<String, String>> getHeaders() {
        List<Map.Entry<String, String>> all =
            new LinkedList<Map.Entry<String, String>>();

        HeaderEntry e = head.after;
        while (e != head) {
            all.add(e);
            e = e.after;
        }
        return all;
    }

    boolean containsHeader(String name) {
        return getHeader(name) != null;
    }

    Set<String> getHeaderNames() {

        Set<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

        HeaderEntry e = head.after;
        while (e != head) {
            names.add(e.key);
            e = e.after;
        }
        return names;
    }

    private static String toString(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof Number) {
            return value.toString();
        }
        if (value instanceof Date) {
            return new HttpHeaderDateFormat().format((Date) value);
        }
        if (value instanceof Calendar) {
            return new HttpHeaderDateFormat().format(((Calendar) value).getTime());
        }
        return value.toString();
    }

    private static final class HeaderEntry implements Map.Entry<String, String> {
        final int hash;
        final String key;
        String value;
        HeaderEntry next;
        HeaderEntry before, after;

        HeaderEntry(int hash, String key, String value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        void remove() {
            before.after = after;
            after.before = before;
        }

        void addBefore(HeaderEntry e) {
            after  = e;
            before = e.before;
            before.after = this;
            after.before = this;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            if (value == null) {
                throw new NullPointerException("value");
            }
            validateHeaderValue(value);
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + '=' + value;
        }
    }
}
