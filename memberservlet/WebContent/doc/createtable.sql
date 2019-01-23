drop table member_detail;

drop table member;

create table member
(
	id varchar2(16),
	name varchar2(30) not null,
	pass varchar2(16) not null,
	emailid varchar2(16),
	emaildomain varchar2(50),
	joindate date default sysdate,
	constraint member_id_pk primary key(id)
);


create table member_datail
(
	id varchar2(16),
	tel1 varchar2(3),
	tel2 varchar2(4),
	tel3 varchar2(4),
	zipcode varchar2(5),
	address varchar2(100),
	address_datail varchar2(100),
	constraint member_detail_id_fk foreign key(id)
	references member(id)
);
