import React from "react";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import './index.css';

const API_URL = "http://localhost:8080/board/posts";

export default function EditorBox ({ UserId, SetContent, SetSummary, Content }) {

    function uploadAdapter(loader) {
        return {
            upload: () => {
                return new Promise((resolve, reject) => {
                    const body = new FormData();
                    loader.file.then((file) => {
                        body.append("postPhoto", file);
                        fetch(`${API_URL}/${UserId}/postPhoto`, {
                            method: "post",
                            body: body
                        })
                        .then((res) => res.json())
                        .then((res) => {
                            resolve({
                                default: `${res.url}`
                            });
                        })
                        .catch((err) => {
                            reject(err);
                        });
                    });
                });
            }
        };
    }

    function uploadPlugin(editor) {
        editor.plugins.get("FileRepository").createUploadAdapter = (loader) => {
            return uploadAdapter(loader);
        };
    }

    return (
        <CKEditor
            config={{
                extraPlugins: [uploadPlugin]
            }}
            editor={ ClassicEditor }
            onReady={ editor => {
                // console.log( 'Editor is ready to use!', editor );
            } }
            data = {Content}
            onChange={ 
                ( event, editor ) => {
                const data = editor.getData();
                let convertContent = data.replace(/<(\/p|p)([^>]*)>/gi, "")
                convertContent = convertContent.replace(/&nbsp;/gi,"");
                SetContent(convertContent);
                SetSummary(convertContent.substring(0, 29));
            } }
            onBlur={ ( event, editor ) => {
                // console.log( 'Blur.', editor );
            } }
            onFocus={ ( event, editor ) => {
                // console.log( 'Focus.', editor );
            } }
        />
    )
}