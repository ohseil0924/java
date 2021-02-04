package seil.service;

import java.util.List;

import seil.dao.DaoImpl;
import seil.dao.IDao;
import seil.vo.VO;

public class Servicelmpl implements IServic{
	private IDao boardDao;
	
	
	public Servicelmpl() {
		boardDao = new DaoImpl();
	}

	
	
	@Override
	public int insertBoard(VO boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public List<VO> displayAll() {
		return boardDao.displayAll();
	}

	@Override
	public List<VO> search(String word) {
		return boardDao.search(word);
	}

	@Override
	public VO displayOne(int boardNo) {
		return boardDao.displayOne(boardNo);
	}

	@Override
	public int update(VO boardVO) {
		return boardDao.update(boardVO);
	}

	@Override
	public int upCnt(int boardNo) {
		return boardDao.upCnt(boardNo);
	}
	
}
