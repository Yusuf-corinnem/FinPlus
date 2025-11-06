package com.finpuls.domain.dto.response.banktoken;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface BankTokenDTO {
    UUID getId();
    String getUserId();
    String getBankCode();
    String getAccessToken();
    String getTokenType();
    Integer getExpiresIn();
    OffsetDateTime getExpiresAt();
    OffsetDateTime getCreatedAt();
    OffsetDateTime getUpdatedAt();
}

