## 개요
* 마틴 파울러 (Martin Fowler) 의 리팩토링(Refactoring) 과 관련된 방법들에 대한 샘플 스터디 코드 및 코드 냄새들에 대한 정리 입니다.
* 좋은 코드란 응집도는 높이고 결합도는 낮춰야함.



### 알 수 있는 것
* 리팩토링 기본 기술
* 캡슐화 관련 기술
* 상속 관련 기술
* API 관련 기술 등

# 코드 냄새들
### 이해하기 힘든 이름
* 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 좋은 이름 이다.
* 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 직관적이어야 한다.
##### 리팩토링 기술  
* 함수 선언 변경하기
* 변수 이름 바꾸기
* 필드 이름 바꾸기
*** 
### 중복 코드
* 비슷한지, 완전히 동일한 코드인지 주의 깊게 살펴봐야 한다.
* 코드를 변경할 때, 동일한 모든곳을 변경해야 한다.
##### 리팩토링 기술
* 동일한 코드가 여러 메소드에서 사용하는 경우, 함수 추출하기 (Extract Function)
* 코드가 비슷하게 생겼지만 완전히 같지는 않은 경우, 코드 분리하기 (Slide Statement)
* 여러 하위 클래스에서 동일한 코드가 있다면, 메소드 올리기 (Pull Up Method)
***
### 긴 함수
* 짧은 함수 vs 긴 함수
  * 함수가 길수록 더 이해하기 어렵다 vs 짧은 함수는 더 많은 문맥 전환이 필요하다.
  * 작은 함수에 좋은 이름을 사용했다면, 구현 코드를 보지 않아도 이해가 가능하다.
  * 함수의 이름으로 의도를 표현해보자.
##### 리팩토링 기술
* 99%는, 함수 추출하기로 해결 가능
* 조건문 분해하기 
* 함수로 분리하면서 해당 함수로 전달해야할 매개변수가 많아진다면 다음과 같은 리팩토링을 고려해볼 것.
  * 임시 변수를 질의 함수로 바꾸기
  * 매개변수 객체 만들기
  * 객체 통째로 넘기기
* 조건문을 다형성으로 바꾸기
* 반복문안에 여러가지 작업을 하고 있어 하나의 메소드로 추출하기가 힘들다면 반복문 쪼개기를 적용할 수 있다.

***
### 긴 매개변수 목록
* 어떤 함수에 매개변수가 많을수록 함수의 역할을 이해하기 어려워진다.
  * 단일책임원칙을 잘 지키고 있는가?
  * 불필요한 매개변수는 없는가?
  * 하나의 레코드로 모을 수 있는 매개변수 목록은 없는가?
