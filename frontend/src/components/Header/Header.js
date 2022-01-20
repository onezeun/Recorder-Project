import React from 'react';
import styled from 'styled-components';
import { media } from './styleUtil';
import { IconButton, Typography, MenuItem, Menu, Box, Badge, Stack, Button } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import NotificationsIcon from '@mui/icons-material/Notifications';
import AccountCircle from '@mui/icons-material/AccountCircle';
import MoreIcon from '@mui/icons-material/MoreVert';

export default function Header() {
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

  const menuId = 'primary-search-account-menu';
  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{
        vertical: 'top',
        horizontal: 'right',
      }}
      id={menuId}
      keepMounted
      transformOrigin={{
        vertical: 'top',
        horizontal: 'right',
      }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={handleMenuClose}>내블로그</MenuItem>
      <MenuItem onClick={handleMenuClose}>계정설정</MenuItem>
      <MenuItem onClick={handleMenuClose}>로그아웃</MenuItem>
    </Menu>
  );

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
      <MenuItem>
        <IconButton size="large" aria-label="search" color="inherit">
          <SearchIcon />
        </IconButton>
        <p>검색</p>
      </MenuItem>
      <MenuItem>
        <IconButton
          size="large"
          aria-label="show 610 new notifications"
          color="inherit"
        >
          <Badge badgeContent={610} color="error">
            <NotificationsIcon />
          </Badge>
        </IconButton>
        <p>알림</p>
      </MenuItem>
      <MenuItem onClick={handleProfileMenuOpen}>
        <IconButton
          size="large"
          aria-label="account of current user"
          aria-controls="primary-search-account-menu"
          aria-haspopup="true"
          color="inherit"
        >
          <AccountCircle />
        </IconButton>
        <p>내정보</p>
      </MenuItem>
    </Menu>
  );


  // 상단 고정
  const Positioner = styled.div`
    display: flex;
    flex-direction: column;
    position: fixed;
    top: 0px;
    width: 100%;
`;

  // 흰 배경, 내용 중간 정렬
  const WhiteBackground = styled.div`
    background: white;
    display: flex;
    justify-content: center;
    height: auto;
`;

  // 헤더의 내용
  const HeaderContents = styled.div`
    width: 1200px;
    height: 100px;
    display: flex;
    flex-direction: row;
    align-items: center;

    padding-right: 1rem;
    padding-left: 1rem;
    ${media.wide`
        width: 992px;
    `}

    ${media.tablet`
        width: 100%;
    `}
`;

  // 로고
  const Logo = styled.div`
    font-size: 1.4rem;
    letter-spacing: 2px;
    color: #444444;
    font-family: 'Rajdhani';
`;

  // 중간 여백
  const Spacer = styled.div`
    flex-grow: 1;
`;

  /* 헤더 구분선
  const GradientBorder = styled.div`
      height: 1px;
      background: #444444;
  `;
  */

  return (
    <Positioner>
      <WhiteBackground>
        <HeaderContents>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            RECORD:ER
          </Typography>
          <Box sx={{ flexGrow: 1 }} />
          <Box sx={{ display: { xs: 'none', md: 'flex' } }}>
            <IconButton size="large" aria-label="search" color="inherit">
              <SearchIcon />
            </IconButton>
            <IconButton
              size="large"
              aria-label="show 17 new notifications"
              color="inherit"
            >
              <Badge badgeContent={17} color="error">
                <NotificationsIcon />
              </Badge>
            </IconButton>
            <IconButton
              size="large"
              edge="end"
              aria-label="account of current user"
              aria-controls={menuId}
              aria-haspopup="true"
              onClick={handleProfileMenuOpen}
              color="inherit"
            >
              <AccountCircle />
            </IconButton>
          </Box>
          <Box sx={{ display: { xs: 'flex', md: 'none' } }}>
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
            {renderMenu}
          </Box> 
          {/* 로그인 전 
          <Box sx={{
            display: 'flex',
            justifyContent: 'flex-end',
            width: '90%',
          }}>
            <IconButton size="large" aria-label="search" color="inherit">
              <SearchIcon />
            </IconButton>
            <Stack spacing={1} direction="row" >
              <Button variant="text" disableElevation>로그인</Button>
            </Stack>
          </Box>
          */}
        </HeaderContents>
      </WhiteBackground>
    </Positioner>
  );
}