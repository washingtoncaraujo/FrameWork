import React from "react";
import { Link } from "react-router-dom";

function About() {
  return (
    <div className="container">
      <h1>Sobre</h1>
      <p>Esta é a página "Sobre" da nossa aplicação.</p>
      <Link to="/">
        <button>Voltar à Home</button>
      </Link>
    </div>
  );
}

export default About;