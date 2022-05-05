import React, { useState, useEffect } from 'react';

import axios from 'axios';
import {
  Button,
  IconButton,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Grid,
  Box,
  Typography,
  CardHeader,
  Avatar,
  Pagination,
  Stack,
  CardActionArea,
} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';

import LikeButton from '../components/Like/LikeButton';

const mainPostDatas = [
  {
    id: 1,
    nickname: 'jiwoon',
    profile: null,
    thumbnail: null,
    title: '인사1',
    summary: '안녕하세요1',
    hits: 3,
    created_time: '2022-03-07 14:46:04',
  },
  {
    id: 2,
    nickname: 'younghan',
    profile: null,
    thumbnail: null,
    title: '인사2',
    summary: '안녕하세요2',
    hits: 39,
    created_time: '2022-03-08 14:46:16',
  },
  {
    id: 3,
    nickname: 'hyeji',
    profile: null,
    thumbnail: null,
    title: '인사3',
    summary: '안녕하세요3',
    hits: 35,
    created_time: '2012-03-19 14:46:37',
  },
  {
    id: 4,
    nickname: 'jieun',
    profile: null,
    thumbnail: null,
    title: '인사4',
    summary: '안녕하세요4',
    hits: 63,
    created_time: '1922-02-06 14:46:53',
  },
  {
    id: 5,
    nickname: 'jiwoon',
    profile: null,
    thumbnail: null,
    title: '인사5',
    summary: '안녕하세요5',
    hits: 93,
    created_time: '2022-02-15 14:25:04',
  },
  {
    id: 6,
    nickname: 'younghan',
    profile: null,
    thumbnail: null,
    title: '인사6',
    summary: '안녕하세요6',
    hits: 9,
    created_time: '2022-09-08 14:43:04',
  },
  {
    id: 7,
    nickname: 'hyeji',
    profile: null,
    thumbnail: null,
    title: '인사7',
    summary: '안녕하세요7',
    hits: 7,
    created_time: '2022-02-16 14:46:04',
  },
  {
    id: 8,
    nickname: 'jieun',
    profile: null,
    thumbnail: null,
    title: '인사8',
    summary: '안녕하세요8',
    hits: 15,
    created_time: '2022-02-26 6:46:04',
  },
  {
    id: 9,
    nickname: 'jiwoon',
    profile: null,
    thumbnail: null,
    title: '인사9',
    summary: '안녕하세요9',
    hits: 4,
    created_time: '2022-05-06 11:46:04',
  },
];

// const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const theme = createTheme();

export default function Main() {
  const [id, setId] = useState(null);
  const [nickname, setNickname] = useState(null);
  const [profile, setProfile] = useState(null);
  const [thumbnail, setThumbnail] = useState(null);
  const [title, setTitle] = useState(null);
  const [summary, setSummary] = useState(null);
  const [hits, setHits] = useState(null);
  const [created_time, setCreated_time] = useState(null);

  const [like, setLike] = useState(false);
  const [number, setNumber] = useState(0);

  // 좋아요 수
  // const onIncrease = () => {
  //   setNumber(likes => likes + 1);
  // }

  // const onDecrease = () => {
  //   setNumber(likes => likes - 1);
  // }

  useEffect(() => {
    const fetchPostDatas = async () => {
      try {
        // const response = await axios.get("http://localhost:8080/api/board/posts");
        const response = mainPostDatas();
        setId(response.data);
        setNickname(response.data);
        setProfile(response.data);
        setThumbnail(response.data);
        setTitle(response.data);
        setSummary(response.data);
        setHits(response.data);
        setCreated_time(response.data);
      } catch (e) {
        console.log(e);
      }
    };
    fetchPostDatas();
  }, []);

  // 좋아요 기능
  useEffect(async () => {
    const fetchLikeData = async (e) => {
      // const response = await axios.get
      // if (response.data.type === 'liked') setLike(true) && onIncrease
    };
    fetchLikeData();
  }, []);

  const recorderLike = async (e) => {
    // const response = await axios.post // 사용자가 좋아요 누를 경우 DB 갱신
    setLike(!like);
  };

  // 조건부 렌더링
  // function neighborPost() {
  //   return (
  //     <Box
  //         sx= {{

  //         }}
  //         noValidate
  //         autoComplete="off"
  //         >
  //       <Button>이웃 게시물</Button>
  //     </Box>
  //   )
  // }

  // function neighborPostButton(props) {
  //   if(props.isLoggedIn) {
  //     return <neighborPost />;
  //   }
  //   return null;
  // }

  function neighborPost(props) {
    return <Button>1번 게시물</Button>;
  }

  function neighborPosts(props) {
    return <Button>2번 게시물</Button>;
  }

  function Greeting(props) {
    const isLoggedOut = props.isLoggedOut;
    if (isLoggedOut) {
      return <neighborPost />;
    }
    return <neighborPosts />;
  }

  return (
    <Box
      sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}
    >
      <Box
        sx={{
          bgcolor: 'background.paper',
          pt: 8,
          pb: 6,
        }}
      >
        {/* 인기, 최근, 이웃 게시물 버튼
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
            <Greeting isLoggedOut={false} />
          </Box>
        </Box>

        <Box
        sx= {{
        '& > :not(style)': { marginLeft: 1 },
        }}
        noValidate
        autoComplete="off"
        > */}
        {/* 게시글 */}
        <Grid container spacing={4}>
          {mainPostDatas.map((mainPostData) => (
            <Grid item key={mainPostData} xs={12} sm={6} md={4}>
              <Card
                sx={{
                  mx: 'auto',
                  width: '86%',
                  height: '100%',
                  display: 'flex',
                  flexDirection: 'column',
                }}
              >
                <CardHeader
                  avatar={
                    <Avatar
                      sx={{}}
                      image={mainPostData.profile}
                      aria-label="recipe"
                    ></Avatar>
                  }
                  title={mainPostData.nickname}
                  subheader={mainPostData.created_time}
                />
                <CardActionArea component="a" href="#">
                  <CardMedia
                    component="img"
                    sx={{
                      width: 'fill',
                      height: '400px',
                      objectFit: 'cover',
                    }}
                    image={mainPostData.thumbnail}
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Typography gutterBottom variant="h5" component="h2">
                      {mainPostData.title}
                    </Typography>
                    <Typography>{mainPostData.summary}</Typography>
                  </CardContent>
                </CardActionArea>
                {/* <CardActions>
                    <IconButton aria-label="like">
                      <LikeButton like={like} onClick={recorderLike}/>
                    </IconButton>
                    <IconButton aria-label="share">
                      <ShareIcon />
                    </IconButton>
                  </CardActions> */}
              </Card>
            </Grid>
          ))}
        </Grid>
      </Box>

      {/* pagination */}
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
    </Box>
  );
}
