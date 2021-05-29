package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.ObjectHelper;
import UI.StartPanel;
import classes.AlbumC;
import interfaces.IdataAccessLayer;

public class AlbumDal extends ObjectHelper implements IdataAccessLayer<AlbumC> {

	@Override
	public void insert(AlbumC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into music.album (idalbum,adalbum,sanatciadalbum,sarkialbum,tarihalbum,turalbum)values('"
					+contract.getIdalbum()+"','"+contract.getAdalbum()+"','"+contract.getSanatciadalbum()+"','"+contract.getSarkialbum()
					+"','"+contract.getTarihalbum()+"','"+contract.getTuralbum()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(AlbumC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE music.album SET adalbum='"+contract.getAdalbum()+"', sanatciadalbum='"+contract.getSanatciadalbum()
			+"',sarkialbum='"+contract.getSarkialbum()+"',tarihalbum='"+contract.getTarihalbum()+"',turalbum='"+contract.getTuralbum()+"' WHERE idalbum='"+contract.getIdalbum()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(AlbumC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("DELETE FROM music.album where idalbum='"+contract.getIdalbum()+"'");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AlbumC> list() {
		List<AlbumC> albumCs=new ArrayList<AlbumC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.album");
			while(rs.next()) 
			{
				AlbumC albumc=new AlbumC();
				albumc.setIdalbum(rs.getString("idalbum"));
				albumc.setAdalbum(rs.getString("adalbum"));
				albumc.setSanatciadalbum(rs.getString("sanatciadalbum"));
				albumc.setTarihalbum(rs.getString("tarihalbum"));
				albumc.setSarkialbum(rs.getString("sarkialbum"));
				albumc.setTuralbum(rs.getString("turalbum"));
				albumCs.add(albumc);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albumCs;
	}

	@Override
	public AlbumC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(AlbumC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AlbumC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
