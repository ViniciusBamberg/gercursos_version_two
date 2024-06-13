package gerCursos.services.documents;

import java.util.Scanner;

import gerCursos.services.initial.RunEverythingService;
import gerCursos.view.MenuDocuments;

public class DocumentsViewController {
	
	private final DocumentsService documents = new DocumentsService();
	
	public void callService(Integer index,Scanner scanner) {
		while(!(index == null) &&  index != 9) {
			switch (index) {
			case 1:
				documents.PaymentReceipt();
				break;
			case 2:
				documents.RegistrationReceiptSend();
				break;
			case 3:
				documents.StatementOfCompletion();
				break;
			case 0:
				new RunEverythingService().execute();
			default:
				System.out.println("Opção inválida");
			}
			Integer optChoice = MenuDocuments.mainMenuDocuments(scanner);
			new DocumentsViewController().callService(optChoice,scanner);
		}
	}
}

