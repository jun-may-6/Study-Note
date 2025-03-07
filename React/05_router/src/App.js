import { BrowserRouter, Routes, Route } from 'react-router-dom'; //구조분해할당
import About from './pages/About';
import Menu from './pages/Menu';
import Main from './pages/Main';

function App() {
  /** 
   * 라우팅
   * : 어떤 요청을 어디로 안내 및 매핑 할 것인지 정해놓고 진행하는 것
   *    리액트에서는 요청에 따라 요청에 매핑 된 컴포넌트를 렌더링 한다.
   * 
   * BrowserRouter : 라우팅이 필요한 컴포넌트들을 감싸는 컴포넌트
   * Routes : Route 들을 묶어주는 단위 (컴포넌트)
   * Route : URL 요청 주소와 컴포넌트를 매핑해 주는 단위(컴포넌트)
   */
  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* <Route path="/" element={<Main/>}/> */}
          <Route index element={<Main/>}/>
          <Route path="/about" element={<About/>}/>
          <Route path="/menu" element={<Menu/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
