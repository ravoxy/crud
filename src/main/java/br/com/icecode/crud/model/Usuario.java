package br.com.icecode.crud.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    @Column(name = "nome_usuario", length = 60)
    private String nome;

    @Size(max = 12)
    @Column(name = "login", length = 12)
    private String login;

    @Size(max = 60)
    @Email
    @Column(name = "email", length = 60)
    private String email;

    @Size(max = 45)
    @Column(name = "senha", length = 45)
    private String senha;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "tempo_expiracao_senha")
    private Integer tempoExpiracaoSenha;

    @Size(max = 1)
    @Column(name = "cod_autorizacao", length = 1)
    private String codigoAutorizacao;

    @Size(max = 1)
    @Column(name = "status_usuario", length = 1)
    private String statusUsuario;

    @Column(name = "cod_pessoa")
    private Long codigoPessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private Set<Perfil> perfis;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_aparelhos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_aparelhos"))
    private Set<Aparelho> aparelhos;

}