##### 리팩토링 기술
* 어떤 매개변수를 다른 매개변수를 통해 알아낼 수 있다면, 매개변수를 질의함수로 바꾸기를 사용할 수 있다.
* 기존 자료구조에서 세부적인 데이터를 가져와서 여러 매개변수로 넘기는 대신 객체 통째로 넘기기를 사용할 수 있다.
* 일부 매개변수들이 대부분 같이 넘어간다면 매개변수 객체 만들기를 사용할 수 있다.
* 여러 함수가 일부 매개변수를 공통적으로 사용한다면 여러 함수를 클래스로 묶기를 통해 매개변수를 클래스의 필드로 만들고 매서드로 전달해야 할 매개변수 목록을 줄일 수 있다.
* 매개변수가 플래그로 사용된다면, 플래그 인수 제거하기를 사용할 수 있다.
***
### 전역 데이터
* 전역 데이터는 아무곳에서나 변경될 수 있는 문제가 있다.
* 어떤 코드로 인해 값이 바뀐지 확인이 어렵다.
* 변수 캡슐화하기를 통해 접근을 제어하거나 어디서 사용하는지 파악이 용이하다.
***
### 가변 데이터
* 데이터를 변경하다보면 예상치 못한 오류가 발생할 수 있다.
* 함수형 프로그래밍 언어는 데이터를 변경하지 않고 복사본을 전달한다. 하지만 그밖의 언어는 데이터 변경을 허용하고 있다. 따라서 변경되는 데이터 사용 시 발생할 수 있는 문제점을 관리할 수 있는 방법을 적용하는것이 좋다.
##### 리팩토링 기술
* 변수 캡슐화하기를 통해 변경할 수 있는 메소드를 제한하자.
* 변수 쪼개기를 사용해 여러 데이터를 저장하는 변수를 나눌 수 있다.
* 함수 추출하기를 통해 데이터를 변경하는 코드로부터 사이드 이펙트가 없는 코드 분리가 가능하다.
* 가능하면 세터는 제거하자.
* 계산해서 알아낼 수 있는 파생 변수를 질의 함수로 바꾸자.
* 변수가 사용되는 범위를 제한하려면 여러 함수를 클래스로 묶기 또는 여러 함수를 변환 함수로 묶기를 적용해 볼 수 있다.
* 참조를 값으로 바꾸기를 통해 데이터 일부를 변경하기 보다 데이터 전체를 교체할 수 있다.
***
### 뒤엉킨 변경
* 소프트웨어는 변경에 유연하게 대처가 가능해야한다.
* 모듈의 책임이 분리되어 있을수록 해당 문맥을 더 이해하기가 쉽고 사이드 이펙트를 최소화할 수 있다.
##### 리팩토링 기술
* 단계 쪼개기를 통하여 서로 다른 문맥의 코드를 분리할 수 있다.
* 함수 옮기기를 통해 적절한 곳으로 재배치가 가능하다.
* 여러가지 일이 하나의 함수에 모여 있다면 함수 추출하기를 사용할 수 있다.
* 모듈이 클래스 단위라면 클래스 추출하기를 통해 별도의 클래스로 분리할 수 있다.
***
### 산탄총 수술
* 어떤 변경 사항이 생겼을 때 여러 모듈을 수정해야 하는 상황
  * 예) 어떤 새로운 결제 방식이 생겼을 때 새로운 결제 방식을 도입하려면 여러 클래스의 코드를 수정해야 한다.
* 변경 사항이 여러 곳에 흩어진다면 찾아서 고치기도 어렵고 중요한 변경 사항을 놓칠 수도 있다.
##### 리팩토링 기술
* 함수 옮기기 또는 필드 옮기기를 사용해서 필요한 변경 내역을 하나의 클래스에 모을 수 있다.
* 비슷한 데이터를 사용하는 여러 함수가 있다면 여러 함수를 클래스로 묶기를 사용할 수 있다.
* 단계 쪼개기를 사용해 공통으로 사용되는 함수의 결과물들을 하나로 묶을 수 있다.
* 함수 인라인과 클래스 인라인을 통해 흩어진 로직을 한곳에 모을 수 있다.
***
### 기능 편애
* 어떤 모듈에 있는 함수가 다른 모듈에 있는 데이터나 함수를 더 많이 참조하는 경우에 발생한다.
  * 예) 다른 객체의 getter 를 여러개 사용하는 메소드
##### 리팩토링 기술
* 함수 옮기기를 사용해 함수를 적절한곳에 재배치 한다.
* 함수 일부분만 다른곳에서 참조한다면 함수 추출하기로 함수를 나눈다음에 옮길 수 있다.
* 만약에 여러 모듈에서 참조하고 있다면, 그 중 가장 많은 데이터를 참조하는곳으로 옮기거나, 함수를 어려개로 쪼개서 각 모듈로 분산시킬 수 있다.
* 데이터와 해당 데이터를 참조하는 행동을 같은 곳에 두도록 하자.
* 예외적으로 데이터와 행동을 분리한 디자인 패턴(전략 패턴 또는 방문자 패턴)을 적용할 수도 있다.
***
### 데이터 뭉치
* 항상 뭉쳐 다니는 데이터는 한 곳으로 모아주는 것이 좋다.
  * 여러 클래스에 존재하는 비슷한 필드 목록
  * 여러 함수에 전달하는 매개변수 목록
