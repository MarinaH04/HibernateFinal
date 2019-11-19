package com.hanzu.DAO;

public interface CursuriDAO {
	public void insera(int cursID,String nume);
	public void modifica(int idcurs, String numecurs);
	public void delete(int idcurs);
}
