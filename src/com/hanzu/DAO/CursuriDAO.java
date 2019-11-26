package com.hanzu.DAO;
import java.util.List;


import com.hanzu.model.Student;
public interface CursuriDAO {
	public void insera(int cursID,String nume, List<Student> student);
	public void modifica(int idcurs, String numecurs);
	public void delete(int idcurs);
}
