import React, { useState, useEffect } from "react";
import axios from "axios";
import ViageForm from "./ViageForm";
import ViageTable from "./ViageTable";
import Sobre from "./Sobre";
import { CssBaseline, Container, Typography, AppBar, Toolbar } from "@mui/material";
import API_URL from "../config";

// Estilos CSS para elementos específicos do componente
const appBarStyle = {
  marginBottom: "30px"
};
const pageTitleStyle = {
  fontSize: "2rem",
  fontWeight: "bold",
  marginBottom: "50px"
};

// Função principal
function Exibir(){
      // Estados locais para armazenar a lista de jogos e controlar a exibição do formulário
  const [viages, setviages] = useState([]);
  const [showForm, setShowForm] = useState(3);

  // Efeito colateral para buscar a lista de jogos ao montar o componente
  useEffect(() => {
    fetchviages();
  }, []);

  // Função assíncrona para buscar a lista de jogos da API
  const fetchviages = async () => {
    try {
      const response = await axios.get(`${API_URL}/Viagens`);
      setviages(response.data);
    } catch (error) {
      console.error("Erro ao buscar viagens:", error);
    }
  };

  // Função para adicionar um novo jogo à coleção
  const handleAddViage = async (newViage) => {
    try {
      await axios.post(`${API_URL}/Viagens`, newViage);
      fetchviages(); // Atualiza a lista de jogos após a adição
      setShowForm(false); // Fecha o formulário de adição
    } catch (error) {
      console.error("Erro ao adicionar viagem:", error);
    }
  };

  // Função para excluir um jogo da coleção
  const handleDeleteViage = async (viageId) => {
    try {
      await axios.delete(`${API_URL}/Viagens/${viageId}`);
      fetchviages(); // Atualiza a lista de jogos após a exclusão
    } catch (error) {
      console.error("Erro ao excluir viagem:", error);
    }
  };

return (
    <div>
      <CssBaseline />
      <Container maxWidth="lg">
      
        {/* Condicional para renderizar o formulário ou a tabela de viagens */}
        {showForm ==1 ? (
          <ViageForm handleAddViage={handleAddViage} setShowForm={setShowForm} />
        ): showForm ==2 ? (< Sobre setShowForm={setShowForm}/>) : (
          <ViageTable
            viage={viages}
            handleDeleteViage={handleDeleteViage}
            setShowForm={setShowForm}
          />
        ) }
      </Container>
    </div>
  );
}
export default Exibir;