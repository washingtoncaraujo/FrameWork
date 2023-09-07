import React from 'react';
import {useState} from 'react';
import {botaoNormal, botaoDestacado} from './Estilos.module.css';


function App() {
  const [estado, setEstado] = useState(0);
  return (
    <>
    <h1>{estado}</h1>
    <button style={botaoNormal} 
    onClick={() => {setEstado(estado+1)}}>Incremento</button>
    <button style={botaoDestacado} 
    onClick={() => {setEstado(estado-1)}}>Decremento</button>
  </>
  );    
}

export default App;
