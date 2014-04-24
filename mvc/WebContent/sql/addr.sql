/* addr.sql */

 create table addr7(
  no number(10) primary key
  ,name varchar2(30) not  null
  ,addr varchar2(200) not null
  ,phone varchar2(30) not null
  ,email varchar2(100) not null
  ,regdate date
 );
 
 
 select * from user_objects;
 create sequence addr7_no_seq
 increment by 1 start with 1 nocache;
 
 select * from addr7 order by no desc;
 

 create table post7(
 no number(10) primary key,
 name varchar2(30) not null,
 cont varchar2(300) not null
 );
 


 select * from post7;
 
 alter table post7 modify cont varchar2(4000);