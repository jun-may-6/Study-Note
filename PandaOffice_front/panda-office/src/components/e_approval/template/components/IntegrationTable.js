export function IntegrationTable({ selectTable }) {
    return selectTable && <div className="integration-table-area">
        {
            (selectTable == 1 &&
                <table>
                    <tbody>
                        <tr>
                            <th style={{ width: '25%' }} >휴가 종류</th>
                            <td style={{ width: '75%' }} colspan="3">연차</td>
                        </tr>
                        <tr>
                            <th style={{ width: '25%' }}>시작일</th>
                            <td style={{ width: '25%' }}><input type="date"></input></td>
                            <th style={{ width: '25%' }}>종료일</th>
                            <td style={{ width: '25%' }}><input type="date"></input></td>
                        </tr>
                    </tbody>
                </table>) ||
            (selectTable == 2 &&
                <table>
                    <tbody>
                        <tr>
                            <th style={{ width: '25%' }} >휴가 종류</th>
                            <td style={{ width: '75%' }} colspan="3">반차</td>
                        </tr>
                        <tr>
                            <th style={{ width: '25%' }}>사용일</th>
                            <td style={{ width: '25%' }}><input type="date"></input></td>
                            <th style={{ width: '25%' }}>종류</th>
                            <td style={{ width: '25%' }}>
                                <select>
                                    <option>오전</option>
                                    <option>오후</option>
                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>) ||
            (selectTable == 3 &&
                <table>
                    <tbody>
                        <tr>
                            <th style={{ width: '25%' }} >근무 종류</th>
                            <td style={{ width: '75%' }}>휴일 근무</td>
                        </tr>
                        <tr>
                            <th style={{ width: '25%' }}>근무일</th>
                            <td style={{ width: '75%' }}><input type="date"></input></td>
                        </tr>
                    </tbody>
                </table>) ||
            (selectTable == 4 &&
                <table>
                    <tbody>
                        <tr>
                            <th style={{ width: '25%' }} >근무 종류</th>
                            <td style={{ width: '75%' }}>초과 근무</td>
                        </tr>
                        <tr>
                            <th style={{ width: '25%' }}>근무일</th>
                            <td style={{ width: '75%' }}><input type="date"></input></td>
                        </tr>
                    </tbody>
                </table>)
        }
    </div>
}