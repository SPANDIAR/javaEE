package com.spandiar.springboot.books.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spandiar.springboot.model.BookSimplifiedModel;

@Mapper
public interface BookMapper {

@Select("SELECT BOOKID, BOOKNAME, AUTHOR, LANGUAGE, PUBLISHER, YEAR, VOLUME FROM BOOKS WHERE BOOKID=#{bookId}")
BookSimplifiedModel selectOne(int bookId);

}
