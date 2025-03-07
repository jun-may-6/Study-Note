// 객체 구조 분해 할당

let toy = {
    productName : "티니핑",
    color : "노랑",
    price: 25000
};

let {productName, color, price} = toy;

console.log(productName);
console.log(color);
console.log(price);
// 이름 명시하여 재할당
let {color : co, price : pr, productName: pn} = toy;
console.log(pn);
console.log(co);
console.log(pr);
