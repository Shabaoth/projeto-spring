create table user
(
    ID           INTEGER auto_increment primary key,
    NAME         VARCHAR(255),
    CODE         VARCHAR(255),
    RA           INTEGER,
    DATA_CRIACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
