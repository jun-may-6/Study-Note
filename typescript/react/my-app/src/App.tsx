import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { Store } from './Store';
import { Address, Restaurant } from './model/restaurant';
import { BestMenu } from './BestMenu';

let data:Restaurant = {
  name: '식당',
  category: '한식',
  address: {
    city: '인천',
    detail: '어딘가',
    zipCode:  12341
  },
  menu: [{name: '파스타', price: 2000, category: 'pasta'},
    {name: '스테이크', price: 4000, category: 'steak'}]
}

const App:React.FC = () => {
  /* 제네릭 문법을 사용하여 state 의 형태도 정해줄 수 있다. */
  const [myRestaurant, setMyRestaurant] = useState<Restaurant>(data);
  const changeAddress = (address:Address) => {
    setMyRestaurant(state=>({...state, address: address}))
  }

  const showBestMenuName = (name:string):string=>{
    return name;
  }

  return (
    <div className='App'>
      <Store info={data} changeAddress={changeAddress}/>
      <BestMenu name="불고기 피자" category="피자" showBestMenuName={showBestMenuName}/>
    </div>
  )
}

export default App;
