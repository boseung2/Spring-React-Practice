package org.zerock.springreactpractice.service;

import org.zerock.springreactpractice.dto.BoardDTO;
import org.zerock.springreactpractice.dto.PageRequestDTO;
import org.zerock.springreactpractice.dto.PageResultDTO;
import org.zerock.springreactpractice.entity.Board;
import org.zerock.springreactpractice.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);

    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto) {

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;

    }

    default BoardDTO entityToDTO(Board board, Member member, Long replycount) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replycount.intValue())
                .build();

        return boardDTO;

    }
}
