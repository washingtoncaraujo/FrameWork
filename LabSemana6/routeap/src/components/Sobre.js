import React from "react";
import { TextField, Button, Grid, Paper, Typography, Container } from "@mui/material";


function Sobre({setShowForm}) {
  const buttonStyle = {
    marginRight: "18px"
  };

  return (
    <div>
      <Paper>
      <Typography variant="h6" gutterBottom>
        Dúvidas
      </Typography>
      </Paper>
      
      
      <Button onClick={() => setShowForm(3)} style={buttonStyle}>Voltar
     </Button>
   </div>   
  );
  }

export default Sobre;