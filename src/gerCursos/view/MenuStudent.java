package gerCursos.view;

import java.util.Scanner;

public class MenuStudent {
	
	public static Integer mainMenuStudent(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		sb.append("<---------------------------------->");
		sb.append("\nMenu ALUNO                         >");
		sb.append("\n                                   >");
		sb.append("\n1 - Cadastrar novo Aluno           >");
		sb.append("\n2 - Atualizar Aluno                >");
		sb.append("\n3 - Remover Aluno                  >");
		sb.append("\n4 - Consultar Aluno                >");
		sb.append("\n5 - Lista de Alunos                >");
		sb.append("\n0 - Voltar para o Menu principal   >");
		sb.append("\n<---------------------------------->");
		System.out.println(sb.toString());
		return sc.nextInt();
	}
}
