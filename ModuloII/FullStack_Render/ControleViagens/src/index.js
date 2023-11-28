// Importações necessárias do React para criar o aplicativo
import { StrictMode } from "react";

// Importação da função createRoot para renderizar o aplicativo no DOM
import { createRoot } from "react-dom/client";

// Importação do componente principal App que será renderizado
import App from "./App";

// Obtém a referência ao elemento HTML com id "root" onde o aplicativo será renderizado
const rootElement = document.getElementById("root");

// Cria um "root" (raiz) para renderizar o aplicativo no elemento HTML com id "root"
const root = createRoot(rootElement);

// Renderiza o componente App dentro de um StrictMode
root.render(
  <StrictMode>
    <App />
  </StrictMode>
);
