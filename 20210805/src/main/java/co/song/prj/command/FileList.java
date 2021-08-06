package co.song.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.comm.Command;
import co.song.prj.image.service.FileInfoService;

public class FileList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FileInfoService fileDao= new FileInfoService();
		request.setAttribute("files", fileDao.fileSelectList());
		
		return "file/fileList";
	}

}
