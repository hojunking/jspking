package co.song.prj.image.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.song.prj.comm.DataSource;
import co.song.prj.image.vo.FileInformationVO;

public class FileInfoService {
	private SqlSession sqlSession =DataSource.getInstance().openSession(true);
	private FileInfoMapper map= sqlSession.getMapper(FileInfoMapper.class);
	
	
	public List<FileInformationVO> fileSelectList(){
		return map.fileSelectList();
	}
	public FileInformationVO fileSelect(int key) {
		return map.fileSelect(key);
	}
	public int fileInsert(FileInformationVO vo) {
		return map.fileInsert(vo);
	}
	public int fileDelete(FileInformationVO vo) {
		return map.fileDelete(vo);
	}
	public int fileUpdate(FileInformationVO vo) {
		return map.fileUpdate(vo);
	}
}
