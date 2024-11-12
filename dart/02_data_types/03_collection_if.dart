void main() {
  /* collection if & collection for */
  /* if 를 활용하여 List 의 값을 정할 수 있다. */
  bool isFive = true;
  List<int> numList = [
    1,
    2,
    3,
    4,
    if(isFive) 5,
  ];
  print(numList); // [1, 2, 3, 4, 5]
}