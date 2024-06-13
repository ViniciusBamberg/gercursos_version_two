package gerCursos.services.documents;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StatementOfCompletion {

    public void statementSend(String studentName, String course, Date conclusionDate) {

		StringBuilder document = new StringBuilder();
		document.append(("\n------------------------------------------------------------------------"));
		document.append(("\n                  DECLARAÇÃO DE CONCLUSÃO DE CURSO                      "));
		document.append(("\n------------------------------------------------------------------------"));
		document.append(("\nDeclaramos que " + studentName + 									   ""));
		document.append(("\nconcluiu o curso de " + course + 									  " "));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		document.append(("em " + dateFormat.format(conclusionDate) + 							  "."));
		document.append(("\n													  				    "));
		document.append(("\n																	    "));
		document.append(("\n          	  _______________________________________				    "));
		document.append(("\n               	        Coordenador do curso  					        "));
		document.append(("\n																	    "));
		document.append(("\n------------------------------------------------------------------------"));
		System.out.println(document.toString());

		System.out.println("Declaração gerada com sucesso!");
	}
}
