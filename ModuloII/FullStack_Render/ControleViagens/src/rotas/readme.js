import React from "react";
import { TextField, Button, Grid, Paper, Typography, Container } from "@mui/material";
import {Routers, Route} from 'react-router-dom';

function Readme({setShowForm}) {
  const buttonStyle = {
    marginRight: "18px"
  };


  return (
    <div>
      <Paper>
      <Typography variant="h6" gutterBottom>
        Manual:
      </Typography>
      <p>Este aplicativos é usado para agendar viagens</p>
      <p>Na tela incial, clique no botaõ adicionar para </p>
      <p>agendar uma nova viagem.</p>
      <p>Clique no botão Excluir para excluir a viagem selecionada.</p>
      
      </Paper>
      
      
      <Button onClick={() => setShowForm(2)} style={buttonStyle}>Voltar
     </Button>
   </div>   
  );
  }

export default Readme;
