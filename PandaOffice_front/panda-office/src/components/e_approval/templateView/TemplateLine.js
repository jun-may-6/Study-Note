import { useEffect, useState } from "react";
import { useSelector } from "react-redux";

export function TemplateLine() {
    const { approvalDocumentTemplate } = useSelector(state => state.e_approvalReducer);
    const [approvalLine, setApprovalLine] = useState([]);

    useEffect(() => {
        if (approvalDocumentTemplate) {
            let employeeApprovalLine = [];
            for (const line of approvalDocumentTemplate.autoApprovalLine) {
                const employee = approvalDocumentTemplate.employeeList.find(emp => emp.employeeId === line.employeeId);
                if (employee) {
                    employeeApprovalLine.push(employee);
                }
            }
            setApprovalLine(employeeApprovalLine);
        }
        console.log(approvalDocumentTemplate)
    }, [approvalDocumentTemplate]);

    return (
        <>
            {approvalLine.map(employee => (
                <div key={employee.employeeId} className="new-line-preview-area border-bottom-padding">
                    <div>
                        <img src="/logo192.png" alt="Employee Avatar" />
                    </div>
                    <div>
                        {employee.department.name}
                        <br />
                        {employee.name} {employee.job.title}
                    </div>
                </div>
            ))}
        </>
    );
}
