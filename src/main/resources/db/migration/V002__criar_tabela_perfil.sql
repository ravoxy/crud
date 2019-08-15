create table perfil
(
    id_perfil    bigserial not null,
    nome_perfil varchar(60)
);

ALTER TABLE perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (id_perfil);
