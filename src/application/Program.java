package application;

import java.util.List;

import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.criarVendedorDAO();
		
		System.out.println("---------- findById ----------");
		Vendedor vendedor = vendedorDAO.findById(3);		
		System.out.println(vendedor);
		
		System.out.println("\n---------- FindByDepartamento ----------");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDAO.findByDepartamento(departamento);
		for (Vendedor ven : list) {
			System.out.println(ven);
		}
	}

}
