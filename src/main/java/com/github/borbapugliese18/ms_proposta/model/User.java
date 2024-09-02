package com.github.borbapugliese18.ms_proposta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String nome;
    private String sobrenome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String telefone;


    private BigDecimal renda;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    List<Proposta> propostas = new ArrayList<>();

}
