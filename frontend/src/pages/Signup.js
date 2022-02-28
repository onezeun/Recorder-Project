import React, { useState, useCallback } from "react";
// import { useDispatch } from 'react-redux';
// import { Router } from 'react-router-dom';
import { Box, Button, TextField } from "@mui/material";


export default function SignUp() {
  const [password, setPassword] = useState("");
  const onChangePassword = useCallback((e) => {
    setPassword(e.target.value);
  }, []);

  // 중복체크
  const [rePassword, setRePassword] = useState('');
  const [passwordError, setPasswordError] = useState(false);
  const onChangePasswordCheck = useCallback((e) => {
      setRePassword(e.target.value);
      setPasswordError(e.target.value !== password);
    }, [password]);


  return (
    <Box
      component="form"
      gap={1}
      sx={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        width: "100vw",
        height: "100vh",
        backgroundColor: "white",
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
      >
        <TextField 
          id="email" 
          label="이메일" 
          variant="outlined"
          />

        <TextField
          id="password"
          label="비밀번호"
          type="password"
          autoComplete="current-password"
          value={password}
          onChange={onChangePassword}
        />
        <TextField
          id="rePassword"
          name="rePassword"
          label="비밀번호 확인"
          type="password"
          autoComplete="current-password"
          value={rePassword}
          onChange={onChangePasswordCheck}
          error={password !== rePassword}
          helperText={password !== rePassword ? "비밀번호가 일치하지 않습니다" : ""}
        />
        <TextField 
        id="nickname" 
        label="닉네임" 
        variant="outlined" 
        />
        <TextField
          id="blogname"
          label="블로그명(영어)"
          variant="outlined"
        />
      </Box>

      <Box
        component="form"
        sx={{
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
          "& > :not(style)": { m: 1, width: "20ch" },
        }}
        noValidate
        autoComplete="off"
      >
        <Button variant="contained">회원가입</Button>
        <Button variant="contained">취소</Button>
      </Box>
    </Box>
  );
}
