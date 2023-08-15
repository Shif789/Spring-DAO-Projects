package in.ineuron.bo;

public class StudentBO {
	private int sid;
	private String sname;
	private String saddress;
	private int sage;

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

	@Override
	public String toString() {
		return "StudentBO [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

}
