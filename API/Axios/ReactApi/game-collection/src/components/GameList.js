import React from "react";
import { Button } from "@mui/material";

// Componente GameList responsável por exibir a lista de jogos
function GameList({ games, handleEdit, handleDeleteGame, setShowForm }) {
  return (
    <div>
      <h2>Lista de Jogos</h2>
      <ul>
        {/* Mapeia a lista de jogos e exibe cada jogo na forma de lista */}
        {games.map((game) => (
          <li key={game.id}>
            {/* Exibe o título do jogo e a plataforma */}
            {game.title} ({game.platform}){/* Botão para editar um jogo */}
            <Button variant="outlined" onClick={() => handleEdit(game)}>
              Editar
            </Button>
            {/* Botão para excluir um jogo */}
            <Button
              variant="outlined"
              color="error"
              onClick={() => handleDeleteGame(game.id)}
            >
              Excluir
            </Button>
          </li>
        ))}
      </ul>

      {/* Botão para adicionar um novo jogo */}
      <Button onClick={() => setShowForm(true)}>Adicionar Jogo</Button>
    </div>
  );
}

export default GameList; // Exportação do componente GameList
