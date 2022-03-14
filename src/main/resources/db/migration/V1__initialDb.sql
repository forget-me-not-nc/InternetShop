create table clients
(
    id          integer not null
        constraint clients_pkey
            primary key,
    address     varchar(255),
    email       varchar(255),
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    phone       varchar(255)
);

create table users
(
    id       integer not null
        constraint users_pkey
            primary key,
    login    varchar(255),
    password varchar(255)
);

create table accounts
(
    id        integer not null
        constraint accounts_pkey
            primary key,
    balance   numeric(19, 2),
    is_active boolean not null,
    client_id integer
        constraint fkgymog7firrf8bnoiig61666ob
            references clients,
    user_id   integer
        constraint fknjuop33mo69pd79ctplkck40n
            references users
);

create table authors
(
    id          integer not null
        constraint authors_pkey
            primary key,
    first_name  varchar(255),
    info        varchar(255),
    last_name   varchar(255),
    middle_name varchar(255)
);

create table books
(
    id               integer not null
        constraint books_pkey
            primary key,
    name             varchar(255),
    price            numeric(19, 2),
    publishing_house varchar(255)
);

create table categories
(
    id   integer not null
        constraint categories_pkey
            primary key,
    name varchar(255)
);

create table book_has_author
(
    book_id   integer not null
        constraint fkq7t4b1gg1eqpjo0kom4t8vktl
            references books,
    author_id integer not null
        constraint fk8oktfipod4dby36a7wj285yn8
            references authors
);

create table book_has_category
(
    book_id     integer not null
        constraint fktoynsl1vx9orlcuol20u48si8
            references books,
    category_id integer not null
        constraint fk5cs1uc6w5jhddv9p4e6kro5hd
            references categories
);

create table orders
(
    id         integer not null
        constraint orders_pkey
            primary key,
    address    varchar(255),
    books      integer[],
    order_date timestamp,
    total_sum  numeric(19, 2),
    account_id integer
        constraint fkagh5svlor3slbay6tq5wqor1o
            references accounts
);

