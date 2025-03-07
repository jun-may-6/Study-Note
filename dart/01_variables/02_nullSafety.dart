void main(){
  /* dart 의 모든 변수는 기본적으로 non-nullable 이다. */
  String name = '이름';
  // name = null;

  /* 타입 뒤에 ? 연산자를 사용함으로서 null 대입이 가능해진다. */
  String? title = '제목';
  title = null;

  /* null able 타입을 사용하기 위해선 검증이 필요하다. */

  // title.isNotEmpty; - 불가능
  
  /* 검증을 완료한 활용 - 가능 */
  if(title != null){
    title.isNotEmpty;
  }
  title?.isNotEmpty;
}