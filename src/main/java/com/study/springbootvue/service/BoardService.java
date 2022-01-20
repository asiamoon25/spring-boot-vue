package com.study.springbootvue.service;

import com.study.springbootvue.domain.BoardDTO;
import com.study.springbootvue.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public int saveBoard(String inputText,String writer){
        return repository.saveBoard(inputText, writer);
    }

    public List<BoardDTO> boardData(){
        return repository.boardData();
    }
}
