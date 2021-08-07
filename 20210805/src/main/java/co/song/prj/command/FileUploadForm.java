package co.song.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.comm.Command;

public class FileUploadForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "file/fileUploadForm";
	}

}
