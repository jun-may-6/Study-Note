import { useEffect, useState } from 'react';
import { IoIosCheckbox, IoIosCheckboxOutline } from 'react-icons/io';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSelectTemplates } from '../../../modules/E_ApprovalModules';
import { useNavigate } from 'react-router-dom';

export function TemplateTable() {
  const { currentFolder, selectTemplates, documentTemplateFolder } =
    useSelector((state) => state.e_approvalReducer);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [selectAllTemplates, setSelectAllTemplates] = useState(false);

  const setSelect = (documentId) => {
    dispatch(
      fetchSelectTemplates(
        selectTemplates.includes(documentId)
          ? selectTemplates.filter((id) => id !== documentId)
          : [...selectTemplates, documentId]
      )
    );
    setSelectAllTemplates(false);
  };

  const setSelectAll = () => {
    if (selectAllTemplates) {
      dispatch(fetchSelectTemplates([]));
    } else {
      dispatch(
        fetchSelectTemplates(
          currentFolder.documentList.map((doc) => doc.documentId)
        )
      );
    }
    setSelectAllTemplates(!selectAllTemplates);
  };

  return (
    currentFolder && (
      <>
        <table className="template-folder-table">
          <colgroup>
            <col style={{ width: '10%' }} />
            <col style={{ width: '30%' }} />
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
            <col style={{ width: '20%' }} />
          </colgroup>
          <thead>
            <tr>
              <th onClick={setSelectAll}>
                {selectAllTemplates ? (
                  <IoIosCheckbox />
                ) : (
                  <IoIosCheckboxOutline />
                )}
              </th>
              <th>제목</th>
              <th>최종 수정자</th>
              <th>최종 수정일</th>
              <th>사용 여부</th>
            </tr>
          </thead>
          <tbody>
            {currentFolder.documentList.map((doc) => (
              <tr
                key={doc.documentId}
                style={{ cursor: 'pointer' }}
                onMouseEnter={(e) =>
                  (e.currentTarget.style.backgroundColor = '#dddddd')
                }
                onMouseLeave={(e) =>
                  (e.currentTarget.style.backgroundColor = '')
                }
              >
                <td
                  onClick={(e) => {
                    e.stopPropagation();
                    setSelect(doc.documentId);
                  }}
                >
                  {selectTemplates.includes(doc.documentId) ? (
                    <IoIosCheckbox />
                  ) : (
                    <IoIosCheckboxOutline />
                  )}
                </td>
                <td
                  onClick={() =>
                    navigate(`/e_approval/document-template/${doc.documentId}`)
                  }
                >
                  {doc.title}
                </td>
                <td
                  onClick={() =>
                    navigate(`/e_approval/document-template/${doc.documentId}`)
                  }
                >{`${doc.lastEditorName} ${doc.lastEditorJob}`}</td>
                <td
                  onClick={() =>
                    navigate(`/e_approval/document-template/${doc.documentId}`)
                  }
                >
                  {doc.lastEditDate}
                </td>
                <td
                  onClick={() =>
                    navigate(`/e_approval/document-template/${doc.documentId}`)
                  }
                >
                  {doc.status}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </>
    )
  );
}
