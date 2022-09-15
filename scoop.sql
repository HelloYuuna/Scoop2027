Drop table scoop_user;
Drop SEQUENCE id_seq;

DROP TABLE scoop_member;
CREATE TABLE scoop_member (
      email	varchar2(320)   primary key NOT NULL,
      wsid	number		    NOT NULL,
      password varchar2(100) ,                          -- JS 유효성으로 체크
      name	varchar2(50)	NOT NULL,                   -- 폼 회원가입일 경우 무조건 받아야함
      picture VARCHAR2(1000) ,                          -- 구글 프로필 사진 (활용 여부는 미정)
      udept	varchar2(50)	,
      role	varchar2(30)
);

COMMENT ON COLUMN scoop_member.email IS '유저아이디(이메일)';
COMMENT ON COLUMN scoop_member.wsid IS '워크스페이스번호';
COMMENT ON COLUMN scoop_member.name IS '유저이름';
COMMENT ON COLUMN scoop_member.udept IS '부서명';
COMMENT ON COLUMN scoop_member.role IS '포지션';
COMMENT ON COLUMN scoop_member.password IS '폼가입비밀번호';
COMMENT ON COLUMN scoop_member.picture IS '프로필사진';

select * from scoop_member;
