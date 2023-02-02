# 상품 주문 배송 API 구현

## 객체지향 모델링을 진행한다.
- 필요 클래스와 기능을 작성

## 데이터베이스는 메모리 기반 DB를 사용
- 이를 검증하기 위한 테스트코드를 작성한다.

## 객체지향 생활체조를 지키며 프로그래밍을 연습한다.

- 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- else 예약어(keyword)는 쓰지 않는다. 
- 모든 원시값과 문자열을 포장한다. 
- 일급(first-class) 콜렉션을 쓴다. 
- 한 줄에 점을 하나만 찍는다. 
- 줄여쓰지 않는다(축약 금지). 
- 모든 엔티티(entity)를 작게 유지한다. 
- 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다. 
- 게터(getter)/세터(setter)/프로퍼티(property)를 쓰지 않는다.

### 객체지향의 핵심
- 객체지향의 핵심은 IoC(Inversion of Control)를 통해 상위레벨의 모듈을 하위레벨로부터 보호하는 것이다.

### 테스트 작성시
- given - when - then / arrange - act - assert 패턴으로 연습
- 어떤 테스트인지 명확히 보여주도록 메소드명에 나타낸다.
  - 한글 메소나 @DisplayName을 사용한다.
- 테스트 하나에 assert 해야할 사항이 1개만 되도록 시도한다.
- 테스트 코드도 중복을 줄여본다.
- Test Fixture를 분리하여 따로 관리한다.
- 아무것도 하지 않거나 중복되거나 불필요한, 절대로 실패하지 않는 테스트는 assert, fail을 추가하거나 삭제한다.
- 기대하는 결과값을 명확하게 명시하도록 수정한다.


상품 생성, 조회, 주문 접수처리, 주문 배송처리 api 개발
1. 객체지향 모델링
	-HELP.md 파일의 api request, response를 보고 필요한 클래스와 기능을
작성(참고: MODEL.md)
-작성된 Model 기반으로 구현
2. db는 memory 기반 repository를 사용하고 이를 검증하기 위해서 test code를 작성
3. 놓친 건 없는지 분석하고 설계 수정
