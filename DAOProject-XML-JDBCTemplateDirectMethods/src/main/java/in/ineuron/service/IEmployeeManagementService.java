package in.ineuron.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeManagementService {

	public int fetchEmpsCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String, Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desig2);
	public int insertEmp(String ename, int eage,String eaddress);
	public int addBounsToEmpByDesig(String desig, int bonus);

}
