CREATE TABLE products (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE customer_orders (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    customer_email VARCHAR(255),
    placed_at TIMESTAMP WITH TIME ZONE NOT NULL
);
CREATE INDEX idx_orders_customer ON customer_orders(customer_id, id);

CREATE TABLE order_lines (
    id BIGINT PRIMARY KEY,
    order_id BIGINT NOT NULL REFERENCES customer_orders(id),
    product_id BIGINT NOT NULL REFERENCES products(id),
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    unit_price DECIMAL(12, 2) NOT NULL CHECK (unit_price >= 0)
);
CREATE INDEX idx_lines_order ON order_lines(order_id, id);
