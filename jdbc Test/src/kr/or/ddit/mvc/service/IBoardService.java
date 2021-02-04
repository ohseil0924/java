package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;

public interface IBoardService {
	
	/**
	 * 새글작성
	 * @param boardVo BoardVo객체
	 * @return 결과 성공 1 실패 0
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * 전체 게시글 조회
	 * @return BoardVO객체를 담고 있는 List객체
	 */
	public List<BoardVO> displayAll();
	
	/**
	 * 검색 
	 * @param word String객체 검색 단어 입력
	 * @return BoardVO객체를 담고 있는 List객체로 리턴
	 */
	public List<BoardVO> search(String word);
	
	/**
	 * 번호 - 게시글 검색
	 * @param boardNo int객체 boardNo
	 * @return BoardVO객체로 리턴
	 */
	public BoardVO displayOne(int boardNo);
	
	/**
	 * 삭제
	 * @param boardNo 삭제할 boardNo
	 * @return 성공 1 실패 0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 수정
	 * @param boardVo 수정 내용 BoardVO객체
	 * @return 성공 1 실패 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 조회 수 올리기
	 * @param boardNo 조회수를 올릴 게시글 번호
	 * @return 성공 1 실패0
	 */
	public int upCnt(int boardNo);
	
}
