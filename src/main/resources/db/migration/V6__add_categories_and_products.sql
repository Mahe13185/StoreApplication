CREATE TABLE categories (
        id TINYINT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        price DECIMAL(10, 2) NOT NULL ,
        category_id TINYINT,
        CONSTRAINT fk_category
            FOREIGN KEY (category_id) REFERENCES categories(id)
                ON DELETE RESTRICT
);
