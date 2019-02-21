
drop table member;
create table member
(
	id varchar2(16),
	name varchar2(30) not null,
	pass varchar2(16) not null,
	email varchar2(100),
	joindate date default sysdate,
	constraint member_id_pk primary key(id)
);

drop table member;
CREATE TABLE MEMBER
(
    ID           VARCHAR2(20)    NOT NULL, 
    NAME         VARCHAR2(20)    NULL, 
    EMAIL        VARCHAR2(50)    NULL, 
    PASS         VARCHAR2(20)    NULL, 
    JOINDATE     DATE            NULL, 
    ADMINCODE    NUMBER(1)       NULL, 
    CONSTRAINT MEMBER_PK PRIMARY KEY (ID)
)