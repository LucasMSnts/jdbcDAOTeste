package model.dao;

import db.DB;
import model.dao.impl.VendedorDAOJDBC;

public class FabricaDAO {

	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAOJDBC(DB.getConnection());
	}
	
}
