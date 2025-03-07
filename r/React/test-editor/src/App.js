import React, { useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import CustomEditor from './ckeditor/build/ckeditor';
import './App.css';
import parse  from 'html-react-parser';

const App = () => {
  const [editorData, setEditorData] = useState('');

  return (
    <div className="editor-container">
      <h2>HTML Editor with CKEditor</h2>
      <CKEditor
        editor={CustomEditor}
        data="<p>Hello from CKEditor 5!</p>"
        onChange={(event, editor) => {
          const data = editor.getData();
          setEditorData(data);
        }}
        config={{
          ckfinder: {
            uploadUrl: '/upload',
          },
          toolbar: [
            'heading', '|', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', 
            'imageUpload', 'insertTable', 'tableColumn', 'tableRow', 'mergeTableCells', 'mediaEmbed', 
            '|', 'undo', 'redo', 'imageResize', 'tableProperties', 'tableCellProperties'
          ],
          image: {
            resizeOptions: [
              {
                name: 'resizeImage:original',
                value: null,
                icon: 'original'
              },
              {
                name: 'resizeImage:50',
                value: '50',
                icon: 'medium'
              },
              {
                name: 'resizeImage:75',
                value: '75',
                icon: 'large'
              }
            ],
            toolbar: [
              'imageStyle:inline', 'imageStyle:block', 'imageStyle:side',
              '|',
              'resizeImage'
            ]
          },
          table: {
            contentToolbar: [ 'tableColumn', 'tableRow', 'mergeTableCells', 'tableProperties', 'tableCellProperties' ]
          }
        }}
      />
      <div className="preview-container">
        <h3>Preview</h3>
        <div className='preview'>{parse(editorData)}</div>
      </div>
    </div>
  );
}

export default App;
