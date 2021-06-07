# Spring-React-Practice

### (Backend) Board url
* 리스트 - (GET) /api/board/
* 등록 - (POST) /api/board/
* 조회 - (GET) /api/board/{bno}
* 삭제 - (DELETE) /api/board/{bno}
* 수정 - (PUT) /api/board/{bno}

### (Frontend) Board url
* 리스트 - /board
* 조회 - /board/:bno
* 등록 - /board/register
* 수정 - /board/register/:bno

## Todo

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
- [ ] (Backend) Board 코드 흐름도 그리기 