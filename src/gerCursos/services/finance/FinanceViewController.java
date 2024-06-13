package gerCursos.services.finance;

import java.util.Scanner;

import gerCursos.services.initial.RunEverythingService;
import gerCursos.view.MenuFinance;

public class FinanceViewController {
	
	private final FinanceService service = new FinanceService();

	public void callService(Integer index,Scanner scanner) {
		switch (index) {
		case 1:
			service.transaction(scanner);
			break;
		case 2:
			service.cashFlow(scanner);
			break;
		case 3:
			service.MonthlyBalance(scanner);
			break;
		case 4:
			service.removeIncomesOrExpenses(scanner);
			break;
		case 0:
			new RunEverythingService().execute();
		default:
			System.out.println("Opção inválida");
		}
		Integer optChoice = MenuFinance.mainMenuFinance(scanner);
		new FinanceViewController().callService(optChoice,scanner);
	}
}

