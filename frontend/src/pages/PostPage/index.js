import React from 'react';
import Clock from 'react-live-clock'

import InputUnstyled from '@mui/base/InputUnstyled';
import { styled } from '@mui/system';
import { Button, Stack, Avatar, Box, ImageList, ImageListItem, IconButton } from '@mui/material';
import AddCircleIcon from '@mui/icons-material/AddCircle';
// import Fab from '@mui/material/Fab';
// import FavoriteIcon from '@mui/icons-material/Favorite';
// import ShareIcon from '@mui/icons-material/Share';



export default function PostPage() {

  // 댓글 입력 창 관련
  const blue = {
    200: '#80BFFF',
    400: '#3399FF',
  };
  const grey = {
    50: '#F3F6F9',
    100: '#E7EBF0',
    200: '#E0E3E7',
    300: '#CDD2D7',
    400: '#B2BAC2',
    500: '#A0AAB4',
    600: '#6F7E8C',
    700: '#3E5060',
    800: '#2D3843',
    900: '#1A2027',
  };
  const StyledInputElement = styled('input')(
    ({ theme }) => `
    width: 50vw;
    font-size: 0.875rem;
    font-family: IBM Plex Sans, sans-serif;
    font-weight: 400;
    line-height: 1.5;
    color: ${theme.palette.mode === 'dark' ? grey[300] : grey[900]};
    background: ${theme.palette.mode === 'dark' ? grey[900] : grey[50]};
    border: 1px solid ${theme.palette.mode === 'dark' ? grey[800] : grey[300]};
    border-radius: 8px;
    padding: 12px 12px;
    transition: all 150ms ease;
  
    &:hover {
      background: ${theme.palette.mode === 'dark' ? '' : grey[100]};
      border-color: ${theme.palette.mode === 'dark' ? grey[700] : grey[400]};
    }
  
    &:focus {
      outline: 2px solid ${theme.palette.mode === 'dark' ? blue[400] : blue[200]};
      outline-offset: 2px;
    }
  `,
  );
  const CustomInput = React.forwardRef(function CustomInput(props, ref) {
    return (
      <InputUnstyled components={{ Input: StyledInputElement }} {...props} ref={ref} />
    );
  });

  // // 예비로 현시각 설정
  // const nowTime = new Date();

  // const year = nowTime.getFullYear();
  // const month = ('0' + (nowTime.getMonth() + 1)).slice(-2);
  // const day = ('0' + nowTime.getDate()).slice(-2);
  // const hours = ('0' + nowTime.getHours()).slice(-2);
  // const minutes = ('0' + nowTime.getMinutes()).slice(-2);
  // const timeString = year + '-' + month + '-' + day + '' + hours + ':' + minutes;

  const itemData = [
    {
      img: 'https://images.unsplash.com/photo-1551963831-b3b1ca40c98e',
      title: 'Breakfast',
    },
    {
      img: 'https://images.unsplash.com/photo-1551782450-a2132b4ba21d',
      title: 'Burger',
    },
    {
      img: 'https://images.unsplash.com/photo-1522770179533-24471fcdba45',
      title: 'Camera',
    },
    {
      img: 'https://images.unsplash.com/photo-1444418776041-9c7e33cc5a9c',
      title: 'Coffee',
    },
    {
      img: 'https://images.unsplash.com/photo-1533827432537-70133748f5c8',
      title: 'Hats',
    },
    {
      img: 'https://images.unsplash.com/photo-1558642452-9d2a7deb7f62',
      title: 'Honey',
    },
    {
      img: 'https://images.unsplash.com/photo-1516802273409-68526ee1bdd6',
      title: 'Basketball',
    },
    {
      img: 'https://images.unsplash.com/photo-1518756131217-31eb79b20e8f',
      title: 'Fern',
    },
    {
      img: 'https://images.unsplash.com/photo-1597645587822-e99fa5d45d25',
      title: 'Mushrooms',
    },
    {
      img: 'https://images.unsplash.com/photo-1567306301408-9b74779a11af',
      title: 'Tomato basil',
    },
    {
      img: 'https://images.unsplash.com/photo-1471357674240-e1a485acb3e1',
      title: 'Sea star',
    },
    {
      img: 'https://images.unsplash.com/photo-1589118949245-7d38baf380d6',
      title: 'Bike',
    },
  ];

  return(
    <Box
      sx= {{
        display: 'flex',
        flexDirection: 'row',
        width: '100vw',
        height: '100vh',
      }}>

            {/* 좌측 Box */}
            <Box
            sx= {{
            display: 'flex',
            width: '20vw',
            height: '100vh',
            }}>
                
            </Box>

            {/* 가운데 Box */}
            <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column', 
                // justifyContent: 'center',
                // alignItems: 'center',
                alignSelf: 'flex-start',
                backgroundColor: 'white',
                width: '100vw', // 컴퓨터 브라우저에서는 60vw
                height: '100vh',
            }}
            >

                {/* 게시물 타이틀 */}
                <Box
                component="form"
                sx={{
                    display: 'flex',
                    // alignItems: 'center',
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
                >
                <h1>내가 찍은 사진</h1>
                </Box>

                {/* 게시글 작성자 닉네임 및 게시 시간 */}
                <Box
                component="form"
                sx={{
                    display: 'flex',
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
                >
                  <h4>쿼카</h4>
                  <Clock format = {'YYYY-MM-DD HH:mm'} ticking = {true} timezone = {'KR/pacific'} />
                </Box>

                {/* 게시물 내용 */}
                <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'column',
                      '& > :not(style)': { m: 1, marginTop: 5},
                  }}
                  noValidate
                  autoComplete="off"
                  >
                  <h4>평소에 사진 찍는 걸 좋아해서 제가 찍은 사진이에요~</h4>
                  <ImageList sx={{ width: 300, height: 300 }} cols={3} rowHeight={120}>
                    {itemData.map((item) => (
                      <ImageListItem key={item.img}>
                        <img
                          src={`${item.img}?w=164&h=164&fit=crop&auto=format`}
                          srcSet={`${item.img}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
                          alt={item.title}
                          loading="lazy"
                        />
                      </ImageListItem>
                    ))}
                  </ImageList>
                  <h4>게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 게시물 내용 채우기용 </h4>
                </Box>

                {/* 하단 작성자 프로필사진, 이름, 설명 */}
                <Box component="form"
                sx={{
                    display: 'flex',
                    flexDirection: 'row',
                    '& > :not(style)': { m: 1, marginTop: 5},
                }}
                noValidate
                autoComplete="off"
                >
                 <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'row',
                      '& > :not(style)': { m: 1},
                  }}
                  noValidate
                  autoComplete="off"
                  >
                  <Stack direction="row" spacing={2}>
                  <Avatar alt="jiwoon-jo" src="" sx={{ width: 70, height: 70 }}/>
                  </Stack>
                 </Box>

                 <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'column',
                      '& > :not(style)': { m: 1},
                  }}
                  noValidate
                  autoComplete="off"
                  >
                  <h3>jwjoo03</h3>
                  <h5>쿼카를 닮은 예비 풀스택 개발자 주지운입니다.</h5>
                 </Box>
               </Box>
              
                {/* 댓글 입력 */}
                <Box
                component="form"
                sx={{
                    display: 'flex',
                    flexDirection: 'row',
                    width: '20vw',
                    '& > :not(style)': { m: 1, marginTop: 5},
                }}
                noValidate
                autoComplete="off"
                >
                  <CustomInput aria-label="Demo input" placeholder="댓글을 입력해주세요" />
                  <Button variant="contained" size="small">등록</Button>
                </Box>

                {/* 게시글 댓글 */}
                <Box component="form"
                sx={{
                    display: 'flex',
                    flexDirection: 'row',
                    '& > :not(style)': { m: 1, marginTop: 5},
                }}
                noValidate
                autoComplete="off"
                >
                 <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'row',
                      '& > :not(style)': { m: 1},
                  }}
                  noValidate
                  autoComplete="off"
                  >
                  <Stack direction="row" spacing={2}>
                  <Avatar alt="younghan" src="" sx={{ width: 70, height: 70 }}/>
                  </Stack>
                 </Box>

                 <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'column',
                      '& > :not(style)': { m: 1},
                  }}
                  noValidate
                  autoComplete="off"
                  >
                  <h3>ezerone&nbsp;&nbsp;&nbsp;&nbsp;2시간 전</h3>
                  <h4>주지운씨 블로그 잘 보고 있습니다!!</h4>
                 </Box>
                </Box>

                <Box component="form"
                  sx={{
                      display: 'flex',
                      flexDirection: 'row',
                      '& > :not(style)': { m: 1 },
                  }}
                  noValidate
                  autoComplete="off"
                >
                <IconButton aria-label="addCircle" color="primary">
                  <AddCircleIcon />  
                </IconButton>
                </Box>

            </Box>


            {/* 우측 Box 및 좋아요 및 공유버튼 */}
            <Box sx={{
            width: '20vw',
            height: '100vh',
            position: 'sticky',
            '& > :not(style)': { m: 1 } }}>
                {/* <Fab aria-label="like">
                <FavoriteIcon />
                </Fab>
                <Fab aria-label="share">
                <ShareIcon />
                </Fab> */}
            </Box>
    </Box>
    
  );
}
