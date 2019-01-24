drop table guestbook;

drop sequence guestbook_seq;

create sequence guestbook_seq
increment by 1
start with 1;

create table guestbook
(
	seq number,
	name varchar2(30) not null,
	subject varchar2(100) not null,
	content varchar2(4000),
	logtime date default sysdate,
	constraint guestbook_seq_pk primary key(seq)
);

select seq,name,subject,content,
		case when to_char(logtime,'yymmdd') = to_char(sysdate,'yymmdd')
			then to_char(logtime,'hh24:mi:ss')
			else to_char(logtime,'yy.mm.dd')
		end logtime
from guestbook
order by seq desc;


select seq,name,subject,content,
		decode(to_char(logtime,'yymmdd'),(sysdate,'yymmdd'),to_char(logtime,'hh24:mi:ss'),
		to_char(logtime,'yy.mm.dd')) logtime
from guestbook
order by seq desc;

