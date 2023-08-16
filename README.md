# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제 😳

### ☑️ 지원자 : 

<br>

### ☑️ 애플리케이션 실행 방법 (엔드포인트 호출 방법 포함)

<hr>

**과제 1. 사용자 회원가입 엔드포인트**

POST `http://localhost:8080/member`

```
+ Request Headers

인증 필요 없음

+ Request Body

{
    "email" : "yurimkang20@gmail.com",
    "password" : "12345678!!"
}
```

**과제 2. 사용자 로그인 엔드포인트**

POST `http://localhost:8080/member/login`

```
+ Request Headers

인증 필요 없음

+ Request Body

{
    "email" : "yurimkang20@gmail.com",
    "password" : "12345678!!"
}
```

**과제 3. 새로운 게시글을 생성하는 엔드포인트** 

POST `http://localhost:8080/board`

```
+ Request Headers

Authorization : [accessToken]

+ Request Body

{
    "title": "제목입니다",
    "content": "본문입니다."
}
```


**과제 4. 게시글 목록을 조회하는 엔드포인트**

GET `http://localhost:8080/board/all?page={page}&size={size}`

```
+ Request Headers

인증 필요 없음
```

**과제 5. 특정 게시글을 조회하는 엔드포인트**

GET `http://localhost:8080/board/{게시글 ID}`

```
+ Request Headers

Authorization : [accessToken]
```

**과제 6. 특정 게시글을 수정하는 엔드포인트**

PATCH `http://localhost:8080/board/{게시글 ID}`

```
+ Request Headers

Authorization : [accessToken]

+ Request Body

{
    "title": "변경한 제목입니다. ",
    "content": "변경한 본문입니다. "
}
```


**과제 7. 특정 게시글을 삭제하는 엔드포인트**

DELETE `http://localhost:8080/board/{게시글 ID}`

```
+ Request Headers

Authorization : [accessToken]
```

<br>

### ☑️ 데이터베이스 테이블 구조

<hr> <br>

<img src=".\docs\Database.PNG">

<br>

### ☑️ 구현한 API의 동작을 촬영한 데모 영상 링크

<hr> 

🎥 **[구현한 API의 동작을 촬영한 데모 영상 링크](https://drive.google.com/drive/folders/1nMgrRt6uFRoli1TIQ4rMHHYmZaKLeyHY?usp=drive_link)**

<br>

### ☑️ 구현 방법 및 이유에 대한 간략한 설명

<hr> 

**과제 1. 사용자 회원가입 엔드포인트**

**과제 2. 사용자 로그인 엔드포인트**

**과제 3. 새로운 게시글을 생성하는 엔드포인트**

**과제 4. 게시글 목록을 조회하는 엔드포인트**

**과제 5. 특정 게시글을 조회하는 엔드포인트**

**과제 6. 특정 게시글을 수정하는 엔드포인트**

**과제 7. 특정 게시글을 삭제하는 엔드포인트**

<br>

### ☑️ API 명세(request/response 포함)

<hr> 

**과제 1. 사용자 회원가입 엔드포인트**

POST `http://localhost:8080/member`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
인증 필요 없음
```

Request Body
```
{
    "email" : {사용자 이메일},
    "password" : {사용자 비밀번호}
}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다."
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "ID_MISSING_SYMBOL",
    "message": "이메일에 @가 포함되지 않았습니다."
}
```
```
{
    "success": false,
    "code": "400",
    "error": "PASSWORD_SHORT_LENGTH",
    "message": "비밀번호가 8자 미만입니다."
}
```

</div>
</details>

**과제 2. 사용자 로그인 엔드포인트**

POST `http://localhost:8080/member/login`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
인증 필요 없음
```

Request Body
```
{
    "email" : {사용자 이메일},
    "password" : {사용자 비밀번호}
}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다.",
    "data": {
        "accessToken": {accessToken},
        "refreshToken": {refreshToken}
    }
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "PASSWORD_SHORT_LENGTH",
    "message": "비밀번호가 8자 미만입니다."
}
```
```
{
    "success": false,
    "code": "400",
    "error": "ID_NOT_CORRECT",
    "message": "존재하지 않는 이메일입니다."
}
```

</div>
</details>

**과제 3. 새로운 게시글을 생성하는 엔드포인트**

POST `http://localhost:8080/board`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
{accessToken}
```

Request Body
```
{
    "title": {게시글 제목},
    "content": {게시글 본문}
}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다."
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "TOKEN_ERROR",
    "message": "유효하지 않거나 만료된 토큰입니다."
}
```

</div>
</details>

**과제 4. 게시글 목록을 조회하는 엔드포인트**

GET `http://localhost:8080/board/all?page={page}&size={size}`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
인증 필요 없음
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다.",
    "data": [
        {
            "boardSeq": {게시글 ID},
            "title": {게시글 제목},
            "createDate": {작성 날짜 및 시간}
        },
        {
            "boardSeq": {게시글 ID},
            "title": {게시글 제목},
            "createDate": {작성 날짜 및 시간}
        }
    ]
}
```

</div>
</details>

**과제 5. 특정 게시글을 조회하는 엔드포인트**

GET `http://localhost:8080/board/{게시글 ID}`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
{accessToken}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다.",
    "data": {
        "boardSeq": {게시글 ID},
        "title": {게시글 제목},
        "content": {게시글 본문},
        "createDate": {작성 날짜 및 시간},
        "modifyDate": {수정 날짜 및 시간},
        "writer": {작성자 이메일}
    }
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "TOKEN_ERROR",
    "message": "유효하지 않거나 만료된 토큰입니다."
}
```
```
{
    "success": false,
    "code": "400",
    "error": "BOARD_NOT_CORRECT",
    "message": "해당하는 게시글이 존재하지 않습니다."
}
```

</div>
</details>

**과제 6. 특정 게시글을 수정하는 엔드포인트**

PATCH `http://localhost:8080/board/{게시글 ID}`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
{accessToken}
```

Request Body
```
{
    "title": {변경한 게시글 제목},
    "content": {변경한 게시글 본문}
}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다."
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "TOKEN_ERROR",
    "message": "유효하지 않거나 만료된 토큰입니다."
}
```
```
{
    "success": false,
    "code": "400",
    "error": "BOARD_NOT_CORRECT",
    "message": "해당하는 게시글이 존재하지 않습니다."
}
```

</div>
</details>

**과제 7. 특정 게시글을 삭제하는 엔드포인트**

DELETE `http://localhost:8080/board/{게시글 ID}`

<details>
<summary>request</summary>
<div markdown="1">

Request Header
```
{accessToken}
```

</div>
</details>

<details>
<summary>response</summary>
<div markdown="1">

성공
```
{
    "success": true,
    "message": "요청에 성공하였습니다."
}
```

실패
```
{
    "success": false,
    "code": "400",
    "error": "TOKEN_ERROR",
    "message": "유효하지 않거나 만료된 토큰입니다."
}
```
```
{
    "success": false,
    "code": "400",
    "error": "BOARD_NOT_CORRECT",
    "message": "해당하는 게시글이 존재하지 않습니다."
}
```

</div>
</details>
