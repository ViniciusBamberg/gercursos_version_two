package gerCursos.services.documents;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {

    public void ReceiptSend(String studentName, String course, double paymentValue, Date PaymentDate) {
    	StringBuilder document = new StringBuilder();
		document.append(("\n---------------------------------------------------"));
    	document.append(("\n                RECIBO DE PAGAMENTO                "));
		document.append(("\n---------------------------------------------------"));
		document.append(("\nNome do Aluno: " + studentName));
		document.append(("\nNome do Curso: " + course));
		document.append(("\nValor do Pagamento: R$" + String.format("%.2f", paymentValue)));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		document.append(("\nData do Pagamento: " + dateFormat.format(PaymentDate)));
		document.append(("\n---------------------------------------------------"));
		System.out.println(document.toString());
		
		System.out.println("Recibo de pagamento gerado com sucesso!");
    }
}
