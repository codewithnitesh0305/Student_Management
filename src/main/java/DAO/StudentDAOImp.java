package DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.Student;

public class StudentDAOImp implements StudentDAO{
	private JdbcTemplate jdbcTemplate;
	
	public StudentDAOImp(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO student1(Name,Address,Cource) VALUES(?,?,?)";
		 int result = jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getCourse());
		return result;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		String query = "UPDATE student1 SET Name = ?,Address = ?,Cource = ? WHERE Id = ?";
		int result = jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getCourse(),student.getId());
		return result;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM student1 WHERE Id = ?";
		int result = jdbcTemplate.update(query,id);
		return result;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM student1 WHERE Id = ?";
		RowMapper<Student> rowMapper = new RowMapperImp();
		Student student = jdbcTemplate.queryForObject(query, rowMapper,id);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM student1";
		List<Student> student = jdbcTemplate.query(query, new RowMapperImp());
		return student;
	}

}
