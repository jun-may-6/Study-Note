
import './App.css';
import WebEditor from './editor/WebEditor';

function App() {
  const style = {
    editAreaStyle: { 

    }
  }
  return (
    <>
    <div style={{border: '1px black solid', height: '700px', width: '1700px', display:'flex', justifyContent:'center'}}>
              <WebEditor style={style}/>
    </div>

    </>
  );
}

export default App;
