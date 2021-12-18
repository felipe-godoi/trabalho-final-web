package br.edu.iftm.upt.trabalhofinal.service;

import br.edu.iftm.upt.trabalhofinal.models.Usuario;
import br.edu.iftm.upt.trabalhofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Boolean salvar(Usuario usuario) {
        Usuario resultado = usuarioRepository.save(usuario);
        if(resultado != null)
            return true;
        else
            return false;
    }
}
