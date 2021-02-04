package kr.or.ddit.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.BoardServiceImpl;
import kr.or.ddit.mvc.service.IBoardService;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardController {
	private Scanner sc = new Scanner(System.in);
	private IBoardService service;
	private int choice;
	private boolean choicechk;
	public BoardController() {
		service = new BoardServiceImpl();
	}

	public static void main(String[] args) {
		new BoardController().boardStart();
		
	}
	
	// 시작
	public void boardStart(){
		while(true){
			if(!choicechk) {
				displayAll();
				choice = menu();
			}
			
			switch(choice){
			case 1:	// 새글작성
				insert();
				choicechk = false;
				
				break;
			case 2:	// 게시글 보기
				displayOne();
				choicechk =false;
				break;
			case 3:	// 검색
				search();
				choicechk = true; 
				choice = menu();
				break;
			case 0:	// 작업 끝
				System.out.println("작업을 종료합니다.");
				System.exit(0);
			default:
				choicechk =false;
				break;
			}
		}
	}
	
	// 메뉴바
	private int menu(){
		System.out.println("메뉴 : 1.새글작성\t2.게시글보기\t3.검색\t0.작업끝");
		System.out.print("작업 선택 >> ");
		choice = sc.nextInt();
		return choice;
	}
	
	
	// 전체 게시글 보여주기
	private void displayAll(){
		List<BoardVO> boardList = service.displayAll();
		
		System.out.println();
		System.out.println("------------------------------------------------------------");;
		System.out.println("No	        제 목            작성자 	조회수   ");
		System.out.println("------------------------------------------------------------");
		if(boardList == null || boardList.size() == 0){
			System.out.println();
			System.out.println("  등록된 게시글 없음  ");
			System.out.println();
		} else{  
			for(BoardVO boardVo : boardList){
				System.out.print(boardVo.getBoard_no() + "\t\t");
				System.out.print(boardVo.getBoard_title() + "\t\t");
				System.out.print(boardVo.getBoard_writer() + "    \t");
				System.out.println(boardVo.getBoard_cnt() + "\t");
			}
		}
		System.out.println("------------------------------------------------------------");
	}
	
	// 새 글 작성
	private void insert(){
		sc.nextLine();
		System.out.println();
		System.out.println("새 글 작성하기 ------------------------");
		System.out.println();
		System.out.print("- 제목 : ");
		String title = sc.nextLine();
		System.out.print("- 글 작성자 : ");
		String writer = sc.next();
		sc.nextLine();
		System.out.print("- 내용 : ");
		String content = sc.nextLine();
		System.out.println();
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		int cnt = service.insertBoard(boardVo);
		
		if(cnt > 0){
			System.out.println("새 글이 추가되었습니다.");
		}else{
			System.out.println("새 글이 추가되지 않았습니다.");
		}
	}
	
	// 게시글보기
	public void displayOne(){
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int boardNo = sc.nextInt();
		System.out.println();
		int cnt = service.upCnt(boardNo);
		BoardVO boardVo = new BoardVO();
		boardVo = service.displayOne(boardNo);
		System.out.println(boardNo + "번 글 내용");
		System.out.println("------------------------------------------------------------");
		System.out.println("-제목 : " + boardVo.getBoard_title());
		System.out.println("-작성자 : " + boardVo.getBoard_writer());
		System.out.println("-내용 : " + boardVo.getBoard_content());
		System.out.println("-작성일 : " + boardVo.getBoard_date());
		System.out.println("-조회수 : " + boardVo.getBoard_cnt());
		System.out.println("------------------------------------------------------------");
		System.out.println("메뉴 : 1.수정\t2.삭제\t3.리스트로 가기");
		System.out.print("작업선택 >> ");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			update(boardVo);
			break;
		case 2:
			delete(boardNo);
			break;
		case 3:
			return;
		}
	}
	
	private void update(BoardVO boardVo){
		sc.nextLine();
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		String title = sc.nextLine();
		System.out.print("- 내  용 : ");
		String content = sc.nextLine();
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		int cnt = service.updateBoard(boardVo);
		
		if(cnt > 0){
			System.out.println(boardVo.getBoard_no()  + "번 글이 수정되었습니다.");
		}else{
			System.out.println("수정 실패!");
		}	
	}
	
	private void delete(int boardNo){
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt > 0){
			System.out.println(boardNo  + "번 글이 삭제되었습니다.");
		}else{
			System.out.println("삭제 실패!");
		}	
	}
	
	private void search(){
		List<BoardVO> boardList = new ArrayList<>();

		System.out.println();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		String word = sc.next();
		System.out.println();
		if(word != null){
			boardList = service.search(word);
		} else{
			return;
		}
		System.out.println("------------------------------------------------------------");
		System.out.println("No	        제 목            작성자 	조회수   ");
		System.out.println("------------------------------------------------------------");
		if(boardList == null || boardList.size() == 0){
			System.out.println();
			System.out.println("  등록된 게시글 없음  ");
			System.out.println();
		} else{
			for(BoardVO boardVo : boardList){
				System.out.print(boardVo.getBoard_no() + "\t\t");
				System.out.print(boardVo.getBoard_title() + "\t\t");
				System.out.print(boardVo.getBoard_writer() + "\t\t");
				System.out.println(boardVo.getBoard_cnt() + "\t");
			}
		}
		System.out.println("------------------------------------------------------------");
	}
	
}








