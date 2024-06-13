package gerCursos.services.students;

import java.util.Scanner;

import gerCursos.services.initial.RunEverythingService;
import gerCursos.view.MenuStudent;

public class StudentViewController {
	
	private final StudentService service = new StudentService();
	
	public void callService(Integer index,Scanner scanner) {
		switch (index) {
		case 1:
			service.insertStudent(scanner);
			break;
		case 2:
			service.updateStudent(index, scanner);
			break;
		case 3:
			service.deleteStudent(scanner);
			break;
		case 4:
			service.readStudent(scanner);
			break;
		case 5:
			service.listStudent();
			break;
		case 0:
			new RunEverythingService().execute();
		default:
			System.out.println("Opção inválida");
		}
		Integer optChoice = MenuStudent.mainMenuStudent(scanner);
		new StudentViewController().callService(optChoice,scanner);
	}
}
