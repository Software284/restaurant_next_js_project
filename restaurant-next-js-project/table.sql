CREATE SEQUENCE food_product_id_seq
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