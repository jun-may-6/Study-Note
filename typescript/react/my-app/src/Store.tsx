import React from 'react';
import { Address, Restaurant } from './model/restaurant';

/* 여기서만 쓰이는 props 타입 */
/* 인터페이스를 통한 타입 구현 */
interface OwnProps{
    info:Restaurant,
    /* 함수의 타입을 정해줄 수 있다. */
    changeAddress(address:Address):void
}

export const Store:React.FC<OwnProps> = ({info, changeAddress}) => {
    return (
        <div>{info.name}</div>
    )
}