package gerCursos.view;

import java.util.Scanner;

public class MenuDocuments {
	
	public static Integer mainMenuDocuments(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		sb.append("<---------------------------------->");
		sb.append("\nMenu Documentos                    >");
		sb.append("\n                                   >");
		sb.append("\n1 - Recibo de Pagamento            >");
		sb.append("\n2 - Recibo de Matrícula            >");
		sb.append("\n3 - Declaração de Conclusão        >");
		sb.append("\n0 - Voltar para o Menu principal   >");
		sb.append("\n<---------------------------------->");
		System.out.println(sb.toString());
		return sc.nextInt();
	}
}
