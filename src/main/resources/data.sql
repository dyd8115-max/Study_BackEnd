INSERT INTO article(title, content) VALUES('강아지', '멍멍');
INSERT INTO article(title, content) VALUES('고양이', '야옹');
INSERT INTO article(title, content) VALUES('병아리', '삐약');

INSERT INTO article_study(number, name, school) VALUES(2022, '이용균', '인천대');
INSERT INTO article_study(number, name, school) VALUES(2019, '김대형', '인하대');
INSERT INTO article_study(number, name, school) VALUES(2021, '서윤하', '인천대');


INSERT INTO article(title, content) VALUES('좋아하는 영화', 'ㅈㄱㄴ');
INSERT INTO article(title, content) VALUES('좋아하는 동물', 'ㅈㄱㄴ');
INSERT INTO article(title, content) VALUES('좋아하는 음식', 'ㅈㄱㄴ');


INSERT INTO comment(article_id, nickname, body) VALUES(4, 'a', '아이언맨3');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'b', '극한직업');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'a', '강아지');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'c', '고양이!');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'd', '카피바라');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'd', '떡볶이');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'c', '초밥');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'a', ' 피자');