import { useLocation, useNavigate, useParams } from "react-router-dom"
import { DocumentCriteria } from "../../../components/e_approval/document/DocumentCriteria";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from 'react-redux'
import { callApprovalDocumentSearch } from "../../../apis/e_approval/ApprovalDocumentAPICalls";
import { DocumentTable } from "../../../components/e_approval/document/DocumentTable";
import { setApprovalDocumentList } from "../../../modules/E_ApprovalModules";
import PagingBar from "../../recruitment/PagingBar";


export function DocumentList() {
    const {approvalDocumentList} = useSelector(state=>state.e_approvalReducer)
    const dispatch = useDispatch();
    const [searchCriteria, setSearchCriteria] = useState();
    const [defaultQuery, setDefaultQuery] = useState('approval-documents');
    const [currentPage, setCurrentPage] = useState(1);
    const [title, setTitle] = useState();

    const {type} = useParams();

    const onClickSearch = () => {
        let query = defaultQuery + '&'
        let isFirstParam = true;
        for (const name in searchCriteria) {
            if (searchCriteria[name] !== '') {
                if (!isFirstParam) {
                    query += '&';
                }
                query += `${name}=${searchCriteria[name]}`;
                isFirstParam = false;
            }
        }
        dispatch(callApprovalDocumentSearch(query))
    }

    useEffect(() => {
        let query;
        switch(type){
            case 'draft-box': query = '?mine=true'; setTitle('내 기안 문서'); break
            case 'pending-box': query = '?approvalStatus=1'; setTitle('결재 대기 문서'); break
            case 'scheduled-box': query = '?approvalStatus=0'; setTitle('결재 예정 문서'); break
            case 'archived-box': query = '?handling=true'; setTitle('결재 문서 열람'); break
        }
        setDefaultQuery('approval-documents'+query)
        return () => {
            setApprovalDocumentList(null)
        }
    }, [type])
    useEffect(() => {
        dispatch(callApprovalDocumentSearch(defaultQuery))
    }, [defaultQuery])

    return (
        approvalDocumentList&&
        <div className="common-comp">
            <div className='title'>{title ? title : '문서'}</div>
            <DocumentCriteria setSearchCriteria={setSearchCriteria} onClickSearch={onClickSearch} />
            <div className="applicant-wrap">
            <DocumentTable documentList={approvalDocumentList.data}/>
            <PagingBar pageInfo={approvalDocumentList.pageInfo} setCurrentPage={setCurrentPage} />
            </div>
        </div>
    )

}