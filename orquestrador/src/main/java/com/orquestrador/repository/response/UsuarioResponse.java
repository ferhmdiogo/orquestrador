package com.orquestrador.repository.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private List<ProdutoResponse> produto;
}
