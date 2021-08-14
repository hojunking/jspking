package co.song.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.comm.Command;
import co.song.prj.comm.DownLoadFile;

public class FileDownLoad implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path="c:/pracfile";
		String orgFileName=request.getParameter("orgFile");
		String downFileName=request.getParameter("downFile");
		
		DownLoadFile downLoadFile = new DownLoadFile(path, orgFileName, downFileName);
		//생성자 만들기
		boolean b = downLoadFile.isFileDown();
		response.setHeader("Content-Disposition", "attachment;filename=\"" + downFileName+"\";");
				if(!b) {
			request.setAttribute("message", "파일이 성공적으로 다운로드 되었습니다.");
		}else {
			request.setAttribute("message", "파일을 다운로드 하는데 실패했습니다");
		}
		System.out.println(request.getParameter("orgFile"));
		System.out.println(request.getParameter("downFile"));
		return "file/fileDownMessage";
		
	
	}
}
