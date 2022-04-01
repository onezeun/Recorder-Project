import React, { useState } from 'react';
import { styled, ThemeProvider, createTheme } from '@mui/material/styles';
import { Link, Stack, Button, Divider, Paper, Avatar, Box, InputBase, Typography } from '@mui/material';
import List from '@mui/material/List';
import SearchIcon from '@mui/icons-material/Search';

import Category from '../Category/Category';

/* 검색바 스타일 */
const Search = styled('div')(({ theme }) => ({
  padding: theme.spacing(0, 2),
  position: 'relative',
  borderRadius: theme.shape.borderRadius,
  backgroundColor: 'rgba(0,0,0,0.1)',
  marginBottom: 10,
  marginRight: theme.spacing(2),
  marginLeft: 0,
  width: '100%',
  [theme.breakpoints.up('sm')]: {
    marginLeft: theme.spacing(2),
    width: 'auto',
  },
}));

const SearchIconWrapper = styled('div')(() => ({
  height: '100%',
  position: 'absolute',
  pointerEvents: 'none',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: 'inherit',
  '& .MuiInputBase-input': {
    padding: theme.spacing(1, 1, 1, 0),
    paddingLeft: `calc(1em + ${theme.spacing(2)})`,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('md')]: {
      width: '20ch',
    },
  },
}));

const Nav = styled(List)({
  '& .MuiListItemButton-root': {
    paddingLeft: 24,
    paddingRight: 24,
  },
  '& .MuiListItemIcon-root': {
    minWidth: 0,
    marginRight: 16,
  },
  '& .MuiSvgIcon-root': {
    fontSize: 20,
  },
});

export default function Sidebar() {
  const [categoryName, setCategoryName] = useState('');
  const onChangeCategory = (e) => {
    e.preventDefault();
    sessionStorage.setItem('category', setCategoryName);
  }


  return (
    <Box>
      <Box sx={{ display: 'flex', mr: 10 }}>
        <ThemeProvider
          theme={createTheme({
            components: {
              MuiListItemButton: {
                defaultProps: {
                  disableTouchRipple: true,
                },
              },
            },
          })}
        >
          <Paper elevation={0} sx={{ maxWidth: 256 }}>
            <Nav component="nav" disablePadding>
              <Stack
                direction="column"
                spacing={1}
                sx={{ ml: 1, mr: 2, mt: 5, my: 3, alignItems: 'center' }}
              >
                <Avatar
                  sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    width: '130px',
                    height: '130px',
                  }}
                  alt="Remy Sharp"
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
                />
                <Typography
                  variant="h6"
                  component="div"
                  sx={{ my: 2, mx: 4.5, fontWeight: 'bold' }}
                >
                  ezerone
                </Typography>
                <Typography
                  variant="button"
                  component="div"
                  sx={{ my: 2, mx: 4.5 }}
                >
                  바보의 블로그 (한줄자기소개)
                </Typography>
                <Stack direction="row">
                  <Button size="small">이웃추가</Button>
                </Stack>
              </Stack>
              <Search>
                <SearchIconWrapper>
                  <SearchIcon />
                </SearchIconWrapper>
                <StyledInputBase
                  placeholder="검색어를 입력하세요"
                  inputProps={{ 'aria-label': 'search' }}
                />
              </Search>
              <Divider />
              <Link to='/' component={Category} exact/>
              <Stack direction="column" sx={{ mb: 5 }}>
                <Typography
                  variant="button"
                  component="div"
                  sx={{ mt: 2, mx: 3, fontWeight: 'bold' }}
                >
                  태그
                </Typography>
                <Stack direction="row" spacing={2}>
                  <Link variant="button" component="div" sx={{ ml: 3 }}>
                    태그1
                  </Link>
                  <Link variant="button" component="div" sx={{ ml: 0.5 }}>
                    태그2
                  </Link>
                  <Link variant="button" component="div" sx={{ ml: 0.5 }}>
                    태그3
                  </Link>
                </Stack>
              </Stack>
            </Nav>
          </Paper>
        </ThemeProvider>
      </Box>
    </Box>
  );
}
