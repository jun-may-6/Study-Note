import { Outlet } from "react-router-dom";
import Footer from "../../components/common/Footer";
import RecruitmentSidebar from "./RecruitmentSidebar";

function Recruitment() {
    return (
        <>
            <RecruitmentSidebar />
            <div className="common-comp">
                <div className="pd mg-bt-27">
                    <Outlet />
                </div>
                <div className="footer">
                    <Footer />
                </div>
            </div>
        </>
    )
}

export default Recruitment;