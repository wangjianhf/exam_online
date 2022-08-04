package com.exam.online.utils;



public interface HttpStatus {
    /**
     * 请求成功
     */
    int HTTP_OK = 200;
    int HTTP_CREATED = 201;
    int HTTP_ACCEPTED = 202;
    int HTTP_NOT_AUTHORITATIVE = 203;
    int HTTP_NO_CONTENT = 204;
    int HTTP_RESET = 205;
    int HTTP_PARTIAL = 206;
    int HTTP_MULT_CHOICE = 300;
    /**
     * 请求的资源被移除
     */
    int HTTP_MOVED_PERM = 301;
    int HTTP_MOVED_TEMP = 302;
    int HTTP_SEE_OTHER = 303;
    int HTTP_NOT_MODIFIED = 304;
    int HTTP_USE_PROXY = 305;
    int HTTP_TEMP_REDIRECT = 307;
    int HTTP_PERMANENT_REDIRECT = 308;

    int HTTP_BAD_REQUEST = 400;
    int HTTP_UNAUTHORIZED = 401;
    int HTTP_PAYMENT_REQUIRED = 402;
    int HTTP_FORBIDDEN = 403;

    /**
     * 请求的资源未找到
     */
    int HTTP_NOT_FOUND = 404;

    /**
     * 请求方法有误 GET/POST
     */
    int HTTP_BAD_METHOD = 405;
    int HTTP_NOT_ACCEPTABLE = 406;
    int HTTP_PROXY_AUTH = 407;
    int HTTP_CLIENT_TIMEOUT = 408;
    int HTTP_CONFLICT = 409;
    int HTTP_GONE = 410;
    int HTTP_LENGTH_REQUIRED = 411;
    int HTTP_PRECON_FAILED = 412;
    int HTTP_ENTITY_TOO_LARGE = 413;
    int HTTP_REQ_TOO_LONG = 414;
    int HTTP_UNSUPPORTED_TYPE = 415;

    /**
     * 服务器错误
     */
    int HTTP_INTERNAL_ERROR = 500;
    int HTTP_NOT_IMPLEMENTED = 501;
    int HTTP_BAD_GATEWAY = 502;
    int HTTP_UNAVAILABLE = 503;
    int HTTP_GATEWAY_TIMEOUT = 504;
    int HTTP_VERSION = 505;

    /**
     * 请求被重定向
     *
     * @param responseCode
     * @return
     */
    static boolean isRedirected(int responseCode) {
        return responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308;
    }
}
