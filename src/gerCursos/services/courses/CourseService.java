package gerCursos.services.courses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import gerCursos.dao.CourseDao;
import gerCursos.dao.DaoFactory;
import gerCursos.dao.StudentDao;
import gerCursos.entities.Course;
import gerCursos.entities.Student;

public class CourseService {
	
	CourseDao courseDao = DaoFactory.createCourseDao();
	StudentDao studentDao = DaoFactory.createStudentDao();
	
	public void insertCourse(Scanner sc) {
		try {
			Course course = new Course();
			
			System.out.print("Digite um curso: ");
			sc.nextLine();
			String name = sc.nextLine();
			course.setName(name);
			
			System.out.print("Digite um professor: ");
			String teacher = sc.nextLine();
			course.setTeacher(teacher);
			
			System.out.print("Descrição do curso: ");
			String description = sc.nextLine();
			course.setDescription (description);
			
			Date start = inputDate2("Data de início(dd/MM/yyyy): ",sc);
			course.setStart(start);
			
			Date end = inputDate2("Data final(dd/MM/yyyy): ",sc);
			course.setEnd(end);
			
			System.out.print("Valor do curso: ");
			Double courseValue = sc.nextDouble();
			course.setCourseValue(courseValue);
			
			System.out.print("Valor da matrícula: ");
			Double registrationValue = sc.nextDouble();
			course.setRegistrationValue(registrationValue);
			
			System.out.print("Quantidade de alunos: ");
			Integer studentsQuantity = sc.nextInt();
			course.setStudentsQuantity(studentsQuantity);
			
			sc.nextLine();
			System.out.print("Situação do curso (Inscrições/ Em andamento/ Concluído): ");		   
			String status = sc.nextLine();
			course.setStatus(status);
			
		    courseDao.insert(course);
						
			System.out.println("Curso cadastrado com sucesso");
		}
		catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        sc.nextLine();
        }
	}
	
	public void updateCourse(Integer id, Scanner sc) {
	    try {
		    System.out.println("Lista de cursos para alteração:");
	
		    List<Course> courses = listCourse();
		 
		    System.out.println("Digite o índice do curso que deseja atualizar: ");
		    int courseId = sc.nextInt();
	
		    	if (courseId >= 0  && courses != null && !courses.isEmpty() ) {
			        Course courseToUpdate = getCourseById(courseId,courses);
			        
			        sc.nextLine();
			        System.out.print("Digite o novo nome: ");
			        String newName = sc.next();
			        courseToUpdate.setName(newName);
			        
			        sc.nextLine();
			        System.out.print("Digite um professor: ");
					String newTeacher = sc.nextLine();
					courseToUpdate.setTeacher(newTeacher);
									
					System.out.print("Descrição do curso: ");
					String newDescription = sc.nextLine();
					courseToUpdate.setDescription (newDescription);
					
					Date newStart = inputDate2("Data de início(dd/MM/yyyy): ",sc);
					courseToUpdate.setStart(newStart);
					
					Date newEnd = inputDate2("Data final(dd/MM/yyyy): ",sc);
					courseToUpdate.setEnd(newEnd);
					
					System.out.print("Valor do curso: ");
					Double newCourseValue = sc.nextDouble();
					courseToUpdate.setCourseValue(newCourseValue);
					
					System.out.print("Valor da matrícula: ");
					Double newRegistrationValue = sc.nextDouble();
					courseToUpdate.setRegistrationValue(newRegistrationValue);
					
					System.out.print("Quantidade de alunos: ");
					Integer newStudentsQuantity = sc.nextInt();
					courseToUpdate.setStudentsQuantity(newStudentsQuantity);
					
					sc.nextLine();
					System.out.print("Situação do curso (Inscrições/ Em andamento/ Concluído): ");		   
					String newStatus = sc.nextLine();
				    courseToUpdate.setStatus(newStatus);
				    
				    courseDao.update(courseToUpdate);
									 
			        System.out.println("Curso atualizado com sucesso! " );
			    } 
			    else {
			        System.out.println("Índice inválido. Nenhuma atualização realizada.");
			    }
	    }
		catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	        sc.nextLine();
	    }
	}

	public void deleteCourse(Scanner sc) {
		try {

			System.out.println("Lista de cursos para remoção:");

			List<Course> courses = listCourse();

			System.out.println("Deseja remover qual curso? (Digite o índice) ");
			int courseId = sc.nextInt();

			if (courseId >= 0 && courses != null && !courses.isEmpty()) {
				courseDao.deleteById(courseId);
				System.out.println("Curso removido com sucesso!");
			} else {
				System.out.println("Índice inválido. Nenhum curso removido.");
			}
		} 
		catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			sc.nextLine();
		}
	}	
	
	public Course readCourse(Scanner sc) {
		try {
	        System.out.println("Lista de cursos:");
	       
	        List<Course> courses = listCourse();
	        
	        System.out.println("Deseja consultar qual curso? (Digite o índice) ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        
	        boolean found = false;
	        for (Course course : courses) {
	            if (course.getId() == id) {
	            	courseDao.findById(id);
	                System.out.println(course);
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Curso não encontrado");
	        }
		}
		catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	        sc.nextLine();
	    }
		
		return null;
	}

	public List<Course> listCourse() {
		
		List<Course> courses = courseDao.findAll();
		 System.out.println("Cursos disponíveis:");
		    for (Course course : courses) {
		        System.out.println("Id: " + course.getId() + ", Nome: " + course.getName());
		    }	
		return courses;
	}
	
	public void associationStudentToCourse(Scanner sc) {
	    try {
	    	List<Course> courses = listCourse();

	        System.out.print("Escolha o índice do curso: ");
	        int courseId = sc.nextInt();
	        sc.nextLine();

	        if (courseId < 1 || courseId > courses.size()) {
	            System.out.println("Número de curso inválido.");
	            return;
	        }

	       //Course course = courses.get(courseId - 1);
	       //System.out.println("Curso selecionado: " + course.getName());
	       
	        Course selectedCourse = null;
			for (Course course : courses) {
				if (course.getId() == courseId) {
					selectedCourse = course;
					System.out.println("Curso selecionado: " + selectedCourse.getName());
					break;
				}
			}
	        
	        List<Student> students = studentDao.findAll();
	        
	        System.out.println("Estudantes disponíveis:");
	        for (int i = 0; i < students.size(); i++) {
	            System.out.println((i + 1) + ". " + students.get(i).getName());
	        }

	        System.out.print("Quantidade de alunos a serem associados: ");
	        int studentsQuantity = sc.nextInt();
	        sc.nextLine();

	        for (int i = 0; i < studentsQuantity; i++) {
	            System.out.print("Escolha o número do aluno " + (i + 1) + ": ");
	            int studentId = sc.nextInt();
	            sc.nextLine();

	            if (studentId < 1 || studentId > students.size()) {
	                System.out.println("Número de aluno inválido.");
	                return;
	            }

	            Student student = students.get(studentId - 1);

	            selectedCourse.addStudent(student);
	        }

	        courseDao.associationCourseDao(selectedCourse);

	        System.out.println("Estudantes associados ao curso com sucesso.");
	    } 
		catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, insira um número.");
        sc.nextLine(); 
	    }
		catch (Exception e) {
	        System.out.println("Ocorreu um erro: " + e.getMessage());
	    }
	}

	public void removeStudentFromCourse(Scanner sc) {
		try {

			List<Course> courses = listCourse();

			System.out.print("Escolha o Id do curso: ");
			int courseId = sc.nextInt();
			sc.nextLine();

			Course selectedCourse = null;
			for (Course course : courses) {
				if (course.getId() == courseId) {
					selectedCourse = course;
					System.out.println("Curso selecionado: " + selectedCourse.getName());
					break;
				}
			}

			if (selectedCourse == null) {
				System.out.println("Curso com Id " + courseId + " não encontrado.");
				return;
			}

			List<Student> studentsInCourse = courseDao.findByCourse(selectedCourse);
			
			System.out.println("Estudantes no curso:");
	        for (int i = 0; i < studentsInCourse.size(); i++) {
	            System.out.println((i + 1) + ". " + studentsInCourse.get(i).getName());
	        }

			if (studentsInCourse.isEmpty()) {
				System.out.println("Não há estudantes neste curso.");
				return;
			}
			
			System.out.print("Escolha o Id do estudante a ser removido: ");
			int studentId = sc.nextInt();
			sc.nextLine();

			selectedCourse.removeStudentById(studentId);

			courseDao.removeStudentFromCourse(courseId, studentId);

			System.out.println("Estudante removido do curso com sucesso.");

		} 
		catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, insira um número.");
			sc.nextLine();
		} 
		catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
	} 
	
	public List<Student> findByCourse(Scanner sc){
		try {
			System.out.println("Lista de cursos: ");

			List<Course> courses = listCourse();

			System.out.println("Deseja verificar os estudantes de qual curso? (Digite o índice) ");
			int courseId = sc.nextInt();

			Course selectedCourse = null;
			for (Course course : courses) {
				if (course.getId() == courseId) {
					selectedCourse = course;
					System.out.println("Curso selecionado: " + selectedCourse.getName());
					break;
				}
			}

			if (selectedCourse != null) {
				List<Student> students = courseDao.findByCourse(selectedCourse);
				if (students.isEmpty()) {
					throw new RuntimeException("Nenhum estudante encontrado para o curso: " + selectedCourse.getName());
				}
				return students;
			} else {
				throw new IllegalArgumentException("Nenhum curso encontrado com o Id fornecido: " + courseId);
			}
		} 
		catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			sc.nextLine();
		}
		return null;
	}
	
	public Course getCourseById(Integer index,List<Course> courses) {
		for (Course course : courses) {
			if(course.getId() == index) {
				return course;
			}
		}
		return null;
	}
	
	public Date inputDate2(String message,Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while (true) {
			try {
				System.out.print(message);
				return sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				System.out.println("Formato de data inválido. Usar o formato dd/MM/yyyy.");
			}
		}
	}
}