package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDAOJDBC implements VendedorDAO{

	private Connection conn;
	
	public VendedorDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT vendedor.*, departamento.nome as DepNome " + 
					"FROM vendedor INNER JOIN departamento " + 
					"ON vendedor.DepartamentoId = departamento.id_departamento " + 
					"WHERE vendedor.id_vendendor = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartamentoId"));
				dep.setNome(rs.getString("DepNome"));
				Vendedor ven = new Vendedor();
				ven.setId(rs.getInt("id_vendendor"));
				ven.setNome(rs.getString("nome"));
				ven.setEmail(rs.getString("email"));
				ven.setDataNasc(rs.getDate("dataNasc"));
				ven.setBaseSalario(rs.getDouble("basesalario"));
				ven.setDepartamento(dep);
				return ven;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}		
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
