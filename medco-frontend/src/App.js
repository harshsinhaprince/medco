// src/App.js
import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import ProductPage from './pages/ProductPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import { Box } from '@chakra-ui/react';

function App() {
  return (
    <Box>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<ProductPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
      </Routes>
    </Box>
  );
}

export default App;
