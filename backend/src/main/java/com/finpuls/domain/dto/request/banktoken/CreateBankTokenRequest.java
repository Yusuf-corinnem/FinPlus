package com.finpuls.domain.dto.request.banktoken;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankTokenRequest {

    @NotBlank(message = "ID пользователя обязателен")
    private String userId;

    @NotBlank(message = "Код банка обязателен")
    private String bankCode;

    @NotBlank(message = "Access token обязателен")
    private String accessToken;

    private String tokenType = "bearer";

    @NotNull(message = "Время жизни токена обязательно")
    @Positive(message = "Время жизни токена должно быть положительным")
    private Integer expiresIn;
}

