package gerCursos.services.finance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import gerCursos.entities.Finance;
import gerCursos.entities.Transaction;

public class FinanceService {
	private Scanner sc = new Scanner(System.in);
    private Finance finance = new Finance();
    private TransactionRepository transactions = new TransactionRepository();
	
	public FinanceService() {
    }

	public void transaction(Scanner scanner) {
		
		while (true) {

			System.out.print("Digite 'r' para adicionar uma receita, 'd' para adicionar uma despesa \n"
					+ "ou 'f' para finalizar: \n");
			String choice = sc.nextLine();
			
			if (choice.equals("f")) {
				break;
			}

			System.out.print("Digite o valor da transação: ");
			double value;
			try {
				value = Double.parseDouble(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido. Por favor, insira um número válido.");
				continue;
			}
			
			System.out.print("Descrição da transação: ");
			String description = sc.nextLine();
					
			Date date = inputDate("Digite a data da transação (dd/MM/yyyy): ");

			if (choice.equals("r")) {
				transactions.addTransaction(value, description, date);
				System.out.println(transactions);
				System.out.println("Receita adicionada com sucesso!");
			} else if (choice.equals("d")) {
				transactions.addTransaction(-value, description, date);
				System.out.println(transactions);
				System.out.println("Despesa adicionada com sucesso!");
			} else {
				System.out.println("Escolha inválida.");
			}
		}
	}

	public double cashFlow(Scanner sc){
		Finance finance = new Finance();
		Date inputDate = new Date();
		Date date = new Date();
		TransactionRepository transactions = new TransactionRepository();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		Date start = inputDate("Digite a data inicial (dd/MM/yyyy): ");
	    Date end = inputDate("Digite a data final (dd/MM/yyyy): ");
	        
		List<Transaction> transactionsPeriod = transactions.getTransactionsPerPeriod(start, end);
		System.out.println("Transações no período:");
		for (Transaction transaction : transactionsPeriod) {
			System.out.println(transaction.getValue() + " em " + transaction.getDate(date));
		}

		double balance = 0;
		for (Transaction transaction : transactionsPeriod) {
			balance += transaction.getValue();
		}
		System.out.println(
				"Saldo total para o período de " + sdf.format(start) + " a " + sdf.format(end) + ": " + balance);

		return balance;
	}
	
	public double MonthlyBalance(Scanner scanner) {
		System.out.print("Digite o ano desejado (yyyy): ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Digite o mês desejado (MM): ");
        int month = Integer.parseInt(sc.nextLine());
		
		TransactionRepository transactions = new TransactionRepository();
	    List<Transaction> transactionsByMonth = transactions.getTransactionsByMonth(year, month);
	    double balanceMonth = 0;
	    for (Transaction transaction : transactionsByMonth) {
	        balanceMonth += transaction.getValue();
	    }
	    
	    System.out.println(
				"Saldo para o mês de " + month + "/" + year + ": " + balanceMonth);
	    
	    return balanceMonth;
	}

	public void removeIncomesOrExpenses(Scanner sc) {
	    TransactionRepository transactions = new TransactionRepository();

	    List<Transaction> allTransactions = transactions.getAllTransactions();
	 
	    System.out.println(transactions);
	    
	    System.out.println("Transações disponíveis:");
	    for (int i = 0; i < allTransactions.size(); i++) {
	    	Transaction transaction = allTransactions.get(i);
	        System.out.println((i + 1) + ". " + transaction.getDescription() + " - Valor: " + transaction.getValue());
	    }

	    System.out.println("Digite o número da transação que deseja remover:");
	    int selectedTransactionIndex = sc.nextInt();
	    	    
	    if (selectedTransactionIndex < 1 || selectedTransactionIndex > allTransactions.size()) {
	        System.out.println("Número de transação inválido.");
	        return;
	    }
	    
	    Transaction selectedTransaction = allTransactions.get(selectedTransactionIndex - 1);
	    transactions.removeTransaction(selectedTransaction);
	    System.out.println("Transação removida com sucesso.");
	}
	
	private Date inputDate(String message) {
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
