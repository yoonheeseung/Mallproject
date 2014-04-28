/* admin.sql */

 create table admin7(
   admin_no number(10) 
   ,admin_id varchar2(30) primary key
   ,admin_pwd varchar2(30) not null
   ,admin_name varchar2(30) 
   ,admin_date date
 );
 
 insert into admin7 values(1,'admin','admin','관리자',sysdate);
 
 select * from admin7;
 
 drop table admin7;