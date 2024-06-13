package gerCursos.dao;

import java.util.List;

import gerCursos.entities.Finance;

public interface FinanceDao {

	void insert(Finance obj);
	void update(Finance obj);
	void deleteById(Integer id);
	Finance findById(Integer id);
	List<Finance> findAll();
}
