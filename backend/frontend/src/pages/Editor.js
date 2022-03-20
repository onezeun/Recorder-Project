// import React, { useState, useEffect } from 'react';
// import { useDispatch } from 'react-redux';
// import { useNavigate } from 'react-router-dom';
// import { registerPost } from '../components/Editor/actions/action';
// import '../components/Editor/index.css';
// import { styled, alpha } from '@mui/material/styles';
// import { Box, Stack, Button, Divider, Input, Menu, MenuItem } from '@mui/material';
// // EditIcon, ArchiveIcon, FileCopyIcon, MoreHorizIcon
// import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
// import { StylesProvider } from '@mui/styles';
// import ReactHtmlParser from 'react-html-parser';
// import axios from 'axios';

// import { CKEditor } from '@ckeditor/ckeditor5-react';
// import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

// const StyledMenu = styled((props) => (
//     <Menu
//       elevation={0}
//       anchorOrigin={{
//         vertical: 'bottom',
//         horizontal: 'left',
//       }}
//       transformOrigin={{
//         vertical: 'top',
//         horizontal: 'left',
//       }}
//       {...props}
//     />
//   ))(({ theme }) => ({
//     '& .MuiPaper-root': {
//       borderRadius: 6,
//       marginTop: theme.spacing(1),
//       minWidth: 150,
//       color:
//         theme.palette.mode === 'light' ? 'rgb(55, 65, 81)' : theme.palette.grey[300],
//       boxShadow:
//         'rgb(255, 255, 255) 0px 0px 0px 0px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px, rgba(0, 0, 0, 0.1) 0px 10px 15px -3px, rgba(0, 0, 0, 0.05) 0px 4px 6px -2px',
//       '& .MuiMenu-list': {
//         padding: '4px 0',
//       },
//       '& .MuiMenuItem-root': {
//         '& .MuiSvgIcon-root': {
//           fontSize: 18,
//           color: theme.palette.text.secondary,
//           marginRight: theme.spacing(1.5),
//         },
//         '&:active': {
//           backgroundColor: alpha(
//             theme.palette.primary.main,
//             theme.palette.action.selectedOpacity,
//           ),
//         },
//       },
//     },
//   }));

// export default function Editor() {
//     const [anchorEl, setAnchorEl] = useState(null);
//     const [category, setCategory] = useState('');
//     const open = Boolean(anchorEl);
//     const handleClick = (event) => {
//         setAnchorEl(event.currentTarget);
//     };
//     const handleClose = (event) => {
//         // console.log('event', event.target.innerText);
//         setCategory(event.target.innerText);
//         setAnchorEl(null);
//     };

//     // const dispatch = useDispatch();
//     // const navigate = useNavigate();
//     // const [Title, setTitle] = useState('');
//     // const [Content, setContent] = useState('');

//     // const onSubmitHandler = (e) => {
//     //     e.preventDefault();
//     //     console.log('title', Title);
//     //     console.log('content', Content);
    
//     // const onTitleHandler = (e) => {
//     //     setTitle(e.target.value);
//     // }

//     // const onContentHandler = (e) => {
//     //     setContent(e.target.value);
//     // }

//     const [posts, setPosts] = useState({
//         title: '',
//         content: ''
//     })

//     const [viewPosts, setViewPosts] = useState([]);

//     useEffect(() => {
//         axios.get('/board/posts/{post_id}')
//         .then((response) => {
//             setViewPosts(response.data);
//         })
//     }, [viewPosts])


//     const submitRegister = () => {
//         axios.post('/board/posts', {
//             title: posts.title,
//             content: posts.content
//         })
//         .then(() => {
//             alert('게시글이 등록되었습니다!');
            
//         console.log('title', posts.title)
//         console.log('content', posts.content)
//         })
//     };

//     const getValue = e => {
//         const { name, value } = e.target;
//         setViewPosts({
//             ...posts,
//             [name]: value
//         })
//     };

//     return (
//         <Box 
//         gap={1}
//         sx={{ 
//         display: 'flex',
//         flexDirection: 'column', 
//         justifyContent: 'center',
//         alignItems: 'center',
//         width: '100vw',
//         height: '100vh',
//         backgroundColor: 'white',
//         }}
//         >
//             <Box
//                 sx={{ 
//                     width: '90%',
//                     display: 'flex',
//                 }}
//             >
//                 <Button
//                     id="demo-customized-button"
//                     aria-controls={open ? 'demo-customized-menu' : undefined}
//                     aria-haspopup="true"
//                     aria-expanded={open ? 'true' : undefined}
//                     variant="outlined"
//                     disableElevation
//                     onClick={handleClick}
//                     endIcon={<KeyboardArrowDownIcon />}
//                     sx={{ 
//                         width: 150,
//                         display: 'flex',
//                     }}
//                 >   
//                     {category=='' ? '카테고리' : category}
//                 </Button>
//                 <StyledMenu
//                     id="demo-customized-menu"
//                     MenuListProps={{
//                     'aria-labelledby': 'demo-customized-button',
//                     }}
//                     anchorEl={anchorEl}
//                     open={open}
//                     onClose={handleClose}
//                 >
//                     <MenuItem onClick={handleClose} disableRipple>
//                         파이썬
//                     </MenuItem>
//                     <MenuItem onClick={handleClose} disableRipple>
//                         자바
//                     </MenuItem>
//                     <MenuItem onClick={handleClose} disableRipple>
//                         자바스크립트
//                     </MenuItem>
//                     <MenuItem onClick={handleClose} disableRipple>
//                         리액트
//                     </MenuItem>
//                 </StyledMenu>
//             </Box>
            
