package com.urna.urna.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eleitores")
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @NotBlank
    private String profissao;

    @NotBlank
    private String telefoneCelular;

    @NotBlank
    private String telefoneFixo;

    @Email
    private String email;
}
