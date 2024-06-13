package gerCursos.services.report;

import java.util.List;

import gerCursos.entities.Course;
import gerCursos.entities.Student;
import gerCursos.entities.Transaction;
import gerCursos.services.courses.CourseService;
import gerCursos.services.finance.TransactionRepository;
import gerCursos.services.students.StudentService;

public class ReportService {
	CourseService repositoryCourses = new CourseService();
	StudentService repositoryStudents = new StudentService();
    TransactionRepository transactions = new TransactionRepository();

    public ReportService() {
    }

    public List<Course> registeredCourses() {
    	return repositoryCourses.listCourse();
    }

    public List<Student> registeredStudents() {
    	return repositoryStudents.listStudent();
    }

    public List<Transaction> totalTransactions() {
        return transactions.getAllTransactions();
    }
}
