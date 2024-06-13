package gerCursos.view;

import java.util.Scanner;

public class MenuCourse {
	
	public static Integer mainMenuCourse(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		sb.append("<---------------------------------->");
		sb.append("\nMenu Curso                         >");
		sb.append("\n                                   >");
		sb.append("\n1 - Cadastrar novo Curso           >");
		sb.append("\n2 - Atualizar Curso                >");
		sb.append("\n3 - Remover Curso                  >");
		sb.append("\n4 - Consultar Curso                >");
		sb.append("\n5 - Lista de Cursos                >");
		sb.append("\n6 - Matricular Estudantes no Curso >");
		sb.append("\n7 - Remover Estudantes do Curso    >");
		sb.append("\n8 - Lista de Estudantes por Curso  >");
		sb.append("\n0 - Voltar para o Menu principal   >");
		sb.append("\n<---------------------------------->");
		System.out.println(sb.toString());
		return sc.nextInt();
	}
}
