# Spring-Web-Board-Project
### Orcle Table

```
create sequence seq_board;--고유번호 시퀀스
```
<hr/>

```
create table tbl_board (
bno number(10,0), --고유번호
title varchar2(200) not null, --제목
content varchar2(2000) not null, --내용
writer varchar2(50) not null, --작성자
regdate date default sysdate, --생성시간
updatedate date default sysdate --수정시간
);
```

<hr/>

```
alter table tbl_board add constraint pk_board
primary key (bno);--board_pk
```

<hr/>

```
insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval, '테스트 제목','테스트 내용','user00'); --더미데이터
```


