import { useNavigate } from 'react-router-dom';

export function DocumentTable({ documentList }) {
  const navigate = useNavigate();
  const handleRowClick = (id) => {
    navigate(`/e_approval/approval-document/${id}`);
  };
  return (
    documentList && (
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
              documentList.map((doc) => {
                return (
                  <tr
                    key={doc.id}
                    onClick={() => {
                      handleRowClick(doc.id);
                    }}
                    style={{ cursor: 'pointer' }}
                    onMouseEnter={(e) =>
                      (e.currentTarget.style.backgroundColor = '#dddddd')
                    }
                    onMouseLeave={(e) =>
                      (e.currentTarget.style.backgroundColor = '')
                    }
                  >
                    <td>{doc.draftDate}</td>
                    <td>{doc.draftEmployeeName}</td>
                    <td>{doc.templateName}</td>
                    <td>{doc.title}</td>
                    <td>{doc.lastApprovalDate}</td>
                    <td>
                      {doc.documentStatus == '승인' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#A3A3A3',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          완료
                        </div>
                      ) : doc.documentStatus == '반려' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#F6B3B3',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          반려
                        </div>
                      ) : (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#A6C76C',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          진행중
                        </div>
                      )}
                    </td>
                    <td>
                      {doc.approvalStatus == '승인' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#A3A3A3',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          승인
                        </div>
                      ) : doc.approvalStatus == '대기' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#A6B0E4',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          대기
                        </div>
                      ) : doc.approvalStatus == '예정' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#F89E6B',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          예정
                        </div>
                      ) : doc.approvalStatus == '반려' ? (
                        <div
                          style={{
                            borderRadius: '5px',
                            backgroundColor: '#F6B3B3',
                            color: 'white',
                            width: '86px',
                            height: '28px',
                            margin: 'auto',
                            paddingTop: '3px',
                          }}
                        >
                          반려
                        </div>
                      ) : (
                        ''
                      )}
                    </td>
                  </tr>
                );
              })}
          </tbody>
        </table>
      </div>
    )
  );
}
