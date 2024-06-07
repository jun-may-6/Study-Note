let toy = {
    productName : "티니핑",
    color : "노랑",
    price: 25000
};

let {productName: pn = "인형", subname = "눈꽃핑", color, price, evventGift: gift = "요술봉"} = toy;
console.log(pn);
console.log(subname);
console.log(color);
console.log(price);
console.log(gift);

// 프로퍼티가 많은 복잡한 객체에서 원하는 정보만 뽑아오기
let {productName:productName2,  price:price2} = toy;
console.log(`${productName2}(이)가 무려 ${price2}원!`);


// rest parameter ...로 나머지 요소를 한번에 가져올 수 있다.
let {productName: productName3, ...rest} = toy;

console.log(productName3);
console.log(rest);
console.log(rest.color);
console.log(rest.price);

let productName4, color4, price4;
// {productName: productName4, color: color4, price: price4} = toy; // 코드블럭으로 인식해 오류 발생
({productName: productName4, color: color4, price: price4} = toy);  // 소괄호로 감싸면 오류 발생 안함

console.log(productName4, color4, price);
