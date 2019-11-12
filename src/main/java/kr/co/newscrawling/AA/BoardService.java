package kr.co.newscrawling.AA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public List<BoardVO> selectAllBoard() {
		return dao.selectAll();
	}
	
	public BoardVO detailBoard(int num) {
		return dao.detail(num);
	}
	
	public void insertBoard(BoardVO vo) {
		dao.insert(vo);
	}
	
	public int modifyBoard(BoardVO vo) {
		return dao.modify(vo);
	}
	
	public int deleteBoard(int num) {
		return dao.delete(num);
	}
}
