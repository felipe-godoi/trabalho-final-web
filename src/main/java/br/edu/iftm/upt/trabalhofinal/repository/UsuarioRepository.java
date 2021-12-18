package br.edu.iftm.upt.trabalhofinal.repository;

import br.edu.iftm.upt.trabalhofinal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByLogin(String login);
}
