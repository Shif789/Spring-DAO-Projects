package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.DTO.ProductDTO;
import in.ineuron.bo.ProductBO;
import in.ineuron.dao.IProductDAO;

@Service
public class StudentManagementServiceImpl implements IProductManagementService {

	@Autowired
	private IProductDAO empDao;


	@Override
	public List<ProductDTO> fetchProductByName(String name1, String name2) {
		List<ProductBO> boList = empDao.fetchProductByName(name1, name2);
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();

		boList.forEach(bo -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(bo, dto);
			
			dtoList.add(dto);

		});
		return dtoList;
	}

}
