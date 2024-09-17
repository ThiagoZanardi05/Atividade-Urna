package com.urna.urna.Entity;

import com.urna.urna.Entity.enums.FuncaoCandidato;
import com.urna.urna.Entity.enums.Status;
import com.urna.urna.Entity.enums.StatusCandidato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidato extends Pessoa{

    @NotNull
    @Column(unique = true)
    private int numero;

    @Enumerated(EnumType.ORDINAL) //1 para Prefeito e 2 para Vereador
    private FuncaoCandidato funcao;

    @Enumerated(EnumType.STRING)
    private StatusCandidato statusCandidato;

    @Transient
    private Long votos;
}
