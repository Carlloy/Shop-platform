CREATE TABLE item
(
    id          BINARY(16) PRIMARY KEY,
    name        VARCHAR(100)               NOT NULL,
    price_value DOUBLE(10, 2)              NOT NULL,
    price_code  ENUM ('PLN','EURO', 'USD') NOT NULL,
    description TEXT(1000)                 NOT NULL
)
