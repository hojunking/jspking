package co.song.prj.member.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String author;
	private int age;
	private String state;
	private String gender;
	
	public String check; //로그인 or 검색 상대를 체크합니다
	
	
}
