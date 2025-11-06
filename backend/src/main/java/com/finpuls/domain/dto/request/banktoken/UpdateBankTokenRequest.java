package com.finpuls.domain.dto.request.banktoken;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBankTokenRequest {

    private String accessToken;

    private String tokenType;

    @Positive(message = "Время жизни токена должно быть положительным")
    private Integer expiresIn;
}

