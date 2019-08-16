create table usuarios_aparelhos
(
    id_usuario      bigserial not null,
    id_aparelhos    bigserial not null
);

ALTER TABLE usuarios_aparelhos
    ADD CONSTRAINT usuarios_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario);

ALTER TABLE usuarios_aparelhos
    ADD CONSTRAINT aparelhos_fkey FOREIGN KEY (id_aparelhos) REFERENCES aparelhos (id_aparelhos);

ALTER TABLE usuarios_aparelhos
    ADD CONSTRAINT usuarios_aparelhos_pkey PRIMARY KEY (id_usuario,id_aparelhos);
