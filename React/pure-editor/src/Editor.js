import React, { useRef, useState, useEffect } from 'react';

const Editor = () => {
    const editorRef = useRef(null);
    const [tableBeingDragged, setTableBeingDragged] = useState(null);
    const [tableBeingResized, setTableBeingResized] = useState(null);
    const [startPos, setStartPos] = useState({ x: 0, y: 0 });

    const execCommand = (command, value = null) => {
        console.log(command)
        document.execCommand(command, false, value);
    };

    const insertTable = () => {
        const table = document.createElement('table');
        table.innerHTML = `<tr><td>Cell 1</td><td>Cell 2</td></tr>`;
        table.style.width = '100px';
        table.style.height = '50px';
        table.style.position = 'relative';
        table.draggable = true;

        // 드래그 핸들 추가
        const dragHandle = document.createElement('div');
        dragHandle.style.width = '10px';
        dragHandle.style.height = '10px';
        dragHandle.style.background = 'blue';
        dragHandle.style.position = 'absolute';
        dragHandle.style.right = '0';
        dragHandle.style.bottom = '0';
        dragHandle.style.cursor = 'se-resize';
        dragHandle.addEventListener('mousedown', (e) => handleResizeStart(e, table));

        table.appendChild(dragHandle);
        table.addEventListener('dragstart', (e) => handleDragStart(e, table));

        editorRef.current.appendChild(table);
    };

    const handleDragStart = (e, table) => {
        setTableBeingDragged(table);
    };

    const handleDrop = (e) => {
        e.preventDefault();
        if (tableBeingDragged) {
            tableBeingDragged.style.position = 'absolute';
            tableBeingDragged.style.left = `${e.clientX}px`;
            tableBeingDragged.style.top = `${e.clientY}px`;
            setTableBeingDragged(null);
        }
    };

    const handleResizeStart = (e, table) => {
        e.preventDefault();
        setTableBeingResized(table);
        setStartPos({ x: e.clientX, y: e.clientY });
        document.addEventListener('mousemove', handleResizing);
        document.addEventListener('mouseup', handleResizeEnd);
    };

    const handleResizing = (e) => {
        if (tableBeingResized) {
            const dx = e.clientX - startPos.x;
            const dy = e.clientY - startPos.y;
            tableBeingResized.style.width = `${tableBeingResized.offsetWidth + dx}px`;
            tableBeingResized.style.height = `${tableBeingResized.offsetHeight + dy}px`;
            setStartPos({ x: e.clientX, y: e.clientY });
        }
    };

    const handleResizeEnd = () => {
        document.removeEventListener('mousemove', handleResizing);
        document.removeEventListener('mouseup', handleResizeEnd);
        setTableBeingResized(null);
    };

    useEffect(() => {
        const editor = editorRef.current;
        editor.addEventListener('dragover', (e) => e.preventDefault());
    }, []);

    return (
        <div>
            <div className="toolbar">
                <button onClick={() => execCommand('fontSize', '15')}>폰트 크기 설정</button>
                <input
                    type="color"
                    onChange={(e) => execCommand('foreColor', e.target.value)}
                />
                <button onClick={insertTable}>표 만들기</button>
            </div>
            <div
                ref={editorRef}
                contentEditable
                className="editor"
                onDrop={handleDrop}
                style={{ border: '1px solid black', minHeight: '300px', position: 'relative' }}
            ></div>
        </div>
    );
};

export default Editor;
