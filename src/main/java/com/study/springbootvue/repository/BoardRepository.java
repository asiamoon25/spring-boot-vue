package com.study.springbootvue.repository;

import com.study.springbootvue.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface BoardRepository {
    int saveBoard(String inputText, String writer);
    List<BoardDTO> boardData(int startRow,int endRow);
    int allData();
    Optional<Object> search(String searchText);
}
