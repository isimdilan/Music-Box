package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.ObjectHelper;
import classes.CazC;
import interfaces.IdataAccessLayer;

public class CazDal extends ObjectHelper implements IdataAccessLayer<CazC> {

	@Override
	public void insert(CazC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("insert music.cazsarkilar (kullanicisi,sarkiidsi,sarkitur) values('"
					+contract.getKullanicisi()+"','"+contract.getSarkiidsi()+"','"+contract.getSarkitur()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void update(CazC contract) {
		// TODO Auto-generated method stub
		
	}
	public void dinlenmesayisi(int sayi,String sarkiidsi) {
		Connection connection=getConnection();
		sayi++;
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.cazsarkilar SET dinlenmesayisi="+sayi+ " where sarkiidsi='"+sarkiidsi+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(CazC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CazC> list() {
		List<CazC> cazCs=new ArrayList<CazC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.cazsarkilar");
			while(rs.next()) 
			{
				CazC cazC=new CazC();
				cazC.setKullanicisi(rs.getString("kullanicisi"));
				cazC.setSarkiidsi(rs.getString("sarkiidsi"));
				cazC.setSarkitur(rs.getString("sarkitur"));
				cazC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				cazCs.add(cazC);
				
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cazCs;
	}

	@Override
	public CazC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(CazC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CazC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<CazC> listcaz(String contract){
		List<CazC> cazCs=new ArrayList<CazC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.cazsarkilar where kullanicisi='"+contract+
					"' and sarkitur='caz'");
			while(rs.next()) 
			{
				CazC cazC=new CazC();
				cazC.setKullanicisi(rs.getString("kullanicisi"));
				cazC.setSarkiidsi(rs.getString("sarkiidsi"));
				cazC.setSarkitur(rs.getString("sarkitur"));
				cazC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				cazCs.add(cazC);
				
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cazCs;
				
	}

}
