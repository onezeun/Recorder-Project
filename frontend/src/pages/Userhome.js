import React, { useState, useEffect } from 'react';
import { Container, Stack, Box, Paper, Grid, Typography, Pagination, CardActionArea, Card, CardMedia, CardContent, Button, Divider, Avatar, Link } from '@mui/material';
import { styled, ThemeProvider, createTheme } from '@mui/material/styles';
import List from '@mui/material/List';
import Category from '../components/Category/Category';
import axios from 'axios';

import { useSelector, useDispatch } from 'react-redux';
import { getUser } from '../redux/actions/user';


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

export default function Userhome() {
  const dispatch = useDispatch();
  const { user: currentUser } = useSelector((state) => state.auth);
  const data = useSelector((state) => state.user);
  const [userData, setUserData] = useState([]);
  const [allPosts, setAllPosts] = useState([]);

  function getUsers() {
    dispatch(getUser(currentUser.userId))
      .then((data) => {
        setUserData(data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
  useEffect(() => {
    getUsers();
    console.log(data)
  }, []);

  useEffect(() => {
      try {
        axios.get(`http://localhost:8080/board/users/${currentUser.userId}/posts`)
        .then(response => {
          setAllPosts(response.data.data);
          console.log('userid', currentUser.userId)
        })
      } catch (e) {
        console.log(e);
      }
  }, []);



  return (
    <Grid>
      <Stack direction="row">
        {/* 사이드바 */}
        <Box
          sx={{ display: 'flex', ml: 1, mr: 3, p: 2 }}
        >
          <ThemeProvider theme={createTheme({
            components: {
              MuiListItemButton: {
                defaultProps: {
                  disableTouchRipple: true,
                  },},},})}>
            <Paper elevation={0} sx={{ maxWidth: 256, width: 200 }}>
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
                    src={data.profilePhoto}
                  />
                  <Typography
                    variant="h6"
                    component="div"
                    sx={{ my: 2, mx: 4.5, fontWeight: 'bold' }}
                  >
                    {data.nickname}
                  </Typography>
                  <Typography
                    variant="button"
                    component="div"
                    sx={{ my: 2, mx: 4.5 }}
                  >
                    {data.introduce}
                  </Typography>
                  <Stack direction="row">
                    <Button size="small">이웃추가</Button>
                  </Stack>
                </Stack>
                <Divider />
                <Link to="/" component={Category} exact />
              </Nav>
            </Paper>
          </ThemeProvider>
        </Box>

        <Stack direction="column" sx={{ justifyContent: 'center' }}>
          {/* 블로그 배너*/}
          <Paper
            sx={{
              mx: 'auto',
              width: '1000px',
              height: '300px',
              overflow: 'hidden',
              position: 'relative',
              backgroundColor: 'grey.800',
              color: '#fff',
              mb: 4,
              backgroundSize: 'cover',
              backgroundRepeat: 'no-repeat',
              backgroundPosition: 'center',
              backgroundImage: `url('https://source.unsplash.com/random')`,
            }}
          >
            {
              <img
                style={{ display: 'none' }}
                src="https://source.unsplash.com/random"
              />
            }
            <Box
              sx={{
                position: 'absolute',
                top: 0,
                bottom: 0,
                right: 0,
                left: 0,
                backgroundColor: 'rgba(0,0,0,.3)',
              }}
            />
            <Grid>
                <Box
                  sx={{
                    position: 'relative',
                    p: { xs: 3, md: 6 },
                    pr: { md: 0 },
                  }}
                >
                  <Typography component="h2" variant="h3" color="inherit">
                    {data.domain}
                  </Typography>
                </Box>
            </Grid>
          </Paper>

          {/* 게시물 */}
          <Box>
            <Grid container rowSpacing={3}>
              {allPosts.map((post) => (
                <Container sx={{ py: 3 }}>
                  <Card
                    sx={{
                      width: '800px',
                      height: '350px',
                      display: 'flex',
                      flexDirection: 'column',
                      mx:'auto'
                    }}
                  >
                    <CardActionArea component="a" href="#">
                      <CardMedia
                        component="img"
                        sx={{
                          width: '800px',
                          height: '250px',
                          objectFit: 'cover',
                        }}
                        image={post.thumbnailImage}
                      />
                      <CardContent>
                        <Typography sx={{ fontSize: 13 }}>
                          2022-05-02
                        </Typography>
                        <Typography component="h2" variant="h5" paragraph>
                        {post.title}
                        </Typography>
                        <Typography variant="subtitle1">
                        {post.summary}
                        </Typography>
                      </CardContent>
                    </CardActionArea>
                  </Card>
                </Container>
              ))}
            </Grid>
          </Box>

          {/* Pagination */}
          <Box
            sx={{
              display: 'flex',
              justifyContent: 'center',
              '& > :not(style)': { m: 3 },
            }}
            noValidate
            autoComplete="off"
          >
            <Stack spacing={2}>
              <Pagination count={3} size="small" shape="rounded" />
            </Stack>
          </Box>
        </Stack>
      </Stack>
    </Grid>
  );
}
