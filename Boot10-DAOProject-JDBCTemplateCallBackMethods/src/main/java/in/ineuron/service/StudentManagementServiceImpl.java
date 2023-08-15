package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.DTO.StudentDTO;
import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDAO;

@Service
public class StudentManagementServiceImpl implements IStudentManagementService {

	@Autowired
	private IStudentDAO empDao;

	@Override
	public StudentDTO fetchStudentNameByNo(int sno) {
		StudentBO bo = empDao.fetchStudentNameByNo(sno);

		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		dto.setSrNo(1);
		if (bo.getSage() > 20) {
			dto.setGrade("A");
		}

		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentByName(String name1, String name2) {
		List<StudentBO> boList = empDao.fetchStudentByName(name1, name2);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();

		boList.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if (bo.getSage() < 25) {
				dto.setGrade("D");
			} else if (bo.getSage() < 26) {
				dto.setGrade("C");
			} else if (bo.getSage() < 27) {
				dto.setGrade("B");
			} else if (bo.getSage() < 30) {
				dto.setGrade("A");
			} 

			dto.setSrNo(dtoList.size() + 1);
			dtoList.add(dto);

		});
		return dtoList;
	}

	@Override
	public List<StudentDTO> fetchStudentByCity(String city1, String city2) {
		List<StudentBO> boList = empDao.fetchStudentByCity(city1, city2);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();

		boList.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if (bo.getSage() < 25) {
				dto.setGrade("D");
			} else if (bo.getSage() < 26) {
				dto.setGrade("C");
			} else if (bo.getSage() < 27) {
				dto.setGrade("B");
			} else if (bo.getSage() < 30) {
				dto.setGrade("A");
			} 

			dto.setSrNo(dtoList.size() + 1);
			dtoList.add(dto);

		});
		return dtoList;
	}

}
