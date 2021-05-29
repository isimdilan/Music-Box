package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dal.KullanicilarDal;
import classes.KullanicilarC;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class UyeOlPanel extends JFrame {

	private JPanel contentPane;
	private JTextField kullaniciemail;
	private JPasswordField kullanicisifre;
	private JTextField kullaniciad;
	private JTextField kullaniciabone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeOlPanel frame = new UyeOlPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UyeOlPanel() {
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Music Box");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kullanici = new JLabel("");
		kullanici.setIcon(new ImageIcon(StartPanel.class.getResource("/images/kullanici2.png")));
		kullanici.setBounds(635, 180, 150, 150);
		contentPane.add(kullanici);
		
		JLabel kullanici_ad = new JLabel("Adınız");
		kullanici_ad.setForeground(Color.WHITE);
		kullanici_ad.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		kullanici_ad.setBounds(600, 340, 150, 14);
		contentPane.add(kullanici_ad);
		//Kullanıcı Adı
		kullaniciad = new JTextField();
		kullaniciad.setForeground(SystemColor.menu);
		kullaniciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		kullaniciad.setColumns(10);
		kullaniciad.setBackground(SystemColor.windowBorder);
		kullaniciad.setBounds(600, 365, 220, 25);
		contentPane.add(kullaniciad);
		//
		
		JLabel email = new JLabel("E-mail");
		email.setForeground(SystemColor.window);
		email.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		email.setBounds(600, 415, 150, 14);
		contentPane.add(email);
		
		kullaniciemail = new JTextField();
		kullaniciemail.setForeground(SystemColor.control);
		kullaniciemail.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		kullaniciemail.setBackground(SystemColor.windowBorder);
		kullaniciemail.setBounds(600, 435, 220, 25);
		contentPane.add(kullaniciemail);
		kullaniciemail.setColumns(10);
		
		JLabel sifre = new JLabel("Şifre");
		sifre.setForeground(SystemColor.window);
		sifre.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		sifre.setBounds(600, 485, 150, 14);
		contentPane.add(sifre);
		
		kullanicisifre = new JPasswordField();
		kullanicisifre.setForeground(SystemColor.window);
		kullanicisifre.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		kullanicisifre.setBackground(SystemColor.windowBorder);
		kullanicisifre.setBounds(600, 505, 220, 25);
		contentPane.add(kullanicisifre);
		
		JLabel lblAbonelikTur = new JLabel("Abonelik Tur");
		lblAbonelikTur.setForeground(Color.WHITE);
		lblAbonelikTur.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		lblAbonelikTur.setBounds(600, 555, 150, 14);
		contentPane.add(lblAbonelikTur);
		//Abonelik Tur
		kullaniciabone = new JTextField();
		kullaniciabone.setForeground(Color.WHITE);
		kullaniciabone.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		kullaniciabone.setBackground(SystemColor.windowBorder);
		kullaniciabone.setBounds(600, 575, 220, 25);
		contentPane.add(kullaniciabone);
		//
		
		JButton giris = new JButton("Üye ol");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!kullaniciad.getText().equals("") && !kullaniciemail.getText().equals("") && !kullanicisifre.getText().equals("")&&!kullaniciabone.getText().equals("")) 
				{
				KullanicilarC kullanicilarC=new KullanicilarC();
				kullanicilarC.setKullaniciadi(kullaniciad.getText());
				kullanicilarC.setKullaniciemail(kullaniciemail.getText());
				kullanicilarC.setKullanicisifre(kullanicisifre.getText());
				kullanicilarC.setKullaniciaboneliktur(kullaniciabone.getText());
				JList list=new JList(new KullanicilarDal().premiumuyeler().toArray());
				new KullanicilarDal().insert(kullanicilarC);
				
					GirisYapPanel gitgiris=new GirisYapPanel();
					list.setListData(new KullanicilarDal().premiumuyeler().toArray());
					gitgiris.setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(sifre, "Tum alanlar dolu olmalıdır");
				}
				
				
			}
		});
		giris.setForeground(SystemColor.controlShadow);
		giris.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		giris.setBackground(new Color(255,243,157));
		giris.setBorder(null);
		
		giris.setBounds(661, 680, 89, 23);
		contentPane.add(giris);
		
		
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		background.setBounds(0, 0, 1366, 768);
		contentPane.add(background);
		
		
		
		
		
		
	}

}
