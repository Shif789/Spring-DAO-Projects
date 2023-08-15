package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String SQL_SELECT_QUERY = "SELECT count(*) FROM employees";
	private static final String SQL_SELECT_QUERY_BY_ID = "SELECT name FROM employees WHERE id=?";
	private static final String GET_EMPLOYEE_BY_NAME = "SELECT id,name,age,address FROM employees WHERE id=?";
	private static final String GET_EMPLOYEE_BY_DESIG = "SELECT id,name,age,address FROM employees WHERE address in (?,?) order by age";
	private static final String INSERT_QUERY = "INSERT INTO employees (name,age,address) VALUES (?,?,?)";
	private static final String ADD_BONUS_BY_DESIG = "UPDATE employees3 SET esalary=esalary+? WHERE eaddress=?";
	private JdbcTemplate template;
	
	public EmployeeDAOImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int getEmpsCount() {
		return template.queryForObject(SQL_SELECT_QUERY, Integer.class);
	}

	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return template.queryForObject(SQL_SELECT_QUERY_BY_ID, String.class,eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return template.queryForMap(GET_EMPLOYEE_BY_NAME, eno);
	}

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desig1, String desig2) {
		return template.queryForList(GET_EMPLOYEE_BY_DESIG,desig1, desig2);
	}

	@Override
	public int insertEmp(String ename, int eage, String eaddress) {
		return template.update(INSERT_QUERY,ename, eage,eaddress);
	}

	@Override
	public int addBounsToEmpByDesig(String desig, int bonus) {
		
		return template.update(ADD_BONUS_BY_DESIG,bonus, desig);
	}

}
