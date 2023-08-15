package in.ineuron.DTO;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pid;
	private String pname;
	private Integer price;
	private Integer quantity;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductBO [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
