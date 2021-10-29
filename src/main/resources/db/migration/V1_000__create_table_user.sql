create table TB_MUSICA
(
    ID INTEGER auto_increment
        primary key,
    NAME VARCHAR(255),
    CODE VARCHAR(255),
    RA INTEGER,
    DATA_CRIACAO TIMESTAMP not null,
);
