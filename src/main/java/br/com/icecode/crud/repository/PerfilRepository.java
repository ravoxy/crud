package br.com.icecode.crud.repository;

import br.com.icecode.crud.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
