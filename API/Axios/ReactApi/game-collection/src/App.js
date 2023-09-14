// Importações necessárias do React e de outras bibliotecas
import React, { useState, useEffect } from "react";
import axios from "axios";
import GameForm from "./components/GameForm";
import GameTable from "./components/GameTable";
import {
  CssBaseline,
  Container,
  Typography,
  AppBar,
  Toolbar
} from "@mui/material";
import API_URL from "./src/config";

// Estilos CSS para elementos específicos do componente
const appBarStyle = {
  marginBottom: "20px"
};

const pageTitleStyle = {
  fontSize: "2rem",
  fontWeight: "bold",
  marginBottom: "20px"
};

// Componente principal da aplicação
function App() {
  // Estados locais para armazenar a lista de jogos e controlar a exibição do formulário
  const [games, setGames] = useState([]);
  const [showForm, setShowForm] = useState(false);

  // Efeito colateral para buscar a lista de jogos ao montar o componente
  useEffect(() => {
    fetchGames();
  }, []);

  // Função assíncrona para buscar a lista de jogos da API
  const fetchGames = async () => {
    try {
      const response = await axios.get(`${API_URL}/games`);
      setGames(response.data);
    } catch (error) {
      console.error("Erro ao buscar jogos:", error);
    }
  };

  // Função para adicionar um novo jogo à coleção
  const handleAddGame = async (newGame) => {
    try {
      await axios.post(`${API_URL}/games`, newGame);
      fetchGames(); // Atualiza a lista de jogos após a adição
      setShowForm(false); // Fecha o formulário de adição
    } catch (error) {
      console.error("Erro ao adicionar jogo:", error);
    }
  };

  // Função para excluir um jogo da coleção
  const handleDeleteGame = async (gameId) => {
    try {
      await axios.delete(`${API_URL}/games/${gameId}`);
      fetchGames(); // Atualiza a lista de jogos após a exclusão
    } catch (error) {
      console.error("Erro ao excluir jogo:", error);
    }
  };

  // Renderização do componente
  return (
    <div>
      <CssBaseline />
      <AppBar position="static" style={appBarStyle}>
        <Toolbar>
          <Typography variant="h6">Coleção de Jogos</Typography>
        </Toolbar>
      </AppBar>
      <Container maxWidth="lg">
        <Typography variant="h2" align="center" style={pageTitleStyle}>
          Coleção de Jogos
        </Typography>
        {/* Condicional para renderizar o formulário ou a tabela de jogos */}
        {showForm ? (
          <GameForm handleAddGame={handleAddGame} setShowForm={setShowForm} />
        ) : (
          <GameTable
            games={games}
            handleDeleteGame={handleDeleteGame}
            setShowForm={setShowForm}
          />
        )}
      </Container>
    </div>
  );
}

export default App; // Exportação do componente principal
