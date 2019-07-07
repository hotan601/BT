create database Connect character set utf8 collate utf8_general_ci;
drop database Connect;
create table user(
id int primary key auto_increment,
name varchar(255) not null,
pass varchar(255),
age int not null
);
select *from  user;
drop  table user;
insert into user(name,pass,age) values ("Le Van A", 12345, 14);
insert into user(name,pass,age) values ("Tran Thi B", 18855, 18);
insert into user(name,pass,age) values ("Nguyen Van C", 45645, 24);
insert into user(name,pass,age) values ("Le Van D", 95623, 15);
insert into user(name,pass,age) values ("Mai Thi J", 85263, 19);
insert into user(name,pass,age) values ("Huynh Thi P", 15683, 56);
insert into user(name,pass,age) values ("Le Van A", 15265, 54);
insert into user(name,pass,age) values ("Le Thi G",52689, 75);
insert into user(name,pass,age) values ("Tran Thi H", 85692, 28);
insert into user(name,pass,age) values ("Nguyen Van F", 74896, 58);
insert into user(name,pass,age) values ("Phan Van E", 02596, 14);
insert into user(name,pass,age) values ("Le Van B", 12583, 44);
insert into user(name,pass,age) values ("Pham Van S", 74586, 11);
insert into user(name,pass,age) values ("Truong Thi T", 41528, 45);
insert into user(name,pass,age) values ("Nguyen Van I", 74855, 25);
insert into user(name,pass,age) values ("Le Van D", 41526, 46);
insert into user(name,pass,age) values ("Ho Van T", 62359, 74);
insert into user(name,pass,age) values ("Le Van B", 47596, 66);
insert into user(name,pass,age) values ("Tran Thi K", 74896, 33);
insert into user(name,pass,age) values ("Le Van U", 18565, 85);
insert into user(name,pass,age) values ("Le Van C", 48885, 76);
insert into user(name,pass,age) values ("Le Van D", 45629, 45);
insert into user(name,pass,age) values ("Le Van E", 74569, 55);
select *from user;



