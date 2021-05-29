package Dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import DB.ObjectHelper;
import classes.AdminC;
import interfaces.IdataAccessLayer;

public class AdminDal extends ObjectHelper implements IdataAccessLayer<AdminC> {

	@Override
	public void insert(AdminC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AdminC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AdminC contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdminC> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminC getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int giris(AdminC contract) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(idadmin) as idadmin from music.admin where emailadmin='"+contract.getEmailadmin()
			+"' and sifreadmin='"+contract.getSifreadmin()+"'");
			while(rs.next())
			{
				if(rs.getInt("idadmin")==1)				
					return 1;
			}		
			statement.close();
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public AdminC getbyemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
