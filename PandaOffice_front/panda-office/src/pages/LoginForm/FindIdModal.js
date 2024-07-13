import React from "react";
import Modal from "react-modal";

const FindIdModal = ({
                         isOpen,
                         onRequestClose,
                         onChangeHandler,
                         onClickFindIdHandler
                     }) => (
    <Modal
        isOpen={isOpen}
        onRequestClose={onRequestClose}
        contentLabel="Find ID Modal"
        className="Modal"
        overlayClassName="Overlay"
        ariaHideApp={false}
    >
        <h3 className="modalTitle">아이디 찾기</h3>
        <div className="modalContent"></div>
        <div className="modalActions">
            <form>
                <input
                    type="text"
                    placeholder="이름 입력"
                    required
                    onChange={onChangeHandler}
                    name="name"
                />
                <br />
                <input
                    type="email"
                    placeholder="이메일 입력"
                    required
                    onChange={onChangeHandler}
                    name="email"
                />
                <br />
                <input
                    type="date"
                    placeholder="생년월일 입력"
                    required
                    onChange={onChangeHandler}
                    name="birthDate"
                />
            </form>
            <div>
                <button onClick={onRequestClose}>취소</button>
                <button
                    style={{ backgroundColor: "#1E1F31", color: "white" }}
                    onClick={onClickFindIdHandler}
                >
                    찾기
                </button>
            </div>
        </div>
    </Modal>
);

export default FindIdModal;

