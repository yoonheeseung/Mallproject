create table guest77( 
	no int primary key,
	guest_name varchar2(20),
	guest_title varchar2(200),
	guest_pwd varchar2(20),
	guest_cont varchar2(4000),
	guest_hit int default 0,
	guest_ref int,
	guest_step int,
	guest_level int,
	guest_date date
);

/* 칼럼명 변경 */
alter table guest77 rename column guest_stop to guest_step;

create sequence guest77_no_seq
increment by 1 start with 1 nocache;

select * from guest77;
no,guest_name,guest_title,guest_pwd,guest_cont,guest_hit,guest_ref,guest_stop,	guest_level,guest_date

select * from 
(select rownum rnum,no,guest_name,guest_title,guest_cont,guest_ref,guest_step,guest_level,guest_hit,guest_date 
from (select * from guest77 order by guest_ref desc,guest_level asc)
)
where rnum>=1 and rnum<=20
					
select * from guest77
					