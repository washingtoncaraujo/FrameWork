import logo from './logo.svg';
import './App.css';

function App() {
  const estiloBotao = {
    backgroundColor: 'blue',
    color: 'white',
    padding: '10px 20px',
    borderRadius: '5px',
    cursor: 'pointer',
  };
  
  return (
    <>   
    <button style={estiloBotao} > Boato</button>
  </>
  );    
}

export default App;
