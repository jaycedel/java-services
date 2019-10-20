create table countries
(
    country_code  varchar(2)   not null
        primary key,
    latitude      double       null,
    longtitude    double       null,
    country_name  varchar(100) null,
    currency_code varchar(3)   null
);

create table customer
(
    id      int auto_increment
        primary key,
    name    varchar(50)   null,
    country varchar(50)   null,
    balance int default 0 null
);


