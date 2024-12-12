import React, { useState, useEffect } from 'react';
import ProdutoList from '../components/ProdutoList';

function Produtos() {
  return (
    <div className="produtos">
      <h2>Lista de Produtos</h2>
      <ProdutoList />
    </div>
  );
}

export default Produtos;
