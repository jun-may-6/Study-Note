DROP
DATABASE IF EXISTS ACADEMY;

CREATE
DATABASE ACADEMY;
USE
ACADEMY;
GRANT ALL PRIVILEGES ON academy.* TO
'ohgiraffers'@'%';

CREATE TABLE IF NOT EXISTS TEACHER
(
    TEACHER_CODE
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY
    NOT
    NULL
    COMMENT
    '강사 코드',
    `NAME`
    VARCHAR
(
    7
) COMMENT '강사명',
    JOIN_DATE DATE COMMENT '입사일',
    `STATUS` CHAR
(
    1
) COMMENT '퇴사여부' DEFAULT 'N',
    CHECK
(
    `STATUS`
    IN
(
    'N',
    'Y'
))
    );

CREATE TABLE IF NOT EXISTS lecture
(
    lecture_code
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY
    NOT
    NULL
    COMMENT
    '강의 코드',
    `NAME`
    VARCHAR
(
    20
) COMMENT '강의명',
    TEACHER_CODE INT COMMENT '강사 코드',
    START_DATE DATE COMMENT '개강일',
    FOREIGN KEY
(
    TEACHER_CODE
) REFERENCES TEACHER
(
    TEACHER_CODE
)
    );

INSERT INTO TEACHER (`NAME`, JOIN_DATE, `STATUS`)
VALUES ('김하나', '2024-04-12', 'Y'),
       ('이두식', '2024-04-15', 'Y'),
       ('이삼순', '2024-04-17', 'Y'),
       ('박사라', '2024-04-20', 'Y'),
       ('최영수', '2024-04-25', 'Y'),
       ('강민수', '2024-05-01', 'N'),
       ('윤지혜', '2024-05-05', 'N'),
       ('정은지', '2024-05-10', 'Y'),
       ('조준호', '2024-05-15', 'Y'),
       ('한수민', '2024-05-20', 'N');

INSERT INTO lecture (`NAME`, TEACHER_CODE, START_DATE)
VALUES ('수학 기초', 1, '2024-05-01'),
       ('영어 회화', 2, '2024-06-01'),
       ('프로그래밍 입문', 3, '2024-07-01'),
       ('물리학 개론', 4, '2024-05-02'),
       ('화학 실험', 5, '2024-05-03'),
       ('생물학', 6, '2024-05-04'),
       ('역사', 7, '2024-05-05'),
       ('지리학', 8, '2024-05-06'),
       ('사회학', 9, '2024-05-07'),
       ('심리학', 10, '2024-05-08'),
       ('철학', 1, '2024-05-09'),
       ('미술', 2, '2024-05-10'),
       ('음악', 3, '2024-05-11'),
       ('체육', 4, '2024-05-12'),
       ('프랑스어', 5, '2024-05-13'),
       ('스페인어', 6, '2024-05-14'),
       ('독일어', 7, '2024-05-15'),
       ('일본어', 8, '2024-05-16'),
       ('중국어', 9, '2024-05-17'),
       ('문학', 10, '2024-05-18'),
       ('경제학', 1, '2024-05-19'),
       ('정치학', 2, '2024-05-20'),
       ('컴퓨터 과학', 3, '2024-05-21'),
       ('데이터 사이언스', 4, '2024-05-22');
