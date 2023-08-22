import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

// Página de renderização do DOM

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
