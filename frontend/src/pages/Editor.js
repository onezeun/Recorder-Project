import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import "../components/Editor/index.css";
import { styled, alpha } from "@mui/material/styles";
import { Box, Stack, Button, Divider, TextField, Menu, MenuItem } from "@mui/material";
import { withStyles } from '@material-ui/core/styles';
// EditIcon, ArchiveIcon, FileCopyIcon, MoreHorizIcon
import KeyboardArrowDownIcon from "@mui/icons-material/KeyboardArrowDown";
import { StylesProvider } from "@mui/styles";
import { registerPost } from "../redux/actions/auth";
import { allCategories } from "../redux/actions/category";
import axios from "axios";

import EditorBox from "../components/Editor/EditorBox";
import parse from "html-react-parser";

const StyledMenu = styled((props) => (
  <Menu
    elevation={0}
    anchorOrigin={{
      vertical: "bottom",
      horizontal: "left",
    }}
    transformOrigin={{
      vertical: "top",
      horizontal: "left",
    }}
    {...props}
  />
))(({ theme }) => ({
  "& .MuiPaper-root": {
    borderRadius: 6,
    marginTop: theme.spacing(1),
    minWidth: 150,
    color:
      theme.palette.mode === "light"
        ? "rgb(55, 65, 81)"
        : theme.palette.grey[300],
    boxShadow:
      "rgb(255, 255, 255) 0px 0px 0px 0px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px, rgba(0, 0, 0, 0.1) 0px 10px 15px -3px, rgba(0, 0, 0, 0.05) 0px 4px 6px -2px",
    "& .MuiMenu-list": {
      padding: "4px 0",
    },
    "& .MuiMenuItem-root": {
      "& .MuiSvgIcon-root": {
        fontSize: 18,
        color: theme.palette.text.secondary,
        marginRight: theme.spacing(1.5),
      },
      "&:active": {
        backgroundColor: alpha(
          theme.palette.primary.main,
          theme.palette.action.selectedOpacity
        ),
      },
    },
  },
}));

const CategoryButton = styled(Button)`
  background: white;
  border: solid 1px;
  color: #ff5f70;
`;

const RecordButton = styled(Button)`
  background: #ff5f70;
  color: white;
`;

const CancleButton = styled(Button)`
  background: white;
  border: solid 1px;
  color: #ff5f70;
`;

const TitleInput = withStyles({
  root: {
    '& .MuiInput-underline:after': {
      borderBottomColor: '#ff5f70',
    },
  },})(TextField);

export default function Editor() {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [anchorEl, setAnchorEl] = useState(null);
  const [successful, setSuccessful] = useState(false);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [summary, setSummary] = useState("");

  const { user: currentUser } = useSelector((state) => state.auth);
  const [ categoryList, setCategoryList ] = useState([]);

  const [disabled, setDisabled] = useState(false);
  const { categoryId } = useParams();

  // 카테고리 조회
  useEffect(() => {
    getCategories();
  }, []);


  const getCategories = () => {
    axios
      .get("http://localhost:8080/board/categories/users/" + `${currentUser.userId}`)
      .then((res) => {
        setCategoryList(res.data.data)
        console.log("categoryList", categoryList)
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const open = Boolean(anchorEl);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = (event) => {
    // console.log('event', event.target.innerText);
    // setCategory(event.target.innerText);
    setAnchorEl(null);
  };

  const onRegisterPost = (e) => {
    setDisabled(true);

    e.preventDefault();

    setSuccessful(false);

    dispatch(registerPost(currentUser.userId, 3, title, content, summary))
      .then((res) => {
        console.log("success", res);
        setSuccessful(true);
        navigate("/");
      })
      .catch((err) => {
        console.log("error", err);
        setSuccessful(false);
        setDisabled(false);
      });
  };

  const onTitleHandler = (e) => {
    // console.log('title', e.target.value);
    setTitle(e.target.value);
  };

  // 취소 버튼
  const onClickCancleButton = () => {
    navigate(-1);
  };

  return (
    <Box
      sx={{
        width: "700px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <Box
        sx={{
          display: "flex",
          alignItems: "left",
          mt: "10px",
        }}
      >
        <CategoryButton
          id="demo-customized-button"
          aria-controls={open ? "demo-customized-menu" : undefined}
          aria-haspopup="true"
          aria-expanded={open ? "true" : undefined}
          disableElevation
          onClick={handleClick}
          endIcon={<KeyboardArrowDownIcon />}
          sx={{
            width: "150px",
            height: "40px",
          }}
        >
          {/* {categoryList.categoryName == null ? "카테고리" : categoryList.categoryName} */}
        카테고리
        </CategoryButton>
        <StyledMenu
          id="demo-customized-menu"
          MenuListProps={{
            "aria-labelledby": "demo-customized-button",
          }}
          anchorEl={anchorEl}
          open={open}
          onClose={handleClose}
        >
          {categoryList &&
            categoryList.map((category) => (
              <MenuItem onClick={handleClose} disableRipple key={category.id}>
                {category.categoryName}
              </MenuItem>
            ))}
        </StyledMenu>
      </Box>

      <TitleInput
        hiddenLabel
        variant="standard"
        placeholder="제목"
        sx={{
          width: "93%",
          px: "10px",
          my: "10px",
          fontStyle: "bold"
        }}
        onChange={onTitleHandler}
        InputProps={{ style: { fontSize: 26 } }}
      />
      <EditorBox
        UserId={currentUser.userId}
        SetContent={setContent}
        SetSummary={setSummary}
      />
      <Box
        sx={{
          display: "flex",
          justifyContent: "flex-end",
          width: "90%",
          mt: "10px",
        }}
      >
        <Stack spacing={1} direction="row">
          <CancleButton onClick={onClickCancleButton} disableElevation>
            취소
          </CancleButton>
          <RecordButton
            onClick={onRegisterPost}
            disableElevation
            disabled={disabled}
          >
            Record
          </RecordButton>
        </Stack>
      </Box>
    </Box>
  );
}
