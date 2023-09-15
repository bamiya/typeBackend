package com.test.type.service;

import com.test.type.dto.BoardDTO;
import com.test.type.entity.BoardEntity;
import com.test.type.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private  final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(BoardEntity boardEntity: boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public void update(Long id, BoardDTO updatedBoardDTO) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            boardEntity.setBoard_title(updatedBoardDTO.getBoard_title());
            boardEntity.setBoard_contents(updatedBoardDTO.getBoard_contents());
            boardEntity.setBoard_writer(updatedBoardDTO.getBoard_writer());
            boardEntity.setBoard_hits(updatedBoardDTO.getBoard_hits());
            boardEntity.setBoard_pass(updatedBoardDTO.getBoard_pass());
            boardRepository.save(boardEntity);
        }
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
