package model.dao;

import model.dao.impl.VendedorDAOJDBC;

public class FabricaDAO {

	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAOJDBC();
	}
	
}
