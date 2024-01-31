CREATE TABLE Categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE Brands
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Products
(
    id             serial PRIMARY KEY,
    name           VARCHAR(100),
    category_id    INT,
    stock_quantity INT,
    price          DECIMAL(10, 2),
    brand_id       INT,
    FOREIGN KEY (category_id) REFERENCES Categories (id),
    FOREIGN KEY (brand_id) REFERENCES Brands(id)
);


