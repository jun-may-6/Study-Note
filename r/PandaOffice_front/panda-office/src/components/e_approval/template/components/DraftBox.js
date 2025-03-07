

export function DraftBox({draftEmployee, date}) {


    return (
        <div className="approval-box">
            <div className="approval-box-cover">{draftEmployee.department.name}</div>
            <div className="approval-box-content">{draftEmployee.name}<br/>{draftEmployee.job.title}</div>
            <div className="approval-box-cover">{date?date:`${new Date().getFullYear()}/${new Date().getMonth() + 1}/${new Date().getDate()}`}</div>
        </div>
    )
}