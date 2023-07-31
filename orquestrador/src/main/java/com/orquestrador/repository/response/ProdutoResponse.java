package com.orquestrador.repository.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private Long id;

    private Long usuarioId;

    private String nomeProduto;

    private String descricao;
}
