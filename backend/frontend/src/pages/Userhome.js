import React from 'react';
import { Stack, Box, Paper, Grid, Typography, Pagination } from '@mui/material';
import Sidebar from '../components/Userhome/Sidebar'
import MainPost from '../components/Userhome/MainPost';

const MainPosts = [
  {
    title: '바보의 일상3',
    description:
      '오늘은 밥을 먹지 않았다. 배가 고팠다.',
  },
  {
    title: '바보의 일상2',
    description:
      '오늘도 밥을 먹었다. 맛있었다.',
  },
  {
    title: '바보의 일상1',
    description:
      '오늘은 밥을 먹었다. 맛있었다.',
  },
];

export default function Userhome() {
  return (
    <Grid>
      <Stack direction="row">
        <Sidebar />
        <Stack direction="column" sx={{ alignItems: 'center' }}>
          {/* 블로그 배너*/}
          <Paper
            sx={{
              mr:5,
              width: '100%', height: 300, overflow: 'hidden',
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
            {<img style={{ display: 'none' }} src='https://source.unsplash.com/random' />}
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
            <Grid container>
              <Grid>
                <Box
                  sx={{
                    position: 'relative',
                    p: { xs: 3, md: 6 },
                    pr: { md: 0 },
                  }}
                >
                  <Typography component="h2" variant="h3" color="inherit" >
                    바보의 일상
                  </Typography>
                </Box>
              </Grid>
            </Grid>
          </Paper>

          {/* 게시물 */}
          <Box sx={{ mr: 5 }}>
            <Grid 
            container
            rowSpacing={3}
            >
              {MainPosts.map((post) => (
                <MainPost key={post.title} post={post} />
              ))}
            </Grid>
          </Box>

          {/* Pagination */}
          <Box
             sx= {{
              display: 'flex',
              justifyContent: 'center',
              '& > :not(style)': { m: 3, marginLeft: 5 },
              
              }}
              noValidate
              autoComplete="off"
              >
              <Stack spacing={2}>
              <Pagination count={6} variant="outlined" color="primary" />
              </Stack>
            </Box>
        </Stack>
      </Stack>
    </Grid>
  )
}
