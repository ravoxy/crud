package br.com.icecode.crud.repository;

import br.com.icecode.crud.model.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
