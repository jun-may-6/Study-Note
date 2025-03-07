import { NavLink, useLocation } from "react-router-dom";
import { IoIosArrowDown, IoMdSettings, IoIosArrowForward, IoIosArrowRoundForward, IoIosArrowUp } from "react-icons/io";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchSidebarStatus } from "../../modules/E_ApprovalModules";
import { callDepartmentBox } from "../../apis/e_approval/ApprovalDocumentFolderAPICalls";
import './E_Approval.css';
import { DraftModal } from "../../components/e_approval/modal/DraftModal";

function E_ApprovalSidebar() {

    const dispatch = useDispatch();
    const [draftModal, setDraftModal] = useState(false)

    const { sidebarStatus, departmentBox } = useSelector(state => state.e_approvalReducer)

    /* 부서함 정보 호출 */
    useEffect(() => {
        dispatch(callDepartmentBox())
    }, [])

    /* 사이드바 열림/접힘 상태 관리 */
    const toggleHandler = (e) => {
        dispatch(fetchSidebarStatus({
            ...sidebarStatus,
            [e.target.id]: !sidebarStatus[e.target.id]
        }))
    };





    return (
        <>
            <div className={`side-wrap no-select`}>
                <div className="side-bar">
                    <div className="title">전자 결재</div>
                    <button className="add-btn"
                    onClick={() => {setDraftModal(true)}}>결재 기안</button>
                    <ul className="mt-30 txt-align-left">
                        <li>
                            <div className="sidebar-item" onClick={toggleHandler}>
                                {sidebarStatus.A ? <IoIosArrowDown className="sidebar-icons toggle-down" /> : <IoIosArrowForward className="sidebar-icons toggle-up" />}
                                <span className="icons-text fs-18 cursor-p" id="A">문서함</span>
                            </div>
                            {sidebarStatus.A && (
                                <ul className="mt-10">
                                    <li>
                                        <div className="sidebar-item" onClick={toggleHandler}>
                                            {sidebarStatus.Aa ? <IoIosArrowDown className="sidebar-icons ml-20" /> : <IoIosArrowForward className="sidebar-icons ml-20" />}
                                            <span className="icons-text fs-14 cursor-p" id="Aa">내 문서함</span>
                                        </div>
                                        {sidebarStatus.Aa && (
                                            <ul className="mt-10">
                                                <NavLink to="approval-documents/draft-box"> <li className="icons-text fs-12 mt-10 ml-55 cursor-p">내 기안 문서</li></NavLink>
                                                <NavLink to="approval-documents/pending-box"><li className="icons-text fs-12 mt-10 ml-55 cursor-p">결재 대기 문서</li></NavLink>
                                                <NavLink to="approval-documents/scheduled-box"><li className="icons-text fs-12 mt-10 ml-55 cursor-p">결재 예정 문서</li></NavLink>
                                                <NavLink to="approval-documents/archived-box"><li className="icons-text fs-12 mt-10 ml-55 cursor-p">결재 문서 열람</li></NavLink>
                                            </ul>
                                        )}
                                    </li>
                                </ul>
                            )}
                        </li>
                    </ul>
                    <div className="approval-setting-sidebar icons-text cursor-p">
                        <NavLink to="document-template/folder">
                            <IoMdSettings className="setting-icon" />전자결재 양식 관리
                        </NavLink>
                    </div>
                </div>
            </div>
            {draftModal&&<DraftModal setDraftModal={setDraftModal}/>}
        </>
    )
}

export default E_ApprovalSidebar;