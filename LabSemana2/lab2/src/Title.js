import React from "react";
import { useState } from "react";

function Title (props){
    const [title, setTitle] = useState("Título Simple");
    const [clickCount, setClickCount] = useState(0);
    return(        
        <><h1 onClick={() => {
            setTitle("Título Modificado"); 
            setClickCount(clickCount+1)}}>{title}</h1>
        <h2>Contagem de Cliques: {clickCount}</h2></>
    )
}

export default Title;