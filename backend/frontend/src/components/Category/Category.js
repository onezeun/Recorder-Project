import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
// import { useParams } from 'react-router-dom';
import {
  createCategory,
  allCategories,
  findCategory,
  updateCategory,
  deleteCategory,
} from '../../redux/actions/category';

import { ListItem, Box, IconButton, Input, FormControl, TextField, InputAdornment, Stack } from '@mui/material';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Tooltip from '@mui/material/Tooltip';
import Settings from '@mui/icons-material/Settings';
import ArrowRight from '@mui/icons-material/ArrowRight';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import AddIcon from '@mui/icons-material/Add';
import CheckIcon from '@mui/icons-material/Check';

export default function Category() {
  const dispatch = useDispatch();
  const [categories, setCategories] = useState([]);
  const [categoryName, setCategoryName] = useState('');
  const { data } = useSelector((state) => state.category);
  const { isLoggedIn } = useSelector((state) => state.auth);
  const [edit, setEdit] = useState(false);
  const { user: currentUser } = useSelector((state) => state.auth);
  const { category: currentCategory } = useSelector((state) => state.category);

  // 조회
  useEffect(() => {
    getCategories();
  }, []);

  function getCategories () {
    dispatch(allCategories(currentUser.userId))
    .then((data) => {
      setCategories(data);
    })
    .catch((error) => {
      console.error(error)
    })
  }

  //추가
  function addCategory (e) {
    const addCategory = () => {
      dispatch(createCategory(currentUser.userId, categoryName))
      .then((response) => {
        console.log(response.data)
        setCategoryName('');
      })
      .catch((error) => {
        console.error(error);
      })
    }
    addCategory();
    console.log('categoryName', categoryName)
    console.log('카테고리 생성')
  }

  function changeCategory (e) {
    e.preventDefault();
    setCategoryName(e.target.value);
  }


  // 수정
  // function putCategory (category_id) {
  //   console.log(category_id)

  //   const putCategory = () => {
  //     dispatch(updateCategory(currentUser.userId, categoryName))
  //     .then((response) => {
  //       setCategories(
  //         categories.map((category) => 
  //           category.category_id === category_id ? { ...category, completed: !category.completed } : category
  //         )
  //       );
  //     })
  //     .catch((error) => {
  //       console.error(error);
  //     })
  //   }
  //   addCategory();
  //   console.log('categoryName', categoryName)
  //   console.log('카테고리 수정')
  // }

  // 삭제
  const removeCategory = () => {
    dispatch(deleteCategory())
    .then(() => {
      getCategories();
    })
    .catch((error) => {
      console.error(error);
    })
  }

  // 저장

  return (
    <Box>
      <ListItem component="div" disablePadding>
        <ListItemButton sx={{ height: 56 }}>
          <ListItemText
            primary="전체보기"
            primaryTypographyProps={{
              fontWeight: 'bold',
              variant: 'button',
            }}
          />
        </ListItemButton>
        {isLoggedIn ? (
          !edit ? (
            <Tooltip title="카테고리 설정">
              <IconButton
                onClick={() => setEdit({ edit: !edit })}
                size="large"
                sx={{
                  '& svg': {
                    transition: '0.2s',
                    transform: 'translateX(0) rotate(0)',
                  },
                  '&:hover, &:focus': {
                    bgcolor: 'unset',
                    '& svg:first-of-type': {
                      transform: 'translateX(-4px) rotate(-20deg)',
                    },
                    '& svg:last-of-type': {
                      right: 0,
                      opacity: 1,
                    },
                  },
                  '&:after': {
                    content: '""',
                    position: 'absolute',
                    height: '80%',
                    display: 'block',
                    left: 0,
                    width: '1px',
                    bgcolor: 'divider',
                  },
                }}
              >
                <Settings />
                <ArrowRight
                  sx={{ position: 'absolute', right: 4, opacity: 0 }}
                />
              </IconButton>
            </Tooltip>
          ) : (
            <Tooltip title="저장">
              <IconButton
                size="large"
                sx={{
                  '&:after': {
                    content: '""',
                    position: 'absolute',
                    height: '80%',
                    display: 'block',
                    left: 0,
                    width: '1px',
                    bgcolor: 'divider',
                  },
                }}
              >
                <CheckIcon />
              </IconButton>
            </Tooltip>
          )
        ) : null}
      </ListItem>
      {isLoggedIn ? (
          !edit ? null : (
            <Stack direction="row" spacing={2} sx={{ px: 0.5, pt: 1 }}>
              <TextField onChange={changeCategory} id="outlined-basic" size="small" label="카테고리 추가" variant="outlined" placeholder="카테고리명을 입력해주세요"/>
              <IconButton onClick={addCategory}><AddIcon/></IconButton>
            </Stack>
          )) : null}
      <List
        sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}
        component="nav"
        aria-labelledby="nested-list-subheader"
      >
        {data &&
          data.map((category) => {
            if (!edit) {
              return (
                <ListItemButton>
                  <ListItemText
                    key={category.category_id}
                    primary={category.categoryName}
                    primaryTypographyProps={{
                      fontWeight: 'midium',
                      variant: 'button',
                    }}
                  />
                </ListItemButton>
              );
            } else {
              return (
                <FormControl sx={{ m: 1, width: '25ch' }} variant="standard">
                  <Input
                    defaultValue={category.categoryName}
                    endAdornment={
                      <InputAdornment position="end">
                        <IconButton>
                          <EditIcon />
                        </IconButton>
                        <IconButton onClick={removeCategory}>
                          <DeleteIcon />
                        </IconButton>
                      </InputAdornment>
                    }
                  />
                </FormControl>
              );
            }
          })}
      </List>
    </Box>
  );
}
