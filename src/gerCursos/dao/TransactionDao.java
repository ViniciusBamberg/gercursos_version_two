package gerCursos.dao;

import java.util.List;

import gerCursos.entities.Transaction;

public interface TransactionDao {

	void insert(Transaction obj);
	void update(Transaction obj);
	void deleteById(Integer id);
	Transaction findById(Integer id);
	List<Transaction> findAll();
}
