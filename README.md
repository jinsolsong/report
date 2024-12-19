## 필수과제 API 명세

### Lv1
| 기능        | Http Method | URL         | request<br/>Body                                                                     | respnse<br/>Body                                                                                                                 |
|-----------|-------------|-------------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 스케줄 생성    | `POST`      | /schedules2 | {<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo":"String"<br/>}       | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 목록 조회 | `GET`       | /schedules2      | -                                                                                    | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"}                    |
| 스케줄 수정    | `PATCH`     | /schedules2/{id} | {<br/>"username" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>} | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"}                    |
| 스케줄 삭제    | `DELETE`    | /schedules2/{id} | -                                                                                    | -                                                                                                                                |


### Lv2-3
| 기능        | Http Method | URL              | request<br/>Body                                                                     | respnse<br/>Body                                                                                                                 |
|-----------|-------------|------------------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 스케줄 생성    | `POST`      | /schedules2      | {<br/>"userId" : "String",<br/>"title" : "String",<br/>"todo":"String"<br/>}         | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 목록 조회 | `GET`       | /schedules2      | -                                                                                    | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 수정    | `PATCH`     | /schedules2/{id} | {<br/>"userId" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>}   | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 삭제    | `DELETE`    | /schedules2/{id} | -                                                                                    | -                                                                                                                                |
| 유저 생성     | `POST`            | /users/signup    | {<br/>"username" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>} | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 단일 조회  | `GET`            | /users/{id}      | -                                                                                    | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 목록 조회  | `GET`            | /users           | -                                                                                    | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 수정     | `PATCH`            | /users/{id}                 | {<br/>"username" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>} | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 삭제     | `DELETE`            | /users/{id}                 | -                                                                                    | -                                                                                                                                |

### Lv4
| 기능        | Http Method | URL              | request<br/>Body                                                                           | respnse<br/>Body                                                                                                                 |
|-----------|-------------|------------------|--------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 스케줄 생성    | `POST`  | /schedules2      | {<br/>"userId" : "String",<br/>"title" : "String",<br/>"todo":"String"<br/>}               | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 목록 조회 | `GET`  | /schedules2      | -                                                                                          | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 수정    | `PATCH`  | /schedules2/{id} | {<br/>"userId" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>}         | {<br/>"id" : "Number",<br/>"userName" : "String",<br/>"title" : "String",<br/>"todo" : "String",<br/>"createdDate" : "DateTime"} |
| 스케줄 삭제    | `DELETE`  | /schedules2/{id} | -                                                                                          | -                                                                                                                                |
| 유저 생성     | `POST`  | /users/signup    | {<br/>"username" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>}       | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 단일 조회  | `GET`  | /users/{id}      | -                                                                                          | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 목록 조회  | `GET` | /users           | -                                                                                          | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 수정     | `PATCH`  | /users/{id}      | {<br/>"username" : "String",<br/>"eMail" : "String",<br/>"password" : "String"<br/>}       | {<br/>"id" : "Number",<br/>"username" : "String",<br/>"createdDate" : "DateTime",<br/>"eMail" : "String"<br/>}                   |
| 유저 삭제     | `DELETE` | /users/{id}      | -                                                                                          | -                                                                                                                                |
| 로그인    | `POST`   | /session-login   | Key -------------------Value<br/>eMail(Text)----------String<br/>password(Text)-----String | 로그인 되었습니다.                                                                                                                       |
| 로그아웃    | `POST`  | /session-logout  | -                                                                                          | 로그아웃 되었습니다.                                                                                                                      |

