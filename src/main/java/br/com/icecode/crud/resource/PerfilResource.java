package br.com.icecode.crud.resource;

import br.com.icecode.crud.model.Perfil;
import br.com.icecode.crud.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilResource {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilResource(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @GetMapping
    public List<Perfil> listar() {
        return perfilRepository.findAll();
    }
}
