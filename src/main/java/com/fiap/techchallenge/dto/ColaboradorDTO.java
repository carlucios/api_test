package com.fiap.techchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techchallenge.entities.Colaborador;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO {
    @Getter
    private Long id;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String nome;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String cargo;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String imagem;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String time;

    public ColaboradorDTO(Colaborador entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cargo = entity.getCargo();
        this.imagem = entity.getImagem();
        this.time = entity.getTime();
    }


    public Colaborador mapToColaborador() {
        return new Colaborador(id, nome, cargo, imagem, time);
    }
}
