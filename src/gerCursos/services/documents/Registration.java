package gerCursos.services.documents;

import java.text.SimpleDateFormat;
import java.util.Date;

	public class Registration {

	    public void RegistrationReceiptSend (String studentName, String course, double registrationValue, Date registrationDate) {
			StringBuilder document = new StringBuilder();
			document.append(("\n---------------------------------------------------"));
			document.append(("\n                RECIBO DE MATRÍCULA                "));
			document.append(("\n---------------------------------------------------"));
			document.append(("\nNome do Aluno: " + studentName));
			document.append(("\nNome do Curso: " + course));
			document.append(("\nValor da Matrícula: R$" + String.format("%.2f", registrationValue)));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			document.append(("\nData da Matrícula: " + dateFormat.format(registrationDate)));
			document.append(("\n---------------------------------------------------"));
			System.out.println(document.toString());

			System.out.println("Recibo de matrícula gerado com sucesso!");

		}
	}
