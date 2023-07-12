package com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_colaborador")
@EqualsAndHashCode
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String cargo;
    @Getter
    @Setter
    private String imagem;
    @Getter
    @Setter
    private String time;
}
