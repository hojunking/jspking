package co.song.prj.image.service;

import java.util.List;

import co.song.prj.image.vo.FileInformationVO;

public interface FileInfoMapper {
	List<FileInformationVO> fileSelectList();
	FileInformationVO fileSelect(int key);
	int fileInsert(FileInformationVO vo);
	int fileDelete(FileInformationVO vo);
	int fileUpdate(FileInformationVO vo);
}
