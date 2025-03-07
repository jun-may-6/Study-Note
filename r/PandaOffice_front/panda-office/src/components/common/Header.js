import { useNavigate } from 'react-router-dom';
import { TbBellFilled } from 'react-icons/tb';
import { IoCalendarNumberOutline } from 'react-icons/io5';
import { FiLogOut } from 'react-icons/fi';
import { Link } from 'react-router-dom';
import { callLogoutAPI } from '../../apis/MemberAPICalls';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useState } from 'react';
import { isLogin } from '../../utils/TokenUtils';

function Header() {
  const navigate = useNavigate();
  const [search, setSearch] = useState('');
  const dispatch = useDispatch();

  /* 로고 클릭 시 메인 페이지로 이동 */
  const onClickHandler = () => navigate('/');
  const onEnterKeyHandler = (e) => {
    if (e.key === 'Enter') navigate(`/product/search?value=${search}`);
  };

  function AfterLogin() {
    const { success } = useSelector((state) => state.memberReducer);

    useEffect(() => {
      if (success === true) {
        window.location.replace('/');
      }
    }, [success]);

    return (
      <header className="panda-header">
        <Link to="/">
          <div className="panda-logo" />
        </Link>
        <div className="icon-area">
          {/* <div className="icon" >
                        <Link to>
                            <TbBellFilled className="bell" />
                        </Link>
                    </div> */}

          {/* <div className="icon">
                        <Link to>
                            <IoCalendarNumberOutline className="calender"/>
                        </Link>
                    </div> */}
          {/*이름 , 직급 추가하는 부분 */}
          <div>
            <span style={{ fontSize: '18px' }}>김민수 부장님 환영합니다</span>
            {/* <span style={{ fontSize: '18px' }}>박민수 대리님 환영합니다</span> */}
          </div>
          <div className="icon">
            <Link to>
              <FiLogOut
                className="logout"
                onClick={() => dispatch(callLogoutAPI())}
              />
            </Link>
          </div>
        </div>
      </header>
    );
  }

  return <div className="panda-header">{<AfterLogin />}</div>;
}

export default Header;
