import { useSelector } from "react-redux"
import { DraftInfo } from "../template/components/DraftInfo"
import { DraftBox } from "../template/components/DraftBox"
import { ApprovalBox } from "../draft/ApprovalBox"
import { WebEditor } from "../template/components/WebEditor"
import { useEffect, useRef, useState } from "react"
import { IntegrationTable } from "../template/components/IntegrationTable"


export function TemplateDocument() {
    const divRef = useRef();
    const { approvalDocumentTemplate } = useSelector(state => state.e_approvalReducer)
    const [approvalLine, setApprovalLine] = useState([]);
    useEffect(() => {
        divRef.current.innerHTML = approvalDocumentTemplate.document
        let employeeApprovalLine = []
        for(const line of approvalDocumentTemplate.autoApprovalLine){
            const employee = approvalDocumentTemplate.employeeList.find(emp=>emp.employeeId == line.employeeId)
            employeeApprovalLine.push(employee)
        }
        setApprovalLine(employeeApprovalLine)
    }, [])
    return (
        approvalDocumentTemplate &&
        <div className='cc-content align-l page-component-outer'>
            <div className='page-component-inner'>
                <div className="template-title">
                    {approvalDocumentTemplate.title}
                </div>
                <div className="flex">
                    <DraftInfo draftEmployee={approvalDocumentTemplate.draftEmployee} />
                    <div className="approval-area">
                        <div className="approval-box-description">기안</div>
                        <DraftBox draftEmployee={approvalDocumentTemplate.draftEmployee} />
                    </div>
                    <div className="approval-box-description">결재</div>
                    {approvalLine.map(line => {
                        return <ApprovalBox key={approvalLine.indexOf(line)}
                        employee={line}/>
                    })}
                </div>
                <div>
                <IntegrationTable selectTable={null} />
                    <div ref={divRef}></div>
                </div>
            </div>
        </div>)
}