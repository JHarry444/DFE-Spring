drop table if exists marsupial CASCADE;
create table marsupial
 (
 	id integer primary key auto_increment,
 	colour varchar(255),
 	name varchar(255),
 	species varchar(255)
 );