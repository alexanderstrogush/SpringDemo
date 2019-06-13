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
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users_to_roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fk_user_id BIGINT NOT NULL,
    fk_role_id BIGINT NOT NULL,
    CONSTRAINT fk_utr_to_user FOREIGN KEY (fk_user_id)
                            REFERENCES users(id),
    CONSTRAINT fk_utr_to_role FOREIGN KEY (fk_role_id)
                            REFERENCES roles(id)
);