package com.test.type.controller;

import com.test.type.dto.BoardDTO;
import com.test.type.entity.BoardEntity;
import com.test.type.service.BoardService;
import com.test.type.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
//@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;


    public BoardController(BoardService boardService, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

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


    @GetMapping("/{id}")
    public ResponseEntity<BoardEntity> getBoardDetail(@PathVariable Long id) {
        Optional<BoardEntity> board = boardRepository.findById(id);
        return board.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody BoardDTO updatedBoardDTO) {
        boardService.update(id, updatedBoardDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}