CREATE DATABASE quanlybanhang;

USE quanlybanhang;

create table users
(
    user_id         int primary key auto_increment,
    user_name       varchar(50)  not null,
    password        varchar(50)  not null,
    email           varchar(50)  not null,
    role            varchar(50)  not null,
    gender          varchar(50)  not null,
    phone           varchar(50)  not null,
    avatar          varchar(150),
    about          varchar(50)
);

create table user_role
(
    user_role_id         int primary key auto_increment,
    name_role            varchar(50) not null ,
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

create table category
(
    category_id         int primary key auto_increment,
    category_name            varchar(50) not null
);

create table brand
(
    brand_id         int primary key auto_increment,
    brand_name           varchar(50) not null
);

create table product
(
    product_id int primary key auto_increment,
    product_name varchar(50) not null ,
    product_code varchar(50) not null ,
    description varchar(150),
    product_price double not null,
    product_image varchar(150),
    product_brand varchar(50),
    product_inventory int default 1,
    category_id int,
    brand_id int,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (brand_id) REFERENCES brand(brand_id)
);

create table orders
(
    order_id          int primary key auto_increment,
    customer_name     varchar(50) not null,
    customer_phone    varchar(50) not null,
    customer_email    varchar(50) not null,
    discount_code     varchar(50)
);



create table order_detail
(
    order_detail_id          int primary key auto_increment,
    quantity     int not null,
    price    varchar(50) not null,
    order_id int,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    product_id int,
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

create table image
(
    image_id int primary key  auto_increment,
    image_file varchar(50),
    product_id int,
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);



insert into users values(1,'Admin', '123', 'admin@abc.com', 'Admin', 'Nam', '0123456789', ' ', 'Đẹp trai có quyền');
insert into users values(2,'Customer', '123', 'customer@abc.com', 'Customer', 'Nữ', '0123456789', ' ', 'Chỉ có quyền mua bán thôi');

insert into user_role values(1,'Admin', 1);
insert into user_role values(2,'Customer', 2);


