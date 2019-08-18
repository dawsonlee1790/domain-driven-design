create database domain_app;

create table domain_app.user
(
    id   int auto_increment not null primary key,
    name varchar(250)       null,
    age  int                null
) ENGINE InnoDB;

create table domain_app.balance_history
(
    id          int auto_increment not null primary key,
    balance     double             null,
    comment     varchar(250)       null,
    ref_user_id int                null
) ENGINE InnoDB;