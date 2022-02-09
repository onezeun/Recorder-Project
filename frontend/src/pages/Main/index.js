import * as React from 'react';
// import AppBar from '@mui/material/AppBar';
import { Button, IconButton, Card, CardActions, CardContent, CardMedia, Grid, Box, Typography, CardHeader, Avatar, Pagination, Stack, CardActionArea }from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';



// function Copyright() {
//   return (
//     <Typography variant="body2" color="text.secondary" align="center">
//       {'Copyright © '}
//       <Link color="inherit" href="https://mui.com/">
//         Your Website
//       </Link>{' '}
//       {new Date().getFullYear()}
//       {'.'}
//     </Typography>
//   );
// }

const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const theme = createTheme();

export default function Main() {
  return (
    <ThemeProvider theme={theme}>
      <main>
        <Box
          sx={{
            bgcolor: 'background.paper',
            pt: 8,
            pb: 6,
          }}
        >

          {/* 인기, 최근, 이웃 게시물 버튼 */}
          <Box
            sx= {{
              display: 'flex',
              flexDirection: 'row',
              }}
              noValidate
              autoComplete="off"
              >
            <Box
             sx= {{
              '& > :not(style)': { marginLeft: 4 },
              }}
              noValidate
              autoComplete="off"
              >
              <Button>인기 게시물</Button>
            </Box>
            <Box
             sx= {{

              }}
              noValidate
              autoComplete="off"
              >
              <Button>최신 게시물</Button>
            </Box>
          </Box>
        </Box>

        <Box
        sx= {{
        '& > :not(style)': { marginLeft: 1 },
        }}
        noValidate
        autoComplete="off"
        >
          {/* 게시글 */}
          <Grid container spacing={4}>
            {cards.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                  <Card
                  sx={{ width: '86%', height: '100%', display: 'flex', flexDirection: 'column' }}
                >
                  <CardHeader
                    avatar={
                      <Avatar sx={{  }} aria-label="recipe">
                        R
                      </Avatar>
                    }
                    title="zu21un"
                    subheader="2월 6일 14:46, 2022"
                  />
                  <CardActionArea component="a" href="#">
                  <CardMedia
                    component="img"
                    sx={{
                      width: 'fill',
                      height: '400px',
                      objectFit: 'cover'
                    }}
                    image="https://source.unsplash.com/random"
                    alt="사진"
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Typography gutterBottom variant="h5" component="h2">
                      1-800-273-8255
                    </Typography>
                    <Typography>
                      Logic, Juanes 노래입니다. I've been on the low I been taking my time I feel like I'm out of my mind
                    </Typography>
                  </CardContent>
                  </CardActionArea>
                  <CardActions>
                    <IconButton aria-label="like">
                      <FavoriteIcon />
                    </IconButton>
                    <IconButton aria-label="share">
                      <ShareIcon />
                    </IconButton>
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
      </Box>

          {/* pagination */}
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
      </main>
      
      {/* 필요시 Footer */}
      {/* <Box sx={{ bgcolor: 'background.paper', p: 6 }} component="footer">
        <Typography variant="h6" align="center" gutterBottom>
          Footer
        </Typography>
        <Typography
          variant="subtitle1"
          align="center"
          color="text.secondary"
          component="p"
        >
          zu21un 바보
        </Typography>
        <Copyright />
      </Box> */}
      {/* End footer */}
    </ThemeProvider>
  );
}