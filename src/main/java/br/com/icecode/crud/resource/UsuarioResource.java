package br.com.icecode.crud.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.icecode.crud.event.RecursoCriadoEvent;
import br.com.icecode.crud.model.Usuario;
import br.com.icecode.crud.repository.UsuarioRepository;
import br.com.icecode.crud.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    private final ApplicationEventPublisher publisher;

    @Autowired
    public UsuarioResource(UsuarioRepository usuarioRepository, UsuarioService usuarioService, ApplicationEventPublisher publisher) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
        this.publisher = publisher;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        try {
            Usuario usuarioSalvo = usuarioService.atualizar(id, usuario);
            return ResponseEntity.ok(usuarioSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
