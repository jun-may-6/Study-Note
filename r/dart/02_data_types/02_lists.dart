void main() {
  /* var 을 사용한 리스트 */
  var varList = [
    1,
    2,
    3,
    4,
  ];
  /* 타입 명시 리스트 */
  List<int> intList = [
    1,
    2,
    3,
    4,
  ];

  /* 다양한 메소드 */
  intList.add(5);
  intList.first;
  intList.last;
  intList.nonNulls;
}
