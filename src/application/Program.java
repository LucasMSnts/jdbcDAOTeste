package application;


import java.util.Date;
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
		
		System.out.println("\n---------- FindAll ----------");
		list = vendedorDAO.findAll();
		for (Vendedor ven : list) {
			System.out.println(ven);
		}
		
		System.out.println("\n---------- Insercao Vendedor ----------");
		Vendedor novoVen = new Vendedor(null, "Luke", "luke@gmail.com", new Date(), 2500.0, departamento);
		vendedorDAO.insert(novoVen);
		System.out.println("Inserido! Novo id = " + novoVen.getId());
		
	}

}
