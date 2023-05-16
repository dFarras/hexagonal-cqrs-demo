CREATE TABLE `transaction` (
    reference VARCHAR(64) NOT NULL,
    channel VARCHAR(16) NOT NULL,
    amount VARCHAR(128) NOT NULL,
    fee VARCHAR(128) NOT NULL,
    transaction_date TIMESTAMP WITHOUT TIME ZONE
);