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
    FOREIGN KEY (brand_id) REFERENCES Brands (id)
);

CREATE TABLE ShoppingCart
(
    id          serial PRIMARY KEY,
    product_id  INT,
    quantity    INT,
    price DECIMAL(10,2),
    totalAmount DECIMAL(10, 2),
    order_date DATE,
    user_id     INT,
    FOREIGN KEY (product_id) REFERENCES Products (id),
    FOREIGN KEY (user_id) REFERENCES Users (id)

);
CREATE TABLE Users
(
    id       serial PRIMARY KEY,
    username VARCHAR(50),
    password varchar(50)
);

CREATE TABLE admins
(
    id       serial PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);