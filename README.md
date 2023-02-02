# Spring-Web-Board-Project

## Orcle Table

#### 게시판 테이블
- 게시판 시퀀스 생성
```
create sequence seq_board;--고유번호 시퀀스
```

- 게시판 테이블 생성
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

- 고유번호에 pk 부여
```
alter table tbl_board add constraint pk_board
primary key (bno);--board_pk
```

- 더미데이터
```
insert into tbl_board(bno, title, content, writer) 
values (seq_board.nextval, '테스트 제목','테스트 내용','user00'); --더미데이터
```

<hr/>

#### 댓글 테이블

- 댓글 테이블 생성
```
create table tbl_reply (
  rno number(10,0), -- 고유번호
  bno number(10,0) not null, -- 게시물 고유번호
  reply varchar2(1000) not null, --댓글 내용
  replyer varchar2(50) not null, -- 댓글 작성자 
  replyDate date default sysdate,  -- 댓글 생성일
  updateDate date default sysdate -- 댓글 수정일
);
```

- 댓글 시퀀스 생성
```
create sequence seq_reply; --댓글고유 번호
```

- 댓글 고유번호 PK 부여 (댓글자체 단독 CRUD)
```
alter table tbl_reply add constraint pk_reply primary key (rno);
```

- 게시글 고유번호(tbl_board) bno 를 참조하는 참조키 부여
``` 
alter table tbl_reply  add constraint fk_reply_board 
foreign key (bno)  references  tbl_board (bno); 
```


