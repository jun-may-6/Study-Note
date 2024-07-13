import { useNavigate } from "react-router-dom"


export function DocumentTable({ documentList }) {
    const navigate = useNavigate();
    const handleRowClick = (id) => {
        navigate(`/e_approval/approval-document/${id}`);
    };
    return documentList &&
        <div className="document-list-table">
            <table>
                <thead>
                    <tr>
                        <th>기안일</th>
                        <th>기안자</th>
                        <th>결재 양식</th>
                        <th>제목</th>
                        <th>최근 결재일</th>
                        <th>진행 상태</th>
                        <th>결재 상태</th>
                    </tr>
                </thead>
                <tbody>
                    {documentList.length > 0 &&
                        documentList.map(doc => {
                            return <tr key={doc.id} onClick={() => {handleRowClick(doc.id)}}>
                                <td>{doc.draftDate}</td>
                                <td>{doc.draftEmployeeName}</td>
                                <td>{doc.templateName}</td>
                                <td>{doc.title}</td>
                                <td>{doc.lastApprovalDate}</td>
                                <td>{doc.documentStatus}</td>
                                <td>{doc.approvalStatus}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
        </div>
}