import { useDispatch, useSelector } from "react-redux";
import TemplateEditor from "../../../components/e_approval/template/TemplateEditor";
import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import { callGetInfoForCreateTemplate, callPostNewApprovalDocumentTemplate } from "../../../apis/e_approval/ApprovalDocumentTemplateAPICalls";
import { TempApprovalLine } from "../../../components/e_approval/template/TempApprovalLine";
import { TemplateSetting } from "../../../components/e_approval/template/TemplateSetting";
import { setInfoForCreate } from "../../../modules/E_ApprovalModules";

function DocumentTemplateRegist() {
    const [selectTable, setSelectTable] = useState();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { currentFolder } = useSelector(state => state.e_approvalReducer)
    const { infoForCreate } = useSelector(state => state.e_approvalReducer)
    const [templateRequest, setTemplateRequest] = useState({
        name: '',
        lastEditComment: '',
        title: '',
        description: '',
        document: '',
        autoApprovalLineRequestList: [
            // {
            //     order: 0,
            //     employeeId: 0,
            //     jobId: 0,
            //     departmentId: 0
            // }
        ],
        folderId: null,
        status: true,
        integrateFeatureId: null
    });

    const submit = () => { 
        dispatch(callPostNewApprovalDocumentTemplate(templateRequest)) 
        navigate('/e_approval/document-template/folder')
    }
    const onChangeFormHandler = (e) => {
        setTemplateRequest(state => {
            console.log(state)
            if (e.target.id == 'document') {
                console.log(e.target.innerHTML)
                return { ...state, [e.target.id]: e.target.innerHTML }
            } else {
                return { ...state, [e.target.name]: e.target.value }
            }
        }
        )
    }
    function onClickApprovalLineChange(currentLine) {
        let newLine = [];
        for (const line of currentLine) {
            const lineObject = {
                order: currentLine.indexOf(line) + 1,
                employeeId: line.employeeId,
                jobId: line.jobId,
                departmentId: line.departmentId
            }
            newLine = [...newLine, lineObject];
        }
        setTemplateRequest(state => ({ ...state, autoApprovalLineRequestList: newLine }));
    }


    useEffect(() => {
        dispatch(callGetInfoForCreateTemplate())
        setTemplateRequest(state => ({ ...state, folderId: currentFolder?.folderId }))
        return () => { dispatch(setInfoForCreate(null)) }
    }, [])

    return (
        infoForCreate &&
        <div className="common-comp">
            <div className='title'>전자결재 양식 등록</div>
            <div className="flex" style={{ width: '100%' }}>
                <div className='common-component'>
                    <div className='cc-header align-c'>양식 입력</div>
                    <TemplateEditor draftEmployee={infoForCreate.draftEmployee}
                        onChangeFormHandler={onChangeFormHandler}
                        templateRequest={templateRequest}
                        selectTable = {selectTable}
                    />
                </div>
                <div style={{ width: '20px' }}></div>
                <div>
                    <div className='common-component template-set-component'>
                        <div className='cc-header align-c '>양식 설정</div>
                        <div className='cc-content align-l'>
                            <TemplateSetting onChangeFormHandler={onChangeFormHandler} templateRequest={templateRequest} setSelectTable={setSelectTable} />
                        </div>
                    </div>
                    <div className='common-component template-set-component'>
                        <div className='cc-header align-c '>자동 결재선</div>
                        <div className='cc-content align-l'>
                            <TempApprovalLine onClickApprovalLineChange={onClickApprovalLineChange} />
                        </div>
                    </div>
                    <div className="align-c">
                        <button className="cancel-btn">취소</button>
                        <button className='modyfi-btn' onClick={submit}>등록</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DocumentTemplateRegist;