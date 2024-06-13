package gerCursos.services.initial;

import java.util.Scanner;

import db.DB;
import gerCursos.entities.Course;
import gerCursos.services.courses.CourseViewController;
import gerCursos.services.documents.DocumentsViewController;
import gerCursos.services.finance.FinanceViewController;
import gerCursos.services.report.ReportViewController;
import gerCursos.services.students.StudentViewController;
import gerCursos.view.MenuCourse;
import gerCursos.view.MenuDocuments;
import gerCursos.view.MenuFinance;
import gerCursos.view.MenuReport;
import gerCursos.view.MenuStudent;
import gerCursos.view.MenuView;

public class RunEverythingService {
	
	public void execute() {
		Integer index = 0;
		Course course = null;
		Scanner sc = new Scanner(System.in);
		
		while(!(index == null) &&  index != 9) {
			index = MenuView.mainMenu(sc);
			switch (index) {
			case 1:
				Integer optChoice1 = MenuStudent.mainMenuStudent(sc);
				new StudentViewController().callService(optChoice1,sc);
				break;
			case 2:
				Integer optChoice2 = MenuCourse.mainMenuCourse(sc);
				new CourseViewController().callService(optChoice2,sc,course);
				break;
			case 3:
				Integer optChoice3 = MenuFinance.mainMenuFinance(sc);
				new FinanceViewController().callService(optChoice3,sc);
				break;
			case 4:
				Integer optChoice4 = MenuReport.mainMenuReport(sc);
				new ReportViewController().callService(optChoice4,sc);
				break;
			case 5:
				Integer optChoice5 = MenuDocuments.mainMenuDocuments(sc);
				new DocumentsViewController().callService(optChoice5,sc);
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("Fim de execução \n");
				break;
			default:
				System.out.println("Opção inválida");;
			}
		}
		
		DB.closeConnection();
	}
}
