import { IoIosAdd, IoIosDocument, IoIosFolder, IoIosRemove } from "react-icons/io";
import { useDispatch, useSelector } from "react-redux";
import { fetchCurrentFolder, setFolderEditMode } from "../../../modules/E_ApprovalModules";
import { useEffect, useRef, useState } from "react";
import { callUpdateDocumentFolderAPI } from "../../../apis/e_approval/ApprovalDocumentFolderAPICalls";


export function Folder({ folder, folders, isOpen, setIsOpen }) {
    const { currentFolder } = useSelector(state => state.e_approvalReducer)
    const { folderEditMode } = useSelector(state => state.e_approvalReducer)
    const dispatch = useDispatch();
    const currentIsOpen = isOpen[folder.folderId]
    const childrenFolder = folders.filter(fol => fol.refFolderId == folder.folderId)
    const inputRef = useRef();
    const [folderName, setFolderName] = useState(folder.name);

    const toggleCurrentFolder = () => {
        if (currentFolder && currentFolder.folderId === folder.folderId) {
            dispatch(fetchCurrentFolder(null));
        } else {
            dispatch(fetchCurrentFolder(folder));
        }
    };
    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            const newName = e.target.value;
            console.log(newName)
            console.log(folder.folderId)
            dispatch(callUpdateDocumentFolderAPI({folderId: folder.folderId, name: newName}))
        }
    };
    const toggleFolder = (e) => {
        setIsOpen(state => ({
            ...state,
            [folder.folderId]: !currentIsOpen
        }))
    }
    useEffect(() => {
        if (folderEditMode && currentFolder?.folderId === folder.folderId) {
            inputRef.current.focus();
        }
    }, [folderEditMode, currentFolder, folder.folderId]);
    return (
        <div className="no-select left-border">
            <div className="flex">
                <div className='folder-icon' onClick={toggleFolder}>
                    {currentIsOpen ? <IoIosRemove /> : <IoIosAdd />}
                </div>
                <div className="flex-center" onClick={toggleCurrentFolder}>
                    <IoIosFolder />
                    {currentFolder?.folderId != folder.folderId ?
                        <div className="folder-name">{folder.name}</div> :
                        folderEditMode?
                        <div className="folder-name"> <input 
                        ref={inputRef}
                        value={folderName}
                        onChange={(e) => setFolderName(e.target.value)}
                        onKeyPress={handleKeyPress}
                    /></div>:
                        <div className="selected-folder-name">{folder.name}</div>}
                </div>
            </div>
            {currentIsOpen &&
                <>
                    {childrenFolder.length > 0 &&
                        childrenFolder.map(child => <Folder
                            key={child.folderId}
                            folder={child}
                            folders={folders}
                            isOpen={isOpen}
                            setIsOpen={setIsOpen} />
                        )}
                    {folder.documentList.length > 0 &&
                        folder.documentList.map(doc => <div
                            key={doc.documentId}
                            className="flex"
                            style={{ marginLeft: '18px' }}
                            onClick={toggleCurrentFolder}>
                            <div className='folder-icon'><IoIosDocument /></div>
                            {doc.title}
                        </div>)
                    }
                </>
            }
        </div>
    )
}