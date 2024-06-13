package gerCursos.view;

import java.util.Scanner;

public class MenuFinance {
	
	public static Integer mainMenuFinance(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		sb.append("<---------------------------------->");
		sb.append("\nMenu Financeiro                    >");
		sb.append("\n                                   >");
		sb.append("\n1 - Lançamentos                    >");
		sb.append("\n2 - Fluxo de caixa                 >");
		sb.append("\n3 - Balanço mensal                 >");
		sb.append("\n4 - Remover Receitas ou Despesas   >");
		sb.append("\n0 - Voltar para o Menu principal   >");
		sb.append("\n<---------------------------------->");
		System.out.println(sb.toString());
		return sc.nextInt();
	}
}
