import React from "react";
import { TextField, Button, Grid, Paper, Typography, Container } from "@mui/material";
import {BrowserRouter as Router, Routes, Link, Route} from 'react-router-dom';
import Readme from '../rotas/readme';
function Sobre({setShowForm}) {
  const buttonStyle = {
    marginRight: "18px"
  };
return (    
  <div>
      
    <Paper>
      <Router>
      <div>
        <header>
          <h1>Dúvidas</h1>
          <nav>
            <ul>
              <li>
                <Link to="/readme">Manual</Link>
              </li>
              <li>
                <Link to="/about">Sobre</Link>
              </li>
              <li>
                <Link to="/users/123">Perfil do Usuário</Link>
              </li>
            </ul>
          </nav>
        </header>
        <Routes>
          <Route path="/readme" element={<Readme />} />
          {/* Adicione outras rotas conforme necessário */}
        </Routes>
      </div>
      </Router>
      </Paper>      
      
      <Button onClick={() => setShowForm(3)} style={buttonStyle}>Voltar
     </Button>
   </div>   
  );
  }

export default Sobre;