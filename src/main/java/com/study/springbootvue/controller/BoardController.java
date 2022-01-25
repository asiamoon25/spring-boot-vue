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

    //======================================================================
    @GetMapping("/board")
    public Map<String, List<BoardDTO>> board(@RequestParam Map<String,String> params){

        String strPage = params.get("page");

        int pageNo = Integer.parseInt(strPage);

        List<BoardDTO> boardData = boardService.boardData(pageNo);

        Map<String,List<BoardDTO>> map = new HashMap<>();

        map.put("boardData",boardData);

        return map;
    }
//======================================================================
    @GetMapping("/board/pagination")
    public Map<String,Integer> pagination(){

        Map<String,Integer> map = new HashMap<>();

        map.put("count",boardService.pagination());

        return map;
    }
//======================================================================
    @PostMapping("/board-save")
    public Integer saveBoard(@RequestParam Map<String,String>params){
        String inputText = params.get("inputText");
        String writer = params.get("writer");
        return boardService.saveBoard(inputText,writer);
    }
//======================================================================
    @GetMapping("/board/search")
    public Map<String,Object> search(@RequestParam Map<String,String>params){

        Map<String,Object> map = new HashMap<>();

        map.put("boardData",boardService.search(params.get("search")));

        return null;
    }
}
