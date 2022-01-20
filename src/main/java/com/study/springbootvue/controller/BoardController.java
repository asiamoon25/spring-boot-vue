package com.study.springbootvue.controller;

import com.study.springbootvue.domain.BoardDTO;
import com.study.springbootvue.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("/api")
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public Map<String, List<BoardDTO>> board(){

        List<BoardDTO> boardData = boardService.boardData();

        Map<String,List<BoardDTO>> map = new HashMap<>();

        map.put("boardData",boardData);

        return map;
    }
    @RequestMapping("/board-save")
    public Integer saveBoard(@RequestParam Map<String,String>params){
        String inputText = params.get("inputText");
        String writer = params.get("writer");
        return boardService.saveBoard(inputText,writer);
    }
}
