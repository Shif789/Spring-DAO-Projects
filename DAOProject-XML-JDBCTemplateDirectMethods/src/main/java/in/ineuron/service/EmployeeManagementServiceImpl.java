package in.ineuron.service;

import java.util.List;
import java.util.Map;

import in.ineuron.dao.IEmployeeDAO;

public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	private IEmployeeDAO empDao;
	
	
	public EmployeeManagementServiceImpl(IEmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public int fetchEmpsCount() {
		return empDao.getEmpsCount();
	}

	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return empDao.getEmployeeNameByNo(eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		
		return empDao.getEmployeeDetailsByNo(eno);
	}

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desig2) {
		return empDao.getEmployeeDetailsByDesignation(desg1, desig2);
	}

	@Override
	public int insertEmp(String ename, int eage, String eaddress) {
		return empDao.insertEmp(ename, eage, eaddress);
	}

	@Override
	public int addBounsToEmpByDesig(String desig, int bonus) {
		
		return empDao.addBounsToEmpByDesig(desig, bonus);
	}
	
}
