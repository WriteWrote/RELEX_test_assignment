CREATE SCHEMA tar2023_crypto;

CREATE TABLE tar2023_crypto.users(
                                     id              SERIAL  PRIMARY KEY ,
                                     login           VARCHAR(50),
                                     password        VARCHAR(50),
                                     secret_key      VARCHAR(100)    UNIQUE
);

CREATE TABLE tar2023_crypto.admins(
    secret_key      VARCHAR(100)    UNIQUE
);

CREATE TABLE tar2023_crypto.currencies(
                                        id              SERIAL PRIMARY KEY ,
                                        currency_name   VARCHAR(50)
);

CREATE TABLE tar2023_crypto.wallets(
                                       id              SERIAL  PRIMARY KEY ,
                                       user_id         INTEGER,
                                       currency_id     INTEGER,
                                       currency_sum    FLOAT  NOT NULL
);

CREATE TABLE tar2023_crypto.transactions(
                                            id              SERIAL PRIMARY KEY ,
                                            user_id         INTEGER NOT NULL ,
                                            currency_id     INTEGER NOT NULL ,
                                            currency_sum    FLOAT NOT NULL
);

CREATE TABLE tar2023_crypto.exchange_rates(
                                              id              SERIAL PRIMARY KEY ,
                                              currency_id1       INTEGER,
                                              currency_id2       INTEGER,
                                              coef            FLOAT
);