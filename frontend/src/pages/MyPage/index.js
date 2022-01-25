import React from 'react';
import styled from 'styled-components';
import { Stack, Paper, Grid, Avatar, Button, Box, IconButton, Typography, Switch } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';


const Input = styled('input')({
  display: 'none',
});

const label = { inputProps: { 'aria-label': 'Switch demo' } };

export default function MyPage() {
  return (

    <Box sx={{ flexGrow: 'wrap', overflow: 'hidden', px: 3 }}>
      <Paper elevation={0} sx={{ maxWidth: 800, mx: 'auto', pt: 4, pl:5 }}>
      <Box sx={{display: 'flex',
                justifyContent: 'center',
                pb:5
                }}>
      <h2>MY PAGE</h2>
      </Box>
        <Grid container wrap="nowrap" spacing={2}>
          <Grid item>
            <Avatar
              sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                alignItems: 'center',
                width: '150px',
                height: '150px',
                backgroundColor: 'white',
              }}
              alt="Remy Sharp"
              src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png'
            />
          </Grid>
          <Box sx={{ my: 4, mx: 4 }}>
            <Typography variant="h4" component="div" sx={{ fontWeight: 'bold', mx: 4 }}>
              닉네임
            </Typography>
            <Typography variant="h6" component="div" sx={{ my: 2, mx: 4.5 }}>
              한줄자기소개
            </Typography>
          </Box>
        </Grid>
        <Stack direction='row' spacing={1} sx={{ ml:1, mr: 2, my:1 }}>
          <Input accept="image/*" id="contained-button-file" multiple type="file" />
          <Button variant="contained" component="span" size="small">
            이미지 업로드
          </Button>
          <IconButton aria-label="delete" size="small">
            <DeleteIcon fontSize="inherit" />
          </IconButton>
        </Stack>
      </Paper>
      <Paper elevation={2} sx={{ maxWidth: 800, my: 1, mx: 'auto', mt:4, p: 2 }}>
        <Stack direction="row" spacing={2} sx={{ my: 1, p: 2 }}>
          <Typography variant="h6" sx={{ fontWeight: 'bold' }}>운영중인 블로그</Typography>
          <Typography sx={{ my: 1, p: 1 }} >블로그명</Typography>
          <Box sx={{ flexGrow: 1 }} />
          <Button size="small">수정</Button>
        </Stack>
      </Paper>
      <Paper elevation={2} sx={{ maxWidth: 800, my: 1, mx: 'auto', px: 2, pt: 2 }}>
        <Stack direction="row" spacing={2} sx={{ my: 1, px: 2, pt: 2 }}>
          <Typography variant="h6" component="div" sx={{ fontWeight: 'bold' }}>이메일</Typography>
          <Stack direction="column" spacing={2}>
            <Typography variant="h6" sx={{ fontWeight: 'bold' }}>주소</Typography>
            <Typography variant="h6" sx={{ fontWeight: 'bold' }}>수신설정</Typography>
          </Stack>
          <Stack direction="column" spacing={3} sx={{ p: 1 }}>
            <Typography variant="body1">메일주소</Typography>
            <Typography variant="body1">댓글알림</Typography>
            <Typography variant="body1">서비스 관련 소식 및 마케팅 메일</Typography>
          </Stack>
          <Box sx={{ justifyContent: 'flex-end' }}>
            <Stack direction="column" spacing={1} sx={{ my: 6 }}>
              <Switch {...label} />
              <Switch {...label} />
            </Stack>
          </Box>
        </Stack>
      </Paper>
      <Paper elevation={2} sx={{ maxWidth: 800, my: 1, mx: 'auto', p: 2 }}>
        <Stack direction="row" spacing={2} sx={{ my: 1, p: 2 }}>
          <Typography variant="h6" component="div" sx={{ fontWeight: 'bold' }}>이웃관리</Typography>
          <Typography variant="body1" component="div" sx={{ p: 1 }}>현재 n명과 이웃입니다</Typography>
          <Box sx={{ flexGrow: 1 }} />
          <Button size="small">이웃관리</Button>
        </Stack>
      </Paper>
      <Paper elevation={2} sx={{ maxWidth: 800, my: 1, mx: 'auto', p: 2 }}>
        <Stack direction="row" spacing={2} sx={{ my: 1, p: 2 }}>
          <Typography variant="h6" component="div" sx={{ fontWeight: 'bold' }}>회원탈퇴</Typography>
          <Box sx={{ flexGrow: 1 }} />
          <Button size="small" color="error">회원탈퇴</Button>
        </Stack>
      </Paper>
    </Box>
  );
}