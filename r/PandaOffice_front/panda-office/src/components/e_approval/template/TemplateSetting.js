import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux"



export function TemplateSetting({onChangeFormHandler, templateRequest, setSelectTable}) {
    const {documentTemplateFolder} = useSelector(state=>state.e_approvalReducer);
    const [folderId, setFolderId] = useState();
    const [folderPath, setFolderPath] = useState();
    const { currentFolder } = useSelector(state => state.e_approvalReducer)

    useEffect(() => {
        setFolderId(templateRequest.folderId)
    },[])
    return (
        <div className="template-set-inner">
            <table>
                <tbody>
                    <tr>
                        <th>양식 별칭</th>
                        <td><input name="name" onChange = {onChangeFormHandler}></input></td>
                    </tr>
                    <tr>
                        <th>양식 설명</th>
                        <td><textarea name="description" onChange = {onChangeFormHandler}></textarea></td>
                    </tr>
                    <tr>
                        <th>수정 사항</th>
                        <td><textarea name="lastEditComment" onChange = {onChangeFormHandler}></textarea></td>
                    </tr>
                    <tr>
                        <th>최근 수정 사항</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>연동 기능</th>
                        <td>
                            <select name="integrateId" onChange = {(e) => {setSelectTable(e.target.value)}}>
                                <option value={null}>=======</option>
                                <option value={1}>연차 신청</option>
                                <option value={2}>반차 신청</option>
                                <option value={3}>휴일근무 신청</option>
                                <option value={4}>초과근무 신청</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>상위 폴더</th>
                        <td>
                            {currentFolder.name}
                        </td>
                    </tr>
                    <tr>
                        <th>사용 상태</th>
                        <td>
                            <label htmlFor="use">사용</label><input id="use" type="radio" name="status" value={true} onChange = {onChangeFormHandler}></input>
                            <label htmlFor="notUse">미사용</label><input id="notUse" type="radio" name="status" value={false} onChange = {onChangeFormHandler}></input>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}