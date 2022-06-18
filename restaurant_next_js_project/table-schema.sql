 CREATE SEQUENCE food_product_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
create table food_product(
    id number(10) not null primary key,
    name varchar2(50) not null,
    currentprice number(10) not null,
    previousprice number(10) not null,
    pictureurl varchar2(100) not null
);
insert into food_product values(1,'chaumin',120,100,'img/pic1.jpg');
insert into food_product values(2,'momo',130,100,'img/pic2.jpg');
insert into food_product values(3,'thukpa',150,120,'img/pic3.jpg');
insert into food_product values (4,'samosa',60,40,'img/pic4.jpg');