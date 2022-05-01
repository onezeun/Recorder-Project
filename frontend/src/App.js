import React from "react";
import CssBaseline from '@mui/material/CssBaseline';

import { useSelector } from "react-redux";
import { Link, Route, BrowserRouter as Router, Routes } from "react-router-dom";
import styled from 'styled-components';

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

const StyledDiv = styled.div`
  margin-top: 50px;
`;

function App() {
  return (
    <>
      <CssBaseline />
      <Router>
        <Header />
        <StyledDiv>
          <hr />
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
            <Link to="/post">
              <button>Post</button>
            </Link>
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
          <hr /> 
          <Routes>
            <Route exact path="/" element={<Main />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/editor" element={<Editor />} />
            <Route path="/user" element={<User />} />
            <Route path="/post" element={<Post />} />
            <Route path="/main" element={<Main />} />
            <Route path="/userhome" element={<UserHome />} />
            <Route path="/search" element={<Search />} />
            <Route path="/neighbor" element={<Neighbor />} />
            <Route path="/category" element={<Category />} />
            <Route path="/profile" element={<Profile />} />
          </Routes>
        </StyledDiv>
      </Router>
    </>
  );
}

export default App;