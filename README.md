# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제

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

**추가. acceess token 재발급 엔드포인트**

POST `http://localhost:8080/member/login/reissue`

```
+ Request Headers

인증 필요 없음

+ Request Body

{
    "accessToken" : {accesstoken},
    "refreshToken" : {refreshToken}
}

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

- 사용자 정보 (이메일, 비밀번호)를 입력받고, 비밀번호를 암호화하여 이메일과 함께 Database에 저장하는 회원가입 기능을 구현하였습니다. 

- 사용자 정보 유효성 검사를 위해 이메일이 @를 포함하지 않거나, 비밀번호가 8자 미만인 경우는 Exception을 응답하도록 하였습니다. 이 외의 다른 유효성 과정은 구현하지 않았습니다.

**과제 2. 사용자 로그인 엔드포인트**

- 로그인 정보 (이메일, 비밀번호)를 통해 JWT 토큰을 발급하는 로그인 기능을 구현하였습니다.

- '회원가입'에서와 동일한 유효성 검사를 진행하며, 추가로 Database에 저장되어 있는 사용자 정보와 입력된 정보를 비교하여 로그인 과정이 가능한지 확인합니다. 

- 모든 검사가 끝나면, JWT 토큰 (access token, refresh token)을 발급하여 응답하고 refresh token은 이후 access token 재발급을 위해 Database에 저장합니다. 

**과제 3. 새로운 게시글을 생성하는 엔드포인트**

- 로그인 정보와 게시글 정보를 통해 새로운 게시글을 생성하는 기능을 구현하였습니다. 

- 로그인한 사용자만 게시글을 작성할 수 있기 때문에 access token을 header에 포함해 전달하고, token을 통해 사용자 정보를 가져올 수 있습니다. 

**과제 4. 게시글 목록을 조회하는 엔드포인트**

- 로그인 없이도 가능한, page 정보와 각 page 안 게시글 size 정보를 통해 게시글 목록을 조회하는 기능을 구현하였습니다.

**과제 5. 특정 게시글을 조회하는 엔드포인트**

- 로그인 정보와 게시글 ID를 통해 특정 게시글을 조회하는 기능을 구현하였습니다. 

- 로그인한 사용자만 게시글을 조회할 수 있기 때문에 access token을 header에 포함해 전달합니다.

**과제 6. 특정 게시글을 수정하는 엔드포인트**

- 로그인 정보와 게시글 ID, 그리고 수정한 게시글 정보를 통해 특정 게시글을 수정하는 기능을 구현하였습니다.

- 로그인한 사용자만 게시글을 수정할 수 있기 때문에 access token을 header에 포함해 전달하며, 본문과 제목 중 하나만 수정이 가능할 수 있도록 PUT이 아닌 PATCH로 method를 정의하였습니다. 

- 게시글 작성자와 게시글을 수정하려는 로그인 사용자가 동일해야 하기 때문에, 사용자 정보를 비교하여 사용자가 동일하지 않을 경우 Exception을 응답합니다. 

**과제 7. 특정 게시글을 삭제하는 엔드포인트**

- 로그인 정보와 게시글 ID를 통해 특정 게시글을 삭제하는 기능을 구현하였습니다.

- 로그인한 사용자만 게시글을 삭제할 수 있기 때문에 access token을 header에 포함해 전달합니다.

- 수정 기능과 마찬가지로, 게시글 작성자와 게시글을 삭제하려는 로그인 사용자가 동일해야 하므로 사용자 정보를 비교하여 동일하지 않을 경우 Exception을 응답합니다. 

**추가. acceess token 재발급 엔드포인트**

- access token이 만료된 경우, 가지고 있던 access token과 refresh token을 함께 보내 새로운 access token을 재발급 할 수 있는 기능을 구현하였습니다.

- refresh token의 유효성을 확인하고, 아직 사용이 가능한 경우에만 access token을 재발급합니다. 

<br>

### ☑️ API 명세(request/response 포함)

<hr> 

📚 [Postman으로 확인하는 Member API](https://documenter.getpostman.com/view/25121598/2s9Y5R15kd) <br>
📚 [Postman으로 확인하는 Board API](https://documenter.getpostman.com/view/25121598/2s9Y5QzkxY#f9f98251-2698-4c17-840f-bee13aadc8d4)

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

**추가. acceess token 재발급 엔드포인트**

POST `http://localhost:8080/member/login/reissue`

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
    "accessToken" : {accesstoken},
    "refreshToken" : {refreshToken}
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
        "accessToken": {accesstoken}
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

</div>
</details>
