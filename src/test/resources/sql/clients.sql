DROP TABLE IF EXISTS clients;
create table clients
(
    id                   bigint
        constraint clients_pk
            primary key,
    name                 VARCHAR(100) not null,
    company              VARCHAR(255),
    years_of_cooperation int          not null
);

INSERT INTO clients(id, name, company, years_of_cooperation)
VALUES (1, 'Юрий', 'Apple', 5)