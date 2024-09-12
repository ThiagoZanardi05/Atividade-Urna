package com.urna.urna.Entity;

import com.urna.urna.Entity.enums.FuncaoCandidato;
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

    @Enumerated(EnumType.ORDINAL)
    private FuncaoCandidato funcaoCandidato;
}
