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

- [x] (Front) /board -> BoardListPage component 구성
- [x] (Front) /board/:bno -> BoardReadPage component 구성
- [x] (Front) /board/register -> BoardRegisterPage component 구성
- [x] (Front) /board/register/:bno -> BoardModifyPage component 구성
- [ ] (Front) api 연동 및 Board 리스트 페이지 리덕스 적용

### 21.06.05

- [ ] (Front) modules/board 리덕스 초기 설정 / 리덕스 공부
- [ ] (Back) jpql이용해 board 검색기능 추가