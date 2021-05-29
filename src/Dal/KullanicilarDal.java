package Dal;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.AlbumC;
import classes.KullanicilarC;
import interfaces.IdataAccessLayer;

public class KullanicilarDal extends ObjectHelper implements IdataAccessLayer<KullanicilarC> {

	@Override
	public void insert(KullanicilarC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert music.kullanicilar (adkullanicilar,emailkullanici,sifrekullanicilar,abonelikturukullanicilar) values ('"
					+ contract.getKullaniciadi() +"','" +contract.getKullaniciemail()+"','"+contract.getKullanicisifre()+"','"+contract.getKullaniciaboneliktur()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public int giris(KullanicilarC contract) {
		Connection connection=getConnection();
		try 
		{
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(idkullanicilar) as kullaniciId from music.kullanicilar where emailkullanici='"+contract.getKullaniciemail()
			+"' and sifrekullanicilar='"+contract.getKullanicisifre()+"'");
			while(rs.next())
			{
				if(rs.getInt("kullaniciId")==1)				
					return 1;
			}		
			statement.close();
		    connection.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return 0;		
	}
	@Override
	public KullanicilarC getbyemail(String email) {
		KullanicilarC kullanicilarC=new KullanicilarC();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.kullanicilar where emailkullanici='"+email+"'");
			while(rs.next()) 
			{
				kullanicilarC.setIdkullanicilar(rs.getInt("idkullanicilar"));
				kullanicilarC.setKullaniciadi(rs.getString("adkullanicilar"));
				kullanicilarC.setKullaniciemail(rs.getString("emailkullanici"));
				kullanicilarC.setKullaniciaboneliktur(rs.getString("abonelikturukullanicilar"));
				
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kullanicilarC;
	}
	
	@Override
	public void update(KullanicilarC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(KullanicilarC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KullanicilarC> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KullanicilarC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<KullanicilarC> premiumuyeler()
	{
		List<KullanicilarC> kullanicilarCs=new ArrayList<KullanicilarC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.kullanicilar where abonelikturukullanicilar='premium'");
			while(rs.next()) 
			{
				KullanicilarC kullanicilarC=new KullanicilarC();
				kullanicilarC.setIdkullanicilar(rs.getInt("idkullanicilar"));
				kullanicilarC.setKullaniciadi(rs.getString("adkullanicilar"));
				kullanicilarC.setKullaniciemail(rs.getString("emailkullanici"));
				kullanicilarC.setKullaniciaboneliktur(rs.getString("abonelikturukullanicilar"));
				kullanicilarCs.add(kullanicilarC);
			}
			connection.close();
			statement.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kullanicilarCs;
	}
	
	

	

}
