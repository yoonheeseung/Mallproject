/* gongji7.sql */
create table gongji7(
gongji_no number(20) primary key,
gongji_name varchar2(30) not null,
gongji_title varchar2(300) not null,
gongji_pwd varchar2(30) not null,
gongji_cont varchar2(4000) not null,
gongji_hit number(20) default 0,
gongji_date date
);

create sequence gongji7_no_seq
increment by 1 start with 1 nocache;

select * from gongji7 order by gongji_no desc;
