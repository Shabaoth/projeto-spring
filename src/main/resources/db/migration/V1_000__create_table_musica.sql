create table TB_MUSICA
(
    ID                      BIGINT auto_increment primary key,
    AUTOR                   VARCHAR(255),
    DATA_CRIACAO            TIMESTAMP not null,
    DATA_LANCAMENTO         DATE,
    DATA_ULTIMA_ATUALIZACAO TIMESTAMP,
    DURACAO                 INTEGER,
    NOME                    VARCHAR(255),
    PRECO                   DECIMAL(19, 2)
);

