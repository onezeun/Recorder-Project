import React, { useState, useEffect } from 'react';
import Clock from 'react-live-clock'

import InputUnstyled from '@mui/base/InputUnstyled';
import { styled } from '@mui/system';
import { Button, Stack, Avatar, Box, ImageList, ImageListItem, IconButton, Typography, getPopoverUtilityClass } from '@mui/material';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import { useSelector, useDispatch } from 'react-redux';
import { getUser } from '../redux/actions/user';
import { getPost } from '../redux/actions/post';
// import Fab from '@mui/material/Fab';
// import FavoriteIcon from '@mui/icons-material/Favorite';
// import ShareIcon from '@mui/icons-material/Share';



export default function Post() {

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
    width: 500px;
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
  
  const { user: currentUser } = useSelector((state) => state.auth);
  const data = useSelector((state) => state.user);
  const datas = useSelector((state) => state.post);
  const [ userData, setUserData ] = useState([]);
  const [ postData, setPostData ] = useState([]);

  const dispatch = useDispatch();

  // 유저 정보 가져오기
  useEffect(() => {
    getUsers();
    getPosts();
  }, []);

  function getUsers() {
    dispatch(getUser(currentUser.userId))
    .then((data) => {
      setUserData(data);
      console.log('data', data);
    })
    .catch((error) => {
      console.error(error);
    })
  }
  console.log('datas.postId', datas.postId);
  console.log('currentUser.userId', currentUser.userId)

  function getPosts() {
    dispatch(getPost(datas.postId))
    .then((datas) => {
      setPostData(datas);
      console.log('datas', datas);
    })
    .catch((error) => {
      console.error(error);
    })
  }

  return(
    <Box
      sx={{
        mt: '20px',
        width: '800px',
        border: '1px solid pink',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}
    >
      {/* 타이틀 */}
      <Typography variant="h4" sx={{ py: '20px' }}>{datas.title}제목 들어갈 것임</Typography>

      {/* 작성자 */}
      <Box sx={{ 
        width: '600px',
        display: 'flex', 
        flexDirection: 'column', 
        p: 0.5, 
        alignItems: 'end' 
        }}
      >
        <Typography >{data.nickname}</Typography>
        {/* 작성시간으로 수정해야함 */}
        <Clock format = {'YYYY-MM-DD HH:mm'} ticking = {true} timezone = {'KR/pacific'} />
      </Box>

      {/* 내용 */}
      <h4>평소에 사진 찍는 걸 좋아해서 제가 찍은 사진이에요~</h4>
      <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FzM3mp%2Fbtrr3oghEUP%2FboYYynkXF9FjhuqxFUSe41%2Fimg.png" width='600px' height='400px' />
      <h4>게시물 내용 채우기용</h4>

      {/* 하단 작성자 프로필사진, 이름, 설명 */}
      <Box 
        sx={{ 
          width: '500px',
          display: 'flex', 
          flexDirection: 'row',
          justifyContent: 'flex-start',
          alignItems: 'center',
        }}
      >
        <Avatar alt="jiwoon-joo" src={data.profilePhoto} sx={{ width: 80, height: 80, mr: '10px' }}/>
        <Stack spacing={1}>
          <Typography variant="h6" >{data.nickname}</Typography>
          <Typography variant="h7" >{data.introduce}</Typography>
        </Stack>
      </Box>

      
      {/* 댓글 입력 */}
      <Stack direction="row" spacing={1} sx={{ my: 3 }}>
        <CustomInput aria-label="Demo input" placeholder="댓글을 입력해주세요" />
        <Button size="small" sx={{ backgroundColor: '#ff5f70', color: 'white', ':hover': { bgcolor: '#ffc0cb'}}}>등록</Button>
      </Stack>

    </Box>
  );   
}