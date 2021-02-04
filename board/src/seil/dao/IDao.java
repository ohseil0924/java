package seil.dao;

import java.util.List;

import seil.vo.VO;

public interface IDao {
	
	
	
	/**
	 *  새글작성
	 * @param boardVo BoardVo객체
	 * @return 결과 성공1 실패 0
	 */
	public int insertBoard(VO boardVo);
	
	
	/**
	 * 전체 게시글 조회
	 * @return VO객체를 담고있는 List객체
	 */
	public List<VO> displayAll();
	
	/**
	 * 검색
	 * @param word String객체 검색 단어 입력
	 * @return BoardVO객체를 담고 있는 List객체로 리턴
	 */
	public List<VO> search(String word);
	
	
	/**
	 * 번호 - 게시글 검색
	 * @param boardNo int 객체 boardNo
	 * @return BoardVO객체로 리턴 
	 */
	public VO displayOne(int boardNo);
	
	
	
	public int deleteBoard(int boardNo);
	
	
	/**
	 * 수정
	 * @param boardVO 수정 내용 BoardVO객체
	 * @return 성공1 실패 0
	 */
	public int update(VO boardVO);
	
	/**
	 * 조회 수 올리기
	 * @param boardNo 조회수를 올릴 게시글 번호
	 * @return 성공1 실패 0
	 */
	public int upCnt(int boardNo);
	
	
}


















