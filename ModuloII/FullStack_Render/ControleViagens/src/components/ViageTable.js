// Importações necessárias do React e do Material-UI
import React, { useState } from "react";
import {
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Typography,
  Box,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";

// Estilos CSS para elementos específicos do componente
const tableStyle = {
  minWidth: 650,
  margin: "auto",
  marginTop: "30px"
};

const headerCellStyle = {
  backgroundColor: "#f5f5f5",
  fontWeight: "bold"
};

// Componente ViageTable
function ViageTable({ viage, handleDeleteViage, setShowForm }) {
  // Estados locais para controlar a abertura e o fechamento do diálogo de confirmação
  const [openDialog, setOpenDialog] = useState(false);
  const [viageToDelete, setviageToDelete] = useState(null);

  // Função para confirmar a exclusão de uma viagem
  const handleConfirmDelete = () => {
    if (viageToDelete) {
      handleDeleteViage(viageToDelete.id);
      setviageToDelete(null);
    }
    setOpenDialog(false); // Fecha o diálogo de confirmação
  };

  // Função para abrir o diálogo de confirmação antes de excluir uma viagem
  const handleOpenDialog = (viage) => {
    setviageToDelete(viage);
    setOpenDialog(true);
  };

  return (
    <div>
      
      {/* Cabeçalho da tabela */}
      
      <Box display="flex" justifyContent="space-between" alignItems="center">
        <Typography variant="h5">Lista de Viagens:</Typography>
        <Button
          variant="contained"
          color="primary"
          startIcon={<AddCircleOutlineIcon />}
          onClick={() => setShowForm(1)}
        >
          Adicionar Viagem
        </Button>
      </Box>

      {/* Tabela de viagens */}
      <TableContainer component={Paper} style={tableStyle}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell style={headerCellStyle} align="center">
                Usuario
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Origem
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Destino
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Data
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Hora
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Aprovada
              </TableCell>
              <TableCell style={headerCellStyle} align="center">
                Ações
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {viage.length === 0 ? ( // Verifica se a lista de viagens está vazia
              <TableRow>
                <TableCell colSpan={3} align="center">
                  <Typography variant="subtitle1">
                    Não há viagens agendadas
                  </Typography>
                </TableCell>
              </TableRow>
            ) : (
              // Mapeia e exibe os viagens na tabela
              viage.map((viage) => (
                <TableRow key={viage.id}>
                  <TableCell align="center">{viage.usuario}</TableCell>
                  <TableCell align="center">{viage.origem}</TableCell>
                  <TableCell align="center">{viage.destino}</TableCell>
                  <TableCell align="center">{viage.data}</TableCell>
                  <TableCell align="center">{viage.hora}</TableCell>
                  <TableCell align="center">{viage.aprovada}</TableCell>
                  <TableCell align="center">
                    {/* Botão para excluir uma viagem */}
                    <Button
                      variant="outlined"
                      color="error"
                      startIcon={<DeleteIcon />}
                      onClick={() => handleOpenDialog(viage)}
                    >
                      Excluir
                    </Button>                    
                  </TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </TableContainer>
      <Button onClick={()=>setShowForm(2)} color = "warning" >Sobre</Button>
      {/* Diálogo de confirmação para excluir uma viagem */}
      <Dialog open={openDialog} onClose={() => setOpenDialog(false)}>
        <DialogTitle>Confirmar Exclusão</DialogTitle>
        <DialogContent>
          Tem certeza de que deseja excluir a viagem "{viageToDelete?.usuario}"?
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setOpenDialog(false)} color="primary">
            Cancelar
          </Button>
          <Button onClick={handleConfirmDelete} color="error">
            Confirmar
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default ViageTable; // Exportação do componente ViageTable
