# Two Schools of TDD

- 상태를 조사(query, algorithm) / 상호작용을 조사(command, business requirements)
# Classic TDD or "London School"? - Software People Inspiring

원문 [Classic TDD or "London School"? - Software People Inspiring](http://codemanship.co.uk/parlezuml/blog/?postid=987)

## Classic TDD or “London School”?

- classic TDD를 써야 하는가 ? “London School” TDD를 써야 하는가 ?
- classic TDD 기법을 구분되게 만드는 특징은 [Triangulation](https://github.com/msbaek/memo/blob/master/Triangulation.md) 기법을 강조한다는 점임
    - Triangulation에 대해서 [Clean Coders Episode 22에서 설명된 내용](https://github.com/msbaek/memo/blob/HEAD/CC-E22-Test-Processes.md#4-triangulation) 은 아래와 같다
        - 토목/수학에서 말하는 삼각법(물체간의 거리를 측정하는)이 아니라 TDD에서 삼각법은 generalization을 만드는 방법의 하나를 의미
        - "As the tests get more specific, the code gets more GENERIC”
        - 하나의 테스트가 아니라 여러개의 테스트를 추가함으로써 문제와 해결책을 좀 더 명확히 하는 기법
        - 삼각법이 2개 이상의 지점의 위치를 이용하여 현 위치를 측정하는 것 처럼...
        - 하나의 테스트만 존재할 때는 fake할 수 있음(상수를 반환함으로써)
        - 하지만 상수로 처리 불가한 테스트를 추가하면(삼각법에서 2개 이상의 지점을 사용하는 것처럼) fake할 수 없게 되어 code가 generic해 짐
- 기본적으로 Classic TDD는 테스트를 추가하면서 점진적으로 알고리즘이 구체화되고, London School TDD는 점진적으로 collaborator를 찾게 된다.

## Classic TDD(Inside out)

- Kent Beck의 [“Test-driven Development By Example"](https://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530) 를 봤다면 classic TDD에 익숙할 것
- 이 기법에서는 test가 구체화됨에 따라 알고리즘이 generic(특정한 경우만 아니라 다양한 경우를 모두 수용함을 의미)해 지도록 TDD를 진행
- 다시 말해 사소한 테스트부터 점진적으로 복잡한 테스트를 추가함에 따라 프로덕션 코드(알로리즘)는 모든 경우를 수용할 수 있도록 generic해 진다는 말임

### 예). 아라비아 숫자를 로만 숫자로 변경하는 프로그램
- 가장 단순한 테스트로 시작. "roman numeral for 1 is I”. 이에 대한 가장 단순한 해결책은 하드 코딩된 “I"를 반환하는 것
- 그 다음으로 생각할 수 있는 가장 단순한 실패하는 테스트로 전개

`Test #1: 1 = I -> return "I”`

`Test #2: 2 = II -> if integer = 1 return “I” else return “II”`

`Test #3: 3 = III -> while(integer > 0) concatenate “I” to result and decrement integer`

- 이 기법의 핵심은 한번에 하나의 실패하는 테스트에 대한 해결책을 일반화하여 결과적으로 해당 시점까지의 모든 테스트를 만족시킬 수 있는 간단하고, 우아한 해결책을 얻는 것임
- 이 기법은 **알고리즘**을 강조한다.
- 가장 간단하고, 명확한 문제에 대해 일련의 테스트 예제를 통해 triangulate하고 해결책을 일반화(generalize)하여 해당 시점까지의 모든 테스트 케이스를 만족하는 일반적인 해결책을 만들어냄
- 객체지향 설계는 하나의 단순한 시작점, 클래스 ,책임, 상호작용에서 시작, 성장, 리팩토링을 통해 구조적(organically)으로 최종적인 설계로 성장함

## London School of TDD(Outside in)

> Interaction-style TDD is also called mockist-style, or London-style after London's Extreme Tuesday club where it became popular. It is usually contrasted with Detroit-style or classic TDD which is more state-based([what-are-the-london-and-chicago-schools-of-tdd](http://softwareengineering.stackexchange.com/questions/123627/what-are-the-london-and-chicago-schools-of-tdd))

> It's born out of the furnace of component-based, distributed and service-oriented applications that are especially prevelant in the City of London (if you've got bail-out money to burn, why keep it simple, right?). The design emphasis of "enterprise applications" tends to be message passing as opposed to raw algorithmic computation([codemanship](http://codemanship.co.uk/parlezuml/blog/?postid=987))

- 이 방법은 알고리즘이 아니라 **역할, 책임, 상호작용**을 강조
- 이 기법은 런던시에 만연하던 CBD, 분산/서비스 지향 등에서 나왔음
- 이 방법에서 설계는 “엔터프라이즈 어플리케이션"은 순수한 알고리즘 계산이 아니라 메시지 패싱하는 경향이 있다는 것을 강조
- 이게 객체지향 설계가 강조하는 점이기도 함
- 이 기법에 대한 정의문은 [Growing Object Oriented Software Guided By Tests](https://www.amazon.com/Growing-Object-Oriented-Software-Guided-Tests/dp/0321503627) 에서 찾아 볼 수 있음
- TDD에 대한 아주 간략화된 이 방식의 서술은 아래와 같음
    - 역할(Role), 책임(Responsibility)을 식별하고
    - 시스템 레벨의 시나리오나 acceptance 테스트를 만족시키기 위한 해결책에 대한 end-to-end 구현에 존재하는 책임들 간의 주요한 상호작용(interaction/collaboration)을 식별
    - 한번에 하나씩 각 협업객체(collaborator)에 요구되는 코드를 구현
        - 이때 이 객체의 직접적인 협업객체들은 fake처리
        - front-end 테스트를 통과하는 동작하는 end-to-end 구현체를 얻을때까지 상호작용하는 객체들을 점진적으로 개발

### 예. userName, password, email을 입력하여 가입하는 웹 어플리케이션
- email 주소가 잘 못 되었을 때를 다루는 acceptance 테스트는 아래와 같음

`User Sign Up Page -> Sign-up Controller.openUserAccount(userName, password, email) -> Email Validator.validateEmail(email)`

- 제대로 동작하지 않는 email 주소를 인자로 openUserAccount()를 호출할 것이라고 기대되는 mock Sign-up Controller를 가지고 User Sign-up Page에 대한 테스트를 만듦으로써 시작
- 이때 controller는 결과로 User Sign-Up Page에 에러 메시지를 출력하도록 기술됨
- 위 테스트를 통과하면 email 주소가 openUserAccount에 전달되면 validateEmail() 메소드 호출되는 것을 기대하는 mock Email Validator를 가지고 Sign-up Controller.openUserAccount()에 대한 테스트를 작성
    - 잘못된 email 주소가 전달되면 Email Validator는 false를 리턴하고 controller는 false를 반환하게 됨
- 그리고 나서, 잘못된 email 주소를 가지고 validateEmail() 메소드를 호출하면 false를 반환하는 Email Validator에 대한 테스트를 작성

- 분산 엔터프라이즈 어플리케이션을 작성하는 사람들은 종종 London School은 그들의 업무에 가장 적합하다고 함
- 그런데 위 예제에서 Email Validator는 아래와 같은 duff의 이메일 주소에 대한 테스트 케이스에 대해 간단하고, 명확한 구현을 갖는 하나의 테스트인가 ?
    - 이경우 종종 TDD가 혼란스러워짐. 너무 자주 개발자들은 하나의 테스트 케이스로 크게 나아가려 한다.
- 아래와 같은 duff의 email 주소를 고려해 보자:

```java
duffrubbish.com
duff@rubbish
@duffrubbish.com
?duff@rubbish.com
```

- 모두 잘못된 email 주소들이다. 하지만 서로 다른 잘못된 원인을 가짐. 잘못된 이라는 말은 다수의 원인을 커버함
- 정규식을 이용해서 하나의 테스트로 이 모든 경우를 해소하려는 유혹이 생김
    - 이럴 경우 우리의 테스트는 하나 이상의 일을 하는 것이고 절대 그러면 안됨
- 또한 각 규칙에 대해 항상 명확한 구현이 존재하는 것은 아님
- 가능한 최대한 작은 작업으로 문제를 해결하는 것이 통하는 방법. 다시 말해 한번에 하나의 규칙씩 작업하는 것, 덜 명확한 규칙을 위해서는 해결책에 triangulating하는 것을 의미
- 경험상으로 보면
    - 상호작용에만 집중하면 알고리즘상으로는 신뢰하기 어려운 코드가 나옴(버그가 포함된)
    - 알고리즘에만 집중하면 rigid/brittle한 end-to-end 설계가 되고, 가끔은 시스템 레벨 요구사항을 만족시키지 못함
- 우리의 목표는 신뢰할 만한 코드(버그가 없는)면서 내부적으로 좋은 설계를 갖는 코드를 만드는 것
    - 이를 위해서는 적절한 시기에 2가지 TDD 기법이 모두 필요함
    - 알고리즘에 집중할 때는 Classic School이, 상호작용에 집중할 때는 London School
- 상당한 복잡성을 가진 소프트웨어를 구현하는 로직은 알고리즘만으로도 안되고, 상호작용만으로도 안됨
- 따라서 Classic TDD와 London School TDD은 동일하게 중요함

# Triangulation

원문 [Triangulation](http://tobeagile.com/2009/12/08/triangulation/)

> If I get stuck and I don’t know how a complex algorithm should work I’ll write a test for an error case. Then I’ll write a test for the simplest non-error case I can think of and return a hard coded value. Then I’ll write another test case and see if I can figure out the algorithm at that point. In doing so I gain some momentum and perhaps some insight in how the algorithm should behave on an edge case and a few normal cases.

## Triangulation

어떻게 복잡한 알고리즘을 구현할 지 모르는 상태에 빠지면(getting stuck되면)

- 에러 케이스에 대한 테스트 작성
- 정상 경우에 대한 가장 간단한 테스트 작성(하드 코딩된 값으로 성공시킬 수 있는)
- 또 다른 테스트 케이스를 작성하고, 이때의 알고리즘을 이해할 수 있는지 살핀다.
- 이렇게 함으로써 경계 케이스와 정상 케이스에 대해서 알고리즘이 어떻게 동작해야 하는지 인사이트를 얻을 수 있다.

이러한 기법은 삼각측량법(triangulation)이라고 한다. 이 방법은 천문 항법(celestial navigation)에 수천년 동안 사용되어 왔다.

움직임을 확인하기 위해서는 하나 보다는 2개 이상의 지평선(horizon)의 지점과 비교하는 것이 쉽다.

코딩도 마찬가지다 하나가 아니라 둘 이상의 테스트 케이스를 조사하는 것이 알고리즘의 동작 방식을 이해하기 쉽게 한다.

이 기법은 한가지 문제점은 잉여 테스트(redundant test)를 만들어 낸다는 것이다. 이러한 잉여 테스트는 리팩토링시 제거되어야 한다.

# [London vs Chicago](https://devlead.io/DevTips/LondonVsChicago)

## 선택이 아닌 통합
- TDD의 2가지 학파
    - London School
        - Outside-in, behavior-based approach
        - CQS를 촉진
        - Test Double에 크게 의존
        - 다소 테스트를 깨지기 쉽게 함
    - Chicago School
        - Inside-out, state-based approach
        - 높은 응집도를 촉진
        - design patterns에 중점을 둠
        - YAGNI는 위험
- 하나를 선택하는 것이 아님
    - 품질 모델을 이해하고 품질 최적화를 추진해야 함
    - 2가지 방법은 각각 장단점이 있음
    - TDD의 최선책은 이 2가지를 통합적으로 채택하는 것임

## London School

- 애플리케이션 외부(일반적으로 API나 컨트롤러)에서 시작하여 도메인 모델과 영속 계층 등의 하위 계층으로 향하며 작업하는 행위 기반 Formal TDD 접근법

### 장점

- 행위 중심
    - 시스템의 진입점에서 시작하여 하위 계층으로 작업함으로써 사용자가 애플리케이션을 탐색하는 방법을 정리하는데 도움이 됨
    - 이를 위해 과도한 Test Double이 요구됨
    - 이를 통해 코드베이스를 작게 유지하고, 사용되지 않는 코드(dead code)를 작성하지 않도록하는데 도움이 되지만 깨지기 쉬운 테스트를 유발하는 경향이 있음
        - 이로 인해 리팩토링이 더 어려워져 지속적인 리팩토링을 방해함
- CQS 촉진
    - 행위에 초점을 맞추면 순수 함수를 촉진하여 side effect을 관리하는 데 도움이 됨
        - 함수형 프로그래밍으로의 관문을 제공

### 단점

- 깨지기 쉬운 테스트(Fragile Tests)
    - 테스트 주도로 행위를 도출함으로써 코드베이스를 작게 유지하고, 사용되지 않는 코드를 작성하지 않도록 하는데 도움이 되지만 깨지기 쉬운 테스트를 만드는 경향이 있음
- 어려운 리팩토링
    - 프로덕션 코드와 강하게 결합된(tightly coupled) 테스트를 사용하면 지속적인 리팩토링이 어렵고 많은 시간이 소요됨
    - 이것은 top-down TDD의 가장 큰 단점 중 하나로써 코드가 변경될 때마다 깨진 테스트를 처리해야 함

## Chicago School

- Chicago School(a.k.a Detroit School)은 애플리케이션의 내부(도메인 모델)에서 시작하여 외부(API)로 향하는 탐색적이고 상태에 기반한 informal 접근법

### 장점

- 강력한 안전망(Strong Safety Net)
    - 아키텍처의 저수준에서 시작했기 때문에 이전 테스트들을 기반으로 지속적으로 구축함(continuously building on prior tests)
    - 이로 인해 구현과 분리(decoupled. 객체간의 관계에 대한 지식이 test에 없는)된 테스트를 생성하는 경향이 있음
        - 기존 테스트를 깨지 않고 구현체 대한 공격적인 리팩토링을 가능케 함
    - 또한 지속적인 리팩토링에 대한 안정망을 제공하는 고도로 중복된 회귀 테스트를 제공함
- 높은 응집도
    - 테스트가 점점 구체화(generic ⇢ specific)되면서 결과로 생성되는 프로덕션 코드는 매우 높은 응집도를 갖게됨
    - As the tests get more specific, the code gets more generic
    - 이것이 높은 응집도를 촉진함
    - 높은 응집도는 느슨한 결합도를 제공함
    - 그 결과 유지보수성, 테스트 용이성, 확장성(extensibility) 등을 포함한 높은 코드 품질을 촉진함
- 테스트 대역(Test Double) 최소화
    - inside out 방식의 개발은 바로 전에 작성된 테스트 위에 개발을 하기 때문에 훨씬 적은 테스트 대역을 필요로함
    - 대부분의 경우 이전(저 수준) 테스트의 결과물을 이용하여 구현하기 때문에 mocking/stubbing할 이유가 거의 없음
    - 이를 통해 보다 안정적이고 덜 깨지는 테스트를 개발하는데 도움이 됨

### 단점

- YAGNI(You Are Not Gonna Need It)
    - 내부(저수준)부터 개발할 때 종종 오버엔지니어링이 촉진됨
        - 나중에 필요치 않은 코드를 작성하게 되는 경우가 종종 있음


# Outside-In TDD

## 정의

- 일반적인 TDD를 Inside-Out(bottom up, chicago school, classic approach)이라고 함
- Outside-In는 Top Down으로 진행하고 London School TDD라고도 부르고, Mockist Approach라고도 함
- Outside-In TDD는 최상위 레이어(view)에서 시작해서 최하위 레이어(DB)로 향해 가면서 TDD를 진행한다.
- 프로그래밍을 할 때 종종 어디서 시작해야 할 지 모르는 경우가 있다.
    - TDD를 한다면 시작이 되는 단위 테스트 작성이 좋은 시작점이됨
    - 하지만 아무 것도 없는 상태라면 어떤 단위 테스트를 작성할지 결정하는 것은 쉽지 않음
    - 이럴 경우 Inside-Out TDD보다는 Outside-In TDD가 효과적임
- Outside-In TDD는 Inside-Out TDD의 절차를 따르지만 한가지 예외가 있음
  > “테스트가 실패할 때 테스트를 성공시키기 위해 반드시 프로덕션 코드를 작성해야만 하는 것은 아니다. 다른 하위 레벨에서 새로운 기능을 구현해야 할 수도 있다”
- 테스트가 하위 레벨 구현을 가이드하면 하위 레벨 구현을 위한 새로운 Inside-Out TDD의 Red-Green-Blue 사이클을 시작
- 이 하위 레벨에서 TDD 싸이클을 아래와 같은 상황이 발생할 때까지 지속
    - 원하는 행위를 구현하기 위해 또 다른 하위 레이어로 이동하여 Inside-Out TDD 수행
    - 현재 레이어에서의 작업이 완료
- 인수테스트(Acceptance Test) 작성으로 시작하고 Acceptance Test가 실패하면 이를 성공시키기 위해 Inside-Out TDD를 수행함
- 아래 그림은 Outside-In TDD 방식으로 어플리케이션을 개발하는 과정을 보여준다. 이 그림은 [Growing Object-Oriented Software Guided by Tests](https://www.amazon.com/Growing-Object-Oriented-Software-Guided-Tests/dp/0321503627)에서 발췌했음
  ![](https://camo.githubusercontent.com/c9bebf338115b153147422c8044dbea07a7cc1fd/68747470733a2f2f6170692e6d6f6e6f736e61702e636f6d2f7270632f66696c652f646f776e6c6f61643f69643d5a74646a5a6f506d43513045496b5977566e3577534a6e6f686d45394d63)

## Outside-In TDD의 절차
1. 어떤 기능(Feature)의 인수테스트로 시작
2. 인수테스트를 실행해서 합당한 이유로 실패하면 어떤 클래스 A가 제공하는 기능이 필요해짐
- 이런 경우 인수테스트를 잠시 중지하고, Figure 5.1이 내부 루프가 시작되어 Unit Test가 시작됨
- 이게 TDD의 **Double Loop**(Outer Loop: Acceptance Test, Inner Loop: Unit Test)
3. 클래스 A의 기능에 대한 단위테스트(Unit Test) 작성을 통한 Inside-Out TDD 실행
4. 단위테스트가 성공하면 인수테스트를 실행시켜서 다음 오류 해소를 위해 또 다른 어떤 클래스 B의 어떤 기능 F가 필요한지 파악
5. 클래스 B의 기능 F 구현을 위해 3부터 반복

## 인수테스트의 역할
1. 새로운 기능 구현을 할때 어디서 부터 시작할 지 알게 해줌
2. 지금 테스트(인수, 단위)가 성공하면 다음에 무엇을 할지 알려줌
3. 어떤 기능의 구현이 완료되었는지 확인
    - 전체 기능들에 대한 인수테스트 집합을 만들었다면 전체 프로젝트에 대한 공정율도 알 수 있다.


## 두 방식의 차이점

| | Inside-Out | Outside-In |
|:---|:---|:---|
| 정의 & 방식 | 개발자가 한번에 하나에만 집중할 수 있도록 해줌 | 일부 엔터티들이 초기엔 하드코딩될 수도 있지만 처음부터 시스템을 정의할 수 있는 경로를 제공  |
| | 한번에 하나의 엔터티에 집중하는 것은 팀원들이 병렬로 개발할 수 있도록 해줌  | 상위 레벨의 인수테스트(High Level Acceptance Test)를 사용하므로 엔터티들의 내부 구현보다는 엔터티들의 상호작용에 집중하게 됨 |
| | 테스트 더블이 필요치 않음. 엔터티들이 사전에 식별되므로 실제 구현체를 사용할 수 있음  | 상호작용이 필요한 엔터티들이 발견될 때 마다 테스트 더블로 치환되어 해당 엔터티들에 대한 상세가 미뤄질 수 있음  |
| |  | 개발자들은 새로운 단위 테스트를 통해서 테스트 더블에 대한 구현물을 제공할 때까지 루프를 수행  |
| 이슈 | 개별 엔터티들은 통합되어 함께 동작할 때까지는 가치가 없을 수 있음  | 설계의 상세 구현이 테스트에 존재. 설계 변경은 대개 테스트의 변경을 수반함. 이런 상황이 위험을 추가하거나 구현에 자신감을 줄 수 있음 |
| | 개발 후반부에 연동을 하는 것은 리스크가 클 수 있음 | 개발자가 사전에 테스트 더블을 활용하여 어떻게 상호작용을 테스트할지 알아야 함  |
| 초기 | 초기에는 시스템 설계에 대한 완전한 이해는 필요치 않음. 시작할 때는 한개의 엔터티만 식별되면 됨  | 초기부터 시스템 전반의 완전한 흐름에 집중함으로써 시스템의 서로 다른 부분들이 어떻게 상호작용하는지에 대한 지식이 요구됨  |
| 적합성 | 기능의 수행 후 상태 값 검증을 통한 정합성 검증에 유리한 알고리즘 구현에 적합  | 협력 객체들의 상호작용 검증(인자, 호출 여부 등)을 통한 정합성 검증이 유리한 비즈니스 어플리케이션에 적합(탑다운으로 점진적으로 협력 객체의 인터페이스를 찾아나가는 방법: [Mock Roles, not Objects](http://jmock.org/oopsla2004.pdf) - Iterative Interface Discovery) |
| | 개발자들이 프로그래밍 언어 초보인 경우 좋은 시작점임. 개발자는 한번에 하나의 엔터티에만 집중하면 됨. 개발을 진행해 나가면서 언어, 테스트 프레임워크 등에 대한 지식이 축적됨 | 개발자들은 전체 시스템을 만들면서 시작하고 리팩토링 기회가 발생할 때 작은 컴포넌트들로 분해한다. 과정은 보다 탐색적일 수 있고, 목표에 대한 일반적인 아이디어가 있지만 구현의 세부사항이 명확치 않을 때 이상적임 |
| | 기 구축된 시스템에 추가 기능을 구현하는 경우, 꽤 상세한 설계가 있는 경우 Inside-Out | 신규 기능 셋 추가, 무엇부터 시작해야 할지 모르는 경우 Outside-In |


# 참고 자료
- [Outside-In TDD Part I](https://www.youtube.com/watch?v=XHnuMjah6ps&t=9s)
- [Outside-In Test-Driven Development](https://www.codecademy.com/articles/tdd-outside-in)
- [TDD - From the Inside Out or the Outside In?](https://8thlight.com/blog/georgina-mcfadyen/2016/06/27/inside-out-tdd-vs-outside-in.html)
- [msbaek/atdd-example](https://github.com/msbaek/atdd-example/blob/master/README.md)
