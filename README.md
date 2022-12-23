# Spring-Web-Board-Project

  create sequence seq_board;--고유번호 시퀀스

  create table tbl_board (
bno number(10,0),
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regdate date default sysdate,
updatedate date default sysdate
);
--고유번호
--제목
--내용
--작성자
--생성시간
--수정시간

  alter table tbl_board add constraint pk_board
primary key (bno);--pk
