package br.com.icecode.crud.resource;

import br.com.icecode.crud.model.Aparelho;
import br.com.icecode.crud.repository.AparelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aparelhos")
public class AparelhoResource {

    private final AparelhoRepository aparelhoRepository;

    @Autowired
    public AparelhoResource(AparelhoRepository aparelhoRepository) {
        this.aparelhoRepository = aparelhoRepository;
    }

    @GetMapping
    public List<Aparelho> listar() {
        return aparelhoRepository.findAll();
    }
}
