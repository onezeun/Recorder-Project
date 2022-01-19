import React from 'react'
import { useDispatch } from 'react-redux'
import { Router } from 'react-router-dom';

function SignUp(props) {

    const dispatch = useDispatch();

    const [Email, setEmail] = useState('');
    const [Password, setPassword] = useState('');
    const [ConfirmPassword, setConfirmPassword] = useState('');
    const [NickName, setNickName] = useState('');
    const [BlogName, setBlogName] = useState('');

    // handler
    const onEmailHandler = (e) => {
        setEmail(e.currentTarget.value);
    };

    const onPasswordHandler = (e) => {
        setPassword(e.currentTarget.value);
    };

    const onConfirmPasswordHandler = (e) => {
        setConfirmPassword(e.currentTarget.value);
    };

    const onNickNameHandler = (e) => {
        setNickName(e.currentTarget.value);
    };

    const onBlogNameHandler = (e) => {
        setBlogName(e.currentTarget.value);
    };

    return (
        <div>
            <input type = 'email' value = {Email} onChange = {onEmailHandler} />
            <input type = 'password' value = {Password} onChange = {onPasswordHandler} />
            <input type = 'password' value = {ConfirmPassword} onChange = {onConfirmPasswordHandler} />
            <input type = 'text' value = {NickName} onChange = {onNickNameHandler} />
            <input type = 'text' value = {BlogName} onChange = {onBlogNameHandler} />
        </div>
    )
}

export default SignUp
