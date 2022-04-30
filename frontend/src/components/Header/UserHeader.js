import React from 'react';
import { useDispatch, useSelector } from "react-redux";
import { Navigate, useNavigate, Link } from 'react-router-dom';
import styled from "styled-components";
import logo from '../../img/logo-removebg.png'

import { IconButton, MenuItem, Menu, Box, Badge, Typography } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import NotificationsIcon from '@mui/icons-material/Notifications';
import AccountCircle from '@mui/icons-material/AccountCircle';
import MoreIcon from '@mui/icons-material/MoreVert';

import { logout } from '../../redux/actions/auth';

const Img = styled.img`
  width: 25vw;
  height: 5vw;

  @media screen and (max-width: 610px) {
    width: 35vw;
    height: 7vw;
    flex-direction: column;
  }
`;

export default function UserHeader() {
  const { isLoggedIn } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [anchorEl, setAnchorEl] = React.useState(null);
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);
  

  const isMenuOpen = Boolean(anchorEl);
  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMobileMenuClose = () => {
    setMobileMoreAnchorEl(null);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
    handleMobileMenuClose();
  };

  const handleMobileMenuOpen = (event) => {
    setMobileMoreAnchorEl(event.currentTarget);
  };

  const onLogOut = (e) => {
    e.preventDefault();
    dispatch(logout())
    .then(() => {
      navigate('/login')
      console.log('isLogin', isLoggedIn);
    });
  };

  const mobileMenuId = 'primary-search-account-menu-mobile';
  const renderMobileMenu = (
    <Menu
      anchorEl={mobileMoreAnchorEl}
      anchorOrigin={{
        vertical: 'top',
        horizontal: 'right',
      }}
      id={mobileMenuId}
      keepMounted
      transformOrigin={{
        vertical: 'top',
        horizontal: 'right',
      }}
      open={isMobileMenuOpen}
      onClose={handleMobileMenuClose}
    >
      <MenuItem component={Link} to={'/Editor'}>
        <Typography textAlign="center">새 글 작성</Typography>
      </MenuItem>
      <MenuItem component={Link} to={'/Userhome'}>
        <Typography textAlign="center">내 블로그</Typography>
      </MenuItem>
      <MenuItem component={Link} to={'/User'}>
        <Typography textAlign="center">계정 설정</Typography>
      </MenuItem>
      <MenuItem onClick={onLogOut}>
        <Typography textAlign="center">로그아웃</Typography>
      </MenuItem>
    </Menu>
  );
  if (isLoggedIn === false) {
    return <Navigate to="/login" replace={true} />
  } else{
  return (
    <Box flexDirection = 'row' alignItems = 'center' sx={{
      display: 'flex',
      justifyContent: 'center',
      pr: '1rem',
      pl: '1rem'
    }}>
      <Box sx={{ mx:5, mt:7 }}>
      <Link to="/main">
        <Img src={logo} />
      </Link>
      </Box>
      <Box sx={{ flexGrow: 1 }} />
      <Box sx={{ display: { xs: 'none', md: 'flex' },  mt:6 }}>
        <MenuItem component={Link} to={'/Editor'}>
          <Typography textAlign="center">새 글 작성</Typography>
        </MenuItem>
        <MenuItem component={Link} to={'/Userhome'}>
          <Typography textAlign="center">내 블로그</Typography>
        </MenuItem>
        <MenuItem component={Link} to={'/User'}>
          <Typography textAlign="center">계정 설정</Typography>
        </MenuItem>
        <MenuItem onClick={onLogOut}>
          <Typography textAlign="center">로그아웃</Typography>
        </MenuItem>
      </Box>
      <Box sx={{ display: { xs: 'flex', md: 'none' }, mt:7 }}>
        <IconButton
          size="large"
          aria-label="show more"
          aria-controls={mobileMenuId}
          aria-haspopup="true"
          onClick={handleMobileMenuOpen}
          color="inherit"
        >
          <MoreIcon />
        </IconButton>
        {renderMobileMenu}
      </Box>
    </Box>
  );
}}