package com.fpp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fpp.dao.BoardDao;
import com.fpp.dto.board.BoardDto;
import com.fpp.dto.board.FormDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSession sqlSession;

	// 게시글 작성
	@Override
	public void write(FormDto formDto) throws Exception {
		sqlSession.insert("board_mapper.insert", formDto);
	}
	// 게시글 리스트 조회
	@Override
	public List<FormDto> list() throws Exception {
		// TODO Auto-generated method stub

		return sqlSession.selectList("board_mapper.list");
	}
	
	// 게시글 번호로 조회
	@Override
	public FormDto read(int fno) throws Exception {

		return sqlSession.selectOne("board_mapper.read", fno);
	}
//
//	// 게시글 수정
//	@Override
//	public void update(BoardDto boardDto) throws Exception {
//
//		sqlSession.update("board_mapper.update", boardDto);
//	}
//
//	// 게시글 삭제
//	@Override
//	public void delete(int bno) throws Exception {
//
//		sqlSession.delete("board_mapper.delete", bno);
//	}

}