import React, { useState } from 'react';
import axios from 'axios';
import { useDispatch } from 'react-redux'
import { loginUser } from '../components/Login/actions/user_action';
import { useNavigate } from 'react-router-dom'

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function Login() {

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [Email, setEmail] = useState('');
    const [Password, setPassword] = useState('');

    const onSubmitHandler = (event) => {
        event.preventDefault();
    }

    const onEmailHandler = (event) => {
        setEmail(event.target.value);
    }

    const onPasswordHandler = (event) => {
        setPassword(event.target.value);
    }

    let body = {
        email: Email,
        password: Password
    }

    // action의 반환값을 dispatch
    dispatch(loginUser(body))
    .then(response => {
        if(response.payload.loginSuccess) {
           navigate('/main')                // 페이지 이동
        } else{
            alert('Error')
        }
    })

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
            
            <h2>Record:er</h2>

            <Box
            component="form"
            sx={{
                display: 'flex',
                flexDirection: 'column',
                '& > :not(style)': { m: 1, width: '35ch' },
            }}
            noValidate
            autoComplete="off"
            onSubmit={onSubmitHandler}
            >
             <TextField 
             id="outlined-basic"
             label="이메일"
             variant="outlined"
             onChange = {onEmailHandler}
             />  
            <TextField
            id="outlined-password-input"
            label="비밀번호"      
            type="password"
            autoComplete="current-password"
            onChange = {onPasswordHandler}
            />
            </Box>

            <Box
            sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            '& > *': {
                m: 1, width: '35ch'
            },
            }}
            >
            <Button variant="contained">로그인</Button>
            </Box>

            <Box
            sx={{
            display: 'flex',
            flexDirection: 'row',
            alignItems: 'center',
            '& > *': {
                m: 1,
            },
            }}
            >
            <Button variant="text">회원 가입</Button>
            <Button variant="text">비밀번호 찾기</Button>
            </Box>
  </Box>
  );
}