create table cg_role(
    id                      int CONSTRAINT pk_role primary key,
    name                    varchar(50) not null
);

create table cg_eye_color(
     id                      int CONSTRAINT pk_eye_color primary key,
     name                    varchar(50) not null
);

create table cg_hair_color(
     id                      int CONSTRAINT pk_hair_color primary key,
     name                    varchar(50) not null
);

create table cg_body_shape(
    id                      int CONSTRAINT pk_body_shape primary key,
    name                    varchar(50) not null
);

create table cg_user(
    id                      serial CONSTRAINT pk_user primary key,
    pseudo                  varchar(50) not null,
    email                   varchar(200) not null,
    password                varchar(1000) not null,
    img                     varchar(1000) not null,
    role                    int default 1 not null,
    eye                     int default 1 not null,
    hair                    int default 1 not null,
    shape                   int default 1 not null,
    birthday                date default CURRENT_DATE not null,
    height                  int default 160 not null,
    description             text null,
    CONSTRAINT fk_user_role FOREIGN KEY (role) REFERENCES cg_role(id),
    CONSTRAINT fk_user_eye FOREIGN KEY (eye) REFERENCES cg_eye_color(id),
    CONSTRAINT fk_user_shape FOREIGN KEY (shape) REFERENCES cg_body_shape(id)
);

insert into cg_role (id, name)
values
    (1, 'User'),
    (2, 'Manager'),
    (3, 'Staff'),
    (4, 'Admin');

insert into cg_eye_color (id, name)
values
    (1, 'Bleu'),
    (2, 'Gris'),
    (3, 'Brun'),
    (4, 'Vert');

insert into cg_hair_color (id, name)
values
    (1, 'Brun'),
    (2, 'Gris'),
    (3, 'Noir'),
    (4, 'Blond'),
    (5, 'Rouge'),
    (6, 'Vert'),
    (7, 'Violet'),
    (8, 'Blanc'),
    (9, 'Autre');

insert into cg_body_shape (id, name)
values
    (1, 'Normal'),
    (2, 'Elfique'),
    (3, 'Des kilos en trop');