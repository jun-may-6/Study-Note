import { useSelector } from "react-redux"

export function DocumentInfo(){
    const {approvalDocumentTemplate} = useSelector(state=>state.e_approvalReducer)
    return (
        <>
         <div className="template-set-inner">
            <table>
                <tbody>
                    <tr>
                        <th>문서 제목</th>
                        <td>{approvalDocumentTemplate.name}</td>
                    </tr>
                    <tr>
                        <th>기안자</th>
                        <td>{approvalDocumentTemplate.draftEmployee.department.name}<br/>{approvalDocumentTemplate.draftEmployee.name} {approvalDocumentTemplate.draftEmployee.job.title}</td>
                    </tr>
                    <tr>
                        <th>기안일</th>
                        <td>{`${new Date().getFullYear()}/${new Date().getMonth() + 1}/${new Date().getDate()}`}</td>
                    </tr>
                    <tr>
                        <th>문서 양식</th>
                        <td>{approvalDocumentTemplate.name}</td>
                    </tr>
                    <tr>
                        <th>연동 기능</th>
                        <td>
                            연차 신청
                        </td>
                    </tr>
                </tbody>
            </table>
            {/* <input type="file">참조 파일</input> */}
        </div>
        </>
    )
}