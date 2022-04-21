import React from 'react';
import styled from 'styled-components';
import { IconButton, Typography, Box, Stack, MenuItem } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { Link } from 'react-router-dom';
import logo from '../../img/logo-removebg.png';

const Img = styled.img`
  width: 25vw;
  height: 5vw;

  @media screen and (max-width: 610px) {
    width: 35vw;
    height: 7vw;
    flex-direction: column;
  }
`;

export default function Header() {
  return (
    <Box
      flexDirection="row"
      alignItems="center"
      sx={{
        display: 'flex',
        justifyContent: 'center',
        pr: '1rem',
        pl: '1rem',
      }}
    >
      <Box sx={{ mx: 5, mt: 4 }}>
        <Link to="/main">
          <Img src={logo} />
        </Link>
      </Box>
      <Box
        sx={{
          display: 'flex',
          justifyContent: 'flex-end',
          width: '90%',
        }}
      >
        {/* 검색
            <IconButton size="large" aria-label="search" color="inherit">
              <SearchIcon />
            </IconButton> */}
        <Box spacing={1} sx={{ mt:6 }}>
            <MenuItem component={Link} to={'/login'}>
              <Typography textAlign="center">로그인</Typography>
            </MenuItem>
        </Box>
      </Box>
    </Box>
  );
}
