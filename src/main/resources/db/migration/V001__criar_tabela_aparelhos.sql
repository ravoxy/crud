create table aparelhos
(
    id_aparelhos    bigserial not null,
    descricao_aparelhos varchar(15),
    codigo_aparelhos  varchar(100)
);

ALTER TABLE aparelhos
    ADD CONSTRAINT aparelhos_pkey PRIMARY KEY (id_aparelhos);
