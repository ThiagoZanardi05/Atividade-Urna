package com.urna.urna.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHoraVotacao;

    @NotNull
    private String hashComprovante;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "prefeito_id")
    private Candidato prefeitoEscolhido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vereador_id")
    private Candidato vereadorEscolhido;

    @PrePersist
    private void prePersist(){
        this.dataHoraVotacao = LocalDateTime.now();
        this.hashComprovante = UUID.randomUUID().toString();
    }
}
