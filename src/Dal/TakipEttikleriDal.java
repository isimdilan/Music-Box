package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.TakipEttikleriC;
import interfaces.IdataAccessLayer;

public class TakipEttikleriDal extends ObjectHelper implements IdataAccessLayer<TakipEttikleriC> {

	@Override
	public void insert(TakipEttikleriC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert music.takipettikleri (kullanicisi,kullaniciid,takipedilenkullanici) values('"
					+contract.getKullanicisi()+"','"+contract.getKullaniciid()+"','"+contract.getTakipedilenkullanici()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void update(TakipEttikleriC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TakipEttikleriC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TakipEttikleriC> list() {
		return null;
	}
	public List<TakipEttikleriC> list2(String kullanici) {
		List<TakipEttikleriC> takipEttikleriCs=new ArrayList<TakipEttikleriC>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from music.takipettikleri where kullanicisi='"+kullanici+"'");
			while(rs.next()) 
			{
				TakipEttikleriC takipEttikleriC=new TakipEttikleriC();
				takipEttikleriC.setKullanicisi(rs.getString("kullanicisi"));
				takipEttikleriC.setKullaniciid(rs.getString("kullaniciid"));
				takipEttikleriC.setTakipedilenkullanici(rs.getString("takipedilenkullanici"));
				takipEttikleriCs.add(takipEttikleriC);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return takipEttikleriCs;
	}

	@Override
	public TakipEttikleriC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(TakipEttikleriC contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TakipEttikleriC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
