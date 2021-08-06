package co.song.prj.command;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.song.prj.comm.Command;
import co.song.prj.image.service.FileInfoService;
import co.song.prj.image.vo.FileInformationVO;

public class FileUpload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		FileInfoService fileDao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();
		int maxFileSize = 5 * 1024*1024*100;
		System.out.println(request.getParameter("subject"));
		try {
			MultipartRequest part = new MultipartRequest
					(request, "d:/temp/", maxFileSize,"utf-8", new DefaultFileRenamePolicy());
			
			//enctype="multipart/form-data"를 사용하게 되면, request.getParameter가 사용이 불가능하다.
			
			String fileName = part.getFilesystemName("fileName"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			String orgfileName = part.getOriginalFileName("fileName"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
			
			
			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgfileName);
			vo.setDownFile(fileName);
			
			int n= fileDao.fileInsert(vo);
			if(n !=0) {
				request.setAttribute("message", vo.getFileName()+"파일업로드 성공");
			}else {
				request.setAttribute("message", orgfileName + "파일업로드 실패!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file/fileUploadResult";
	}

}
