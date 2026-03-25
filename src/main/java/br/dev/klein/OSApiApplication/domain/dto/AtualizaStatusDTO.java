/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.dev.klein.OSApiApplication.domain.dto;

import br.dev.klein.OSApiApplication.domain.model.StatusOrdemServico;
import jakarta.validation.constraints.NotNull;


public record AtualizaStatusDTO(
        @NotNull(message = "Status é obrigatório")
        StatusOrdemServico status
        ) 

 {}

