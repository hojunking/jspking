package co.song.data.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.data.common.Command;
import co.song.data.serviceImpl.TestServiceImpl;

public class Main implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		TestServiceImpl dao = new TestServiceImpl();
		request.setAttribute("list", dao.testSelectList());
		
		return "main";
	}

}
