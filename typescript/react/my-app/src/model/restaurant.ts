/* 타입을 만드는 두 가지 방법 */
// 1. 타입
export type Restaurant = {
    name:string;
    category:string;
    address:Address;
    menu:Menu[];
}
export type Address = {
    city:string;
    detail:string;
    zipCode:number;
}
export type Menu = {
    name:string;
    price:number;
    category:string;
}

/* Omit을 활용하여 타입을 제거할 수 있다. */
export type AddressWithoutZip = Omit<Address, 'zipCode'>
/* Pick을 통하여 하나만 선택하여 사용할 수 있다. */
export type RestaurantOnlyCategory = Pick<Restaurant, 'category'>
/* ?를 붙혀서 선택적으로 받을 수 있다. (비권장) */

/* 제네릭에 T 를 사용하여 유동적으로 response 형태를 만들 수 있다. */
export type ApiResponse<T> = {
    data:T[];
    totalPage:number;
    page:number;
}
export type RestaurantResponse = ApiResponse<Restaurant>;
export type AddressResponse = ApiResponse<Address>;