//           <Box
//                 sx={{ 
//                     width: '90%',
//                 }}
//             >
//                 <Input 
//                     placeholder="제목" 
//                     sx={{ 
//                         width: '100%',
//                         px: '10px',
//                         fontSize: 'h5.fontSize',
//                         fontStyle: 'bold',
//                     }}
//                     onChange={getValue}
//                     // onChange={onTitleHandler}  
//                 />
//             </Box>
//             <Box 
//                 sx={{ 
//                     color: 'black',
//                     width: '90%',
//                 }}
//             >
//                 <CKEditor
//                     editor={ ClassicEditor }
//                     onReady={ editor => {
//                         console.log( 'Editor is ready to use!', editor );
//                     } }
//                     onChange={ 
//                         ( event, editor ) => {
//                         const data = editor.getData();
//                         console.log( { event, editor, data } );
//                         setPosts({
//                             ...posts,
//                             content: data
//                         }) }
//                      }
//                     onBlur={ ( event, editor ) => {
//                         console.log( 'Blur.', editor );
//                     } }
//                     onFocus={ ( event, editor ) => {
//                         console.log( 'Focus.', editor );
//                     } }
//                 />
//             </Box>
//             <Divider />
//             <Box sx={{
//                     display: 'flex',
//                     justifyContent: 'flex-end',
//                     width: '90%',
//                 }}>
//                 <Stack spacing={1} direction="row" >
//                     <Button variant="outlined" disableElevation>임시저장</Button>
//                     <Button variant="contained" onClick={submitRegister} disableElevation >Record</Button>
//                 </Stack>
//             </Box>

//             <Box>
//                 {viewPosts.map(element =>
//                     <Box>
//                         <h2>{element.title}</h2>
//                         <Box>
//                             {ReactHtmlParser(element.content)}
//                         </Box>
//                     </Box>)}
//             </Box> 
//     </Box>
//     );
// }

// import React, { useState } from 'react';
// import { CKEditor } from '@ckeditor/ckeditor5-react';
// import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
// import ReactHtmlParser from 'react-html-parser';

// export default function Editor() {
//     const [addData, setVal] = useState('');
//     const [addedData, showData ] = useState(0);
//     const handleChange = (e, editor) => {
//         const data = editor.getData();
//         setVal(data);
//     }

//     return (
//         <div className="Editor">
//             <h2>
//                 <u>ckeditor5 with React.js</u>
//             </h2>
//             <div style = {{width:'700px', display: 'inline-block', textAlign: 'left'}}>
//                 <div style={{width:'700px', display: 'inline-block', textAlign: 'right', marginBottom: '5px'}}>
//                     <button style={{backgroundColor:'black', color:'white'}} onClick={()=>showData(!addedData)}>{addedData ? 'Hide Data' : 'Show Data'}</button>
//                 </div>
//                 <CKEditor editor={ClassicEditor} data={addData} onChnage={(e, editor) => { handleChange(e, editor) }} />
//                 <div>
//                     {addData}
//                 </div>
//             </div>
//         </div>
//     );
// }

// import React, { useState } from 'react';
// import { CKEditor } from '@ckeditor/ckeditor5-react';
// import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
// import ReactHtmlParser, { processNodes, convertNodeToElement, htmlparser2 } from 'react-html-parser';

// export default function Editor() {
//     const [data, setData] = useState('');

//     const handleChange = (e, editor) => {
//         setData(ReactHtmlParser(editor.getData()));
//     }
//     return (
//         <div>
//             <CKEditor
//                 editor={ClassicEditor}
//                 onChange={handleChange} />
//             <div>
//                 {data}
//             </div>
//         </div>
//     )
// }

import { useState, useEffect } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import ReactHtmlParser from 'react-html-parser';
import Axios from 'axios';

export default function Editor() {
  const [Posts, setPosts] = useState({
    title: '',
    content: ''
  })

  const [viewContent, setViewContent] = useState([]);

  useEffect(()=>{
    Axios.get('http://localhost:8080/board/posts/{post_id}').then((response)=>{
      setViewContent(response.data);
    })
  },[viewContent])

  const submitReview = ()=>{
    Axios.post('http://localhost:8080/board/posts', {
      title: Posts.title,
      content: Posts.content
    }).then(()=>{
      alert('등록 완료!');
    })
  };

  const getValue = e => {
    const { name, value } = e.target;
    setPosts({
      ...Posts,
      [name]: value
    })
  };


  return (
    <div className="App">
      <h1>Post Register</h1>
      <div className='movie-container'>
        {viewContent.map(element =>
          <div style={{ border: '1px solid #333' }}>
            <h2>{element.title}</h2>
            <div>
              {ReactHtmlParser(element.content)}
            </div>
          </div>
        )}
      </div>
      <div className='form-wrapper'>
        <input className="title-input"
          type='text'
          placeholder='제목'
          onChange={getValue}
          name='title'
        />
        <CKEditor
          editor={ClassicEditor}
          data="<p>Hello from CKEditor 5!</p>"
          onReady={editor => {
            // You can store the "editor" and use when it is needed.
            console.log('Editor is ready to use!', editor);
          }}
          onChange={(event, editor) => {
            const data = editor.getData();
            console.log({ event, editor, data });
            setPosts({
              ...Posts,
              content: data
            })
          }}
          onBlur={(event, editor) => {
            console.log('Blur.', editor);
          }}
          onFocus={(event, editor) => {
            console.log('Focus.', editor);
          }}
        />
      </div>
      <button
        className="submit-button"
        onClick={submitReview}
        >입력</button>
    </div>
  );
}
