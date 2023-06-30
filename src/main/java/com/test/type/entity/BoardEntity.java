package com.test.type.entity;

import com.test.type.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Entity 는 DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "BOARD")
public class BoardEntity {
    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(name = "boardWriter", length = 20, nullable = false) // 컬럼 크기는 20, NOT NULL
    private String board_writer;

    @Column // 크기 255, null 가능
    private  String board_pass;

    @Column
    private  String board_title;

    @Column
    private  String board_contents;

    @Column
    private  int board_hits;

    //DTO 객체를 Entity 로 옮겨담기
    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_writer(boardDTO.getBoard_writer());
        boardEntity.setBoard_pass(boardDTO.getBoard_pass());
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_hits(0);
        return boardEntity;
    }
}