package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.ObjectHelper;
import classes.KlasikC;
import interfaces.IdataAccessLayer;

public class KlasikDal extends ObjectHelper implements IdataAccessLayer<KlasikC> {

	@Override
	public void insert(KlasikC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert music.klasiksarkilar (kullanicisi,sarkiidsi,sarkitur) values('"
					+contract.getKullanicisi()+"','"+contract.getSarkiidsi()+"','"+contract.getSarkitur()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void update(KlasikC contract) {
		// TODO Auto-generated method stub
		
	}
	public void dinlenmesayisi(int sayi,String sarkiidsi) {
		Connection connection=getConnection();
		sayi++;
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.klasiksarkilar SET dinlenmesayisi="+sayi+ " where sarkiidsi='"+sarkiidsi+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void delete(KlasikC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KlasikC> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KlasikC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(KlasikC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KlasikC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<KlasikC> listklasik(String contract){
		List<KlasikC> klasikCs=new ArrayList<KlasikC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.klasiksarkilar where kullanicisi='"+contract+
					"' and sarkitur='klasik'");
			while(rs.next()) 
			{
				KlasikC klasikC=new KlasikC();
				klasikC.setKullanicisi(rs.getString("kullanicisi"));
				klasikC.setSarkiidsi(rs.getString("sarkiidsi"));
				klasikC.setSarkitur(rs.getString("sarkitur"));
				klasikC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				klasikCs.add(klasikC);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return klasikCs;
	}
	

}
