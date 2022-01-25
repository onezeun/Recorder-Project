import React from 'react';
// import { useDispatch } from 'react-redux';
// import { Router } from 'react-router-dom';

import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';

export default function SignUp() {

    // const dispatch = useDispatch();

    // const [Email, setEmail] = useState('');
    // const [Password, setPassword] = useState('');
    // const [ConfirmPassword, setConfirmPassword] = useState('');
    // const [NickName, setNickName] = useState('');
    // const [BlogName, setBlogName] = useState('');

    // // handler
    // const onEmailHandler = (e) => {
    //     setEmail(e.currentTarget.value);
    // };

    // const onPasswordHandler = (e) => {
    //     setPassword(e.currentTarget.value);
    // };

    // const onConfirmPasswordHandler = (e) => {
    //     setConfirmPassword(e.currentTarget.value);
    // };

    // const onNickNameHandler = (e) => {
    //     setNickName(e.currentTarget.value);
    // };

    // const onBlogNameHandler = (e) => {
    //     setBlogName(e.currentTarget.value);
    // };

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
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            '& > :not(style)': { m: 1, width: '35ch' },
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
            <TextField
                id="outlined-password-input"
                label="비밀번호 확인"      
                type="password"
                autoComplete="current-password"
                />
            <TextField id="outlined-basic" label="닉네임" variant="outlined" />
            <TextField id="outlined-basic" label="블로그명(영어)" variant="outlined" />
            </Box>

            <Box
            component="form"
            sx={{
            display: 'flex',
            flexDirection: 'row',
            alignItems: 'center',
            '& > :not(style)': { m: 1, width: '20ch' },
            }}
            noValidate
            autoComplete="off"
            >
            <Button variant="contained">회원가입</Button>
            <Button variant="contained">취소</Button>
            </Box>
        </Box>
        // <div>
        //     <form style={{ display: 'flex', flexDirection: 'column' }} onSubmit = {onSubmitHandler}>
        //     <label>이메일</label>
        //     <input type = 'email' value = {Email} onChange = {onEmailHandler} />
        //     <label>비밀번호</label>
        //     <input type = 'password' value = {Password} onChange = {onPasswordHandler} />
        //     <label>비밀번호 확인</label>
        //     <input type = 'password' value = {ConfirmPassword} onChange = {onConfirmPasswordHandler} />
        //     <label>닉네임</label>
        //     <input type = 'text' value = {NickName} onChange = {onNickNameHandler} />
        //     <label>블로그명</label>
        //     <input type = 'text' value = {BlogName} onChange = {onBlogNameHandler} />
        //     <Button varient='contained'>회원 가입</Button>
        //     </form>
        // </div>
    )
}
