CREATE TABLE categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price       DOUBLE       NOT NULL,
    fk_categ_id BIGINT NOT NULL,
    CONSTRAINT  fk_prod_to_categ FOREIGN KEY (fk_categ_id)
                      REFERENCES categories(id)
)