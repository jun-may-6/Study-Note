import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Main from './pages/Main'
import Layout from './layouts/Layout'
import Menus from './pages/Menus'
import Reviews from './pages/Reviews'
import MenuDetail from './pages/MenuDetail';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Main />} />
          <Route path="menu">
            <Route index element={<Menus />} />
            <Route path=":id" element={<MenuDetail/>}/>
          </Route>
          <Route path="review" element={<Reviews/>}>
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
