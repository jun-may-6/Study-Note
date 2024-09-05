$(document).ready(function()
{
    $('#submitBtn').click(function()
    {
        // 폼 데이터 수집
        var formData =
            {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val(),
                createdAt: new Date() // 작성일을 현재 시간으로 설정
            };

        // AJAX POST 요청
        $.ajax({
            url: '/api/insert',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response)
            {
                alert('Article이 성공적으로 저장되었습니다.');
                console.log(response); // 서버의 응답 출력

                // 등록 완료 시 form 초기화
                $('#title').val("");
                $('#author').val("");
                $('#content').val("");
            },
            error: function(xhr, status, error)
            {
                alert('저장 중 오류가 발생했습니다.');
                console.error(xhr, status, error); // 오류 정보 출력
            }
        });
    });
});