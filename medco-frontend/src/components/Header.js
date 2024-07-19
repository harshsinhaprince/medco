// src/components/Header.js
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Header.css'; // Ensure the path is correct

const Header = () => {
  return (
    <header className="header">
      <div className="container">
        <h1 className="logo">
          <Link to="/">Medco</Link>
        </h1>
        <nav>
          <ul className="nav-links">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/products">Products</Link>
            </li>
            <li>
              <Link to="/cart">Cart</Link>
            </li>
            <li>
              <Link to="/checkout">Checkout</Link>
            </li>
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Header;
