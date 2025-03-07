package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

/* @Service : @Component 의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
@Service("bookServiceField")
public class BookService {

    /* BookDAO 타입의 빈(bean) 객체를 이 프로퍼티에 자동으로 주입 */
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
