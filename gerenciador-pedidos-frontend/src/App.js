import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Clientes from './pages/Clientes';
import Produtos from './pages/Produtos';
import Pedidos from './pages/Pedidos';

function App() {
  return (
    <Router>
      <Navbar />
      <div className="content">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/clientes" element={<Clientes />} />
          <Route path="/produtos" element={<Produtos />} />
          <Route path="/pedidos" element={<Pedidos />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
