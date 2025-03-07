import { useDispatch, useSelector } from 'react-redux';
import { callCheckInAPI, callCheckOutAPI } from '../../apis/AttendanceAPICalls';

export function AttendanceHandler() {
    const dispatch = useDispatch();
    const message = useSelector(state => state.attendance?.message);
    const attendanceState = useSelector(state => state.attendance);
    console.log('Attendance 상태:', attendanceState);

    const handleCheckIn = async () => {
        const attendanceData = {
            checkInDate: new Date().toISOString().split('T')[0], // 'YYYY-MM-DD' 형식
            checkInTime: new Date().toTimeString().split(' ')[0] // 'HH:mm:ss' 형식
        };
        try {
            await dispatch(callCheckInAPI(attendanceData));
        } catch (error) {
            console.error("출근 오류:", error);
        }
    };

    const handleCheckOut = async () => {
        const attendanceData = {
            checkInDate: new Date().toISOString().split('T')[0], // 'YYYY-MM-DD' 형식
            checkOutTime: new Date().toTimeString().split(' ')[0] // 'HH:mm:ss' 형식
        };
        try {
            await dispatch(callCheckOutAPI(attendanceData));
        } catch (error) {
            console.error("퇴근 오류:", error);
        }
    };

    return (
        <div className="check-button">
            <button onClick={handleCheckIn}>출근</button>
            <button onClick={handleCheckOut}>퇴근</button>
            {message && <p>{message}</p>}
        </div>
    );
}
