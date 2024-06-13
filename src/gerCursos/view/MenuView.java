package gerCursos.view;

import java.util.Scanner;

public class MenuView {

	
	public static Integer mainMenu(Scanner sc) {
		var menu = new StringBuilder();
		headerMenu();
		menu.append("1 - Aluno\n");
		menu.append("2 - Curso\n");
		menu.append("3 - Financeiro\n");
		menu.append("4 - Relatórios\n");
		menu.append("5 - Declarações\n");
		menu.append("9 - Sair\n");
		
		System.out.println(menu.toString());
		
		return sc.nextInt();
	}
	
	private static void headerMenu() {
		var header = new StringBuilder();
		header.append("<====================================>\n");
		header.append("< gerCursos --- Program v1.0         >\n");
		header.append("<====================================>\n");
		System.out.println(header.toString());
	}
}
