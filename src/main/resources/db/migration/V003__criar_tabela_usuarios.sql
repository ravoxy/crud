create table usuarios
(
    id_usuario   bigserial not null,
    nome_usuario varchar(60),
    login varchar(60),
    email varchar(60),
    senha varchar(45),
    data_criacao timestamp,
    tempo_expiracao_senha int,
    cod_autorizacao varchar(1),
    status_usuario varchar(1),
    cod_pessoa bigint
);

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);
