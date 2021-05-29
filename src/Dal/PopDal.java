package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.PopC;
import interfaces.IdataAccessLayer;

public class PopDal extends ObjectHelper implements IdataAccessLayer<PopC> {

	@Override
	public void insert(PopC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("insert music.popsarkilar (kullanicisi,sarkiidsi,sarkitur,dinlenmesayisi) values('"
					+contract.getKullanicisi()+"','"+contract.getSarkiidsi()+"','"+contract.getSarkitur()+"',"+contract.getDinlenmesayisi()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void update(PopC contract) {
		// TODO Auto-generated method stub
		
	}
	public void dinlenmesayisi(int sayi,String sarkiidsi) {
		Connection connection=getConnection();
		sayi++;
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.popsarkilar SET dinlenmesayisi="+sayi+ " where sarkiidsi='"+sarkiidsi+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(PopC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PopC> list() {
		List<PopC> popCs=new ArrayList<PopC>();
		Connection connection=getConnection();
	
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.popsarkilar order by dinlenmesayisi desc");
			while(rs.next()) 
			{
				PopC popC=new PopC();
				popC.setKullanicisi(rs.getString("kullanicisi"));
				popC.setSarkiidsi(rs.getString("sarkiidsi"));
				popC.setSarkitur(rs.getString("sarkitur"));
				popC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				popCs.add(popC);
			}	
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return popCs;
	}

	@Override
	public PopC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(PopC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PopC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<PopC> listpop(String contract){
		List<PopC> popCs=new ArrayList<PopC>();
		Connection connection=getConnection();
	
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.popsarkilar where kullanicisi='"+contract+
					"' and sarkitur='pop'");
			while(rs.next()) 
			{
				PopC popC=new PopC();
				popC.setKullanicisi(rs.getString("kullanicisi"));
				popC.setSarkiidsi(rs.getString("sarkiidsi"));
				popC.setSarkitur(rs.getString("sarkitur"));
				popC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				popCs.add(popC);
			}	
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return popCs;
	}
	public List<PopC> listpopSırala(String contract){
		List<PopC> popCs=new ArrayList<PopC>();
		Connection connection=getConnection();
	
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.popsarkilar  where kullanicisi='"+contract+
					"' order by dinlenmesayisi desc");
			while(rs.next()) 
			{
				PopC popC=new PopC();
				popC.setKullanicisi(rs.getString("kullanicisi"));
				popC.setSarkiidsi(rs.getString("sarkiidsi"));
				popC.setSarkitur(rs.getString("sarkitur"));
				popC.setDinlenmesayisi(rs.getInt("dinlenmesayisi"));
				popCs.add(popC);
			}	
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return popCs;
	}
	

}
