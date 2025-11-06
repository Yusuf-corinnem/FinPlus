package com.finpuls.domain.dto.response.banktoken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTokenDTOImpl implements BankTokenDTO {
    private UUID id;
    private String userId;
    private String bankCode;
    private String accessToken;
    private String tokenType;
    private Integer expiresIn;
    private OffsetDateTime expiresAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}

