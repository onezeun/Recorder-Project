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
import CategoryService from '../../services/category.service';

import { ListItem, Box, IconButton, Input, Stack, FormControl, InputLabel, InputAdornment } from '@mui/material';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Tooltip from '@mui/material/Tooltip';
import Settings from '@mui/icons-material/Settings';
import ArrowRight from '@mui/icons-material/ArrowRight';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import AddIcon from '@mui/icons-material/Add';

export default function Category({ onChangeCategory }) {
  const dispatch = useDispatch();
  const { data } = useSelector((state) => state.category);
  const { isLoggedIn } = useSelector((state) => state.auth);
  const [edit, setEdit] = useState(false);
  const [category, setCategory] = useState([]);
  const [submitted, setSubmitted] = useState(false);


  useEffect(() => {
    dispatch(allCategories());
  }, []);

  //추가
  const saveCategory = () => {
    const { user_id, categoryName } = category;
    dispatch(createCategory(user_id, categoryName))
      .then(data => {
        setCategory({
          user_id: data.user_id,
          categoryName: data.categoryName,
          published: data.published
        });
        setSubmitted(true);

        console.log(data);
      })
      .catch(e => {
        console.log(e);
      });
  };

  return (
    <Box>
      <ListItem component="div" disablePadding>
        <ListItemButton sx={{ height: 56 }} onClick={allCategories}>
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
            <Tooltip title="카테고리 수정">
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
                <EditIcon />
              </IconButton>
            </Tooltip>
          )
        ) : null}
      </ListItem>
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
                  <InputLabel htmlFor="categoryname">
                    카테고리명
                  </InputLabel>
                  <Input
                    endAdornment={
                      <InputAdornment position="end">
                        <IconButton onClick={saveCategory}>
                          <AddIcon />
                        </IconButton>
                        <IconButton>
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
