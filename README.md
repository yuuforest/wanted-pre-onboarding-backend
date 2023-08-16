# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제 😳

### ☑️ 지원자 : 강유림

### ☑️ 애플리케이션 실행 방법 (엔드포인트 호출 방법 포함)

**과제 1. 사용자 회원가입 엔드포인트**

[POST] http://localhost:8080/member

- Request Body
```
{
    "email" : "yurimkang20@gmail.com",
    "password" : "12345678!!"
}
```

**과제 2. 사용자 로그인 엔드포인트**

[POST] http://localhost:8080/member/login

- Request Body
```
{
    "email" : "yurimkang20@gmail.com",
    "password" : "12345678!!"
}
```

**과제 3. 새로운 게시글을 생성하는 엔드포인트** 

[POST] http://localhost:8080/board

- Request Headers
```
Authorization : [accessToken]
```

- Request Body
```
{
    "title": "제목입니다",
    "content": "본문입니다."
}
```

**과제 4. 게시글 목록을 조회하는 엔드포인트**

[GET] http://localhost:8080/board/all?page={page}&size={size}

- Request Headers
```
인증 필요 없음
```

**과제 5. 특정 게시글을 조회하는 엔드포인트**

[GET] http://localhost:8080/board/{게시글 ID}

- Request Headers
```
Authorization : [accessToken]
```

**과제 6. 특정 게시글을 수정하는 엔드포인트**

[PATCH] http://localhost:8080/board/{게시글 ID}

- Request Headers
```
Authorization : [accessToken]
```

- Request Body
```
{
    "title": "변경한 제목입니다. ",
    "content": "변경한 본문입니다. "
}
```

**과제 7. 특정 게시글을 삭제하는 엔드포인트**

[DELETE] http://localhost:8080/board/{게시글 ID}

- Request Headers
```
Authorization : [accessToken]
```