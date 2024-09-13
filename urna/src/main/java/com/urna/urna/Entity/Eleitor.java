package com.urna.urna.Entity;

import com.urna.urna.Entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
public class Eleitor extends Pessoa {

    @NotBlank
    private String profissao;

    @NotBlank
    private String telefoneCelular;

    @NotBlank
    private String telefoneFixo;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

}
