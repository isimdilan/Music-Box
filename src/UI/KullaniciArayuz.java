package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Dal.KullanicilarDal;
import classes.KullanicilarC;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class KullaniciArayuz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciArayuz frame = new KullaniciArayuz();
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
	public KullaniciArayuz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Kullanıcı Arayüz");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 768);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel kullanicipp = new JLabel("New label");
		kullanicipp.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/admin2.png")));
		kullanicipp.setBounds(64, 54, 150, 150);
		panel.add(kullanicipp);
		JPanel paneltakipettiklerin = new JPanel();
		
		//Kullanıcı Bilgileri Çek
		//KullanicilarC kullanicilarC=new KullanicilarDal().getbyemail(kullaniciemail);
		
				
		JLabel kullaniciad = new JLabel("Kullanici Adı");
		kullaniciad.setForeground(SystemColor.window);
		kullaniciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		kullaniciad.setBounds(26, 221, 200, 14);
		//kullaniciad.setText("Kullanıcı: "+kullanicilarC.getKullaniciadi());
		panel.add(kullaniciad);
		
		JLabel kullanicimail = new JLabel("Kullanici Abonelik Tur");
		kullanicimail.setForeground(SystemColor.window);
		kullanicimail.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		kullanicimail.setBounds(26, 240, 200, 14);
		//kullanicimail.setText("Abonelik Turu: "+kullanicilarC.getKullaniciaboneliktur());
		panel.add(kullanicimail);
		
		
		JButton tumsarkilar = new JButton("Tüm Şarkılar");
		tumsarkilar.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		tumsarkilar.setBackground(new Color(51, 51, 51));
		tumsarkilar.setForeground(SystemColor.window);
		tumsarkilar.setBounds(26, 296, 224, 35);
		tumsarkilar.setBorder(null);
		panel.add(tumsarkilar);
		
		JButton takipebk = new JButton("Takip edebileceğin kullanıcılar");
		takipebk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{					
					paneltakipettiklerin.setVisible(true);					
				}			
			}
		});
		takipebk.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		takipebk.setBackground(new Color(51, 51, 51));
		takipebk.setForeground(SystemColor.window);
		takipebk.setBounds(26, 360, 224, 35);
		takipebk.setBorder(null);
		panel.add(takipebk);
		
		
		
		//Panel Arkaplan
		JLabel panelarka = new JLabel("New label");
		panelarka.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background2.png")));
		panelarka.setBounds(0, 0, 300, 768);
		panel.add(panelarka);
		
		
		paneltakipettiklerin.setBounds(300, 0, 1066, 768);
		contentPane.add(paneltakipettiklerin);
		paneltakipettiklerin.setLayout(null);
		//Liste
		JList list=new JList(new KullanicilarDal().premiumuyeler().toArray());
		//
		list.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		list.setForeground(SystemColor.window);
		list.setBackground(Color.DARK_GRAY);
		JScrollPane kullanicilarp = new JScrollPane(list);
		kullanicilarp.setToolTipText("");
		kullanicilarp.setViewportBorder(new LineBorder(Color.GRAY, 3));
		kullanicilarp.setBounds(80, 184, 800, 200);
		kullanicilarp.setBackground(new Color(25,25,25));
		paneltakipettiklerin.add(kullanicilarp);
		
		//sil
		//Liste değerlerini doğru getiriyor mu diye denemek olarak konuldu
		JLabel lblNewLabel = new JLabel("aaaaa");
		lblNewLabel.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(80, 535, 184, 14);
		paneltakipettiklerin.add(lblNewLabel);
		
		//Takip Et button 
		//Butona basınca sectiği kullanıcı e-mail adresi ile bile başka bir listeye atılmalı ve datada tutulmalı
		JButton takipetbutton = new JButton("Takip Et");
		takipetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					lblNewLabel.setText(""+list.getSelectedValue());
				}
				
			}
		});
		takipetbutton.setBackground(SystemColor.windowBorder);
		takipetbutton.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		takipetbutton.setForeground(SystemColor.window);
		takipetbutton.setBounds(890, 300, 150, 80);
		paneltakipettiklerin.add(takipetbutton);
		//Eğer kullanıcı takip ediliyorsa tıklandığında kullanıcının listeleri gelecek 
		//Şarkılar boş olduğu için şimdilik boş listeler olarak pop caz klasik olarak görünmeli 
		//Her kullanıcı üye kaydında 3 tablosu oluşmalı
		JButton listegoruntule = new JButton("Listeleri");
		listegoruntule.setForeground(Color.WHITE);
		listegoruntule.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		listegoruntule.setBackground(SystemColor.windowBorder);
		listegoruntule.setBounds(890, 184, 150, 80);
		paneltakipettiklerin.add(listegoruntule);
		
		
		JLabel takipettiklerinbg = new JLabel("New label");
		takipettiklerinbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		takipettiklerinbg.setBounds(0, 0, 1066, 768);
		paneltakipettiklerin.add(takipettiklerinbg);
		
		
		
		
		
		paneltakipettiklerin.setVisible(false);

		
		//Background
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1366, 768);
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		contentPane.add(background);
		
		
		
	
		
		
		
	}
}
