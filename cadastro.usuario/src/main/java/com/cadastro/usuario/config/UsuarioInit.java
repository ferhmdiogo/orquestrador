package com.cadastro.usuario.config;

import com.cadastro.usuario.domain.UsuarioDomain;
import com.cadastro.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInit implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var usuario = UsuarioDomain.builder()
                .nome("Teste 1")
                .email("testeteste@gmail.com")
                .build();
        usuarioRepository.save(usuario);
        var usuario2 = UsuarioDomain.builder()
                .nome("Teste 2")
                .email("teste1teste1@gmail.com")
                .build();
        usuarioRepository.save(usuario2);
    }
}

