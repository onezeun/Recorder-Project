import React, { useEffect, useState } from 'react';
import { useDispatch } from 'react-redux'
import { loginUser } from '../components/Login/actions/action';

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { FormControlLabel, Checkbox } from '@mui/material';

export default function Login(props) {

    const dispatch = useDispatch();
    const [Email, setEmail] = useState('');
    const [Password, setPassword] = useState('');

    const onSubmitHandler = (e) => {
        e.preventDefault();
        console.log('Email', Email);
        console.log('Password', Password)
    }

    const onEmailHandler = (e) => {
        setEmail(e.target.value);
    }

    const onPasswordHandler = (e) => {
        setPassword(e.target.value);
    }
    
    // let body = {
    //     email: Email,
    //     password: Password
    // }

    // // action의 반환값을 dispatch
    // dispatch(loginUser(body))
    // .then(response => {
    //     if(response.payload.loginSuccess) {
    //         props.history.push('/')                // 페이지 이동
    //     } else{
    //         alert('Error')
    //     }
    // })

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
             autoComplete='email'
             autoFocus
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
            <FormControlLabel
                control={<Checkbox value="remember"
                color="primary" />}
                label="Remember"
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
            <Button variant="contained" type="submit">로그인</Button>
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