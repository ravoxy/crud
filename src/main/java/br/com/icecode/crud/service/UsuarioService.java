package br.com.icecode.crud.service;

import br.com.icecode.crud.model.Usuario;
import br.com.icecode.crud.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioSalvo = buscarUsuarioExistente(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        return usuarioRepository.save(usuarioSalvo);
    }

    private Usuario buscarUsuarioExistente(Long id) {
        return usuarioRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

}
