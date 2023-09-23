// Importações necessárias do React e de outras bibliotecas
import React, { useState, useEffect } from "react";
import {
  CssBaseline,
  Typography,
  AppBar,
  Toolbar
} from "@mui/material";

// Estilos CSS para elementos específicos do componente
const appBarStyle = {
  marginBottom: "100px"
};

const pageTitleStyle = {
  fontSize: "2rem",
  fontWeight: "bold",
  marginBottom: "50px"
};

// Componente principal da aplicação
function App() {
  // Renderização do componente
  return (
    <div>
      <CssBaseline />
      <AppBar position="static" style={appBarStyle}>
        <Toolbar>
          <Typography variant="h1">Viagens</Typography>
        </Toolbar>
      </AppBar>
    </div>
  );
}
export default App; // Exportação do componente principal
