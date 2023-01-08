DROP TABLE IF EXISTS customers;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES
('Bob'),
('Jack'),
('John'),
('Goblin'),
('Gremlin'),
('Michael'),
('Frida');

DROP TABLE  IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price DOUBLE PRECISION, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES
('Apples', 123),
('Chocolate Bar', 99),
('Milk', 110),
('Ham', 458.33),
('Bear', 78.50),
('Water', 21.99),
('Oranges', 99.99);

DROP TABLE if exists orders;
CREATE TABLE IF NOT EXISTS orders (id bigserial, customer_id BIGINT, product_id BIGINT, price DOUBLE PRECISION,
                                    created_at DATETIME DEFAULT current_timestamp,
                                    PRIMARY KEY (id), FOREIGN KEY (product_id) REFERENCES products(id),
                                    FOREIGN KEY (customer_id) REFERENCES customers(id));
INSERT INTO orders (customer_id, product_id, price) VALUES (2, 1, 123), (3, 1, 123), (4, 3, 110), (1, 2, 99), (1, 4, 458.33);


