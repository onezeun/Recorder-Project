import React, { useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { useSelector } from "react-redux";
import '../components/Editor/index.css';
import { styled, alpha } from '@mui/material/styles';
import { Box, Stack, Button, Divider, Input, Menu, MenuItem } from '@mui/material';
// EditIcon, ArchiveIcon, FileCopyIcon, MoreHorizIcon
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import { StylesProvider } from '@mui/styles';
import { registerPost } from '../redux/actions/auth';
import { allCategories } from '../redux/actions/category';
import axios from 'axios';

import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

const StyledMenu = styled((props) => (
    <Menu
      elevation={0}
      anchorOrigin={{
        vertical: 'bottom',
        horizontal: 'left',
      }}
      transformOrigin={{
        vertical: 'top',
        horizontal: 'left',
      }}
      {...props}
    />
  ))(({ theme }) => ({
    '& .MuiPaper-root': {
      borderRadius: 6,
      marginTop: theme.spacing(1),
      minWidth: 150,
      color:
        theme.palette.mode === 'light' ? 'rgb(55, 65, 81)' : theme.palette.grey[300],
      boxShadow:
        'rgb(255, 255, 255) 0px 0px 0px 0px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px, rgba(0, 0, 0, 0.1) 0px 10px 15px -3px, rgba(0, 0, 0, 0.05) 0px 4px 6px -2px',
      '& .MuiMenu-list': {
        padding: '4px 0',
      },
      '& .MuiMenuItem-root': {
        '& .MuiSvgIcon-root': {
          fontSize: 18,
          color: theme.palette.text.secondary,
          marginRight: theme.spacing(1.5),
        },
        '&:active': {
          backgroundColor: alpha(
            theme.palette.primary.main,
            theme.palette.action.selectedOpacity,
          ),
        },
      },
    },
  }));

export default function Editor() {
    const [categoryData, setCategoryData] = useState(null);
    const [anchorEl, setAnchorEl] = useState(null);
    const [category, setCategory] = useState('');
    const [successful, setSuccessful] = useState(false);
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const { user: currentUser } = useSelector((state) => state.auth);

    const [categoryId, setCategoryId] = useState('');
    const [categoryName, setCategoryName] = useState('');

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = (event) => {
        // console.log('event', event.target.innerText);
        setCategory(event.target.innerText);
        setAnchorEl(null);
    };

    

    const onRegisterPost = () => {
      setSuccessful(false);
      dispatch(allCategories(currentUser.userId))
      .then(data => {
        setCategoryData(data.data[0].categoryId);
      });

      console.log('category_id', categoryData);

      dispatch(registerPost(currentUser.userId, categoryData, title, content))
        .then(() => {
        setSuccessful(true);
        navigate('/');
      })
        .catch(() => {
        setSuccessful(false);
      });
      

      console.log('currentUser.userId', currentUser.userId);
      // console.log('category_id', categoryId);
      console.log('title', registerPost.title);
      console.log('content', registerPost.content);
    }

    const onTitleHandler = (e) => {
      setTitle(e.target.value);
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
            <Box
                sx={{ 
                    width: '90%',
                    display: 'flex',
                }}
            >
                <Button
                    id="demo-customized-button"
                    aria-controls={open ? 'demo-customized-menu' : undefined}
                    aria-haspopup="true"
                    aria-expanded={open ? 'true' : undefined}
                    variant="outlined"
                    disableElevation
                    onClick={handleClick}
                    endIcon={<KeyboardArrowDownIcon />}
                    sx={{ 
                        width: 150,
                        display: 'flex',
                    }}
                >   
                    {categoryName=='' ? '카테고리' : categoryName}
                </Button>
                <StyledMenu
                    id="demo-customized-menu"
                    MenuListProps={{
                    'aria-labelledby': 'demo-customized-button',
                    }}
                    anchorEl={anchorEl}
                    open={open}
                    onClose={handleClose}
                >
                    <MenuItem onClick={handleClose} disableRipple>
                        파이썬
                    </MenuItem>
                    <MenuItem onClick={handleClose} disableRipple>
                        자바
                    </MenuItem>
                    <MenuItem onClick={handleClose} disableRipple>
                        자바스크립트
                    </MenuItem>
                    <MenuItem onClick={handleClose} disableRipple>
                        리액트
                    </MenuItem>
                </StyledMenu>
            </Box>
            
          <Box
                sx={{ 
                    width: '90%',
                }}
            >
                <Input 
                    placeholder="제목" 
                    sx={{ 
                        width: '100%',
                        px: '10px',
                        fontSize: 'h5.fontSize',
                        fontStyle: 'bold',
                    }}
                    onChange={onTitleHandler} 
                />
            </Box>
            <Box 
                sx={{ 
                    color: 'black',
                    width: '90%',
                }}
            >
                <CKEditor
                    editor={ ClassicEditor }
                    onReady={ editor => {
                        console.log( 'Editor is ready to use!', editor );
                    } }
                    onChange={ 
                      ( event, editor ) => {
                      const data = editor.getData();
                      setContent(data);
                      }
                    }
                    onBlur={ ( event, editor ) => {
                        console.log( 'Blur.', editor );
                    } }
                    onFocus={ ( event, editor ) => {
                        console.log( 'Focus.', editor );
                    } }
                />
            </Box>
            <Divider />
            <Box sx={{
                    display: 'flex',
                    justifyContent: 'flex-end',
                    width: '90%',
                }}>
                <Stack spacing={1} direction="row" >
                    <Button variant="outlined" disableElevation>취소</Button>
                    <Button variant="contained" onClick={onRegisterPost} disableElevation >Record</Button>
                </Stack>
            </Box>

    </Box>
    );
}



  
