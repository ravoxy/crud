create table usuarios_perfil
(
    id_usuario      bigserial not null,
    id_perfil    bigserial not null
);

ALTER TABLE usuarios_perfil
    ADD CONSTRAINT usuarios_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario);

ALTER TABLE usuarios_perfil
    ADD CONSTRAINT perfil_fkey FOREIGN KEY (id_perfil) REFERENCES perfil (id_perfil);

ALTER TABLE usuarios_perfil
    ADD CONSTRAINT usuarios_perfil_pkey PRIMARY KEY (id_usuario,id_perfil);
