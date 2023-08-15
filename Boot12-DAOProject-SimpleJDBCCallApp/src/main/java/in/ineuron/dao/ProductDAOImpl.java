package in.ineuron.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.ProductBO;

@Repository
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBO> fetchProductByName(String name1, String name2) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
				.withProcedureName("P_GET_PRODUCT_DETAILS_BY_NAME")
				.returningResultSet("products", new BeanPropertyRowMapper<ProductBO>(ProductBO.class));

		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("name1", name1);
		map.put("name2", name2);

		Map<String, Object> result = simpleJdbcCall.execute(map);
		List<ProductBO> listProductBO = (List<ProductBO>) result.get("products");

		return listProductBO;

	}

}
