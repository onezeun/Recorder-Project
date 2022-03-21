import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Navigate, useNavigate } from 'react-router-dom';
import { login } from '../redux/actions/auth';

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { FormControlLabel, Checkbox } from '@mui/material';

export default function Login(props) {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const { isLoggedIn } = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  useEffect(()=>{
    console.log(isLoggedIn);
  }, [isLoggedIn]);
  
  
  const onSubmitHandler = (e) => {
    e.preventDefault();
    console.log('email', email);
    console.log('password', password);
    
    dispatch(login(email, password))
    .then(() => {
      console.log('isLogin', isLoggedIn);
      navigate('/');
      // window.location.reload();
    })
    .catch(() => {
      setLoading(false);
    });
  };
  
  const onEmailHandler = (e) => {
    setEmail(e.target.value);
  };
  
  const onPasswordHandler = (e) => {
    setPassword(e.target.value);
  };
  
  
  if (isLoggedIn) {
    return <Navigate to="/" replace={true} />
  } else{
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
          component='form'
          sx={{
            display: 'flex',
            flexDirection: 'column',
            '& > :not(style)': { m: 1, width: '35ch' },
          }}
          noValidate
          autoComplete='off'
          onSubmit={onSubmitHandler}
        >
          <TextField
            id='outlined-basic'
            label='이메일'
            variant='outlined'
            autoComplete='email'
            autoFocus
            onChange={onEmailHandler}
          />
          <TextField
            id='outlined-password-input'
            label='비밀번호'
            type='password'
            autoComplete='current-password'
            onChange={onPasswordHandler}
          />
  
          {/* 로그인 정보 기억 */}
          <Box
            sx={{
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              '& > *': {
                m: 1,
                width: '35ch',
              },
            }}
          >
            <FormControlLabel
              control={<Checkbox value='로그인 정보 기억하기' color='primary' />}
              label='Remember'
            />
          </Box>
  
          {/* 로그인 버튼 */}
          <Box
            sx={{
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              '& > *': {
                m: 1,
                width: '35ch',
              },
            }}
          >
            <Button variant='contained' type='submit'>
              로그인
            </Button>
          </Box>
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
          <Button variant='text'>회원 가입</Button>
          <Button variant='text'>비밀번호 찾기</Button>
        </Box>
      </Box>
    );
  }
}
