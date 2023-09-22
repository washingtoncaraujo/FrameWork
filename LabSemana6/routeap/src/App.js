// Importações necessárias do React e de outras bibliotecas
import React, { useState, useEffect } from "react";
import {
  CssBaseline,
  Typography,
  AppBar,
  Toolbar
} from "@mui/material";
//import {Link, Route} from 'react-router-dom';
// Estilos CSS para elementos específicos do componente
const appBarStyle = {
  marginBottom: "30px"
};

const pageTitleStyle = {
  fontSize: "2rem",
  fontWeight: "bold",
  marginBottom: "50px"
};

// Componente principal da aplicação
function App() {

 /* <Routers>
    <Route path="/exibir" element={<Exibir />}/>
  </Routers>*/

  // Renderização do componente
  return (
    <div>
      <CssBaseline />
      <AppBar position="static" style={appBarStyle}>
        <Toolbar>
          <Typography variant="h8">Viagens</Typography>
        </Toolbar>
      </AppBar>
    </div>
  );
}

export default App; // Exportação do componente principal
