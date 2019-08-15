package br.com.icecode.crud.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "aparelhos")
public class Aparelhos {
    private Long id;
    private String descricao;
    private String codigo;
}
