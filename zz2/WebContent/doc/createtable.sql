drop table member;

create table member
(
	id varchar2(16),
	name varchar2(30) not null,
	pass varchar2(16) not null,
	emaildomain varchar2(100),
	joindate date default sysdate,
	constraint member_id_pk primary key(id)
);