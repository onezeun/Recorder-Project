import React from "react";
import CssBaseline from '@mui/material/CssBaseline';

import { useSelector } from "react-redux";
import { Link, Route, BrowserRouter as Router, Routes } from "react-router-dom";

import Box from '@mui/material/Box';

import './App.css';

import Header from './components/Header/Header';
import UserHeader from './components/Header/Header';
import MemberComponent from './components/Member/MemberConponent.js';
import Category from './components/Category/Category';

import Login from './pages/Login';
import Signup from './pages/Signup';
import Editor from './pages/Editor';
import User from './pages/User';
import Post from './pages/Post';
import Main from './pages/Main';
import UserHome from './pages/Userhome';
import Search from './pages/Search';
import Neighbor from './pages/Neighbor';
import Profile from "./pages/Profile";


function App() {
  return (
    <>
      <CssBaseline />
      <Router>
        <Header />

        <hr />
          <div style={{ display:'inline' }}>
            {/* <Link to="/login">
              <button>Login</button>
            </Link>
            <Link to="/signup">
              <button>Signup</button>
            </Link> */}
            <Link to="/editor">
              <button>Editor</button>
            </Link>
            {/* <Link to="/user">
              <button>User</button>
            </Link> */}
            {/* <Link to="/post">
              <button>Post</button>
            </Link> */}
            <Link to="/main">
              <button>Main</button>
            </Link>
            {/* <Link to="/userhome">
              <button>Userhome</button>
            </Link> */}
            {/* <Link to="/search">
              <button>Search</button>
            </Link>
            <Link to="/neighbor">
              <button>Neighbor</button>
            </Link> */}
            <Link to="/category">
              <button>Category</button>
            </Link>
            {/* <Link to="/profile">
              <button>profile</button>
            </Link> */}
          </div>
          <hr /> 

        <main style={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center' 
        }}>
          <Routes>
            <Route exact path="/" element={<Main />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/editor" element={<Editor />} />
            <Route path="/user" element={<User />} />
            <Route path="/main" element={<Main />} />
            <Route path="/userhome" element={<UserHome />} />
            <Route path="/userhome/:userId" element={<UserHome />} />
            <Route path="/search" element={<Search />} />
            <Route path="/neighbor" element={<Neighbor />} />
            <Route path="/category" element={<Category />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/post/:postId" element={<Post />} />
          </Routes>
        </main>

        <footer style={{ textAlign: "center", margin: "30px 0" }}>
          <h3>Team Recoder</h3>
        </footer>
      </Router>
    </>
  );
}

export default App;