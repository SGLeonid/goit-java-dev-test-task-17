
USE PUBLIC;

CREATE TABLE IF NOT EXISTS users(
    username VARCHAR(256) PRIMARY KEY NOT NULL,
    password VARCHAR(256) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities(
    username VARCHAR(256) NOT NULL,
    authority VARCHAR(256) NOT NULL,
    FOREIGN KEY(username) REFERENCES users(username)
);