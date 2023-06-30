package com.test.type.controller;

import com.test.type.dto.BoardDTO;
import com.test.type.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllPosts() {
        List<BoardDTO> boardDTOList = boardService.findAll();
        return new ResponseEntity<>(boardDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}