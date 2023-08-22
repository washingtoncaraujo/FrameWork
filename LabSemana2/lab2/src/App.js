import React from 'react';
import './App.css';
import Subtitle from './Subtitle';
import Title from './Title';


function App() {
  return (
    <div className='App'>
      <Title/>  {/*Usando o componente Title*/}
      <Subtitle text = 'Meu subtítulo'/>   {/* Usando o componente Subtitle e alterando seu props */}

    </div>
  );
}

export default App;  // Exportando a função
