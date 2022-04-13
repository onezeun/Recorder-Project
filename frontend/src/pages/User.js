import React, { useState, useEffect } from "react";
import styled from "styled-components";
import { Stack, Paper, Grid, Avatar, Button, Box, IconButton, Typography, Switch } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import { useSelector, useDispatch } from "react-redux";
import { getUser, updateUser } from "../redux/actions/user";
import { TextField } from "@mui/material";

import axios from 'axios';

const Input = styled("input")({
  display: "none",
});

export default function User() {
  const { user: currentUser } = useSelector((state) => state.auth);
  const data = useSelector((state) => state.user);
  const [ userData, setUserData ] = useState([]);

  const dispatch = useDispatch();

  useEffect(() => {
    getUsers();
  }, []);

  function getUsers() {
    dispatch(getUser(currentUser.userId))
    .then((data) => {
      setUserData(data);
    })
    .catch((error) => {
      console.error(error);
    })
  }

  const [update, setUpdate] = useState(true);
  const [email, setEmail] = useState('');
  const [nickname, setNickname] = useState('');
  const [domain, setDomain] = useState(''); 
  const [introduce, setIntroduce] = useState('');
  let updateNickname, updateIntroduce, updateDomain, updateButton = null;
  
  const onClickUpdate = () => {
      setUpdate(!update);
  }

  const onClickRegister = () => {
      
      dispatch(updateUser(currentUser.userId, email, nickname, domain, introduce))
      .then(() => {
      })
      .catch(() => {  
      })
      setUpdate(!update);
      
      window.location.reload();
  }

  const onNicknameHandler = (e) => {
    setNickname(e.target.value);
  };

  const onIntroduceHandler = (e) => {
    setIntroduce(e.target.value);
  };

  const onDomainHandler = (e) => {
    setDomain(e.target.value);
  };


  if (update) {
    updateNickname = <Typography sx={{ marginLeft: 10.8, p: 0.5 }}>{data.nickname}</Typography>;
    updateIntroduce = <Typography sx={{ marginLeft: 8.3, p: 0.5 }}>{data.introduce}</Typography>
    updateDomain = <Typography sx={{ marginLeft: 5, p: 0.5 }}>{data.domain}</Typography>
    updateButton = <Button size="small" onClick={onClickUpdate}>수정하기</Button>
  } else {
    updateNickname = <TextField sx={{ marginLeft: 10, p: 0.5}} id="outlined-basic" onChange={onNicknameHandler} defaultValue={data.nickname} variant="outlined" />
    updateIntroduce = <TextField sx={{ marginLeft: 7.4, p: 0.5}} id="outlined-basic" onChange={onIntroduceHandler} defaultValue={data.introduce} variant="outlined" />
    updateDomain = <TextField sx={{ marginLeft: 4.2, p: 0.5}} id="outlined-basic" onChange={onDomainHandler} defaultValue={data.domain} variant="outlined" />
    updateButton = <Button size="small" onClick={onClickRegister}>저장하기</Button>
  }
  
  return (
    <Box sx={{ flexGrow: "wrap", overflow: "hidden", px: 3 }}>
      
      {/* MY PAGE, 이미지 관리 */}
      <Paper
        elevation={0}
        sx={{ maxWidth: 800, mx: "auto", pt: 4, pl: 5, pr: 4 }}
      >
      <Paper elevation={0} sx={{ maxWidth: 800, mx: "auto", pt: 4, pl: 5, pr:4 }}>
        <Box sx={{ display: "flex", justifyContent: "center", pb: 5 }}>
          <h2>MY PAGE</h2>
        </Box>
        <Box sx={{ display: "flex", justifyContent: "center", pb: 5 }}>
            <Avatar
              sx={{
                display: "flex",
                alignItems: "center",
                width: "150px",
                height: "150px",
                backgroundColor: "white",
              }}
              alt="Remy Sharp"
              src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
            />
        </Box>
        </Paper>
        <Box sx={{ display: "flex", justifyContent: "center", pb: 5 }}>
        <Stack direction="row" spacing={1} sx={{ ml: 1, mr: 2, my: 1 }}>
          <Input
            accept="image/*"
            id="contained-button-file"
            multiple
            type="file"
          />
          <Button variant="contained" component="span" size="small">
            이미지 변경
          </Button>
          <IconButton aria-label="delete" size="small">
            <DeleteIcon fontSize="inherit" />
          </IconButton>
        </Stack>
        </Box>      
      </Paper>

      {/* 첫 번째 칸 */}
      <Paper
        elevation={2}
        sx={{ maxWidth: 800, my: 1, mx: "auto", mt: 4, p: 2 }}
      >
          <Stack direction="column" sx={{ my: 1, p: 1 }}>

            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold"}}>닉네임</Typography>
              {updateNickname}
            </Stack>

              
            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold" }}>자기소개</Typography>
              {updateIntroduce}
            </Stack>

            
            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold" }}>블로그 주소</Typography>
              {updateDomain}
            </Stack>

            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold" }}>이메일 주소</Typography>
              <Typography sx={{ marginLeft: 5, p: 0.5 }}>{data.email}</Typography>
            </Stack>

            {updateButton}
    
          </Stack>
      </Paper>

      {/* 두 번째 칸 */}
      <Paper
        elevation={2}
        sx={{ maxWidth: 800, my: 1, mx: "auto", mt: 1, p: 2 }}
      >
          <Stack direction="column" sx={{ my: 1, p: 1 }}>

            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold" }}>이웃 관리</Typography>
              <Typography sx={{ marginLeft: 7.5, p: 0.5 }}>3명</Typography>
              <Box sx={{ flexGrow: 1 }} />
            </Stack>

            <Button size="small">이웃 관리</Button>    
          </Stack>
      </Paper>

      {/* 세 번째 칸 */}
      <Paper
        elevation={2}
        sx={{ maxWidth: 800, my: 1, mx: "auto", mt: 1, p: 2 }}
      >
          <Stack direction="column" sx={{ my: 1, p: 1 }}>

            <Stack direction='row' sx={{ my: 1, p: 1}}>
              <Typography variant="h6" sx={{ fontWeight: "bold" }}>회원 탈퇴</Typography>
              <Box sx={{ flexGrow: 1 }} />
            </Stack>

            <Button size="small" color="error">회원 탈퇴</Button>    
          </Stack>
      </Paper>
    </Box>
  );
}