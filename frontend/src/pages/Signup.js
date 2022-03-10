import React, { useState, useCallback } from "react";
import { useDispatch } from 'react-redux';
import { registerUser } from "../components/Signup/actions/action";

import { Box, Button, TextField } from "@mui/material";

export default function SignUp(props) {

  // const [Password, setPassword] = useState("");
  // const onChangePassword = useCallback((e) => {
  //   setPassword(e.target.value);
  // }, []);

  // // 중복체크
  // const [rePassword, setRePassword] = useState('');
  // const [passwordError, setPasswordError] = useState(false);
  // const onChangePasswordCheck = useCallback((e) => {
  //     setRePassword(e.target.value);
  //     setPasswordError(e.target.value !== Password);
  //   }, [Password]);
  // const [rePassword, setRePassword] = useState("");
  const dispatch = useDispatch();
  const [Email, setEmail] = useState('');
  const [Password, setPassword] = useState('');
  const [rePassword, setRePassword] = useState('');
  const [Nickname, setNickname] = useState('');
  const [Domain, setDomain] = useState('');
  const [Introduce, setIntroduce] = useState('');

  const onSubmitHandler = (e) => {
    e.preventDefault();
    console.log('Email', Email);
    console.log('Password', Password);
    console.log('Nickname', Nickname);
    console.log('Domain', Domain);
    console.log('Introduce', Introduce);

    let body = {
      email: Email,
      password: Password,
      nickname: Nickname,
      domain: Domain,
      introduce: Introduce
    }

    dispatch(registerUser(body))
      .then(response => {
        if(response.payload.signupSuccess) {
            props.history.push('/login')
        } else {
            alert('회원가입 실패')
        }
      })
  }

  const onEmailHandler = (e) => {
      setEmail(e.target.value);
  }

  const onPasswordHandler = (e) => {
      setPassword(e.target.value);
  }

  const onRePasswordHandler = (e) => {
      setRePassword(e.target.value);
  }

  const onNicknameHandler = (e) => {
      setNickname(e.target.value);
  }

  const onDomainHandler = (e) => {
      setDomain(e.target.value);
  }

  const onIntroduceHandler = (e) => {
      setIntroduce(e.target.value);
  }

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
      <h2>회원 가입</h2>
      <Box
        component="form"
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          "& > :not(style)": { m: 1, width: "35ch" },
        }}
        noValidate
        autoComplete="off"
        onSubmit={onSubmitHandler}
      >
        <TextField 
          id="Email" 
          label="이메일" 
          variant="outlined"
          autoComplete="email"
          autoFocus
          onChange={onEmailHandler}
          />
        <TextField
          id="Password"
          label="비밀번호"
          type="password"
          autoComplete="current-password"
          value={Password}
          onChange={onPasswordHandler}
        />
        <TextField
          id="rePassword"
          name="rePassword"
          label="비밀번호 확인"
          type="password"
          autoComplete="current-password"
          value={rePassword}
          onChange={onRePasswordHandler}
          error={Password !== rePassword}
          helperText={Password !== rePassword ? "비밀번호가 일치하지 않습니다" : ""}
        />
        <TextField 
          id="Nickname" 
          label="닉네임" 
          variant="outlined" 
          onChange={onNicknameHandler}
        />
        <TextField
          id="Domain"
          label="블로그명(영어)"
          variant="outlined"
          onChange={onDomainHandler}
        />
        <TextField
          id="Introduce"
          label="소개 글을 작성해주세요"
          variant="outlined"
          onChange={onIntroduceHandler}
        />
        
      <Box
        sx={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          "& > :not(style)": { m: 1, width: "20ch" },
        }}
      >
        <Button variant="contained" type="submit">회원가입</Button>
        <Button variant="contained">취소</Button>
      </Box>

      </Box>
    </Box>
  );
}