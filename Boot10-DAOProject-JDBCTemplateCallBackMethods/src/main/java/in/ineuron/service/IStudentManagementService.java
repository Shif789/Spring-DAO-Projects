package in.ineuron.service;

import java.util.List;

import in.ineuron.DTO.StudentDTO;

public interface IStudentManagementService {

	public StudentDTO fetchStudentNameByNo(int eno);
	public List<StudentDTO> fetchStudentByName(String name1, String name2);
	public List<StudentDTO> fetchStudentByCity(String city1, String city2);

}
