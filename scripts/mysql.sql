CREATE USER 'coregeek'@'%' IDENTIFIED BY '#####';
CREATE DATABASE IF NOT EXISTS coregeek CHARACTER SET utf8;
GRANT SELECT,INSERT,CREATE,ALTER,DROP,LOCK TABLES,CREATE TEMPORARY TABLES, DELETE,UPDATE,EXECUTE ON coregeek.* TO 'coregeek'@'%';

create table cg_sex(
    id                      int NOT NULL AUTO_INCREMENT,
    name                    varchar(50) not null,
    PRIMARY KEY (id)
);

create table cg_role(
    id                      int NOT NULL AUTO_INCREMENT,
    name                    varchar(50) not null,
    PRIMARY KEY (id)
);

create table cg_eye_color(
    id                      int NOT NULL AUTO_INCREMENT,
    name                    varchar(50) not null,
    PRIMARY KEY (id)
);

create table cg_hair_color(
    id                      int NOT NULL AUTO_INCREMENT,
    name                    varchar(50) not null,
    PRIMARY KEY (id)
);

create table cg_body_shape(
    id                      int NOT NULL AUTO_INCREMENT,
    name                    varchar(50) not null,
    PRIMARY KEY (id)
);

create table cg_dept(
  id                      int NOT NULL AUTO_INCREMENT,
  name                    varchar(50) not null,
  PRIMARY KEY (id)
);

create table cg_user(
    id                      int NOT NULL AUTO_INCREMENT,
    pseudo                  varchar(50) not null,
    email                   varchar(200) not null,
    password                varchar(1000) not null,
    img                     varchar(1000) default 'user/default_user.png' not null,
    city                    varchar(1000) null,
    role                    int default 1 not null,
    eye                     int default 1 not null,
    hair                    int default 1 not null,
    shape                   int default 1 not null,
    sex                     int default 1 not null,
    interested              int default 1 not null,
    dept                    int default 1 not null,
    birthday                timestamp default CURRENT_TIMESTAMP not null,
    height                  int default 160 not null,
    description             text null,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_role FOREIGN KEY (role) REFERENCES cg_role(id),
    CONSTRAINT fk_user_eye FOREIGN KEY (eye) REFERENCES cg_eye_color(id),
    CONSTRAINT fk_user_shape FOREIGN KEY (shape) REFERENCES cg_body_shape(id),
    CONSTRAINT fk_user_sex FOREIGN KEY (sex) REFERENCES cg_sex(id),
    CONSTRAINT fk_user_dept FOREIGN KEY (dept) REFERENCES cg_dept(id),
    CONSTRAINT fk_user_interested FOREIGN KEY (interested) REFERENCES cg_sex(id)
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

insert into cg_sex (id, name)
values
    (1, 'Homme'),
    (2, 'Femme'),
    (3, 'Homme et Femme');

insert into cg_dept (id, name)
values
    (1, 'Ain'),
    (2, 'Aisne'),
    (3, 'Allier');