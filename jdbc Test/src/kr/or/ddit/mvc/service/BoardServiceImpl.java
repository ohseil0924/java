package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.BoardDaoImpl;
import kr.or.ddit.mvc.dao.IBoardDao;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao boardDao;
	
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public List<BoardVO> displayAll() {
		return boardDao.displayAll();
	}

	@Override
	public List<BoardVO> search(String word) {
		return boardDao.search(word);
	}

	@Override
	public BoardVO displayOne(int boardNo) {
		return boardDao.displayOne(boardNo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}
	@Override
	public int upCnt(int boardNo) {
		return boardDao.upCnt(boardNo);
	}

}