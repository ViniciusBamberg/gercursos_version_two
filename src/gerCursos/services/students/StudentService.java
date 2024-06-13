package gerCursos.services.students;

import java.util.List;
import java.util.Scanner;

import gerCursos.dao.DaoFactory;
import gerCursos.dao.StudentDao;
import gerCursos.entities.Course;
import gerCursos.entities.Student;

public class StudentService {
	
	Student student = new Student();
	 
	StudentDao studentDao = DaoFactory.createStudentDao();
	
	public void insertStudent(Scanner sc) {
	    Student student = new Student();
	    
	    System.out.print("Digite o nome do aluno: ");
	    sc.nextLine();
	    String name = sc.nextLine();
	    student.setName(name);
	    	    
	    System.out.print("Digite o CPF: ");
	    String cpf = sc.nextLine();
	    student.setCpf(cpf);
	    
	    System.out.print("Digite o endereço: ");
	    String address = sc.nextLine();
	    student.setAddress(address);
	    
	    System.out.print("Digite o email: ");
	    String email = sc.nextLine();
	    student.setEmail(email);
	    
	    System.out.print("Digite o telefone: ");
	    String phone = sc.nextLine();
	    student.setPhone(phone);
	    
	    System.out.print("Situação da Matrícula (Não Pago/ Pago/ Cancelado/ Atrasado): ");
	    String status = sc.nextLine();
	    student.setStatus(status);
	    	    
	    studentDao.insert(student);
	    	    
	    System.out.println("Aluno cadastrado com sucesso");
	}
	
	public void updateStudent(Integer id, Scanner sc) {
	    System.out.println("Lista de alunos para alteração: ");

	    List<Student> students = listStudent();
	   
	    System.out.println("Digite o índice do aluno que deseja atualizar: ");
	    int studentId = sc.nextInt();

	    	/*
	    	 * <<<<<<<<< ALERTA >>>>>>>>
	    	 * Aqui faz mais sentido validar se o numero digitado é diferente de 0 e se 
	    	 * a lista é vazia ou nula, conforme está abaixo
	    	 * 
	    	 * studentId < students.size()
	    	 */
		    if (studentId >= 0  && students != null && !students.isEmpty() ) {
		    	/**
		    	 * <<<<<<<<<<<<<<<<ALERTAAA>>>>>>>>>>>>>>>>
		    	 * Tem que pegar o aluno baseado no id dele 
		    	 * e não no indice da lista 
		    	 */
		    	
		        Student studentToUpdate = getStudentById(studentId,students);
	
		        sc.nextLine();//Existe um bug no scanner por isso esse foi colocado aqui para ele não se perder na hora de cadastrar o nome 
		        System.out.print("Digite o novo nome: ");
		        String newName = sc.nextLine();
		        studentToUpdate.setName(newName);
		   
		        System.out.print("Digite o novo CPF: ");
				String newCpf = sc.nextLine();
				studentToUpdate.setCpf(newCpf);
				
				System.out.print("Digite o novo endereço: ");
				String newAddress = sc.nextLine();
				studentToUpdate.setAddress(newAddress);
				
				System.out.print("Digite o novo email: ");
				String newEmail = sc.nextLine();
				studentToUpdate.setEmail(newEmail);
	
				System.out.print("Digite o telefone: ");
				String newPhone = sc.nextLine();
				studentToUpdate.setPhone(newPhone);
				
				System.out.print("Situação da Matrícula (Não Pago/ Pago/ Cancelado/ Atrasado): ");
			    String status = sc.nextLine();
			    studentToUpdate.setStatus(status);
			  
			    studentDao.update(studentToUpdate);
	
		        System.out.println("Aluno atualizado com sucesso! ");
		    } 
		    else {
		        System.out.println("Índice inválido. Nenhuma atualização realizada.");
		    }
	 	}
		
	public void deleteStudent(Scanner sc) {
		 System.out.println("Lista de alunos para remoção:");
		    
		 List<Student> students = listStudent();

	    System.out.println("Deseja remover qual aluno? (Digite o índice) ");
	    int studentId = sc.nextInt();
	    
	    if (studentId >= 0  && students != null && !students.isEmpty() ) {
	    		studentDao.deleteById(studentId);
	    		
		        System.out.println("Aluno removido com sucesso!");
		    } 
		    else {
		        System.out.println("Índice inválido. Nenhum aluno removido.");
		    }
	}	
	
	public Student readStudent(Scanner sc) {
	    try {
	        System.out.println("Lista de alunos:");
	        
	        List<Student> students = listStudent();
	        
	        System.out.println("Deseja consultar qual aluno? (Digite o índice) ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        
	        boolean found = false;
	        for (Student student : students) {
	            if (student.getId() == id) {
	            	studentDao.findById(id);
	                System.out.println(student);
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Aluno não encontrado");
	        }
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	        sc.nextLine();
	    }
	    
	    return null;
	}

	public List<Student> listStudent() {
		
		List<Student> students = studentDao.findAll();
		System.out.println("Estudantes disponíveis:");
        for (Student student : students) {
            System.out.println("Id: " + student.getId() + ", Nome: " + student.getName());
        }
        return students;
	}
	
	public Student getStudentById(Integer index,List<Student> students) {
		for (Student student : students) {
			if(student.getId() == index) {
				return student;
			}
		}
		return null;
	}
	
	/*public void findByCourse(Course course, Scanner sc){
		try {
			boolean found = false;
			course = new Course();
			List<Student> students = studentDao.findByCourse(course);
			for (Student obj : students) {
				studentDao.findByCourse(course);
				System.out.println(obj);
			}
			if (!found) {
	            System.out.println("Aluno não encontrado");
			}
	    } 
		catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	        sc.nextLine();
	    }			
	}*/
}