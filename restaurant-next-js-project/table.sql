CREATE SEQUENCE food_product_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
create table food_product(
    id number(10) primary key,
    name varchar2(50) not null,
    img varchar2(50) not null,
    ratings number(1) not null,
    price number(10) not null,
    description varchar2(400) not null,
    price_range varchar2(100) not null,
    type varchar2(100) not null
);

insert into food_product values(1,'Momo','img/momo.jpg',4,150,'Momo are bite-size dumplings made with a spoonful of stuffing wrapped in dough. Momo are usually steamed, though they are sometimes fried or steam-fried. Meat or vegetables fillings becomes succulent as it produces an intensively flavored broth sealed inside the wrappers','Less Than 200','Food');
insert into food_product values(2,'Chaumin','img/chaumin.jpg',4,120,'A Chinese dish consisting of noodles fried with chicken, pork, beef, or fish, and a variety of vegetables. Chinese restaurants in Western nations usually prepare the dish with shredded chicken, celery, onions, mushrooms, and fried noodles.','Less Than 200','Food');
insert into food_product values(3,'Thukpa','img/thukpa.jpg',4,200,'Thukpa is a traditional Tibetan staple food suitable for the highland climate to keep the nomads warm during the long Tibetan winters enjoying a very nutritious meal. Generally speaking, noodle soups of all kinds are known as thukpa.','Less Than 200','Food');
insert into food_product values(4,'Chicken Chilly','img/chickenchilly.jpg',4,300,'Nepali chicken chili is served in almost all the Nepali restaurants in Nepal, and internationally. It is a very popular dish. The hot chili, capsicum being bitter and spicy, tomatoes, onion and ketchup sweetness, all bringing out a unique taste of Nepali authentic recipe, which is absolutely acquired.','Less Than 300','Food');
insert into food_product values(5,'Sasausage','img/sasausage.jpg',4,500,'sausage, meat product made of finely chopped and seasoned meat, which may be fresh, smoked, or pickled and which is then usually stuffed into a casing. Sausages of fish or poultry are also made','Less Than 500','Food');
insert into food_product values(6,'Chicken Lollypop','img/lollypup.jpg',4,300,'This Chicken Lollipop Recipe is generally considered as a hors d’œuvre or appetizer dish. Though not everyone may know, this chicken dish is made from chicken wings','Less Than 300','Food');
insert into food_product values(7,'Vodka','img/vodka.jpg',5,500,'vodka, distilled liquor, clear and colourless and without definite aroma or taste, ranging in alcoholic content from about 40 to 55 percent','Less Than 500','Drinks');
insert into food_product values(8,'Coke','img/coke.jpg',5,200,'vodka, distilled liquor, clear and colourless and without definite aroma or taste, ranging in alcoholic content from about 40 to 55 percent','Less Than 200','Drinks');
insert into food_product values(9,'Juice','img/juice.jpg',5,200,'vodka, distilled liquor, clear and colourless and without definite aroma or taste, ranging in alcoholic content from about 40 to 55 percent','Less Than 100','Drinks');







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

  CREATE SEQUENCE food_favouritesproduct_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
 create table food_favouritesproduct(
  id number(10) primary key,
  name varchar2(40) not null,
  price number(10) not null,
  quantity number(10) not null,
  image varchar2(50) not null,
  username varchar2(50) not null
  );

  /* security tables */

CREATE SEQUENCE user_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

  create table users(
    USERNAME varchar2(70),
    PASSWORD varchar2(70) NOT NULL,
    ENABLED char(1) NOT NULL CHECK(ENABLED IN('Y','N')),
    primary key(username)
    );
    
    insert into users values('mahesh@gmail.com','$2y$10$SlQ6xPNZgjYjy8w01VQO5uFi.arpbcRleyplr40r138W7ctfSuCri','Y');
    insert into users values('nabin@gmail.com','$2y$10$QDuZL9LUP7pRknXwU25KyO5Ap23faZRb.RTwf8vKd/upksbsVwI4q','Y');
    
     create table authorities(
        authority_id number(10) primary key,
        role varchar2(128) not null,
        authority varchar(128) not null
        );
        CREATE SEQUENCE authorities_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
        alter table authorities add constraint authorities_unique unique(role,authority);
        alter table authorities add constraint authorities_FK1 foreign key(ROLE) references roles(role);
        
        insert into authorities values(1,'ROLE_ADMIN','ADD_PRODUCT');
        insert into authorities values(2,'ROLE_USER','GET_PRODUCT');
        
        
    
    create table roles(
    id number(10),
    ROLE varchar2(128) not null,
    primary key(id),
    alter table roles add constraint role_unique unique(role);
    );
    CREATE SEQUENCE role_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
    insert into roles values('ROLE_ADMIN');
    insert into roles values('ROLE_USER');
    
  
    
    create table USER_ROLE(
        USER_ROLE_ID number(10) primary key,
        USERNAME varchar2(128) not null,
        ROLE varchar2(128) not null
        );

    CREATE SEQUENCE user_role_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;

    alter table user_role add constraint user_role_unique unique(username,role);
    alter table user_role add constraint user_role_fk3 foreign key(username) 
    references users(username);
    alter table user_role add constraint user_role_fk2 foreign key(role) 
    references roles(role);
    
    insert into user_role values(1,'mahesh@gmail.com','ROLE_ADMIN');
    insert into user_role values(2,'nabin@gmail.com','ROLE_USER');
   



  