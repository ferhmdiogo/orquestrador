package com.orquestrador.repository;

import com.orquestrador.repository.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "usuario", url = "http://localhost:8092/usuario")
public interface UsuarioRepository {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<UsuarioResponse> retornaUsuarios();
}
