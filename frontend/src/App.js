import React, { lazy } from "react";
import { Link, Route, BrowserRouter as Router, Routes } from "react-router-dom";

import './App.css';

import Header from './components/Header/Header.js';

import Login from './pages/Login';
import SignUp from './pages/SignUp';
import Editor from './pages/EditorPage';

function App() {
  return (
    <Router>
      {/* <div> */}
      <Header />
        {/* <Link to="/login">
          <button>Login</button>
        </Link>
        <Link to="/signup">
          <button>SignUp</button>
        </Link>
        <Link to="/editor">
          <button>Editor</button>
        </Link>
      </div> 
      <hr /> */}
      <Routes>
        <Route exact path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/editor" element={<Editor />} />
      </Routes>
    </Router>
  );
}

export default App;
