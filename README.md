# Open-Feign-Test
OpenFeign 테스트
- Jira Cloud API 요청하여 이슈 생성 및 조회하기

1. 직접 API 요청
- 이슈 생성: POST http://localhost:8080/test/{issueKeyOrId}
- 이슈 조회: GET &nbsp;&nbsp;http://localhost:8080/test
- 직접 API를 호출하므로, API 호출을 위해 헤더에 인증 값을 넣는 처리가 필요함.

2. API 요청하는 서비스가 따로 만들어져있고, 그 서비스를 호출
- 이슈 생성: POST http://localhost:8080/test2/{issueKeyOrId}
- 이슈 조회: GET &nbsp;&nbsp;http://localhost:8080/test2
- 서비스에서 헤더 인증 값 처리 및 API 호출을 함.
- 따라서, 해당 서비스만 호출하면 됨.
