package com.test.type.entity;

import com.test.type.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Entity 는 DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "board")
public class BoardEntity {
    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 20, nullable = false) // 컬럼 크기는 20, NOT NULL
    private String boardWriter;

    @Column // 크기 255, null 가능
    private  String boardPass;

    @Column
    private  String boardTitle;

    @Column
    private  String boardContents;

    @Column
    private  int boardHits;

    //DTO 객체를 Entity 로 옮겨담기
    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }
}