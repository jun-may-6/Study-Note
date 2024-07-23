import React from 'react';

export function Toolbar({ applyStyle, editMode }) {
    const handleStyleClick = (style) => {
        applyStyle(style);
    };

    return (
        editMode && (
            <div className='editor-edit-toolbar'>
                <div
                    className='editor-edit-toolbar-icon'
                    id='bold'
                    onClick={() => handleStyleClick('bold')}
                >
                    <img src='/editor/bold.png' alt="bold img" className='editor-edit-toolbar-icon-image' />
                </div>
                <div
                    className='editor-edit-toolbar-icon'
                    id='underscore'
                    onClick={() => handleStyleClick('underline')}
                >
                    <img src='/editor/underscore.png' alt="underscore img" className='editor-edit-toolbar-icon-image' />
                </div>
                <div
                    className='editor-edit-toolbar-icon'
                    id='line-through'
                    onClick={() => handleStyleClick('line-through')}
                >
                    <img src='/editor/line-through.png' alt="line-through img" className='editor-edit-toolbar-icon-image' />
                </div>
                <div
                    className='editor-edit-toolbar-icon'
                    id='italic'
                    onClick={() => handleStyleClick('italic')}
                >
                    <img src='/editor/italic.png' alt="italic img" className='editor-edit-toolbar-icon-image' />
                </div>
            </div>
        )
    );
}
