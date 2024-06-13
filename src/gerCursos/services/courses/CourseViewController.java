package gerCursos.services.courses;

import java.util.Scanner;

import gerCursos.entities.Course;
import gerCursos.services.initial.RunEverythingService;
import gerCursos.view.MenuCourse;

public class CourseViewController {
	
	private final CourseService service = new CourseService();

	public void callService(Integer index, Scanner scanner, Course course) {
		while(!(index == null) &&  index != 9) {
			switch (index) {
			case 1: 
				service.insertCourse(scanner);
				break;
			case 2:
				service.updateCourse(index, scanner);
				break;
			case 3:
				service.deleteCourse(scanner);
				break;
			case 4:
				service.readCourse(scanner);
				break;
			case 5:
				service.listCourse();
				break;
			case 6:
				service.associationStudentToCourse(scanner);
				break;
			case 7:
				service.removeStudentFromCourse(scanner);
				break;
			case 8:
				service.findByCourse(scanner);
				break;
			case 0:
				new RunEverythingService().execute();
				break;
			default:
				System.out.println("Opção inválida");		
			}
			Integer optChoice = MenuCourse.mainMenuCourse(scanner);
			new CourseViewController().callService(optChoice,scanner, course);
		}
	}
}
