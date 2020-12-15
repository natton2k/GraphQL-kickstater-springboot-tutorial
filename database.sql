/*Step 1: create database 
create database BookManagement
use BookManagement*/

/*Step 2: create tables
create table Author(
	id bigint primary key,
	fullname nvarchar(100)
)

create table Book(
	isbn char(13) primary key,
	title nvarchar(100) not null,
	edition int,
	publishedYear int,
	authorId bigint foreign key references Author(id)
)*/

/*Step 3: create some data
insert into Author values(1, N'Paulo Coelho');
insert into Author values(2, N'Rosie Nguyễn');
insert into Author values(3, N'Robin Sharma');

insert into Book values ('2518407786529', N'The Alchemist (Nhà giả kim)', 1, 2013, 1);
insert into Book values ('6911225907262', N'Tuổi Trẻ Đáng Giá Bao Nhiêu', 2, 2018, 2);
insert into Book values ('2425402340697', N'Đời Ngắn Đừng Ngủ Dài', 2, 2014, 3);*/