INSERT INTO products (id, name) VALUES
    (10, 'USB-C dock'), (11, 'Wireless keyboard'), (12, 'Laptop stand');

INSERT INTO customer_orders (id, customer_id, customer_email, placed_at) VALUES
    (1001, 42, 'Alex@example.com', '2026-09-01T09:15:00Z'),
    (1002, 42, 'Alex@example.com', '2026-09-02T10:30:00Z'),
    (1003, 84, 'Sam@example.com', '2026-09-03T14:00:00Z'),
    (1004, 99, NULL, '2026-09-04T08:00:00Z');

INSERT INTO order_lines (id, order_id, product_id, quantity, unit_price) VALUES
    (1, 1001, 10, 1, 89.90), (2, 1001, 11, 2, 49.50),
    (3, 1002, 12, 1, 39.00), (4, 1003, 11, 1, 49.50),
    (5, 1004, 12, 1, 39.00);
