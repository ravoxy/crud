package br.com.icecode.crud.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icecode.crud.model.Usuario;
import br.com.icecode.crud.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioSalvo = buscarUsuarioExistente(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        return usuarioRepository.save(usuarioSalvo);
    }

    private Usuario buscarUsuarioExistente(Long id) {
        return usuarioRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

}
