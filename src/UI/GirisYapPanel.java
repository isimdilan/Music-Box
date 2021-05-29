package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Dal.CazDal;
import Dal.KlasikDal;
import Dal.KullanicilarDal;
import Dal.PopDal;
import Dal.SarkiDal;
import Dal.TakipEttikleriDal;
import classes.CazC;
import classes.KlasikC;
import classes.KullanicilarC;
import classes.PopC;
import classes.SarkiC;
import classes.TakipEttikleriC;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GirisYapPanel extends JFrame {

	private JPanel contentPane;
	private String kullaniciad2;
	private String kullaniciemail;
	private JTextField textField;
	private String pop="Pop"; 
	private String caz="Caz"; 
	private String klasikString="Klasik";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisYapPanel frame = new GirisYapPanel();
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
	public GirisYapPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Kullanıcı Giriş");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Listeler
		
		JLabel kullanici = new JLabel("");
		kullanici.setIcon(new ImageIcon(StartPanel.class.getResource("/images/kullanici2.png")));
		kullanici.setBounds(640, 175, 150, 150);
		contentPane.add(kullanici);
		
		JLabel email = new JLabel("E-mail");
		email.setForeground(SystemColor.window);
		email.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		email.setBounds(600, 355, 150, 14);
		contentPane.add(email);
		
		JTextField textField = new JTextField();
		textField.setBackground(SystemColor.windowBorder);
		textField.setForeground(SystemColor.control);
		textField.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		textField.setBounds(600, 380, 220, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel sifre = new JLabel("Şifre");
		sifre.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		sifre.setForeground(SystemColor.window);
		sifre.setBounds(600, 429, 150, 14);
		contentPane.add(sifre);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.control);
		passwordField.setBackground(SystemColor.windowBorder);
		passwordField.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		passwordField.setBounds(600, 454, 220, 25);
		contentPane.add(passwordField);
		
		JButton giris = new JButton("Giriş");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullanicilarC kullanicilarC=new KullanicilarC();
				kullanicilarC.setKullaniciemail(textField.getText());
				kullaniciemail=textField.getText();
				kullanicilarC.setKullanicisifre(passwordField.getText());
				KullanicilarDal kullanicilarDal=new KullanicilarDal();
				if(kullanicilarDal.giris(kullanicilarC)==1) 
				{
					//JOptionPane.showMessageDialog(giris, "Giris basarili");
					//KullaniciArayuz kullaniciArayuz=new KullaniciArayuz();
					//kullaniciArayuz.setVisible(true);
					
					KullaniciArayuz();
				}
				else 
				{
					JOptionPane.showMessageDialog(giris, "Giris basarisiz");
				}
				
			}
		});
		giris.setForeground(SystemColor.controlShadow);
		giris.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		
		giris.setBackground(new Color(255,243,157));
		giris.setBounds(661, 509, 89, 23);
		giris.setBorder(null);
		contentPane.add(giris);
		
		
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		background.setBounds(0, 0, 1366, 768);
		contentPane.add(background);
	}
	//Giriş yapıldıktan sonra gelen panel
	public void KullaniciArayuz() 
	{
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
		
		//Kullanıcı Bilgileri Çek
		KullanicilarC kullanicilarC=new KullanicilarDal().getbyemail(kullaniciemail);		
		JLabel kullaniciad = new JLabel("Kullanici Adı");
		kullaniciad.setForeground(SystemColor.window);
		kullaniciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		kullaniciad.setBounds(26, 221, 200, 14);
		kullaniciad.setText("Kullanıcı: "+kullanicilarC.getKullaniciadi());
		panel.add(kullaniciad);
		JLabel kullanicimail = new JLabel("Kullanici Abonelik Tur");
		kullanicimail.setForeground(SystemColor.window);
		kullanicimail.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		kullanicimail.setBounds(26, 240, 200, 14);
		kullanicimail.setText("Abonelik Turu: "+kullanicilarC.getKullaniciaboneliktur());
		panel.add(kullanicimail);
		JList sarkilarlist=new JList(new SarkiDal().list().toArray()); //Tum sarkilar içinceki sarkilar list
		JList tskipedebileceklerin=new JList(new KullanicilarDal().premiumuyeler().toArray()); //Takip edebilecekler Listesi
		JList takipedilenler=new JList(new TakipEttikleriDal().list2(kullanicilarC.getKullaniciemail()).toArray()); //Takip edilenler
		JList listelerimcaz=new JList(new CazDal().listcaz(kullanicilarC.getKullaniciemail()).toArray()); //Listelerim Caz
		JList listelerimpop=new JList(new PopDal().listpop(kullanicilarC.getKullaniciemail()).toArray()); //Listelerim Pop
		JList listelerimklasik=new JList(new KlasikDal().listklasik(kullanicilarC.getKullaniciemail()).toArray()); //Listelerim Klasik
		JList encon10jlistJList=new JList(new PopDal().listpopSırala(kullanicilarC.getKullaniciemail()).toArray()); //En cok dinlenenler
		JList genelJList=new JList(new PopDal().list().toArray()); //En cok dinlenenler

		JLabel kullanicipp = new JLabel("New label");
		kullanicipp.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/admin2.png")));
		kullanicipp.setBounds(64, 54, 150, 150);
		panel.add(kullanicipp);
		
		//Paneller
		JPanel tumsarkilar = new JPanel();
		JPanel paneltakipettiklerin = new JPanel();
		JPanel paneltakipettiklerin2 = new JPanel();
		JPanel listelerim = new JPanel();
		JPanel en_cok_dinlenen_panel = new JPanel();
		JPanel en_cok_dinlenen_ulke_panel = new JPanel();
		
		
		
		
		JButton Tum_sarkilarButton = new JButton("Tüm Şarkılar");
		Tum_sarkilarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(true);
					paneltakipettiklerin.setVisible(false);	
					paneltakipettiklerin2.setVisible(false);
					listelerim.setVisible(false);
					en_cok_dinlenen_panel.setVisible(false);
					en_cok_dinlenen_ulke_panel.setVisible(false);
					sarkilarlist.setListData(new SarkiDal().list().toArray());
					
				}			
			}
		});
		Tum_sarkilarButton.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Tum_sarkilarButton.setBackground(new Color(51, 51, 51));
		Tum_sarkilarButton.setForeground(SystemColor.window);
		Tum_sarkilarButton.setBounds(26, 300, 224, 35);
		Tum_sarkilarButton.setBorder(null);
		panel.add(Tum_sarkilarButton);
		
		JButton takipebk = new JButton("Takip edebileceğin kullanıcılar");
		takipebk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(false);
					paneltakipettiklerin.setVisible(true);	
					paneltakipettiklerin2.setVisible(false);
					listelerim.setVisible(false);
					en_cok_dinlenen_panel.setVisible(false);
					en_cok_dinlenen_ulke_panel.setVisible(false);
					
				}			
			}
		});
		takipebk.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		takipebk.setBackground(new Color(51, 51, 51));
		takipebk.setForeground(SystemColor.window);
		takipebk.setBounds(26, 370, 224, 35);
		takipebk.setBorder(null);
		panel.add(takipebk);
		
		JButton Takip_ettiklerin = new JButton("Takip Ettiklerin");
		Takip_ettiklerin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(false);
					paneltakipettiklerin.setVisible(false);	
					paneltakipettiklerin2.setVisible(true);
					listelerim.setVisible(false);
					en_cok_dinlenen_panel.setVisible(false);
					en_cok_dinlenen_ulke_panel.setVisible(false);
					takipedilenler.setListData(new TakipEttikleriDal().list2(kullanicilarC.getKullaniciemail()).toArray());
					
				}			
			}
		});
		Takip_ettiklerin.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Takip_ettiklerin.setBackground(new Color(51, 51, 51));
		Takip_ettiklerin.setForeground(SystemColor.window);
		Takip_ettiklerin.setBounds(26, 440, 224, 35);
		Takip_ettiklerin.setBorder(null);
		panel.add(Takip_ettiklerin);
		
		JButton Listelerim = new JButton("Listelerim");
		Listelerim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(false);
					paneltakipettiklerin.setVisible(false);	
					paneltakipettiklerin2.setVisible(false);
					listelerim.setVisible(true);
					en_cok_dinlenen_panel.setVisible(false);
					en_cok_dinlenen_ulke_panel.setVisible(false);
					listelerimcaz.setListData(new CazDal().listcaz(kullanicilarC.getKullaniciemail()).toArray());
					listelerimklasik.setListData(new KlasikDal().listklasik(kullanicilarC.getKullaniciemail()).toArray());
					listelerimpop.setListData(new PopDal().listpop(kullanicilarC.getKullaniciemail()).toArray());
					
				}			
			}
		});
		Listelerim.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Listelerim.setBackground(new Color(51, 51, 51));
		Listelerim.setForeground(SystemColor.window);
		Listelerim.setBounds(26, 520, 224, 35);
		Listelerim.setBorder(null);
		panel.add(Listelerim);
		
		JButton En_cok_dinlenen = new JButton("En Çok Dinlenen");
		En_cok_dinlenen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(false);
					paneltakipettiklerin.setVisible(false);	
					paneltakipettiklerin2.setVisible(false);
					listelerim.setVisible(false);
					en_cok_dinlenen_panel.setVisible(true);
					en_cok_dinlenen_ulke_panel.setVisible(false);
					sarkilarlist.setListData(new SarkiDal().list().toArray());
					listelerimcaz.setListData(new CazDal().listcaz(kullanicilarC.getKullaniciemail()).toArray()); 
					listelerimpop.setListData(new PopDal().listpop(kullanicilarC.getKullaniciemail()).toArray()); //Listelerim Pop
					listelerimklasik.setListData(new KlasikDal().listklasik(kullanicilarC.getKullaniciemail()).toArray()); //Listelerim Klasik
					encon10jlistJList.setListData(new PopDal().listpopSırala(kullanicilarC.getKullaniciemail()).toArray()); //En cok dinlenenler
					genelJList.setListData(new PopDal().list().toArray()); //En cok dinlenenler
					
				}			
			}
		});
		En_cok_dinlenen.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		En_cok_dinlenen.setBackground(new Color(51, 51, 51));
		En_cok_dinlenen.setForeground(SystemColor.window);
		En_cok_dinlenen.setBounds(26, 600, 224, 35);
		En_cok_dinlenen.setBorder(null);
		panel.add(En_cok_dinlenen);
		
		JButton En_cok_dinlenen_ulke = new JButton("En Çok Dinlenen");
		En_cok_dinlenen_ulke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					tumsarkilar.setVisible(false);
					paneltakipettiklerin.setVisible(false);	
					paneltakipettiklerin2.setVisible(false);
					listelerim.setVisible(false);
					en_cok_dinlenen_panel.setVisible(false);
					en_cok_dinlenen_ulke_panel.setVisible(true);
					encon10jlistJList.setListData(new PopDal().listpopSırala(kullanicilarC.getKullaniciemail()).toArray());
				}			
			}
		});
		En_cok_dinlenen_ulke.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		En_cok_dinlenen_ulke.setBackground(new Color(51, 51, 51));
		En_cok_dinlenen_ulke.setForeground(SystemColor.window);
		En_cok_dinlenen_ulke.setBounds(26, 670, 224, 35);
		En_cok_dinlenen_ulke.setBorder(null);
		panel.add(En_cok_dinlenen_ulke);
		
		
		//Panel Arkaplan
		JLabel panelarka = new JLabel("New label");
		panelarka.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background2.png")));
		panelarka.setBounds(0, 0, 300, 768);
		panel.add(panelarka);
		//Tum Sarkilar Panel
		tumsarkilar.setBounds(300, 0, 1066, 768);
		contentPane.add(tumsarkilar);
		tumsarkilar.setLayout(null);
		
		JScrollPane sarkitablosu_scroll = new JScrollPane(sarkilarlist);
		sarkitablosu_scroll.setBounds(60, 200, 950, 300);
		tumsarkilar.add(sarkitablosu_scroll);
		sarkilarlist.setForeground(SystemColor.window);
		sarkilarlist.setBackground(Color.DARK_GRAY);
		
		JButton SarkiEkle = new JButton("Şarkıyı Ekle");
		SarkiEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					 SarkiC sarkiC=(SarkiC)sarkilarlist.getSelectedValue();
					
					 String turString=sarkiC.getTuralbums();
						
					 
						PopC popC=new PopC();
						popC.setKullanicisi(kullanicilarC.getKullaniciemail());
						popC.setSarkiidsi(sarkiC.getIdsarki());
						popC.setSarkitur(sarkiC.getTuralbums());
						popC.setDinlenmesayisi(sarkiC.getDinlenmesayisi());
						
						new PopDal().insert(popC);
					
					
						KlasikC klasikC=new KlasikC();
						klasikC.setKullanicisi(kullanicilarC.getKullaniciemail());
						klasikC.setSarkiidsi(sarkiC.getIdsarki());
						klasikC.setSarkitur(sarkiC.getTuralbums());
						klasikC.setDinlenmesayisi(sarkiC.getDinlenmesayisi());
						new KlasikDal().insert(klasikC);
					
				
						CazC cazC=new CazC();
						cazC.setKullanicisi(kullanicilarC.getKullaniciemail());
						cazC.setSarkiidsi(sarkiC.getIdsarki());
						cazC.setSarkitur(sarkiC.getTuralbums());
						cazC.setDinlenmesayisi(cazC.getDinlenmesayisi());
						new CazDal().insert(cazC);
					
					
					
				}			
			}
		});
		SarkiEkle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		SarkiEkle.setBackground(new Color(51, 51, 51));
		SarkiEkle.setForeground(SystemColor.window);
		SarkiEkle.setBounds(400, 520, 224, 35);
		SarkiEkle.setBorder(null);
		tumsarkilar.add(SarkiEkle);
		
		JLabel tumsarkilarbg = new JLabel("New label");
		tumsarkilarbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		tumsarkilarbg.setBounds(0, 0, 1066, 768);
		tumsarkilar.add(tumsarkilarbg);
		tumsarkilar.setVisible(true);
		
		//Takip edebileceklerin panel
		paneltakipettiklerin.setBounds(300, 0, 1066, 768);
		contentPane.add(paneltakipettiklerin);
		paneltakipettiklerin.setLayout(null);
		
		tskipedebileceklerin.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		tskipedebileceklerin.setForeground(SystemColor.window);
		tskipedebileceklerin.setBackground(Color.DARK_GRAY);
		JScrollPane kullanicilarp = new JScrollPane(tskipedebileceklerin);
		kullanicilarp.setToolTipText("");
		kullanicilarp.setViewportBorder(new LineBorder(Color.GRAY, 3));
		kullanicilarp.setBounds(80, 154, 907, 200);
		kullanicilarp.setBackground(new Color(25,25,25));
		paneltakipettiklerin.add(kullanicilarp);
		
		JButton TakipEt = new JButton("Takip Et");
		TakipEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{	
					KullanicilarC kullanicilarC2=(KullanicilarC)tskipedebileceklerin.getSelectedValue();
					TakipEttikleriC takipEttikleriC=new TakipEttikleriC();
					takipEttikleriC.setKullanicisi(kullanicilarC.getKullaniciemail());
					takipEttikleriC.setKullaniciid(kullanicilarC2.getKullaniciadi());
					takipEttikleriC.setTakipedilenkullanici(kullanicilarC2.getKullaniciemail());
					new TakipEttikleriDal().insert(takipEttikleriC);
					
					
					
				}			
			}
		});
		TakipEt.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		TakipEt.setBackground(new Color(51, 51, 51));
		TakipEt.setForeground(SystemColor.window);
		TakipEt.setBounds(400, 520, 224, 35);
		TakipEt.setBorder(null);
		paneltakipettiklerin.add(TakipEt);
		JLabel takipettiklerinbg = new JLabel("New label");
		takipettiklerinbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		takipettiklerinbg.setBounds(0, 0, 1066, 768);
		paneltakipettiklerin.add(takipettiklerinbg);
		paneltakipettiklerin.setVisible(false);
		
		//Takip Ettiklerinr Panel
		paneltakipettiklerin2.setBounds(300, 0, 1066, 768);
		contentPane.add(paneltakipettiklerin2);
		paneltakipettiklerin2.setLayout(null);
		//Takip edilen kullanıcılar liste halinde gelicek Seçilen kullanıcının listeleri görüntülenecek 
		//Açılan listelerden şarkı eklemesi yapılabilecek Şarkı türe göre oluşturulan listeye
		//Secilen List
		
		JScrollPane takipettiklerins = new JScrollPane(takipedilenler);
		takipettiklerins.setToolTipText("");
		takipettiklerins.setViewportBorder(new LineBorder(Color.GRAY, 3));
		takipettiklerins.setBounds(80, 154, 957, 150);
		takipettiklerins.setBackground(new Color(25,25,25));
		paneltakipettiklerin2.add(takipettiklerins);
		
		
		JButton Takipettigin_liste = new JButton("Listelerini Goruntule");
		Takipettigin_liste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{
					 
					TakipEttikleriC takipEttikleriC=(TakipEttikleriC)takipedilenler.getSelectedValue();
				
					JList secilencazJList=new JList(new CazDal().listcaz(takipEttikleriC.getTakipedilenkullanici()).toArray());
					JList secilenpopJList=new JList(new PopDal().listpop(takipEttikleriC.getTakipedilenkullanici()).toArray());
					JList secilenklasikJList=new JList(new KlasikDal().listklasik(takipEttikleriC.getTakipedilenkullanici()).toArray());
					JScrollPane takipedilencazliste = new JScrollPane();
					takipedilencazliste.setViewportBorder(new LineBorder(Color.GRAY, 3));
					takipedilencazliste.setBounds(80, 374, 280, 250);
					takipedilencazliste.setBackground(new Color(25,25,25));
					paneltakipettiklerin2.add(takipedilencazliste);
					
					JScrollPane takipedilenklasikliste = new JScrollPane();
					takipedilenklasikliste.setViewportBorder(new LineBorder(Color.GRAY, 3));
					takipedilenklasikliste.setBounds(410, 374, 280, 250);
					takipedilenklasikliste.setBackground(new Color(25,25,25));
					paneltakipettiklerin2.add(takipedilenklasikliste);
										
					JScrollPane takipedilenlerpopliste = new JScrollPane();
					takipedilenlerpopliste.setViewportBorder(new LineBorder(Color.GRAY, 3));
					takipedilenlerpopliste.setBounds(760, 374, 280, 250);
					takipedilenlerpopliste.setBackground(new Color(25,25,25));
					paneltakipettiklerin2.add(takipedilenlerpopliste);
					secilencazJList.setForeground(SystemColor.window);  
					secilencazJList.setBackground(Color.DARK_GRAY);
					secilenpopJList.setForeground(SystemColor.window);  
					secilenpopJList.setBackground(Color.DARK_GRAY);
					secilenklasikJList.setForeground(SystemColor.window);  
					secilenklasikJList.setBackground(Color.DARK_GRAY);
					takipedilencazliste.add(secilencazJList);
					takipedilenklasikliste.add(secilenklasikJList);
					takipedilenlerpopliste.add(secilenpopJList);
										
				}			
			}
		});
		Takipettigin_liste.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Takipettigin_liste.setBackground(new Color(51, 51, 51));
		Takipettigin_liste.setForeground(SystemColor.window);
		Takipettigin_liste.setBounds(440, 320, 224, 35);
		Takipettigin_liste.setBorder(null);
		paneltakipettiklerin2.add(Takipettigin_liste);
		
		JLabel paneltakipettiklerin2bg = new JLabel("New label");
		paneltakipettiklerin2bg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		paneltakipettiklerin2bg.setBounds(0, 0, 1066, 768);
		paneltakipettiklerin2.add(paneltakipettiklerin2bg);
		paneltakipettiklerin2.setVisible(false);
		
		//Listelerim Panel
		listelerim.setBounds(300, 0, 1066, 768);
		contentPane.add(listelerim);
		listelerim.setLayout(null);
		//Oluşturulan 3 tablo pop caz klasik şarkı listeleri görüntülenecek
		
		JScrollPane cazscroll = new JScrollPane(listelerimcaz); //Caz liste
		cazscroll.setBounds(60, 40, 550, 200);
		listelerim.add(cazscroll);
		listelerimcaz.setForeground(SystemColor.window);
		listelerimcaz.setBackground(Color.DARK_GRAY);
		
		JScrollPane klasikscroll = new JScrollPane(listelerimklasik); //Klasik liste
		klasikscroll.setBounds(60, 290, 550, 200);
		listelerim.add(klasikscroll);
		listelerimklasik.setForeground(SystemColor.window);
		listelerimklasik.setBackground(Color.DARK_GRAY);
		
		JScrollPane popscroll = new JScrollPane(listelerimpop); //Pop liste
		popscroll.setBounds(60, 530, 550, 200);
		listelerim.add(popscroll);
		listelerimpop.setForeground(SystemColor.window);  
		listelerimpop.setBackground(Color.DARK_GRAY);
		//Buttonlar Listelerim
		JButton Caz_Dinle = new JButton("Dinle");
		Caz_Dinle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{
					CazC secilencaz=(CazC)listelerimcaz.getSelectedValue();
					new CazDal().dinlenmesayisi(secilencaz.getDinlenmesayisi(),secilencaz.getSarkiidsi());
					listelerimcaz.setListData(new CazDal().listcaz(kullanicilarC.getKullaniciemail()).toArray());
					
					
				}			
			}
		});
		Caz_Dinle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Caz_Dinle.setBackground(new Color(51, 51, 51));
		Caz_Dinle.setForeground(SystemColor.window);
		Caz_Dinle.setBounds(670, 120, 224, 35);
		Caz_Dinle.setBorder(null);
		listelerim.add(Caz_Dinle);
		
		JButton Klasik_Dinle = new JButton("Dinle");
		Klasik_Dinle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{
					KlasikC secilenklasik=(KlasikC)listelerimklasik.getSelectedValue();
					new KlasikDal().dinlenmesayisi(secilenklasik.getDinlenmesayisi(), secilenklasik.getSarkiidsi());
					listelerimklasik.setListData(new KlasikDal().listklasik(kullanicilarC.getKullaniciemail()).toArray());
					
					
				}			
			}
		});
		Klasik_Dinle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Klasik_Dinle.setBackground(new Color(51, 51, 51));
		Klasik_Dinle.setForeground(SystemColor.window);
		Klasik_Dinle.setBounds(670, 365, 224, 35);
		Klasik_Dinle.setBorder(null);
		listelerim.add(Klasik_Dinle);
		
		JButton Pop_Dinle = new JButton("Dinle");
		Pop_Dinle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{
					PopC secilenPopC=(PopC)listelerimpop.getSelectedValue();
					new PopDal().dinlenmesayisi(secilenPopC.getDinlenmesayisi(), secilenPopC.getSarkiidsi());
					listelerimpop.setListData(new PopDal().listpop(kullanicilarC.getKullaniciemail()).toArray());
				}			
			}
		});
		Pop_Dinle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		Pop_Dinle.setBackground(new Color(51, 51, 51));
		Pop_Dinle.setForeground(SystemColor.window);
		Pop_Dinle.setBounds(670, 620, 224, 35);
		Pop_Dinle.setBorder(null);
		listelerim.add(Pop_Dinle);
		
		
		JLabel listelerimbg = new JLabel("New label");
		listelerimbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		listelerimbg.setBounds(0, 0, 1066, 768);
		listelerim.add(listelerimbg);
		listelerim.setVisible(false);
		
		//En çok 10 Panel
		en_cok_dinlenen_panel.setBounds(300, 0, 1066, 768);
		contentPane.add(en_cok_dinlenen_panel);
		en_cok_dinlenen_panel.setLayout(null);
		
		
		JScrollPane encok10 = new JScrollPane(encon10jlistJList);
		encok10.setToolTipText("");
		encok10.setViewportBorder(new LineBorder(Color.GRAY, 3));
		encok10.setBounds(80, 154, 957, 150);
		encok10.setBackground(new Color(25,25,25));
		en_cok_dinlenen_panel.add(encok10);
		encon10jlistJList.setForeground(SystemColor.window);  
		encon10jlistJList.setBackground(Color.DARK_GRAY);
		JLabel en_cok_dinlenen_panelbg = new JLabel("New label");
		en_cok_dinlenen_panelbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		en_cok_dinlenen_panelbg.setBounds(0, 0, 1066, 768);
		en_cok_dinlenen_panel.add(en_cok_dinlenen_panelbg);
		en_cok_dinlenen_panel.setVisible(false);
		
		//En çok 10 Ulkeler Panel
		en_cok_dinlenen_ulke_panel.setBounds(300, 0, 1066, 768);
		contentPane.add(en_cok_dinlenen_ulke_panel);
		en_cok_dinlenen_ulke_panel.setLayout(null);
		
		JScrollPane genelJScrollPane = new JScrollPane(genelJList);
		genelJScrollPane.setToolTipText("");
		genelJScrollPane.setViewportBorder(new LineBorder(Color.GRAY, 3));
		genelJScrollPane.setBounds(80, 154, 957, 150);
		genelJScrollPane.setBackground(new Color(25,25,25));
		en_cok_dinlenen_ulke_panel.add(genelJScrollPane);
		genelJList.setForeground(SystemColor.window);  
		genelJList.setBackground(Color.DARK_GRAY);
		
		JLabel en_cok_dinlenen_ulke_panelbg = new JLabel("New label");
		en_cok_dinlenen_ulke_panelbg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
		en_cok_dinlenen_ulke_panelbg.setBounds(0, 0, 1066, 768);
		en_cok_dinlenen_ulke_panel.add(en_cok_dinlenen_ulke_panelbg);
		en_cok_dinlenen_ulke_panel.setVisible(false);
		
		
		
		//Background
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1366, 768);
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		contentPane.add(background);
	}
	
}
