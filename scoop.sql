CREATE TABLE scoop_user
(
    id      VARCHAR2(1000),
    name    VARCHAR2(1000) NOT NULL,
    email   VARCHAR2(1000) NOT NULL,
    picture VARCHAR2(1000),
    role    VARCHAR2(1000)
);

CREATE SEQUENCE id_seq;

SELECT * FROM scoop_user;
