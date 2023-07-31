package com.cadastro.usuario.repository;

import com.cadastro.usuario.domain.UsuarioDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioDomain, Long> {
}
