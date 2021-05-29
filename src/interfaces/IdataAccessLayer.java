package interfaces;

import java.util.List;

public interface IdataAccessLayer<T> {
	public void insert(T contract);
	public void update(T contract);
	public void delete(T contract);
	public List<T> list();
	public T getbyid(int id);
	public int giris(T contract);
	public T getbyemail(String email);

}
