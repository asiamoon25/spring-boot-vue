package com.study.springbootvue.service;

import com.study.springbootvue.domain.BoardDTO;
import com.study.springbootvue.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }
    //======================================================================
    public int saveBoard(String inputText,String writer){
        return repository.saveBoard(inputText, writer);
    }
    //======================================================================
    public List<BoardDTO> boardData(int pageNo){
        int startRow = pageNo*5-4;
        int endRow = startRow+4;
        return repository.boardData(startRow,endRow);
    }
    //======================================================================
    public Integer pagination(){
        int all = repository.allData();
        int pagePerCount = 5; // 페이징
        return (all%pagePerCount == 0)? all/pagePerCount : (all/pagePerCount)+1;
    }
    //======================================================================
    public Optional<Object> search(String searchText){
        return repository.search(searchText);
    }
}
