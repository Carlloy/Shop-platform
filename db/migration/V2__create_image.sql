CREATE TABLE image
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    item_id BINARY(16)   NOT NULL,
    url     VARCHAR(150) NOT NULL,
    main    BOOL         NOT NULL DEFAULT 0,
    INDEX par_ind (item_id),
    CONSTRAINT fk_item FOREIGN KEY (item_id)
        REFERENCES item (ID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
