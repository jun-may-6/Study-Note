import React, { useRef, useEffect, useState } from 'react';

function WebEditor() {
  const editorRef = useRef(null);
  
  const [fontSize, setFontSize] = useState('16px');
  const [color, setColor] = useState('#000000');
  const [isTextSelected, setIsTextSelected] = useState(false);
  const [isEditorFocused, setIsEditorFocused] = useState(false);
  const [activeStyles, setActiveStyles] = useState({
    bold: false,
    italic: false,
    underline: false,
  });

  useEffect(() => {
    if (editorRef.current) {
      editorRef.current.focus();
    }
  }, []);

  const applyStyle = (style) => {
    if (!isSelectionInEditor()) return;

    const selection = window.getSelection();
    if (!selection.rangeCount) return;

    const range = selection.getRangeAt(0);
    const span = document.createElement('span');

    switch(style) {
      case 'bold':
        span.style.fontWeight = 'bold';
        break;
      case 'italic':
        span.style.fontStyle = 'italic';
        break;
      case 'underline':
        span.style.textDecoration = 'underline';
        break;
      case 'fontSize':
        span.style.fontSize = fontSize;
        break;
      case 'color':
        span.style.color = color;
        break;
      default:
        break;
    }

    const contents = range.extractContents();
    span.appendChild(contents);
    range.insertNode(span);

    selection.removeAllRanges();
    selection.addRange(range);
    editorRef.current.focus();
  };

  const toggleStyle = (style) => {
    setActiveStyles(prev => ({
      ...prev,
      [style]: !prev[style]
    }));
    editorRef.current.focus();
  };

  const handleStyleButtonClick = (e, style) => {
    e.preventDefault();
    toggleStyle(style);
  };

  const insertTable = () => {
    if (!isSelectionInEditor()) return;

    const table = document.createElement('table');
    table.style.border = '1px solid black';
    table.style.borderCollapse = 'collapse';
    
    const row = table.insertRow();
    const cell = row.insertCell();
    cell.style.border = '1px solid black';
    cell.style.padding = '5px';
    cell.textContent = '내용';

    const selection = window.getSelection();
    if (selection.rangeCount) {
      const range = selection.getRangeAt(0);
      range.insertNode(table);
    }

    editorRef.current.focus();
  };

  const isSelectionInEditor = () => {
    const selection = window.getSelection();
    return selection.rangeCount > 0 && editorRef.current.contains(selection.anchorNode);
  };

  const handleSelectionChange = () => {
    const selection = window.getSelection();
    const isSelected = isSelectionInEditor() && !selection.isCollapsed;
    setIsTextSelected(isSelected);
  };

  const handleEditorFocus = () => {
    setIsEditorFocused(true);
  };

  const handleEditorBlur = () => {
    setIsEditorFocused(false);
  };

  const handleEditorInput = (e) => {
    const selection = window.getSelection();
    if (selection.rangeCount > 0) {
      const range = selection.getRangeAt(0);
      const span = document.createElement('span');
      
      span.style.fontWeight = activeStyles.bold ? 'bold' : 'normal';
      span.style.fontStyle = activeStyles.italic ? 'italic' : 'normal';
      span.style.textDecoration = activeStyles.underline ? 'underline' : 'none';
      span.style.fontSize = fontSize;
      span.style.color = color;

      const contents = range.extractContents();
      span.appendChild(contents);
      range.insertNode(span);

      range.setStartAfter(span);
      range.setEndAfter(span);
      selection.removeAllRanges();
      selection.addRange(range);
    }
  };

  useEffect(() => {
    document.addEventListener('selectionchange', handleSelectionChange);
    return () => {
      document.removeEventListener('selectionchange', handleSelectionChange);
    };
  }, []);

  return (
    <div>
      {isTextSelected && (
        <div>
          <button onClick={() => applyStyle('bold')}>굵게</button>
          <button onClick={() => applyStyle('italic')}>기울임</button>
          <button onClick={() => applyStyle('underline')}>밑줄</button>
          <select value={fontSize} onChange={(e) => setFontSize(e.target.value)}>
            <option value="12px">12px</option>
            <option value="16px">16px</option>
            <option value="20px">20px</option>
            <option value="24px">24px</option>
          </select>
          <button onClick={() => applyStyle('fontSize')}>폰트 크기 적용</button>
          <input 
            type="color" 
            value={color} 
            onChange={(e) => setColor(e.target.value)} 
          />
          <button onClick={() => applyStyle('color')}>색상 적용</button>
          <button onClick={insertTable}>테이블 삽입</button>
        </div>
      )}

      <div 
        onFocus={handleEditorFocus}
        onBlur={handleEditorBlur}
      >
        {isEditorFocused && (
          <div onMouseDown={(e) => e.preventDefault()}>
            <button 
              onMouseDown={(e) => handleStyleButtonClick(e, 'bold')}
              style={{fontWeight: activeStyles.bold ? 'bold' : 'normal'}}
            >
              굵게
            </button>
            <button 
              onMouseDown={(e) => handleStyleButtonClick(e, 'italic')}
              style={{fontStyle: activeStyles.italic ? 'italic' : 'normal'}}
            >
              기울임
            </button>
            <button 
              onMouseDown={(e) => handleStyleButtonClick(e, 'underline')}
              style={{textDecoration: activeStyles.underline ? 'underline' : 'none'}}
            >
              밑줄
            </button>
            <select 
              value={fontSize} 
              onChange={(e) => {
                setFontSize(e.target.value);
                editorRef.current.focus();
              }}
            >
              <option value="12px">12px</option>
              <option value="16px">16px</option>
              <option value="20px">20px</option>
              <option value="24px">24px</option>
            </select>
            <input 
              type="color" 
              value={color} 
              onChange={(e) => {
                setColor(e.target.value);
                editorRef.current.focus();
              }}
            />
          </div>
        )}
        <div
          ref={editorRef}
          contentEditable={true}
          onInput={handleEditorInput}
          style={{ 
            border: '1px solid black', 
            minHeight: '200px', 
            padding: '10px',
            whiteSpace: 'pre-wrap',
            wordBreak: 'break-word'
          }}
        />
      </div>
      <div>
        밖의 영역
      </div>
    </div>
  );
}

export default WebEditor;
