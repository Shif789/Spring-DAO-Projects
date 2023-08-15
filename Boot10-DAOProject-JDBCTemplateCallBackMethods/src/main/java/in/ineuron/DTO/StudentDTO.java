package in.ineuron.DTO;

import java.io.Serializable;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int srNo;
	private String grade;

	private int sid;
	private String sname;
	private String saddress;
	private int sage;


	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StudentDTO [srNo=" + srNo + ", sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage="
				+ sage + ", grade=" + grade + "]";
	}

}
