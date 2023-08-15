package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.ProductBO;

public interface IProductDAO {
	
	public List<ProductBO> fetchProductByName(String name1, String name2);
}
