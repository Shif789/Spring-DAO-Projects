package in.ineuron.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.DTO.StudentDTO;
import in.ineuron.bo.StudentBO;

@Repository
public class StudentDAOImpl implements IStudentDAO {

	private static final String GET_STUDENT_BY_ID = "SELECT sid,sname,sage,saddress FROM studenthib WHERE sid=:no";

	private static final String GET_STUDENT_BY_NAME = "SELECT sid,sname,sage,saddress FROM studenthib WHERE sname IN (:name1,:name2)";

	private static final String GET_STUDENT_BY_ADDRESS = "SELECT sid,sname,sage,saddress FROM studenthib WHERE saddress IN (:city1,:city2)";

	private static final String GET_STUDENTNAME_BY_ID = "SELECT sname FROM studenthib WHERE sid=:no";

	private static final String INSERT_STUDENT = "INSERT INTO studenthib (sid,sname,sage,saddress) VALUES(:sid,:sname,:sage,:saddress)";

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public StudentBO fetchStudentNameByNo(int sno) {

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("no", sno);

		StudentBO studentBO = template.queryForObject(GET_STUDENT_BY_ID, map, new StudentMapper());
		StudentBO studentBO1 = template.queryForObject(GET_STUDENT_BY_ID, map,
				new BeanPropertyRowMapper<StudentBO>(StudentBO.class));
		return studentBO1;
	}

	private static class StudentMapper implements RowMapper<StudentBO> {

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("StudentDAOImpl.StudentMapper.mapRow()");

			StudentBO bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		}

	}

	@Override
	public List<StudentBO> fetchStudentByName(String name1, String name2) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name1", name1);
		map.addValue("name2", name2);

		return template.query(GET_STUDENT_BY_NAME, map, new RowMapper<StudentBO>() {

			@Override
			public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("StudentDAOImpl.fetchStudentByName()");
				StudentBO bo = new StudentBO();

				bo.setSid(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSage(rs.getInt(3));
				bo.setSaddress(rs.getString(4));

				return bo;
			}
		} /*
			 * (ResultSet rs, int rowNum) -> {
			 * System.out.println("StudentDAOImpl.fetchStudentByName()"); StudentBO bo = new
			 * StudentBO();
			 * 
			 * bo.setSid(rs.getInt(1)); bo.setSname(rs.getString(2));
			 * bo.setSage(rs.getInt(3)); bo.setSaddress(rs.getString(4));
			 * 
			 * return bo; }
			 */ /* new StudentMapper() */ /* new StudentRowMapper() */ );

	}

	private static class StudentRowMapper implements RowMapper<StudentBO> {
		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("StudentDaoImpl.StudentRowMapper.mapRow()");
			StudentBO bo = null;
			bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		}
	}

	@Override
	public List<StudentBO> fetchStudentByCity(String city1, String city2) {

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("city1", city1);
		map.addValue("city2", city2);
		
		// Using ResultSetExtractor interface

		List<StudentBO> listBO = template.query(GET_STUDENT_BY_ADDRESS, map, new ResultSetExtractor<List<StudentBO>>() {

			@Override
			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				System.out.println("StudentDAOImpl.fetchStudentByCity()");
				List<StudentBO> listBO = new ArrayList<StudentBO>();
				StudentBO bo = null;

				while (rs.next()) {
					bo = new StudentBO();
					bo.setSid(rs.getInt(1));
					bo.setSname(rs.getString(2));
					bo.setSage(rs.getInt(3));
					bo.setSaddress(rs.getString(4));
					listBO.add(bo);
				}
				return listBO;
			}

		});

		// Using RowMapperResultSetExtractor class

		List<StudentBO> listBO2 = template.query(GET_STUDENT_BY_ADDRESS, map,
				new RowMapperResultSetExtractor<StudentBO>(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)));

		// Using RowCallbackHandler Interface
		
		List<StudentBO> listBO3 = new ArrayList<StudentBO>();
		template.query(GET_STUDENT_BY_ADDRESS, map, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				System.out
						.println("StudentDAOImpl.fetchStudentByCity(...).new RowCallbackHandler() {...}.processRow()");
				StudentBO bo = null;
				bo = new StudentBO();
				bo.setSid(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSage(rs.getInt(3));
				bo.setSaddress(rs.getString(4));
				listBO3.add(bo);
			}
		});

		return listBO3;
	}

	@Override
	public int registerStudent(StudentBO studentBO) {
		BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(studentBO);
		
		return template.update(INSERT_STUDENT, beanPropertySqlParameterSource);
	}

	@Override
	public String getStudentNameByNo(int sno) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("no", sno);
		return template.queryForObject(GET_STUDENTNAME_BY_ID, map, String.class);
	}

}
