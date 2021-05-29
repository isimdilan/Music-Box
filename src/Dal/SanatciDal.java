package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.SanatciC;
import interfaces.IdataAccessLayer;

public class SanatciDal extends ObjectHelper implements IdataAccessLayer<SanatciC>  {
	
	@Override
	public void insert(SanatciC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into music.sanatci (idsanatci,adsanatci,ulkesanatci) values('"+contract.getIdsanatci()+"','"
					+contract.getAdsanatci()+"','"+contract.getUlkesanatci()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(SanatciC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.sanatci SET idsanatci='"+contract.getIdsanatci()+"',adsanatci='"+contract.getAdsanatci()+"',ulkesanatci='"+contract.getUlkesanatci()+"' WHERE idsanatci='"+contract.getIdsanatci()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(SanatciC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("DELETE FROM music.sanatci where idsanatci='"+contract.getIdsanatci()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<SanatciC> list() {
		List<SanatciC> sanatciCs=new ArrayList<SanatciC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select adsanatci from music.sanatci");
			while(rs.next()) 
			{
				SanatciC sanatciC=new SanatciC();
				sanatciC.setAdsanatci(rs.getString("adsanatci"));
				sanatciCs.add(sanatciC);
				
			}
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sanatciCs;
	}

	@Override
	public SanatciC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(SanatciC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SanatciC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SanatciC> tumsanatcilar(){
		List<SanatciC> sanatciCs=new ArrayList<SanatciC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.sanatci");
			while(rs.next()) 
			{
				SanatciC sanatciC=new SanatciC();
				sanatciC.setIdsanatci(rs.getString("idsanatci"));
				sanatciC.setAdsanatci(rs.getString("adsanatci"));
				sanatciC.setUlkesanatci(rs.getString("ulkesanatci"));
				sanatciCs.add(sanatciC);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanatciCs;
	}
	public List<SanatciC> sanatciid(){
		List<SanatciC> sanatciCs=new ArrayList<SanatciC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select idsanatci from music.sanatci");
			while(rs.next()) 
			{
				SanatciC sanatciC=new SanatciC();
				sanatciC.setIdsanatci(rs.getString("idsanatci"));
				sanatciCs.add(sanatciC);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanatciCs;
	}

}
