import React from "react";
import { TextField, Button, Grid, Paper, Typography, Container } from "@mui/material";
import {Routers, Route} from 'react-router-dom';

function Sobre({setShowForm}) {
  const buttonStyle = {
    marginRight: "18px"
  };


  return (
    <div>
      <Route>
        <Route path="/readme" element = {<Readme />}></Route>
      </Route>
      <Paper>
      <Typography variant="h6" gutterBottom>
        Dúvidas:
      </Typography>
      <p>WCA</p>
      </Paper>
      
      
      <Button onClick={() => setShowForm(3)} style={buttonStyle}>Voltar
     </Button>
   </div>   
  );
  }

export default Sobre;