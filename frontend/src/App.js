import React, { lazy } from "react";
import { Link, Route, BrowserRouter as Router, Routes } from "react-router-dom";
import styled from 'styled-components';

import './App.css';

import Header from './components/Header/Header.js';

import Login from './pages/Login';
import SignUp from './pages/SignUp';
import Editor from './pages/EditorPage';
import MyPage from './pages/MyPage';
import Post from './pages/PostPage';
import Main from './pages/Main';
import UserHome from './pages/UserHome';
import Search from './pages/Search';
import MemberComponent from './components/Member/MemberConponent.js';

const StyledDiv = styled.div`
  margin-top: 50px;
`;

function App() {
  return (
    // <div className="App">
    //   <MemberComponent />
    // </div>
    <Router>
      <Header />
      <StyledDiv>
        <hr />
          <Link to="/login">
            <button>Login</button>
          </Link>
          <Link to="/signup">
            <button>SignUp</button>
          </Link>
          <Link to="/editor">
            <button>Editor</button>
          </Link>
          <Link to="/mypage">
            <button>Mypage</button>
          </Link>
          <Link to="/post">
            <button>Post</button>
          </Link>
          <Link to="/main">
            <button>Main</button>
          </Link>
          <Link to="/userhome">
            <button>Userhome</button>
          </Link>
          <Link to="/search">
            <button>Search</button>
          </Link>
          <Link to="/member">
            <button>member</button>
          </Link>
        <hr /> 
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/editor" element={<Editor />} />
          <Route path="/mypage" element={<MyPage />} />
          <Route path="/post" element={<Post />} />
          <Route path="/main" element={<Main />} />
          <Route path="/userhome" element={<UserHome />} />
          <Route path="/search" element={<Search />} />
          <Route path="/member" element={<MemberComponent />} />
        </Routes>
      </StyledDiv>
    </Router>
  );
}

export default App;
