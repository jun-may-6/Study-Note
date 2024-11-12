void main() {
  /* var : 타입 명시 없이 변수 생성.
  관습적으로 함수나 메소드 내부에 지역변수 선언할때는 var 사용 */

  /* 선언과 동시에 초기화 할 경우 타입이 지정된다. 즉, 다른 타입을 대입할 수 없다. */
  var name = "이름";
  name = 'name';
  // name = 123

  /* 선언만 할 경우 다이나믹 타입으로 지정된다. 즉, 여러 타입을 대입할 수 있다. */
  var autoDynamic;
  autoDynamic = '명시 없는 다이나믹';
  autoDynamic = 123;

  /* 명시하여 다이나믹 타입을 사용할 수 있다. */
  dynamic explicitDynamic;
  explicitDynamic = '명백한 다이나믹';
  explicitDynamic = 123;

  /* 타입 변수 생성
  class / property 선언 시 타입 지정. */
  String title = "제목";
}