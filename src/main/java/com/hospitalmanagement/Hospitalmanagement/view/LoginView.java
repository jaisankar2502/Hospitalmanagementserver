package com.hospitalmanagement.Hospitalmanagement.view;


import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.json.Json;
import com.hospitalmanagement.Hospitalmanagement.security.util.TokenGenerator;

import java.util.Date;

public class LoginView extends UserView {
    public static class TokenView {

        private final String value;
        @Json.DateTimeFormat
        private final Date expiry;

        public TokenView(TokenGenerator.Token token) {
            this.value = token.value;
            this.expiry = new Date(token.expiry);
        }

        public TokenView(String value, long expiry) {
            this.value = value;
            this.expiry = new Date(expiry);
        }

        public String getValue() {
            return value;
        }

        public Date getExpiry() {
            return expiry;
        }
    }
    private final TokenView accessToken;
    private final TokenView refreshToken;

    public LoginView(User user, TokenGenerator.Token accessToken, TokenGenerator.Token refreshToken) {
        super(user);
        this.accessToken = new TokenView(accessToken);
        this.refreshToken = new TokenView(refreshToken);
    }

    public LoginView(User user, TokenView accessToken, TokenView refreshToken) {
        super(user);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public TokenView getAccessToken() {
        return accessToken;
    }

    public TokenView getRefreshToken() {
        return refreshToken;
    }
}

