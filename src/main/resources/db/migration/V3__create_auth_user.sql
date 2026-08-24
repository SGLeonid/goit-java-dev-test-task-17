
USE note_db;

CREATE TABLE auth_user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    role VARCHAR(16) NOT NULL
);