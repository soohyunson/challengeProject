package DTO;

public class ChallengeDTO {
	
	private int seq;
	private String title;
	private String content;
	private String start_date;
	private String end_date;
	private String end;
	private int total_participate;
	
	
	
	public ChallengeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChallengeDTO(int seq, String title, String content, String start_date, String end_date, String end,
			int total_participate) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.end = end;
		this.total_participate = total_participate;
	}
	public ChallengeDTO(String end_date) {
		super();
		this.end_date = end_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date=end_date;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getTotal_participate() {
		return total_participate;
	}
	public void setTotal_participate(int total_participate) {
		this.total_participate = total_participate;
	}
	

}
