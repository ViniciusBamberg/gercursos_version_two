package gerCursos.services.report;

import java.util.Scanner;

import gerCursos.services.initial.RunEverythingService;
import gerCursos.view.MenuReport;

public class ReportViewController {
	
	private final ReportService report = new ReportService();
	
	public void callService(Integer index,Scanner scanner) {
		switch (index) {
		case 1:
			report.registeredCourses();
			break;
		case 2:
			report.registeredStudents();
			break;
		case 3:
			report.totalTransactions();
			break;
		case 0:
			new RunEverythingService().execute();
		default:
			System.out.println("Opção inválida");
		}
		Integer optChoice = MenuReport.mainMenuReport(scanner);
		new ReportViewController().callService(optChoice,scanner);
	}
}

