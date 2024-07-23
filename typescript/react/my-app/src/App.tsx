import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Store } from './Store';

let data = {
  name: '식당',
  cateagory: '한식',
  address: {
    city: '인천',
    detail: '어딘가',
    zipCode:  12341
  },
  menu: [{name: '파스타', price: 2000, category: 'pasta'},
    {name: '스테이크', price: 4000, category: 'steak'}]
}

const App:React.FC = () => {
  return (
    <div className='App'>
      <Store info={data}/>
    </div>
  )
}

export default App;
