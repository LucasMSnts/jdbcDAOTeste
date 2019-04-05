package application;

import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.criarVendedorDAO();
		
		Vendedor vendedor = vendedorDAO.findById(3);
		
		System.out.println(vendedor);
	}

}
