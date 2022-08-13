create table users
(
    id           bigint not null
        primary key,
    email        varchar(255),
    firstname    varchar(255),
    last_name    varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    roles        varchar(255),
    status       varchar(255)
);
create table halls
(
    id    bigint  not null
        primary key,
    name  varchar(255),
    seats integer not null
);
create table images
(
    id       bigint not null
        primary key,
    filename varchar(255),
    mime     varchar(255),
    size     bigint
);
create table messages
(
    id     bigint not null
        primary key,
    author varchar(255),
    film   varchar(255),
    text   varchar(255),
    time   varchar(255)
);
create table confirmation_token
(
    token_id           bigint not null
        primary key,
    confirmation_token varchar(255),
    created_date       timestamp,
    user_id            bigint not null
        constraint fkah4p1rycwibwm6s9bsyeckq51
            references users
);

create table films
(
    id          bigint  not null
        primary key,
    age         integer not null,
    description varchar(255),
    title       varchar(255),
    year        integer not null,
    poster      bigint
        constraint fkcsw6qfiow49y5psdhtby4ip39
            references images
);

create table sessions
(
    id   bigint  not null
        primary key,
    cost integer not null,
    time varchar(255),
    film bigint
        constraint fkdjn0hkrbd8sbgmtjkoijaifx9
            references films,
    hall bigint
        constraint fkn0sqm8rd657hqxcrwim6bg7o3
            references halls
);

create table user_session
(
    id      bigint not null
        primary key,
    date    varchar(255),
    ip      varchar(255),
    time    varchar(255),
    user_id bigint
        constraint fklr29o11uswdgcnn8swu3q15f8
            references users
);

create table users_avatars
(
    user_id    bigint not null
        constraint fkab0ikudxtnce519sqmts13g5k
            references users,
    avatars_id bigint not null
        constraint uk_pc6yxefchykm2g1v10lckty1t
            unique
        constraint fk92yqnxix90f8551eqjw79gx5q
            references images
);

create table users_sessions
(
    user_id     bigint not null
        constraint fkql9djjnh2v3a1nhmax0jehdbe
            references users,
    sessions_id bigint not null
        constraint uk_gf9rd2660dwstodhx745l0k09
            unique
        constraint fkaafjbaowiq6hywpeg9njidsbi
            references user_session
);

alter table users
    owner to postgres;
alter table users_sessions
    owner to postgres;
alter table users_avatars
    owner to postgres;
alter table user_session
    owner to postgres;
alter table sessions
    owner to postgres;
alter table messages
    owner to postgres;
alter table images
    owner to postgres;
alter table halls
    owner to postgres;
alter table films
    owner to postgres;
alter table confirmation_token
    owner to postgres;
