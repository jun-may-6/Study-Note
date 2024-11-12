void main() {
  var firstList = [1, 2, 3];
  var secondList = [
    4,
    5,
    6,
    for(var first in firstList) "f${first}"
  ];
  print(secondList);
}
