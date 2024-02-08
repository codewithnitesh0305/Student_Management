package DAO;

import java.util.List;

import com.Entity.Student;

public interface StudentDAO {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int id);
	public Student getStudentById(int id);
	public List<Student> getAllStudent();
}
