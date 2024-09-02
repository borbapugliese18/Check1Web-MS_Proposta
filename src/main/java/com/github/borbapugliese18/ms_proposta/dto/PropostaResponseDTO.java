package com.github.borbapugliese18.ms_proposta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropostaResponseDTO {

    private Long id;
    private BigDecimal valorSolicitado;
    private Integer prazoParaPagamento;
    private Boolean aprovado;
    private Long userId;


}