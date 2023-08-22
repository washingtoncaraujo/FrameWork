import React from "react";
import { useState } from "react";

function Title (props){
    const [title, setTitle] = useState("Título Simple"); // Definição das variáveis de estado
    const [clickCount, setClickCount] = useState(0);
    return(        
        <><h1 onClick={() => { // Manipulando as variáveis de estado após clicar no título
            setTitle("Título Modificado"); 
            setClickCount(clickCount+1)}}>{title}</h1>
        <h2>Contagem de Cliques: {clickCount}</h2></>
    )
}

export default Title; // Exportando a função