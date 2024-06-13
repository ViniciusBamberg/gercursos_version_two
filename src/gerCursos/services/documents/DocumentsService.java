package gerCursos.services.documents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DocumentsService {
	private static Scanner sc = new Scanner(System.in);
		
	public void PaymentReceipt() {
	        
		  	System.out.print("Digite o nome do aluno: ");
		 	String studentName = sc.nextLine();
		 	
		 	System.out.print("Digite o nome do curso: ");
		 	String course = sc.nextLine();
		 	
		 	System.out.print("Digite o valor do pagamento: ");
		 	double paymentValue = sc.nextDouble();
		 	sc.nextLine();
		 	
		 	Date paymentDate = allDate("Digite a data do pagamento(dd/MM/yyyy): ");

		 	Receipt receipt = new Receipt();
		 	
		 	receipt.ReceiptSend(studentName, course, paymentValue, paymentDate);
	  }
	  
	  public void RegistrationReceiptSend() {
	      
		  	System.out.print("Digite o nome do aluno: ");
		 	String studentName = sc.nextLine();
		 	
		 	System.out.print("Digite o nome do curso: ");
		 	String course = sc.nextLine();
		 	
		 	System.out.print("Digite o valor da matrícula: ");
		 	double registrationValue = sc.nextDouble();
			sc.nextLine();
			
		 	Date registrationDate = allDate("Digite a data da matrícula(dd/MM/yyyy): ");
		  
		 	Registration registration = new Registration();
		 	
		 	registration.RegistrationReceiptSend(studentName, course, registrationValue, registrationDate);
	  }
	  
	  public void StatementOfCompletion() {
			 
		 	System.out.print("Digite o nome do aluno: ");
		 	String studentName = sc.nextLine();
		 	
		 	System.out.print("Digite o nome do curso: ");
	        String course = sc.nextLine();
	        
	        Date conclusionDate = allDate("Digite a data de conclusão(dd/MM/yyyy): ");
	        
	        StatementOfCompletion document = new StatementOfCompletion();
	        
	        document.statementSend(studentName, course, conclusionDate);
	 }
	 	
	  public static Date allDate(String message) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			while (true) {
				try {
					System.out.print(message);
					return sdf.parse(sc.nextLine());
				} catch (ParseException e) {
					System.out.println("Formato de data inválido. Usar o formato dd/MM/yyyy.");
				}
			}
		}
}
