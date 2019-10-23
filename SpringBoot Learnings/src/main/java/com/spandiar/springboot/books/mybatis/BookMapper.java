package com.spandiar.springboot.books.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spandiar.springboot.model.BookModel;
import com.spandiar.springboot.model.BookSimplifiedModel;

@Mapper
public interface BookMapper {

@Select("SELECT BOOKID, BOOKNAME, AUTHOR, LANGUAGE, PUBLISHER, YEAR, VOLUME FROM BOOKS WHERE BOOKID=#{bookId}")
BookSimplifiedModel selectOne(int bookId);

/*@Select("SELECT A.BOOKID as bookId, A.BOOKNAME as bookName, A.AUTHOR as author, A.LANGUAGE as language, B.GENRE as genre, A.PUBLISHER as publisher, A.YEAR as year, A.VOLUME as volume FROM BOOKS A, BOOK_ATTRIBUTES B where B.BOOKID=A.BOOKID AND A.BOOKID=#{bookId}")
BookSimplifiedModel BookWithGenre(int bookId);*/

BookSimplifiedModel BookWithGenre(int bookId);
void AddBookToLibrary(BookModel addBook);

}
