package com.spandiar.springboot.books.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spandiar.springboot.model.BookSimplifiedModel;
import com.spandiar.springboot.model.Library;


@Mapper
public interface BookMapper {

/*@Select("SELECT BOOKID, BOOKNAME, AUTHOR, LANGUAGE, PUBLISHER, YEAR, VOLUME FROM BOOKS WHERE BOOKID=#{bookId}")
Library selectOne(int bookId);*/

BookSimplifiedModel BookWithGenre(int bookId);
//void AddBookToLibrary(BookModel addBook);
//Library QueryParamSearch(@Param("columnName") String columnName, @Param("columnValue") String columnValue);
Library AllBooks();

}
