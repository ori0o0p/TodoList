## TodoList Backend Application

### Project Structure
1. **Presentation Layer**: 사용자 인터페이스 제공 계층. 클라이언트와 직접적인 상호작용

2. **Application Layer**: 비즈니스 로직 처리 계층. 

3. **Domain Layer**: 데이터 상태, 행위 관리 계층.

### Data Flow

이 프로젝트는 추후 확장을 고려하여 계층 별 독립성을 강하게 유지시키기 위해 이런 데이터 흐름을 따릅니다.

```
  {presentation}        {application}          {domain}       - Layer
      [form]    ->     [internal dto]    ->    [entity]       - Data flow
            (mapping)                (mapping)                - Mapping needed
```

사용자에게 입력 받은 객체(Form)을 애플리케이션 계층에서 Adapter 패턴을 사용하여 Internal DTO로 변환 Form과 Internal DTO에서는 DP를 사용하여 꾸준히 데이터 유효성 검사 진행.

그 후 Internal DTO는 도메인 계층의 Entity로 매핑.

### API Spec
- REST API: http://localhost:8080/api/todo
- GraphQL: http://localhost:8080/graphql

#### REST API

- **할 일 추가**: 새로운 할 일을 추가
    - **엔드포인트**: `POST /api/todo`
    - **요청 본문**: `TodoListElementSaveRequest`
    - **응답**: `TodoListElementKeyResponse`

- **할 일 삭제**: 기존 할 일을 삭제
    - **엔드포인트**: `DELETE /api/todo/{key}`
    - **응답**: `204 No Content`

- **할 일 초기화**: 모든 할 일을 초기화
    - **엔드포인트**: `PUT /api/todo/init`
    - **응답**: `204 No Content`

- **할 일 완료 표시**: 특정 할 일을 완료 상태로 표시
    - **엔드포인트**: `PATCH /api/todo/{key}`
    - **응답**: `204 No Content`

- **전체 할 일 조회**: 모든 할 일을 조회
    - **엔드포인트**: `GET /api/todo`
    - **응답**: `List<TodoListElementResponse>`

- **완료된 할 일 조회**: 완료된 할 일만 조회
    - **엔드포인트**: `GET /api/todo/successful`
    - **응답**: `List<TodoListElementResponse>`

- **미완료된 할 일 조회**: 미완료된 할 일만 조회
    - **엔드포인트**: `GET /api/todo/unsuccessful`
    - **응답**: `List<TodoListElementResponse>`

#### GraphQL

- **할 일 추가**: 새로운 할 일을 추가
    - **Mutation**: `addTodo`
    - **인자**: `TodoInput`
    - **응답**: `TodoListElementKeyResponse`

- **할 일 삭제**: 기존 할 일을 삭제
    - **Mutation**: `removeTodo`
    - **인자**: `Key`
    - **응답**: `Boolean`

- **할 일 초기화**: 모든 할 일을 초기화
    - **Mutation**: `initTodos`
    - **응답**: `Boolean`

- **할 일 완료 표시**: 특정 할 일을 완료 상태로 표시
    - **Mutation**: `markTodoSuccess`
    - **인자**: `Key`
    - **응답**: `Boolean`

- **전체 할 일 조회**: 모든 할 일을 조회
    - **Query**: `getAllTodos`
    - **응답**: `List<TodoListElementResponse>`

- **완료된 할 일 조회**: 완료된 할 일만 조회
    - **Query**: `getSuccessfulTodos`
    - **응답**: `List<TodoListElementResponse>`

- **미완료된 할 일 조회**: 미완료된 할 일만 조회
    - **Query**: `getUnsuccessfulTodos`
    - **응답**: `List<TodoListElementResponse>`

### Development Stack

- **Spring Boot**, **Spring Security**, **Spring GraphQL**, **Spring Docs**
- **Java 21**
- **Lombok**
- **GraphQL**, **REST API**

---