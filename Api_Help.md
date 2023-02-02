# 1주차
## API 구현
1. 요구사항 분석
2. 객체지향 모델링
3. 구현

## 상품 API
### 상품 생성 API
- URL: POST /products

#### 상품등록 성공
- Request Body

```json
{
  "name": "상품", 
  "price": 5000,
  "detail": "상품내용내용내용"
}
```

- Response Body
```json
{
  "success": true,
  "response": {
    "id": 2,
    "name": "상품",
    "price": 190,
    "details": "상품내용내용내용"
  },
  "error": null
}
```

#### 상품등록 실패 1
- Request Body

```json
{
  "name": "", 
  "price": 5000,
  "detail": "상품내용내용내용"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "상품 이름이 없습니다",
    "status": 400
  }
}
```

#### 상품등록 실패 2
- Request Body

```json
{
  "price": 5000,
  "detail": "상품내용내용내용"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "상품 이름이 없습니다",
    "status": 400
  }
}
```

#### 상품등록 실패 3
- Request Body

```json
{
  "name": "", 
  "price": 5000,
  "detail": "상품내용내용내용"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "상품 이름이 없습니다",
    "status": 400
  }
}
```

#### 상품등록 실패 4
- Request Body

```json
{
  "name": "상품", 
  "price": -1,
  "detail": "상품내용내용내용"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "상품 가격은 0원 이상이어야합니다",
    "status": 400
  }
}
```

### 상품 조회 API
- GET /products/{id}

- Response Body
```json
{
  "success": true,
  "response": {
    "id": 2,
    "name": "상품",
    "price": 190,
    "details": "상품내용내용내용"
  },
  "error": null
}
```

### 상품 목록 조회 API
- GET /findAll

- Response Body
```json
{
  "success": true,
  "response": [
    {
      "id": 1,
      "name": "상품",
      "price": 190,
      "details": "상품내용내용내용"
    },
    {
      "id": 2,
      "name": "상품",
      "price": 190,
      "details": "상품내용내용내용"
    },
    {
      "id": 3,
      "name": "상품",
      "price": 190,
      "details": "상품내용내용내용"
    }
  ],
  "error": null
}
```

## 주문 API
주문 상태 `state`가 존재하며 상태의 종류로는 `REQUESTED`, `ACCEPTED`, `SHIPPING`, `COMPLETED`, `REJECTED`가 있다

### 주문 생성 API

- URL: POST /orders

#### 주문 생성 성공
- Request Body

```json
{
  "userId": 1,
  "productId": 2,
  "requestMsg": "빠르게배송!",
  "orderAddress": "NY"
}
```

- Response Body
```json
{
  "success": true,
  "response": {
    "productId": 2,
    "createAt": "2022-01-20 20:16:47",
    "userName": "you",
    "orderAddress": "NY"
  },
  "error": null
}
```

#### 주문 생성 실패 1
- Request Body

```json
{
  "userId": 0,
  "productId": 2,
  "requestMsg": "빠르게배송!",
  "orderAddress": "NY"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "유저가 없습니다",
    "status": 404
  }
}
```

#### 주문 생성 실패 2
- Request Body

```json
{
  "userId": 1,
  "productId": 0,
  "requestMsg": "빠르게배송!",
  "orderAddress": "NY"
}
```

- Response Body
```json
{
  "success": false,
  "response": null,
  "error": {
    "message": "상품이 없습니다",
    "status": 404
  }
}
```

### 주문 접수 처리 api
주문이 최초 생성될 때 주문 상태 `state`는 `REQUESTED`이다. 주문 상태가 `REQUESTED`라면 접수 처리를 할 수 있다. 정상적으로 접수 처리 되면 주문 상태는 `ACCEPTED`로 변경된다.

- URL: PATCH /orders/{id}/accept
    * {id}: 상태를 변경할 주문의 PK
- Response Body: true 라면, 상태변경 성공
```json
{
  "success": true,
  "response": true,
  "error": null
}
```
- 주문 상태 `state`가 `REQUESTED`가 아닌 경우 응답 예시
```json
{
  "success": true,
  "response": false,
  "error": null
}
```

### 주문 배송 처리 api
주문 상태 `state`가 `ACCEPTED`라면 배송 처리를 할 수 있다. 정상적으로 배송 처리 되면 주문 상태는 `SHIPPING`으로 변경된다.

- URL: PATCH /api/orders/{id}/shipping
    * {id}: 상태를 변경할 주문의 PK
- Response Body: true 라면, 상태변경 성공
```json
{
  "success": true,
  "response": true,
  "error": null
}
```
- 주문 상태 `state`가 `ACCEPTED`가 아닌 경우 응답
```json
{
  "success": true,
  "response": false,
  "error": null
}
```