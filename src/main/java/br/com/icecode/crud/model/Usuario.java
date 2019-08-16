package br.com.icecode.crud.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario", length = 60)
    private String nome;

    @Column(name = "login", length = 12)
    private String login;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "senha", length = 45)
    private String senha;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "tempo_expiracao_senha")
    private Integer tempoExpiracaoSenha;

    @Column(name = "cod_autorizacao", length = 1)
    private String codigoAutorizacao;

    @Column(name = "status_usuario", length = 1)
    private String statusUsuario;

    @Column(name = "cod_pessoa")
    private Long codigoPessoa;

    @ManyToMany
    @JoinTable(name = "usuarios_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfis;

    @ManyToMany
    @JoinTable(name = "usuarios_aparelhos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_aparelhos"))
    private List<Aparelho> aparelhos;

}
