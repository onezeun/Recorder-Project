import * as React from 'react';
// import AppBar from '@mui/material/AppBar';
import { Button, IconButton, Card, CardActions, CardContent, CardMedia, Grid, Box, Typography, Container }from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
// import CameraIcon from '@mui/icons-material/PhotoCamera';
// import CssBaseline from '@mui/material/CssBaseline';
// import Stack from '@mui/material/Stack';
// import Toolbar from '@mui/material/Toolbar';
// import Link from '@mui/material/Link';

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

export default function Album() {
  return (
    <ThemeProvider theme={theme}>
      <main>
        {/* Hero unit */}
        <Box
          sx={{
            bgcolor: 'background.paper',
            pt: 8,
            pb: 6,
          }}
        >

          
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
        {/* <Container sx={{ py: 8 }} maxWidth="md"> */}
        <Box
        sx= {{
        '& > :not(style)': { marginLeft: 1, marginRight: 1 },
        }}
        noValidate
        autoComplete="off"
        >
          {/* End hero unit */}
          <Grid container spacing={4}>
            {cards.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card
                  sx={{ width: '86%', height: '100%', display: 'flex', flexDirection: 'column' }}
                >
                  <CardMedia
                    component="img"
                    sx={{
                      // 16:9
                      pt: '56.25%',
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
        {/* </Container> */}
      </main>
      {/* Footer */}
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
          Something here to give the footer a purpose!
        </Typography>
        <Copyright />
      </Box> */}
      {/* End footer */}
    </ThemeProvider>
  );
}