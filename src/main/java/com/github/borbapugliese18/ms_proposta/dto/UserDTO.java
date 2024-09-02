// Gabriel Borba Pugliese Ribeiro - RM94677
// Pedro De Sousa Dutra - RM96167
package com.github.borbapugliese18.ms_proposta.dto;


import com.github.borbapugliese18.ms_proposta.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserDTO {


    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String sobrenome;

    @NotBlank(message = "Campo requerido")
    private String cpf;

    @NotBlank(message = "Campo requerido")
    private String telefone;

    @NotNull
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal renda;

//    public UserDTO(User entity) {
//        id = entity.getId();
//        nome = entity.getNome();
//        sobrenome = entity.getSobrenome();
//        cpf = entity.getCpf();
//        telefone = entity.getTelefone();
//        renda = entity.getRenda();
//    }
}
