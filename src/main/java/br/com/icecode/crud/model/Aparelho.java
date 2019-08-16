package br.com.icecode.crud.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "aparelhos")
public class Aparelho {

    @Id
    @Column(name = "id_aparelhos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao_aparelhos")
    private String descricao;

    @Column(name = "codigo_aparelhos")
    private String codigo;
}
