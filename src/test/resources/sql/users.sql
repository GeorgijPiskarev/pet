DROP TABLE IF EXISTS users;
create table users
(
    id         bigint
        constraint users_pk
            primary key,
    email      VARCHAR(255) not null,
    first_name VARCHAR(50)  not null,
    last_name  VARCHAR(100) not null,
    password   VARCHAR(255) not null,
    role       VARCHAR(20)  not null,
    status     VARCHAR(20)  not null
);
create unique index users_email_uindex
    on users (email);

INSERT INTO users(id, email, first_name, last_name, password, role, status)
VALUES (1, 'gg111@mail.ru', 'Георгий', 'Пискарев', '$2a$12$MV3y7eC86XBQuXUJ0dtatOtoPRdGbzepQDI4P7GtV4gn9UK7.IkzW',
        'USER', 'ACTIVE')