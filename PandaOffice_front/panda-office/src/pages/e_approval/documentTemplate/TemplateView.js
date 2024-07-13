import { useEffect } from "react"
import { useDispatch, useSelector } from "react-redux"
import { callGetDocumentTemplate } from "../../../apis/e_approval/ApprovalDocumentTemplateAPICalls";
import { setApprovalDocumentTemplate } from "../../../modules/E_ApprovalModules";
import { NavLink, useParams } from "react-router-dom";
import { TemplateDocument } from "../../../components/e_approval/templateView/TemplateDocument";
import { DocumentInfo } from "../../../components/e_approval/templateView/DocumentInfo";
import { TemplateLine } from "../../../components/e_approval/templateView/TemplateLine";


export function TemplateView() {
    const dispatch = useDispatch();
    const { documentId } = useParams();
    const { approvalDocumentTemplate } = useSelector(state => state.e_approvalReducer)
    useEffect(() => {
        dispatch(callGetDocumentTemplate(documentId))
        return () => {
            dispatch(setApprovalDocumentTemplate(null))
        }
    }, [])
    
    return (
        approvalDocumentTemplate &&
        <>
            <div className="common-comp">
                <div className='title'>전자결재 양식</div>
                <div className="flex" style={{ width: '100%' }}>
                    <div className='common-component'>
                        <div className='cc-header align-c'>양식 문서</div>
                        <TemplateDocument/>
                    </div>
                    <div style={{ width: '20px' }}></div>
                    <div>
                        <div className='common-component template-set-component'>
                            <div className='cc-header align-c '>양식 정보</div>
                            <div className='cc-content align-l'>
                                <DocumentInfo/>
                            </div>
                        </div>
                        <div className='common-component template-set-component'>
                            <div className='cc-header align-c '>결재선</div>
                            <div className='cc-content align-l'>
                                <TemplateLine/>
                            </div>
                        </div>
                        <div className="align-c">
                            <NavLink to ="/e_approval/document-template/folder">
                            <button className='modyfi-btn' style={{width: '180px'}}>돌아가기</button>
                            </NavLink>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}