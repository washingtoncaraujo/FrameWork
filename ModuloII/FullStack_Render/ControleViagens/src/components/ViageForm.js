import React, { useState } from "react";
import { TextField, Button, Grid, Paper, Typography } from "@mui/material";

// Estilos CSS para o componente de formulário
const formStyle = {
  padding: "16px",
  maxWidth: "400px",
  margin: "auto"
};

// Estilo CSS para os botões do formulário
const buttonStyle = {
  marginRight: "8px"
};

// Componente ViageForm responsável por adicionar um novo jogo
function ViageForm({ handleAddViage, setShowForm }) {
  // Estado local para armazenar os dados do novo jogo
  const [newViage, setNewViage] = useState({ usuario: "", origem: "", destino: "", data: "", hora: "", aprovada: "" });

  // Função para atualizar o estado quando os campos do formulário são preenchidos
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewViage({ ...newViage, [name]: value });
  };

  // Função para lidar com o envio do formulário
  const handleSubmit = (e) => {
    e.preventDefault(); // Evita o recarregamento da página após o envio
    handleAddViage(newViage); // Chama a função para adicionar uma viagem
    setNewViage({  usuario: "", origem: "", destino: "", data: "", hora: "", aprovada: "" }); // Limpa os campos do formulário
  };

  return (
    <Paper elevation={3} style={formStyle}>
      <Typography variant="h6" gutterBottom>
        Adicionar Viagem
      </Typography>
      <form onSubmit={handleSubmit}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Usuário"
              name="usuario"
              value={newViage.usuario}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Origem"
              name="origem"
              value={newViage.origem}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Destino"
              name="destino"
              value={newViage.destino}
              onChange={handleInputChange}
            />
          </Grid><Grid item xs={12}>
            <TextField
              fullWidth
              label="Data"
              name="data"
              value={newViage.data}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Hora"
              name="hora"
              value={newViage.hora}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Aprovada?"
              name="aprovada"
              value={newViage.aprovada}
              onChange={handleInputChange}
            />
          </Grid>
        </Grid>
        <div style={{ marginTop: "16px" }}>
          <Button
            variant="contained"
            color="primary"
            type="submit"
            style={buttonStyle}
          >
            Adicionar
          </Button>
          <Button onClick={() => setShowForm(3)} style={buttonStyle}>
            Cancelar
          </Button>
        </div>
      </form>
    </Paper>
  );
}

export default ViageForm; // Exportação do componente ViageForm
