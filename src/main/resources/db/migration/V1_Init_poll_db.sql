CREATE DATABASE poll_db;

USE poll_db;

CREATE TABLE lessons (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL CHECK (name != ''),
                         time TIMESTAMP NOT NULL,
                         teacher VARCHAR(255) NOT NULL CHECK (teacher != '')
);
