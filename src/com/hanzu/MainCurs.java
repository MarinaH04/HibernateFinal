package com.hanzu;

import com.hanzu.DAOImpl.CursuriDAOImpl;

public class MainCurs {
	public static void main(String[] args) {
		CursuriDAOImpl cursuriDAO = new CursuriDAOImpl();
		cursuriDAO.insera(4, "Geografie");
//		cursuriDAO.modifica(2, "Psihologie");
//		cursuriDAO.delete(4);
	}
}