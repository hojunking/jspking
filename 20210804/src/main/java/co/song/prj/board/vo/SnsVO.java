package co.song.prj.board.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class SnsVO extends CommentsVO{
	private int sNO;
	private String sWriter;
	private Date sDate;
	private String sTitle;
	private String sContents;
	private int sAno;
	private int sHit;

}
