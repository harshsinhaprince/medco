// src/components/Header.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../AuthContext';
import { auth } from '../firebase';
import '../styles/Header.css';

const Header = () => {
  const user = useAuth();

  const handleLogout = () => {
    auth.signOut();
  };

  return (
    <header className="header">
      <div className="container">
        <h1 className="logo">
          <Link to="/">Medco</Link>
        </h1>
        <nav>
          <ul className="nav-links">
            {user ? (
              <>
                <li>Hello, {user.email}</li>
                <li>
                  <button onClick={handleLogout}>Logout</button>
                </li>
              </>
            ) : (
              <>
                <li>
                  <Link to="/login">Login</Link>
                </li>
                <li>
                  <Link to="/register">Register</Link>
                </li>
              </>
            )}
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Header;
