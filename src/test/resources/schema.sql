create TABLE IF NOT EXISTS product
(
product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(32) NOT NULL,
album_type  VARCHAR(32) NOT NULL,
singer VARCHAR(64) NOT NULL,
product_name VARCHAR(128) NOT NULL,
image_url VARCHAR(256) NOT NULL,
barcode VARCHAR(64) NOT NULL UNIQUE,
company VARCHAR(128) NOT NULL,
issue_date DATE NOT NULL,
description VARCHAR(2048),
price INT NOT NULL,
stock INT NOT NULL,
shelves VARCHAR(1) NOT NULL,
created_date TIMESTAMP NULL,
last_modified_date TIMESTAMP NULL
);