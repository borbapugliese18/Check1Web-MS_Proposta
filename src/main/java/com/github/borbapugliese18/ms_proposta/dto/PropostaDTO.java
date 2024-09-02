package com.github.borbapugliese18.ms_proposta.dto;

import com.github.borbapugliese18.ms_proposta.model.Proposta;
import com.github.borbapugliese18.ms_proposta.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PropostaDTO {

    private Long id;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valorSolicitado;
    private Integer prazoParaPagamento;

    private Boolean aprovado;

    private Long userId;

//    public PropostaDTO(Proposta entity) {
//        id = entity.getId();
//        valorSolicitado = entity.getValorSolicitado();
//        prazoParaPagamento = entity.getPrazoParaPagamento();
//        aprovado = entity.getAprovado();
//        userId = entity.getUser().getId();
//
//    }


}
