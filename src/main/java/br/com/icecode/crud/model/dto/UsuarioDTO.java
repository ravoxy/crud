package br.com.icecode.crud.model.dto;

import br.com.icecode.crud.model.Aparelho;
import br.com.icecode.crud.model.Perfil;
import br.com.icecode.crud.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UsuarioDTO {

    @Setter
    private Long id;

    @Setter
    @Size(max = 60)
    private String nome;

    @Setter
    @Size(max = 12)
    private String login;

    @Setter
    @Size(max = 60)
    @Email
    private String email;

    @Setter
    @Size(max = 45)
    private String senha;

    @Setter
    private LocalDateTime dataCriacao;

    @Setter
    private Integer tempoExpiracaoSenha;

    @Setter
    @Size(max = 1)
    private String codigoAutorizacao;

    @Setter
    @Size(max = 1)
    private String statusUsuario;

    @Setter
    private Long codigoPessoa;

    @Setter
    private Perfil perfil;

    @Setter
    private Aparelho aparelho;

    @JsonIgnore
    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setLogin(this.login);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setDataCriacao(this.dataCriacao);
        usuario.setTempoExpiracaoSenha(this.tempoExpiracaoSenha);
        usuario.setCodigoAutorizacao(this.codigoAutorizacao);
        usuario.setStatusUsuario(this.statusUsuario);
        usuario.setCodigoPessoa(this.codigoPessoa);
        if (this.perfil != null)
            usuario.getPerfis().add(this.perfil);

        if (this.aparelho != null)
            usuario.getAparelhos().add(this.aparelho);
        return usuario;
    }
}
