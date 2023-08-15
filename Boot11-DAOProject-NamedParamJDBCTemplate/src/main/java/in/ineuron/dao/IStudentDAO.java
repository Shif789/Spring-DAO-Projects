package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.StudentBO;

public interface IStudentDAO {
	
	public StudentBO fetchStudentNameByNo(int sno);
	public List<StudentBO> fetchStudentByName(String name1, String name2);
	public List<StudentBO> fetchStudentByCity(String city1, String city2);
	public int registerStudent(StudentBO studentBO);
    public String getStudentNameByNo(int sno);
}
