package gerCursos.application;

import java.sql.Connection;

import db.DB;
import gerCursos.services.initial.RunEverythingService;

public class CursoRun {

	public static void main(String[] args) {
		new RunEverythingService().execute();
	
	}
}


/*Connection conn = null;
Statement st = null;

try {
	conn = DB.getConnection();
	
	conn.setAutoCommit(false);
				
	st = conn.createStatement();
			
	int rows1 = st.executeUpdate("UPDATE student SET Phone 934567890 WHERE Id = 6");
	
	int rows2 = st.executeUpdate("UPDATE student SET Phone 945678345 WHERE Id = 5");
	
	conn.commit();
			
	System.out.println("rows1 " + rows1);
	System.out.println("rows2 " + rows2);*/
	
    /*"DELETE FROM student "
	+"WHERE "
	+"Id = ?");
	
	st.setInt(1, 5);
			
	int rowsAffected = st.executeUpdate();
	
	System.out.println("Done! Rows affected = " + rowsAffected);
	*/
	/*"INSERT INTO student"
	+"(Name, Cpf, Address, Email, Phone) "
	+"VALUES "
	+"(?, ?, ?, ?, ?)",
	Statement.RETURN_GENERATED_KEYS);
	
	st.setString(1, "João Carlos");
	st.setString(2, "45576498634");
	st.setString(3, "Rua Fabiano Peixoto");
	st.setString(4, "joãocarlos@gmail.com");
	st.setString(5, "944587321");*/
	
	/*int rowsAffected = st.executeUpdate();
	
	System.out.println("Done! Rows affected = " + rowsAffected);*/
	
	/*if (rowsAffected > 0){
		ResultSet rs = st.getGeneratedKeys();
		while (rs.next()) {
			int index = rs.getInt(1);
			System.out.println("Done! Index = " + index);
		}
	}
	else {
		System.out.println("No rows affected!");
	}*/
	
	//while(rs.next()) {
		//System.out.println(rs.getInt("index") + ", " + rs.getString("name"));
	//}
/*}
catch(SQLException e) {
	try {
		conn.rollback();
		throw new DbException("Transaction rolled back! Caused by " + e.getMessage());
		//throw new DbIntegrityException(e.getMessage());
	}
	catch(SQLException e1) {
		throw new DbException("Error trying to roolback! Caused by: " + e.getMessage());
	}
}
finally {
	DB.closeStatement(st);
	DB.closeConnection();
}*/