package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.SarkiC;
import interfaces.IdataAccessLayer;

public class SarkiDal extends ObjectHelper implements IdataAccessLayer<SarkiC> {

	@Override
	public void insert(SarkiC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into music.sarki (idsarki,idsanatci,turalbum,tarih,suresarki,dinlenmesayis) values('"
					+contract.getIdsarki()+"','"+contract.getSanatcisarki()+"','"+contract.getTuralbums()+"','"+contract.getTarihsarki()
					+"','"+contract.getSuresarki()+"',"+contract.getDinlenmesayisi()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(SarkiC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.sarki SET turalbum='"+contract.getTuralbums()+"',tarih='"+contract.getTarihsarki()+"',suresarki='"+contract.getSuresarki()+"' WHERE idsarki='"+contract.getIdsarki()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(SarkiC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("DELETE FROM music.sarki where idsarki='"+contract.getIdsarki()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SarkiC> list() {
		List<SarkiC> sarkiCs=new ArrayList<SarkiC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.sarki");
			while(rs.next()) 
			{
				SarkiC sarkic=new SarkiC();
				sarkic.setIdsarki(rs.getString("idsarki"));
				sarkic.setSanatcisarki(rs.getString("idsanatci"));
				sarkic.setTuralbums(rs.getString("turalbum"));
				sarkic.setTarihsarki (rs.getString("tarih"));
				sarkic.setSuresarki(rs.getString("suresarki"));
				sarkic.setDinlenmesayisi(rs.getInt("dinlenmesayis"));
				sarkiCs.add(sarkic);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sarkiCs;
	}

	@Override
	public SarkiC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(SarkiC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SarkiC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SarkiC> sarkiid(){
		List<SarkiC> sarkiCs=new ArrayList<SarkiC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select idsarki from music.sarki");
			while(rs.next()) 
			{
				SarkiC sarkic=new SarkiC();
				sarkic.setIdsarki(rs.getString("idsarki"));
				sarkiCs.add(sarkic);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sarkiCs;
	}
	

}
