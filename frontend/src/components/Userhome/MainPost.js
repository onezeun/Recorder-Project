import React from 'react';
import { Typography, Grid, Card, CardActionArea, CardContent, CardMedia } from '@mui/material';
import Clock from 'react-live-clock'

export default function MainPost(props) {
  const { post } = props;

  return (
    <Grid item xs={8} md={20}>
      <CardActionArea component="a" href="#">
        <Card sx={{ display: 'flex', height: 250 }}>
          <CardContent sx={{ flex: 1 }}>
            <Typography component="h2" variant="h5">
              {post.title}
            </Typography>
            <Typography variant="subtitle1" color="text.secondary">
              <Clock format={'YYYY.MM.DD HH:mm'} ticking={true} timezone={'KR/pacific'} />
            </Typography>
            <Typography variant="subtitle1" paragraph>
              {post.description}
            </Typography>
            <Typography variant="subtitle1" color="primary">
              Continue reading...
            </Typography>
          </CardContent>
          <CardMedia
            component="img"
            sx={{ width: 300, display: { xs: 'none', sm: 'block' } }}
            image="https://source.unsplash.com/random"
          />
        </Card>
      </CardActionArea>
    </Grid>
  );
}