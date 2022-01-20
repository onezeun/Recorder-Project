import React from 'react';

import styled from 'styled-components';

import { StylesProvider } from '@mui/styles';
import Box from '@mui/material/Box';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Divider from '@mui/material/Divider';

import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

export default function EditorPage() {
    return (
        <Box 
            gap={1}
            sx={{ 
                display: 'flex',
                flexDirection: 'column', 
                alignItems: 'center',
                width: '100%',
                height: '100%',
                backgroundColor: 'white',
            }}
        >
            <Box 
                sx={{ 
                    color: 'black',
                    width: '90%',
                    // height: '60%',
                }}
            >
                <CKEditor
                    editor={ ClassicEditor }
                    data="<p>안녕하세요</p>"
                    onReady={ editor => {
                        // You can store the "editor" and use when it is needed.
                        console.log( 'Editor is ready to use!', editor );
                    } }
                    onChange={ ( event, editor ) => {
                        const data = editor.getData();
                        console.log( { event, editor, data } );
                    } }
                    onBlur={ ( event, editor ) => {
                        console.log( 'Blur.', editor );
                    } }
                    onFocus={ ( event, editor ) => {
                        console.log( 'Focus.', editor );
                    } }
                />
            </Box>
            <Divider sx={{color: 'black'}}/>
            <Box sx={{
                    display: 'flex',
                    justifyContent: 'flex-end',
                    width: '90%',
                    // height: '10%',
                    mb: 2,
                }}>
                <Stack spacing={1} direction="row">
                    <Button variant="outlined" disableElevation>임시저장</Button>
                    <Button variant="contained" disableElevation>Record!</Button>
                </Stack>
            </Box>
        </Box>
    );
}