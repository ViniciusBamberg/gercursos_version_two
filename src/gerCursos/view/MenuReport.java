package gerCursos.view;

import java.util.Scanner;

public class MenuReport {
	
	public static Integer mainMenuReport(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n<---------------------------------->");
		sb.append("\nMenu Relatório                     >");
		sb.append("\n                                   >");
		sb.append("\n1 - Cursos Cadastrados             >");
		sb.append("\n2 - Alunos Cadastrados             >");
		sb.append("\n3 - Balanço Total                  >");
		sb.append("\n0 - Voltar para o Menu principal   >");
		sb.append("\n<---------------------------------->");
		System.out.println(sb.toString());
		return sc.nextInt();
	}
}
