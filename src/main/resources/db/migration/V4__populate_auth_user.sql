
USE PUBLIC;

-- User password is set according to task 2.1

INSERT INTO users(username, password, enabled) VALUES('user', '$2a$10$37YFWkHCVD4jP2Hoe6SaseAVFdnh655mElIW8mOIk.jfIJnBJrpD.', true);
INSERT INTO authorities(username, authority) VALUES('user', 'USER');
INSERT INTO authorities(username, authority) VALUES('user', 'ADMIN');