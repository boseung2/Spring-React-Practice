# Spring-React-Practice

### (Backend) Auth
* (POST) /api/auth/register
* (POST) /api/auth/login

### (Backend) Board url
* 리스트 - (GET) /api/board
* 등록 - (POST) /api/board
* 조회 - (GET) /api/board/{bno}
* 삭제 - (DELETE) /api/board/{bno}
* 수정 - (PUT) /api/board/{bno}

### (Backend) Reply url
* 리스트 - (GET) /api/reply/{bno}
* 등록 - (POST) /api/reply
* 삭제 - (DELETE) /api/reply/{rno}
* 수정 - (PUT) /api/reply/{rno}

---

### (Backend) Movie url
* 리스트 - (GET) /api/movie
* 등록 - (POST) /api/movie
* 조회 - (GET) /api/movie/{mno}   
  (추가예정)
* 삭제 - (DELETE) /api/movie/{mno}
* 수정 - (PUT) /api/movie/{mno}

### (Backend) Review url
* 리스트 - (GET) /api/review/{mno}
* 등록 - (POST) /api/review
* 삭제 - (DELETE) /api/review/{reviewnum}
* 수정 - (PUT) /api/review/{reviewnum}

---

### (Frontend) Board url
* 리스트 - /board
* 조회 - /board/:bno
* 등록 - /board/register
* 수정 - /board/register/:bno

## TODO (21.06.04 ~)

### 21.06.04

- [x] (Frontend) /board -> BoardListPage component 구성
- [x] (Frontend) /board/:bno -> BoardReadPage component 구성
- [x] (Frontend) /board/register -> BoardRegisterPage component 구성
- [x] (Frontend) /board/register/:bno -> BoardModifyPage component 구성
- [ ] ~~(Frontend) api 연동 및 Board 리스트 페이지 리덕스 적용~~

### 21.06.05

- [x] (Frontend) modules/board 리덕스 초기 설정 / 리덕스 공부
- [ ] ~~(Backend) jpql이용해 board 검색기능 추가~~

### 21.06.07

- [x] (Backend) jpql이용해 board 검색기능 추가
- [x] (Backend) Board 코드 흐름도 그리기 

### 21.06.08

- [x] (Backend) Reply url 정하고 api 구성하기

### 21.06.09

- [x] (Backend) Movie, Review, Member2 repository 구성하기
- [ ] ~~(Backend) Reply api 테스트~~

### 21.06.10

- [x] (Backend) MovieImage 파일 업로드 처리
- [x] (Backend) Movie api 구성
- [x] (Backend) Review api 구성
- [ ] ~~(Backend) Reply api 테스트~~
- [ ] ~~(Backend) Movie api 테스트~~
- [ ] ~~(Backend) Review api 테스트~~

### 21.06.11

- [x] (Backend) Note Api 구성
- [x] (Backend) Spring Security 추가

### 21.06.12

- [x] (Backend) Google Social Login 추가

### 21.06.13

- [x] (Backend) JWT Token 추가

## TODO (21.06.14 ~)

1. (Backend) 회원 테이블들을 club_member 테이블 하나로 관계맺기
2. (Backend) 모든 api 테스트 코드 추가 (repository, service, controller) + 자동화
3. (Backend) 유효성검사, 예외처리 코드 추가
4. (Backend) API 사용법 README 정리

### 21.06.14

- [x] (Backend) member 테이블 설계 해서 통합

### 21.06.16

- [ ] (Backend) member-note 기능 리팩토링(자동화된 테스트 코드 추가, 유효성검사 추가, 예외처리 추가, API 사용법 README 추가)