##### 리팩토링 기술
* 클래스 추출하기를 사용해 여러 필드를 하나의 객체나 클래스로 모을 수 있다.
* 매개변수 객체 만들기 또는 객체 통째로 넘기기 를 사용해 메소드 매개변수를 개선할 수 있다.
***
### 기본형 집착
* 기본형으로는 단위 또는 표기법을 표현하기 어렵다.
##### 리팩토링 기술
* 기본형을 객체로 바꾸기
* 타입코드를 서브클래스로 바꾸기
* 조건부 로직을 다형성으로 바꾸기
* 클래스 추출하기
* 매개변수 객체 만들기
***
### 반복되는 switch 문
* 예전에는 switch 문이 한번만 등장해도 코드 냄새로 생각하고 다형성 적용을 권장했다.
* 하지만 최근에는 다형성이 꽤 널리 사용되고 있으며, 여러 프로그래밍 언어에서 보다 세련된 형태의 switch 문을 지원하고 있다.
* 따라서 오늘날은 반복해서 등장하는 동일한 switch 문을 냄새로 여기고 있다.
* 반복해서 동일한 switch 문이 존재할 경우, 새로운 조건을 추가하거나 기존의 조건을 변경할 때 모든 switch 문을 찾아서 바꿔야 할지도 모른다.
***
### 반복문
* 프로그래밍언어 초기부터 있었던 반복문은 처음에는 대안이 없어 간과했지만 최근에는 Java 에서 함수 프로그래밍 지원으로 반복문에 비해 더 나은 대안이 생겼다.
* 반복문을 파이프라인으로 바꾸는 리팩토링을 적용하면 필터나 맵핑 같은 파이프라인 기능을 사용해 보다 빠르게 어떤 작업을 하는지 파악할 수 있다.
***
### 성의없는 요소
* 여러 프로그래밍적인 요소(변수, 메소드, 클래스등)를 만드는 이유
  * 나중에 발생할 변화를 대비해서
  * 해당 함수 또는 클래스를 재사용하기 위해
  * 의미있는 이름을 지어주려고
* 가끔은 그렇게 만든 요소들이 기대에 부응하지 못하는 경우도 있는데 그런 경우에는 해당 요소를 제거해야 한다.
##### 리팩토링 기술
* 함수 인라인
* 클래스 인라인
* 불필요한 상속 구조는 계층 합치기를 사용할 수 있다.
***
### 추측성 일반화
* 나중에 이런 저런 기능이 생길 것으로 예상해, 여러 경우에 필요 할만한 기능을 만들어 놨지만 결국에 쓰이지 않는 코드가 발생 할 경우.
* XP의 YAGNI(You aren`t gonna need it) 원칙을 따르자.
##### 리팩토링 기술
* 추상 클래스를 만들었지만 크게 유효하지 않으면 계층 합치기
* 불필요한 위임은 함수 인라인 또는 클래스 인라인
* 사용하지 않는 매개변수를 가진 함수는 함수 선언 변경하기
* 오로지 테스트 코드에서만 사용하는 죽은 코드 제거하기
***
### 임시 필드
* 클래스에 있는 어떤 필드가 특정한 경우에만 값을 갖는 경우
* 어떤 객체에 필드가 특정한 경우에만 값을 가진다는 것은 이해하는 것은 일반적으로 예상하지 못하기 때문에 이해하기 어렵다.
##### 리팩토링 기술
* 클래스 추출하기를 사용해 해당 변수들을 옮길 수 있다.
* 함수 옮기기를 사용해서 해당 변수를 사용하는 함수를 특정 클래스로 옮길 수 있다.
* 특이 케이스 추가하기를 적용해 특정한 경우에 해당하는 클래스를 만들어 해당 조건을 제거할 수 있다.