import { useDispatch, useSelector } from "react-redux"
import { callReviewListAPI } from "../../api/ReviewAPICalls"
import { useEffect } from "react";

function ReviewList() {
    const dispatch = useDispatch();
    const { reviewList } = useSelector(state => state.reviewReducer);

    useEffect(() => {
        dispatch(callReviewListAPI())
    }, [])
    console.log('text', reviewList)
    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>리뷰 번호</th>
                        <th>작성자</th>
                        <th>제목</th>
                        <th>내용</th>
                    </tr>
                </thead>
                <tbody>
                    {reviewList &&
                        reviewList.map(review =>
                            <tr key={review.id}>
                                <td>{review.id}</td>
                                <td>{review.writer}</td>
                                <td>{review.title}</td>
                                <td>{review.content}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </>
    )

}


export default ReviewList;