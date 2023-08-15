package in.ineuron.service;

import java.util.List;

import in.ineuron.DTO.ProductDTO;

public interface IProductManagementService {

	public List<ProductDTO> fetchProductByName(String name1, String name2);
}
