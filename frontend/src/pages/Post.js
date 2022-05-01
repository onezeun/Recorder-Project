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
            width: '40vw',
            height: '100vh',
            }}>
                
            </Box>

            {/* 가운데 Box */}
            <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column',
                backgroundColor: 'white',
                width: '100vw', // 컴퓨터 브라우저에서는 60vw
                height: '100vh',
            }}
            >

            <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
            >
                {/* 게시물 타이틀 */}
                <Box
                component="form"
                sx={{
                    display: 'flex',
                    alignItems: 'center',
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
                >
                <Typography variant="h4" sx={{ marginLeft: 10.8, p: 0.5 }}>{datas.title}제목 들어갈 것임</Typography>
                </Box>
            </Box>

            <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'flex-end',
            }}
            >
              
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
                  <Typography sx={{ marginLeft: 10.8, p: 0.5 }}>{data.nickname}</Typography>
                  {/* <Clock format = {'YYYY-MM-DD HH:mm'} ticking = {true} timezone = {'KR/pacific'} /> */}
                </Box>

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
                  <h4>게시물 내용 채우기용</h4>
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
                  <Avatar alt="jiwoon-jo" src={data.profilePhoto} sx={{ width: 70, height: 70 }}/>
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

                  <Typography variant="h6" sx={{ marginLeft: 10.8 }}>{data.nickname}</Typography>
                  <Typography sx={{ marginLeft: 10.8 }}>{data.introduce}</Typography>
                  
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
                {/* <Box component="form"
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
                <Button variant="text">댓글 더보기</Button>
                </Box> */}

            </Box>


            {/* 우측 Box 및 좋아요 및 공유버튼 */}
            <Box sx={{
            width: '40vw',
            height: '100vh',
            position: 'sticky',
            '& > :not(style)': { m: 1 } }}>
            </Box>
    </Box>
    
  );
}
