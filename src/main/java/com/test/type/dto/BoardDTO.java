package com.test.type.dto;


import com.test.type.entity.BoardEntity;
import lombok.*;

//Data Transfer Object (데이터를 전송할때 사용하는 객체)
@Getter
@Setter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    private Long id;
    private String board_writer;
    private String board_pass;
    private String board_title;
    private String board_contents;
    private int board_hits;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoard_writer(boardEntity.getBoard_writer());
        boardDTO.setBoard_pass(boardEntity.getBoard_pass());
        boardDTO.setBoard_title(boardEntity.getBoard_title());
        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
        boardDTO.setBoard_hits(boardEntity.getBoard_hits());
        return boardDTO;
    }

}