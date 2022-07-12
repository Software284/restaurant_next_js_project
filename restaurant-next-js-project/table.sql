CREATE SEQUENCE food_product_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
create table food_product(
    id number(10) primary key,
    name varchar2(50) not null,
    img varchar2(50) not null,
    ratings number(1),
    price number(10)
);

insert into food_product values(1,'Momo','img/momo.jpg',4,150);
insert into food_product values(2,'Chaumin','img/chaumin.jpg',4,120);
insert into food_product values(3,'Thukpa','img/thukpa.jpg',4,200);
insert into food_product values(4,'Chicken Chilly','img/chickenchilly.jpg',4,300);
insert into food_product values(5,'Sasausage','img/sasausage.jpg',4,500);
insert into food_product values(6,'Chicken Lollypop','img/lollypup.jpg',4,300);





CREATE SEQUENCE food_address_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  
create table food_address(
    id number(10) primary key,
    street varchar2(50) not null,
    zipcode number(6) not null,
    district varchar2(20) not null
);






CREATE SEQUENCE food_customer_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
create table food_customer(
    id number(10) primary key,
    name varchar2(50) not null,
    email varchar2(50) not null,
    gender varchar2(10) not null,
    address number(10) not null,
    FOREIGN KEY(address) REFERENCES food_address(id)
);


CREATE SEQUENCE food_cartproduct_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
 create table food_cartproduct(
  id number(10) primary key,
  name varchar2(40) not null,
  price number(10) not null,
  quantity number(10) not null,
  image varchar2(50) not null,
  cart_id number(10) not null,
  FOREIGN KEY(cart_id) REFERENCES food_order(id)
  );

  CREATE SEQUENCE food_order_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
   create table food_order(
    id number(10) primary key,
    customer_id number(10) not null,
    totalprice number(10) not null,
    FOREIGN KEY(customer_id) REFERENCES food_customer(id)
  );



  