package com.eodya.backend.auth.domain;

public enum OauthProvider {

    KAKAO,
    UNKNOWN,
    ;

    public static OauthProvider from(String type) {
        return OauthProvider.valueOf(type.toUpperCase());
    }
}
