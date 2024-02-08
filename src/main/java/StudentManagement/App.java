package StudentManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Entity.Student;

import DAO.StudentDAOImp;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		StudentDAOImp studentdao = context.getBean("studentdao", StudentDAOImp.class);
		// System.out.println(template.getDataSource().getConnection());
		Student student ;
		while(true) {
		System.out.println("-----------Student Management----------");
		System.out.println("1. Add Student");
		System.out.println("2. Update Student");
		System.out.println("3. Read Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Exit");
		System.out.println();
		System.out.println("Enter Your Choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the Student Name");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Enter the Student Address");
			String address = sc.nextLine();
			
			System.out.println("Enter the Student Course");
			String course = sc.nextLine();
			 student = new Student(name,address,course);
			int result = studentdao.insert(student);
			if(result == 1) {
				System.out.println("Insert data successfully");
			}else {
				System.out.println("Data not inserted");
			}
			break;
		case 2:
			System.out.println("Enter the Id of Student");
			int id = sc.nextInt();
			
			System.out.println("Enter the Name of Student");
			sc.nextLine();
			String name1 = sc.nextLine();
			
			System.out.println("Enter the Address of Student");
			String address1 = sc.nextLine();
			
			System.out.println("Enter the Course of Student");
			String course1 = sc.nextLine();
			student = new Student(id,name1,address1,course1);
			int result1 = studentdao.update(student);
			if(result1 == 1) {
				System.out.println("Update data successfully");
			}else {
				System.out.println("Data not updated");
			}
			break;
		case 3:
			System.out.println("1. Reterive All Data");
			System.out.println("2. Reterive data by Id");
			System.out.println("Enter Your Choice");
			int choice1 = sc.nextInt();
			switch(choice1) {
			case 1:
				List<Student> students = studentdao.getAllStudent();
				for(Student s : students) {
					System.out.println(s);
				}
				break;
			case 2:
				System.out.println("Enter the Id of Student");
				int sid = sc.nextInt();
				student = studentdao.getStudentById(sid);
				System.out.println(student);
				break;
			case 3:
				System.exit(0);
			}		
			break;		
		case 4:
			System.out.println("Enter the Id to be delete");
			int studentid = sc.nextInt();
			int result3 = studentdao.delete(studentid);
			if(result3 == 1) {
				System.out.println("Delete data successfully");
			}else {
				System.out.println("Data not deleted");
			}
			break;
		case 5:
			System.out.println("Thank You");
			System.exit(0);
		}
		
	}
}

}
