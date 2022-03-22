import React from 'react';
import { IconButton, Typography, Box, Stack, Button } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import { Link } from "react-router-dom";



export default function Header() {
  return (
    <Box flexDirection = 'row' alignItems = 'center' sx={{
      display: 'flex',
      justifyContent: 'center',
      pr: '1rem',
      pl: '1rem'
    }}>
      <Box sx={{ mx:5, mt:4 }}>
      <Link to="/main"><Typography variant="h6" component="div">
        RECORD:ER
      </Typography></Link>
      </Box>
          <Box sx={{
            display: 'flex',
            justifyContent: 'flex-end',
            width: '90%',
          }}>
            <IconButton size="large" aria-label="search" color="inherit">
              <SearchIcon />
            </IconButton>
            <Stack spacing={1} direction="row" >
            <Link to="/login"><Button variant="text" disableElevation>로그인</Button></Link>
            </Stack>
          </Box>
    </Box>
  );
}