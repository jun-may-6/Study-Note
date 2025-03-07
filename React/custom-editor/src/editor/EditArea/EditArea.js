import React, { useRef, useEffect } from 'react';

export function EditArea({ currentValue, setCurrentValue, styleToApply, setStyleToApply }) {
    const editorRef = useRef(null);

    useEffect(() => {
        if (styleToApply) {
            applyStyle(styleToApply);
            setStyleToApply(null);
        }
    }, [styleToApply, setStyleToApply]);

    const applyStyle = (style) => {
        const selection = window.getSelection();
        if (selection.rangeCount > 0) {
            const range = selection.getRangeAt(0);
            wrapTextNodes(range, style);
        }
    };

    const wrapTextNodes = (range, style) => {
        const startContainer = range.startContainer;
        const endContainer = range.endContainer;
        const commonAncestor = range.commonAncestorContainer;

        if (startContainer === endContainer && startContainer.nodeType === Node.TEXT_NODE) {
            wrapNode(startContainer, style, range.startOffset, range.endOffset);
            return;
        }

        if (startContainer.nodeType === Node.TEXT_NODE) {
            wrapNode(startContainer, style, range.startOffset, startContainer.length);
        }

        if (endContainer.nodeType === Node.TEXT_NODE) {
            wrapNode(endContainer, style, 0, range.endOffset);
        }

        let currentNode = startContainer;
        while (currentNode && currentNode !== commonAncestor) {
            currentNode = currentNode.nextSibling;
            if (currentNode && currentNode.nodeType === Node.TEXT_NODE) {
                wrapNode(currentNode, style, 0, currentNode.length);
            }
        }

        currentNode = endContainer;
        while (currentNode && currentNode !== commonAncestor) {
            currentNode = currentNode.previousSibling;
            if (currentNode && currentNode.nodeType === Node.TEXT_NODE) {
                wrapNode(currentNode, style, 0, currentNode.length);
            }
        }

        const walker = document.createTreeWalker(
            commonAncestor,
            NodeFilter.SHOW_TEXT,
            {
                acceptNode: (node) => {
                    if (
                        (node.compareDocumentPosition(startContainer) & Node.DOCUMENT_POSITION_FOLLOWING) &&
                        (node.compareDocumentPosition(endContainer) & Node.DOCUMENT_POSITION_PRECEDING)
                    ) {
                        return NodeFilter.FILTER_ACCEPT;
                    }
                    return NodeFilter.FILTER_REJECT;
                }
            },
            false
        );

        while (walker.nextNode()) {
            wrapNode(walker.currentNode, style, 0, walker.currentNode.length);
        }
    };

    const wrapNode = (node, style, start, end) => {
        const span = document.createElement('span');
        span.className = style;
        const text = node.textContent.slice(start, end);
        const textNode = document.createTextNode(text);
        span.appendChild(textNode);

        const range = document.createRange();
        range.setStart(node, start);
        range.setEnd(node, end);
        range.deleteContents();
        range.insertNode(span);
    };

    const onInputHandler = (e) => {
        const element = editorRef.current;
        if (element.scrollHeight > 500) {
            e.target.innerHTML = currentValue;
        }
        setCurrentValue(e.target.innerHTML);
    };

    return (
        <div
            ref={editorRef}
            contentEditable
            onInput={onInputHandler}
            className='editor-edit-area'
        />
    );
}
