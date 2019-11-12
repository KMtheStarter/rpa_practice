package kr.co.newscrawling.AA;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	public List<BoardVO> selectAll() {
		return ss.selectList("BoardDAO.selectAll");
	}
	
	public BoardVO detail(int num) {
		return ss.selectOne("BoardDAO.detail", num);
	}
	
	public void insert(BoardVO vo) {
		ss.insert("BoardDAO.insert", vo);
	}
	
	public int modify(BoardVO vo) {
		return ss.update("BoardDAO.update", vo);
	}
	
	public int delete(int num) {
		return ss.delete("BoardDAO.delete", num);
	}
}
