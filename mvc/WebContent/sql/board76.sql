/* board76.sql */

create table board76(
 board_no number(20) primary key
 ,board_name varchar2(60) not null
 ,board_title varchar2(200) not null
 ,board_pwd varchar2(30) not null
 ,board_cont varchar2(4000) not null
 ,board_hit int default 0
 ,board_ref int /*글 그룹번호*/
 ,board_step int /*답변글 위치번호*/
 ,board_level int /*답변글 레벨*/
 ,board_date date
);

drop sequence board76_no_seq;

create sequence board76_no_seq
increment by 1 start with 40;

select board76_no_seq.nextval from dual;//41;

alter sequence board76_no_seq;

select * from board76 order by board_no desc;

select count(*) from board76

board_no,board_name,board_title,board_pwd,board_cont,board_hit,board_ref,board_step,board_level,board_date 

select * from user_objects


select board_no_seq.nextval from dual;