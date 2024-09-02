package com.github.borbapugliese18.ms_proposta.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaRequestDTO {

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor solicitado deve ser maior que zero.")
    private BigDecimal valorSolicitado;

    @NotNull
    @Min(value = 1, message = "O prazo para pagamento deve ser pelo menos 1 mês.")
    private Integer prazoParaPagamento;

    private Boolean aprovado;

    @Valid
    @NotNull
    private UserDTO user;
}
