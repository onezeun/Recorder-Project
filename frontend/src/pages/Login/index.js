import React from 'react';

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';

export default function Login() {
  return (
    <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column', 
                justifyContent: 'center',
                alignItems: 'center',
                width: '100vw',
                height: '100vh',
                backgroundColor: 'white',
            }}
        >
            <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1, width: '40ch' },
            }}
            noValidate
            autoComplete="off"
    >
             <TextField id="outlined-basic" label="이메일" variant="outlined" />  
                <TextField
                id="outlined-password-input"
                label="비밀번호"      
                type="password"
                autoComplete="current-password"
                />
            </Box>

            <Box
            sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            '& > *': {
                m: 1,
            },
            }}
            >
            <ButtonGroup variant="outlined" aria-label="outlined button group">
                <Button>로그인</Button>
                <Button>회원 가입</Button>
                <Button>비밀번호 찾기</Button>
                </ButtonGroup>
            </Box>
  </Box>
  );
}