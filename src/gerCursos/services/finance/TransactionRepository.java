package gerCursos.services.finance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gerCursos.entities.Transaction;

public class TransactionRepository {
	
	private static List<Transaction> transactions = new ArrayList<>();
	
	public TransactionRepository() {
	}

	public void addTransaction(double value, String description, Date date) {
		Transaction transaction = new Transaction(value, description, date);
		transactions.add(transaction);
	}

	public List<Transaction> getTransactionsPerPeriod(Date start, Date end) {
		List<Transaction> transactionsPeriod = new ArrayList<>();
		for (Transaction transaction : transactions) {
			
			if ((transaction.getDate().after(start) && transaction.getDate().before(end))|| transaction.getDate().equals(start)) {
				transactionsPeriod.add(transaction);
			}
		}
		return transactionsPeriod;
	}
	
	
	public List<Transaction> getTransactionsByMonth(int year, int month) {
       List<Transaction> transactionsByMonth = new ArrayList<>();
     
       for (Transaction transaction : transactions) {
    	   Date transactionDate = transaction.getDate();
    	 
    	    if((transactionDate.getYear()+1900) == year && (transactionDate.getMonth()+ 1) == month) {
                transactionsByMonth.add(transaction);
            }
        }
        return transactionsByMonth;
    }

	@Override
	public String toString() {
		return "transações = " + transactions ;
	}

	public List<Transaction> getAllTransactions() {
		for (int i = 0; i < transactions.size(); i++) {
	        System.out.print(i + ": " + transactions.get(i));
    	}
		return transactions;	
	}

	public void removeTransaction(Transaction selectedTransaction) {
		transactions.remove(selectedTransaction);
	}	
	
}

