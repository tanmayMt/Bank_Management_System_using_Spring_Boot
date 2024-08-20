use banking_app;
create database banking_app;

CREATE TABLE accounts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_holder_name VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL
);

