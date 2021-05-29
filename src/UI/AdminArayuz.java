package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Dal.AlbumDal;
import Dal.KullanicilarDal;
import Dal.SanatciDal;
import Dal.SarkiDal;
import classes.AlbumC;
import classes.SanatciC;
import classes.SarkiC;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JComboBox;

public class AdminArayuz extends JFrame {

	private JPanel contentPane;
	private JTextField sanatciaditxt;
	private JTextField sanatciulketxt;
	private JTextField sanatciid2txt;
	private JTextField albumturtxt;
	private JTextField suretxt;
	private JTextField tarihtxt;
	private JTextField albumekletxt;
	private JTextField sanatciadi3txt;
	private JTextField sarki3txt;
	private JTextField tarih3txt;
	private JTextField turtxt;
	private JTextField sarkiid_txt;
	private JTextField albumidtxt;
	
	//Gucelleme TXTler
	private JTextField guncellesanatciid;
	private JTextField guncellesanatciad;
	private JTextField guncellesanatciulke;
	private JTextField idsanatcitxt;
	private JTextField guncellealbumtur;
	private JTextField guncellesure;
	private JTextField guncelletarih;
	private JTextField guncellealbumad;
	private JTextField guncellealbumtarih;
	private JTextField guncellealbumatur;
	//Listeler
	//Sanatci Sayfası
	private JList sanatcilarJListS=new JList(new SanatciDal().tumsanatcilar().toArray());
	//Sarki Sayfasi
	private JList sanatcilarJListSanatcilar=new JList(new SanatciDal().tumsanatcilar().toArray());
	private JList sarkilarlistSanatcilar=new JList(new SarkiDal().list().toArray());
	//Album sayfası
	private JList sanatcilarJListAlbum=new JList(new SanatciDal().tumsanatcilar().toArray());
	private JList albumlistAlbum=new JList(new AlbumDal().list().toArray());
	private JList sarkilarlistAlbum=new JList(new SarkiDal().list().toArray());
	
	private JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
	private JList albumlist=new JList(new AlbumDal().list().toArray());
	private JList sarkilarlist=new JList(new SarkiDal().list().toArray());
	
	//Silme
	private JList sanatcilarJListSilme=new JList(new SanatciDal().tumsanatcilar().toArray());
	private JList albumlistSilme=new JList(new AlbumDal().list().toArray());
	private JList sarkilarlistSilme=new JList(new SarkiDal().list().toArray());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminArayuz frame = new AdminArayuz();
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
	public AdminArayuz() {
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
		//Paneller
		JPanel panel_sarkiekle = new JPanel();
		JPanel panel_sanatciekle = new JPanel();
		JPanel panel_albumekle = new JPanel();
		JPanel panel_silme = new JPanel();
		JPanel panel_guncelleme = new JPanel();
		
		//Admin Bilgileri Çek
		//KullanicilarC kullanicilarC=new KullanicilarDal().getbyemail(kullaniciemail);
		JLabel adminad = new JLabel("Admin Adı");
		adminad.setForeground(SystemColor.window);
		adminad.setFont(new Font("Baloo Bhai", Font.PLAIN, 14));
		adminad.setBounds(26, 221, 200, 14);
		//adminad.setText("Kullanıcı: "+kullanicilarC.getKullaniciadi());
		panel.add(adminad);
		
		//Sanatçı Ekle
		JButton sanatciekle = new JButton("Sanatçı Ekle");
		sanatciekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_sanatciekle.setVisible(true);
				panel_sarkiekle.setVisible(false);
				panel_albumekle.setVisible(false);
				panel_silme.setVisible(false);
				panel_guncelleme.setVisible(false);
				sanatcilarJList.setListData(new SanatciDal().tumsanatcilar().toArray());
				sanatcilarJListSanatcilar.setListData(new SanatciDal().tumsanatcilar().toArray());
				sarkilarlistSanatcilar.setListData(new SarkiDal().list().toArray());
			}
		});
		sanatciekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		sanatciekle.setBackground(new Color(51, 51, 51));
		sanatciekle.setForeground(SystemColor.window);
		sanatciekle.setBounds(26, 300, 224, 35);
		sanatciekle.setBorder(null);
		panel.add(sanatciekle);
		//
		//Şarkı Ekle
		JButton sarkiekle = new JButton("Şarkı Ekle");
		sarkiekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				{					
					panel_sarkiekle.setVisible(true);
					panel_sanatciekle.setVisible(false);
					panel_albumekle.setVisible(false);
					panel_silme.setVisible(false);
					panel_guncelleme.setVisible(false);
					sanatcilarJListSanatcilar.setListData(new SanatciDal().tumsanatcilar().toArray());
					sarkilarlistSanatcilar.setListData(new SarkiDal().list().toArray());
					
					
				}			
			}
		});
		sarkiekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		sarkiekle.setBackground(new Color(51, 51, 51));
		sarkiekle.setForeground(SystemColor.window);
		sarkiekle.setBounds(26, 375, 224, 35);
		sarkiekle.setBorder(null);
		panel.add(sarkiekle);
		//
		//Album Ekle
		JButton albumekle = new JButton("Album Ekle");
		albumekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_albumekle.setVisible(true);
				panel_sarkiekle.setVisible(false);
				panel_sanatciekle.setVisible(false);
				panel_silme.setVisible(false);
				panel_guncelleme.setVisible(false);
				sanatcilarJListAlbum.setListData(new SanatciDal().tumsanatcilar().toArray());
				albumlistAlbum.setListData(new AlbumDal().list().toArray());
				sarkilarlistAlbum.setListData(new SarkiDal().list().toArray());
			}
			
		});
		albumekle.setForeground(Color.WHITE);
		albumekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		albumekle.setBorder(null);
		albumekle.setBackground(new Color(51, 51, 51));
		albumekle.setBounds(26, 450, 224, 35);
		panel.add(albumekle);
		//
		//Silme islemleri
		JButton silmeislemleri = new JButton("Silme İşlemleri");
		silmeislemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_silme.setVisible(true);
				panel_sanatciekle.setVisible(false);
				panel_sarkiekle.setVisible(false);
				panel_albumekle.setVisible(false);
				panel_guncelleme.setVisible(false);
				sanatcilarJList.setListData(new SanatciDal().tumsanatcilar().toArray());
				albumlist.setListData(new AlbumDal().list().toArray());
				sarkilarlist.setListData(new SarkiDal().list().toArray());
			}
		});
		silmeislemleri.setForeground(Color.WHITE);
		silmeislemleri.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		silmeislemleri.setBorder(null);
		silmeislemleri.setBackground(new Color(51, 51, 51));
		silmeislemleri.setBounds(26, 525, 224, 35);
		panel.add(silmeislemleri);
		//
		//Guncelleme İslemleri Button
		JButton guncellemeislemleri = new JButton("Güncelleme İşlemleri");
		guncellemeislemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_guncelleme.setVisible(true);
				panel_sarkiekle.setVisible(false);
				panel_sanatciekle.setVisible(false);
				panel_albumekle.setVisible(false);
				panel_silme.setVisible(false);
				sanatcilarJListSilme.setListData(new SanatciDal().tumsanatcilar().toArray());
				albumlistSilme.setListData(new AlbumDal().list().toArray());
				sarkilarlistSilme.setListData(new SarkiDal().list().toArray());
				
			}
		});
		guncellemeislemleri.setForeground(Color.WHITE);
		guncellemeislemleri.setFont(new Font("Baloo Bhai", Font.PLAIN, 13));
		guncellemeislemleri.setBorder(null);
		guncellemeislemleri.setBackground(new Color(51, 51, 51));
		guncellemeislemleri.setBounds(26, 600, 224, 35);
		panel.add(guncellemeislemleri);
		//
		//Panel Arkaplan
		JLabel panelarka = new JLabel("New label");
		panelarka.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background2.png")));
		panelarka.setBounds(0, 0, 300, 768);
		panel.add(panelarka);
		{
			//Panel Sanatcı Ekle
			panel_sanatciekle.setBounds(300, 0, 1066, 768);
			contentPane.add(panel_sanatciekle);
			panel_sanatciekle.setLayout(null);
			panel_sanatciekle.setVisible(true);
			//Sanatcı Scroll ve Listeler
			//JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
			//JList albumlist=new JList(new AlbumDal().list().toArray());
			//JList sarkilarlist=new JList(new SarkiDal().list().toArray());
			JScrollPane sanatcitabloscroll = new JScrollPane(sanatcilarJListS);
			sanatcitabloscroll.setBounds(400, 512, 200, 200);
			panel_sanatciekle.add(sanatcitabloscroll);
			JLabel lblsanatciekle = new JLabel("Sanatçı Ekle ");
			lblsanatciekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 24));
			lblsanatciekle.setForeground(SystemColor.window);
			lblsanatciekle.setBounds(50, 80, 150, 25);
			panel_sanatciekle.add(lblsanatciekle);JLabel lblSanatId = new JLabel("Sanatçı ID");
			lblSanatId.setForeground(Color.WHITE);
			lblSanatId.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblSanatId.setBounds(250, 230, 125, 20);
			panel_sanatciekle.add(lblSanatId);
			idsanatcitxt = new JTextField();
			idsanatcitxt.setForeground(SystemColor.windowBorder);
			idsanatcitxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			idsanatcitxt.setColumns(10);
			idsanatcitxt.setBounds(500, 230, 200, 25);
			panel_sanatciekle.add(idsanatcitxt);
			JLabel lblsanatciadi = new JLabel("Sanatçı Adı");
			lblsanatciadi.setForeground(SystemColor.window);
			lblsanatciadi.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsanatciadi.setBounds(250, 300, 125, 20);
			panel_sanatciekle.add(lblsanatciadi);
			sanatciaditxt = new JTextField();
			sanatciaditxt.setForeground(SystemColor.windowBorder);
			sanatciaditxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			sanatciaditxt.setBounds(500, 300, 200, 25);
			panel_sanatciekle.add(sanatciaditxt);
			sanatciaditxt.setColumns(10);
			JLabel lblsanatciulke = new JLabel("Sanatçı Ülke");
			lblsanatciulke.setForeground(Color.WHITE);
			lblsanatciulke.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsanatciulke.setBounds(250, 370, 125, 20);
			panel_sanatciekle.add(lblsanatciulke);
			sanatciulketxt = new JTextField();
			sanatciulketxt.setForeground(SystemColor.windowBorder);
			sanatciulketxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			sanatciulketxt.setColumns(10);
			sanatciulketxt.setBounds(500, 370, 200, 25);
			panel_sanatciekle.add(sanatciulketxt);
			
			
			
			
			
			
			
			JButton SanatciEkleButton = new JButton("Sanatçıyı Ekle");
			SanatciEkleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!sanatciaditxt.getText().equals("") && !sanatciulketxt.getText().equals("")) 
					{
						SanatciC sanatciC=new SanatciC();
						sanatciC.setIdsanatci(idsanatcitxt.getText());
						sanatciC.setAdsanatci(sanatciaditxt.getText());
						sanatciC.setUlkesanatci(sanatciulketxt.getText());
						new SanatciDal().insert(sanatciC);
						sanatcilarJListS.setListData(new SanatciDal().tumsanatcilar().toArray());
						albumlistAlbum.setListData(new AlbumDal().list().toArray());
						sarkilarlistSanatcilar.setListData(new SarkiDal().list().toArray());
						
					}
				}
			});
			SanatciEkleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SanatciEkleButton.setBackground(SystemColor.windowBorder);
			SanatciEkleButton.setForeground(SystemColor.window);
			SanatciEkleButton.setBounds(400, 466, 200, 25);
			SanatciEkleButton.setBorder(null);
			panel_sanatciekle.add(SanatciEkleButton);
			
			JLabel sanatcieklebg = new JLabel("");
			sanatcieklebg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
			sanatcieklebg.setBounds(0, 0, 1066, 768);
			panel_sanatciekle.add(sanatcieklebg);
		}							
		
		
		
		
		
		
		
		
	
						
		
		{
			//Panel Şarkı Ekle
			panel_sarkiekle.setBounds(300, 0, 1066, 768);
			contentPane.add(panel_sarkiekle);
			panel_sarkiekle.setLayout(null);
			panel_sarkiekle.setVisible(false);
			//Sanatcı Tablosu Şarkı içinde Scroll
			//JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
			JScrollPane sanatcitabloscroll2 = new JScrollPane(sanatcilarJListSanatcilar);
			sanatcitabloscroll2.setBounds(250, 512, 200, 200);
			panel_sarkiekle.add(sanatcitabloscroll2);
			
			//
			
			//Sanrkı Tablosu Şarkı içinde Scroll
			//JList sarkilarlist=new JList(new SarkiDal().list().toArray());
			JScrollPane sarkitablosu_scroll = new JScrollPane(sarkilarlistSanatcilar);
			sarkitablosu_scroll.setBounds(550, 512, 200, 200);
			panel_sarkiekle.add(sarkitablosu_scroll);
			JLabel lblsarkiekle = new JLabel("Sarkı Ekle ");
			lblsarkiekle.setForeground(Color.WHITE);
			lblsarkiekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 24));
			lblsarkiekle.setBounds(50, 80, 150, 25);
			panel_sarkiekle.add(lblsarkiekle);
			JLabel sarkiid_lbl = new JLabel("Şarkı ID");
			sarkiid_lbl.setForeground(Color.WHITE);
			sarkiid_lbl.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			sarkiid_lbl.setBounds(250, 150, 125, 20);
			panel_sarkiekle.add(sarkiid_lbl);
			sarkiid_txt = new JTextField();
			sarkiid_txt.setForeground(SystemColor.windowBorder);
			sarkiid_txt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			sarkiid_txt.setColumns(10);
			sarkiid_txt.setBounds(500, 150, 200, 25);
			panel_sarkiekle.add(sarkiid_txt);
			
			JLabel lblsanatciid2 = new JLabel("Sanatçı ID");
			lblsanatciid2.setForeground(Color.WHITE);
			lblsanatciid2.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsanatciid2.setBounds(250, 200, 125, 20);
			panel_sarkiekle.add(lblsanatciid2);
			
			//Sanatcı id list içine sanatcı tablosunun idleri atılacak
			JComboBox sanatciid_txt = new JComboBox(new SanatciDal().sanatciid().toArray());
			sanatciid_txt.setBounds(500, 200, 200, 20);
			panel_sarkiekle.add(sanatciid_txt);
			
			JLabel lblalbumtur = new JLabel("Album Tur");
			lblalbumtur.setForeground(Color.WHITE);
			lblalbumtur.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblalbumtur.setBounds(250, 250, 125, 20);
			panel_sarkiekle.add(lblalbumtur);
			albumturtxt = new JTextField();
			albumturtxt.setForeground(SystemColor.windowBorder);
			albumturtxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			albumturtxt.setColumns(10);
			albumturtxt.setBounds(500, 250, 200, 25);
			panel_sarkiekle.add(albumturtxt);
			JLabel lblsure = new JLabel("Süre");
			lblsure.setForeground(Color.WHITE);
			lblsure.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsure.setBounds(250, 300, 125, 20);
			panel_sarkiekle.add(lblsure);
			suretxt = new JTextField();
			suretxt.setForeground(SystemColor.windowBorder);
			suretxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			suretxt.setColumns(10);
			suretxt.setBounds(500, 300, 200, 25);
			panel_sarkiekle.add(suretxt);
			JLabel lbltarih = new JLabel("Tarih");
			lbltarih.setForeground(Color.WHITE);
			lbltarih.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lbltarih.setBounds(250, 350, 125, 20);
			panel_sarkiekle.add(lbltarih);
			tarihtxt = new JTextField();
			tarihtxt.setForeground(SystemColor.windowBorder);
			tarihtxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			tarihtxt.setColumns(10);
			tarihtxt.setBounds(500, 350, 200, 25);
			panel_sarkiekle.add(tarihtxt);
			
			
			
			
			JButton SarkıEkleButton = new JButton("Şarkıyı Ekle");
			SarkıEkleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!sarkiid_txt.getText().equals("")&& !albumturtxt.getText().equals("") && !suretxt.getText().equals("")&& !tarihtxt.getText().equals("")) 
					{
						SarkiC sarkiC=new SarkiC();
						sarkiC.setIdsarki(sarkiid_txt.getText());
						sarkiC.setTarihsarki(tarihtxt.getText());
						
						sarkiC.setSanatcisarki((String)sanatciid_txt.getSelectedItem().toString());
						sarkiC.setTuralbums(albumturtxt.getText());
						sarkiC.setSuresarki(suretxt.getText());
						sarkiC.setDinlenmesayisi(0);
						new SarkiDal().insert(sarkiC);
						sarkilarlistSanatcilar.setListData(new SarkiDal().list().toArray());
						
					}
				}
			});
			SarkıEkleButton.setForeground(Color.WHITE);
			SarkıEkleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SarkıEkleButton.setBorder(null);
			SarkıEkleButton.setBackground(SystemColor.windowBorder);
			SarkıEkleButton.setBounds(386, 400, 200, 25);
			panel_sarkiekle.add(SarkıEkleButton);
			JLabel sarkieklebg = new JLabel("");
			sarkieklebg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
			sarkieklebg.setBounds(0, 0, 1066, 768);
			panel_sarkiekle.add(sarkieklebg);
		}
		{
			//Panel Album Ekle
			panel_albumekle.setBounds(300, 0, 1066, 768);
			contentPane.add(panel_albumekle);
			panel_albumekle.setLayout(null);
			panel_albumekle.setVisible(false);
			//
			//Sanatcı Tablosu Album içinde Scroll
			//JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
			JScrollPane sanatcitabloscroll3 = new JScrollPane(sanatcilarJListAlbum);
			sanatcitabloscroll3.setBounds(50, 512, 200, 200);
			panel_albumekle.add(sanatcitabloscroll3);
			
			//Sarkı tablosu Album içinde
			//JList sarkilarlist=new JList(new SarkiDal().list().toArray());
			JScrollPane sarkitabloscroll = new JScrollPane(sarkilarlistAlbum);
			sarkitabloscroll.setBounds(400, 512, 200, 200);
			panel_albumekle.add(sarkitabloscroll);
			
			//Album Tablo Album içinde
			//JList albumlist=new JList(new AlbumDal().list().toArray());
			JScrollPane albumtabloscroll = new JScrollPane(albumlistAlbum);
			albumtabloscroll.setBounds(800, 512, 200, 200);
			panel_albumekle.add(albumtabloscroll);
			
			JLabel lblalbumekle = new JLabel("Albüm Ekle ");
			lblalbumekle.setForeground(Color.WHITE);
			lblalbumekle.setFont(new Font("Baloo Bhai", Font.PLAIN, 24));
			lblalbumekle.setBounds(50, 80, 150, 25);
			panel_albumekle.add(lblalbumekle);
			JLabel lblalbumid = new JLabel("Album ID");
			lblalbumid.setForeground(Color.WHITE);
			lblalbumid.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblalbumid.setBounds(250, 150, 125, 20);
			panel_albumekle.add(lblalbumid);
			albumidtxt = new JTextField();
			albumidtxt.setForeground(SystemColor.windowBorder);
			albumidtxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			albumidtxt.setColumns(10);
			albumidtxt.setBounds(500, 150, 200, 25);
			panel_albumekle.add(albumidtxt);
			
			JLabel lblsalbumadi = new JLabel("Album Adı");
			lblsalbumadi.setForeground(Color.WHITE);
			lblsalbumadi.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsalbumadi.setBounds(250, 200, 125, 20);
			panel_albumekle.add(lblsalbumadi);
			albumekletxt = new JTextField();
			albumekletxt.setForeground(SystemColor.windowBorder);
			albumekletxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			albumekletxt.setColumns(10);
			albumekletxt.setBounds(500, 200, 200, 25);
			panel_albumekle.add(albumekletxt);
			JLabel lblsanatciadi3 = new JLabel("Sanatçı Adı");
			lblsanatciadi3.setForeground(Color.WHITE);
			lblsanatciadi3.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsanatciadi3.setBounds(250, 250, 125, 20);
			panel_albumekle.add(lblsanatciadi3);
			//Sanatci ad liste deneme
			//deneme
			JList list=new JList(new SanatciDal().list().toArray());
		
			JComboBox comboBox = new JComboBox(new SanatciDal().list().toArray());
			comboBox.setEditable(true);
			comboBox.setMaximumRowCount(50);
			comboBox.setBounds(500, 250, 200, 25);
		
			panel_albumekle.add(comboBox);
			JLabel lblsarki3 = new JLabel("Şarkı ID");
			lblsarki3.setForeground(Color.WHITE);
			lblsarki3.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lblsarki3.setBounds(250, 300, 125, 20);
			panel_albumekle.add(lblsarki3);
			
			//Şarkı id liste
			JComboBox sarkiid_txt = new JComboBox(new SarkiDal().sarkiid().toArray());
			sarkiid_txt.setEditable(true);
			sarkiid_txt.setMaximumRowCount(50);
			sarkiid_txt.setBounds(500, 300, 200, 25);
			panel_albumekle.add(sarkiid_txt);
			
			JLabel lbltarih3 = new JLabel("Tarih");
			lbltarih3.setForeground(Color.WHITE);
			lbltarih3.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lbltarih3.setBounds(250, 350, 125, 20);
			panel_albumekle.add(lbltarih3);
			tarih3txt = new JTextField();
			tarih3txt.setForeground(SystemColor.windowBorder);
			tarih3txt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			tarih3txt.setColumns(10);
			tarih3txt.setBounds(500, 350, 200, 25);
			panel_albumekle.add(tarih3txt);
			JLabel lbltur = new JLabel("Tür");
			lbltur.setForeground(Color.WHITE);
			lbltur.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			lbltur.setBounds(250, 400, 125, 20);
			panel_albumekle.add(lbltur);
			turtxt = new JTextField();
			turtxt.setForeground(SystemColor.windowBorder);
			turtxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 20));
			turtxt.setColumns(10);
			turtxt.setBounds(500, 400, 200, 25);
			panel_albumekle.add(turtxt);
			
			
			
			JButton AlbumEkleButton = new JButton("Albüm Ekle");
			AlbumEkleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!albumidtxt.getText().equals("")&& !albumekletxt.getText().equals("")&& !tarih3txt.getText().equals("")
							&&!turtxt.getText().equals("")) 
					{
						AlbumC albumC=new AlbumC();
						albumC.setIdalbum(albumidtxt.getText());
						albumC.setAdalbum(albumekletxt.getText());
						albumC.setSanatciadalbum((String)comboBox.getSelectedItem().toString());
						albumC.setSarkialbum(sarkiid_txt.getSelectedItem().toString());
						albumC.setTarihalbum(tarih3txt.getText());
						albumC.setTuralbum(tarih3txt.getText());
						new AlbumDal().insert(albumC);
						albumlistAlbum.setListData(new AlbumDal().list().toArray());
						
						
					}
					
					
				}
			});
			AlbumEkleButton.setForeground(Color.WHITE);
			AlbumEkleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			AlbumEkleButton.setBorder(null);
			AlbumEkleButton.setBackground(SystemColor.windowBorder);
			AlbumEkleButton.setBounds(386, 450, 200, 25);
			panel_albumekle.add(AlbumEkleButton);
			JLabel albumeklebg = new JLabel("");
			albumeklebg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
			albumeklebg.setBounds(0, 0, 1066, 768);
			panel_albumekle.add(albumeklebg);
		}
		{
			//Panel Silme İşlemleri
			panel_silme.setBounds(300, 0, 1066, 768);
			contentPane.add(panel_silme);
			panel_silme.setLayout(null);
			panel_silme.setVisible(false);
			
			//
			//Sanatcı Tablosu Album içinde Scroll
			//JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
			JScrollPane sanatcitabloscroll3 = new JScrollPane(sanatcilarJList);
			sanatcitabloscroll3.setBounds(50, 50, 450, 200);
			panel_silme.add(sanatcitabloscroll3);
			
			//Sarkı tablosu Album içinde
			//JList sarkilarlist=new JList(new SarkiDal().list().toArray());
			JScrollPane sarkitabloscroll = new JScrollPane(sarkilarlist);
			sarkitabloscroll.setBounds(50, 280, 450, 200);
			panel_silme.add(sarkitabloscroll);
			
			//Album Tablo Album içinde
			//JList albumlist=new JList(new AlbumDal().list().toArray());
			JScrollPane albumtabloscroll = new JScrollPane(albumlist);
			albumtabloscroll.setBounds(50, 520, 450, 200);
			panel_silme.add(albumtabloscroll);
			
			
			//Butonlar
			JButton SanatciSil = new JButton("Sanatçı Sil");
			SanatciSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  SanatciC sanatciC=(SanatciC) sanatcilarJList.getSelectedValue();
					  
					  new SanatciDal().delete(sanatciC);
				
					  sanatcilarJList.setListData(new SanatciDal().tumsanatcilar().toArray());
					  sarkilarlist.setListData(new SarkiDal().list().toArray());
					  albumlist.setListData(new AlbumDal().list().toArray());
					}
				});
			SanatciSil.setForeground(Color.WHITE);
			SanatciSil.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SanatciSil.setBorder(null);
			SanatciSil.setBackground(SystemColor.windowBorder);
			SanatciSil.setBounds(800, 150, 200, 25);
			panel_silme.add(SanatciSil);
			
			JButton SarkiSil = new JButton("Sarkı Sil");
			SarkiSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						SarkiC sarkiC=(SarkiC) sarkilarlist.getSelectedValue();
						new SarkiDal().delete(sarkiC);
						sarkilarlist.setListData(new SarkiDal().list().toArray());
						albumlist.setListData(new AlbumDal().list().toArray());
						sanatcilarJList.setListData(new SanatciDal().list().toArray());
						
					}
				});
			SarkiSil.setForeground(Color.WHITE);
			SarkiSil.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SarkiSil.setBorder(null);
			SarkiSil.setBackground(SystemColor.windowBorder);
			SarkiSil.setBounds(800, 360, 200, 25);
			panel_silme.add(SarkiSil);
			
			JButton AlbumSil = new JButton("Album Sil");
			AlbumSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						AlbumC albumC=(AlbumC) albumlist.getSelectedValue();
						new AlbumDal().delete(albumC);
					
						albumlist.setListData(new AlbumDal().list().toArray());
						sanatcilarJList.setListData(new SanatciDal().list().toArray());
						sarkilarlist.setListData(new SarkiDal().list().toArray());
					}
				});
			AlbumSil.setForeground(Color.WHITE);
			AlbumSil.setFont(new Font("Tahoma", Font.PLAIN, 20));
			AlbumSil.setBorder(null);
			AlbumSil.setBackground(SystemColor.windowBorder);
			AlbumSil.setBounds(800, 600, 200, 25);
			panel_silme.add(AlbumSil);
			
			
			//
			JLabel silmebg = new JLabel("");
			silmebg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
			silmebg.setBounds(0, 0, 1066, 768);
			panel_silme.add(silmebg);
			
		}
		{
			//Panel Guncelleme İşlemleri
			panel_guncelleme.setBounds(300, 0, 1066, 768);
			panel_guncelleme.setLayout(null);
			panel_guncelleme.setVisible(false);
			contentPane.add(panel_guncelleme);
			//Txtler
			
		
			guncellesanatciad = new JTextField();
			guncellesanatciad.setForeground(SystemColor.windowBorder);
			guncellesanatciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellesanatciad.setColumns(10);
			guncellesanatciad.setBounds(750, 150, 150, 25);
			panel_guncelleme.add(guncellesanatciad);
			guncellesanatciulke = new JTextField();
			guncellesanatciulke.setForeground(SystemColor.windowBorder);
			guncellesanatciulke.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellesanatciulke.setColumns(10);
			guncellesanatciulke.setBounds(750, 200, 150, 25);
			panel_guncelleme.add(guncellesanatciulke);
			guncellealbumtur = new JTextField();
			guncellealbumtur.setForeground(SystemColor.windowBorder);
			guncellealbumtur.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellealbumtur.setColumns(10);
			guncellealbumtur.setBounds(750, 320, 150, 25);
			panel_guncelleme.add(guncellealbumtur);
			guncellesure = new JTextField();
			guncellesure.setForeground(SystemColor.windowBorder);
			guncellesure.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellesure.setColumns(10);
			guncellesure.setBounds(750, 360, 150, 25);
			panel_guncelleme.add(guncellesure);
			guncelletarih = new JTextField();
			guncelletarih.setForeground(SystemColor.windowBorder);
			guncelletarih.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncelletarih.setColumns(10);
			guncelletarih.setBounds(750, 400, 150, 25);
			panel_guncelleme.add(guncelletarih);
			guncellealbumad = new JTextField();
			guncellealbumad.setForeground(SystemColor.windowBorder);
			guncellealbumad.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellealbumad.setColumns(10);
			guncellealbumad.setBounds(750, 550, 150, 25);
			panel_guncelleme.add(guncellealbumad);
			JComboBox comboBox = new JComboBox(new SanatciDal().list().toArray());
			comboBox.setEditable(true);
			comboBox.setMaximumRowCount(50);
			comboBox.setBounds(750, 580, 150, 25);
			panel_guncelleme.add(comboBox);
			//Şarkı id liste
			JComboBox sarkiid_txt = new JComboBox(new SarkiDal().sarkiid().toArray());
			sarkiid_txt.setEditable(true);
			sarkiid_txt.setMaximumRowCount(50);
			sarkiid_txt.setBounds(750, 610, 150, 25);
			panel_guncelleme.add(sarkiid_txt);
			guncellealbumtarih = new JTextField();
			guncellealbumtarih.setForeground(SystemColor.windowBorder);
			guncellealbumtarih.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellealbumtarih.setColumns(10);
			guncellealbumtarih.setBounds(750, 640, 150, 25);
			panel_guncelleme.add(guncellealbumtarih);
			guncellealbumatur = new JTextField();
			guncellealbumatur.setForeground(SystemColor.windowBorder);
			guncellealbumatur.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			guncellealbumatur.setColumns(10);
			guncellealbumatur.setBounds(750, 670, 150, 25);
			panel_guncelleme.add(guncellealbumatur);
			//
			//Sanatcı Tablosu Album içinde Scroll
			//JList sanatcilarJList=new JList(new SanatciDal().tumsanatcilar().toArray());
			JScrollPane sanatcitabloscroll3 = new JScrollPane(sanatcilarJListSilme);
			sanatcitabloscroll3.setBounds(350, 80, 200, 150);
			panel_guncelleme.add(sanatcitabloscroll3);
			
			//Sarkı tablosu Album içinde
			//JList sarkilarlist=new JList(new SarkiDal().list().toArray());
			JScrollPane sarkitabloscroll = new JScrollPane(sarkilarlistSilme);
			sarkitabloscroll.setBounds(350, 300, 200, 150);
			panel_guncelleme.add(sarkitabloscroll);
			
			//Album Tablo Album içinde
			//JList albumlist=new JList(new AlbumDal().list().toArray());
			JScrollPane albumtabloscroll = new JScrollPane(albumlistSilme);
			albumtabloscroll.setBounds(350, 550, 200, 150);
			panel_guncelleme.add(albumtabloscroll);
			//Butonlar
			JButton SanatciGuncelle = new JButton("Sanatci Guncelle");
			SanatciGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						SanatciC sarC=(SanatciC)sanatcilarJListSilme.getSelectedValue();
						SanatciC sanatcic=new SanatciC();
						sanatcic.setIdsanatci(sarC.getIdsanatci());
						sanatcic.setAdsanatci(guncellesanatciad.getText());
						sanatcic.setUlkesanatci(guncellesanatciulke.getText());
						new SanatciDal().update(sanatcic);
						sanatcilarJListSilme.setListData(new SanatciDal().tumsanatcilar().toArray());
						sarkilarlistSilme.setListData(new SarkiDal().list().toArray());
						albumlistSilme.setListData(new AlbumDal().list().toArray());
						
					}
				});
			SanatciGuncelle.setForeground(Color.WHITE);
			SanatciGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SanatciGuncelle.setBorder(null);
			SanatciGuncelle.setBackground(SystemColor.windowBorder);
			SanatciGuncelle.setBounds(50, 150, 200, 25);
			panel_guncelleme.add(SanatciGuncelle);
			
			JButton SarkiGuncelle = new JButton("Sarki Guncelle");
			SarkiGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						SarkiC sarC=(SarkiC) sarkilarlistSilme.getSelectedValue();
						SarkiC sarkiC=new SarkiC();
						sarkiC.setIdsarki(sarC.getIdsarki());
						sarkiC.setTuralbums(guncellealbumtur.getText());
						sarkiC.setSuresarki(guncellesure.getText());
						sarkiC.setTarihsarki(guncelletarih.getText());
						new SarkiDal().update(sarkiC);
						sanatcilarJListSilme.setListData(new SanatciDal().tumsanatcilar().toArray());
						sarkilarlistSilme.setListData(new SarkiDal().list().toArray());
						albumlistSilme.setListData(new AlbumDal().list().toArray());
						
					}
				});
			SarkiGuncelle.setForeground(Color.WHITE);
			SarkiGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 20));
			SarkiGuncelle.setBorder(null);
			SarkiGuncelle.setBackground(SystemColor.windowBorder);
			SarkiGuncelle.setBounds(50, 360, 200, 25);
			panel_guncelleme.add(SarkiGuncelle);
			
			JButton AlbumGuncelle = new JButton("Album Guncelle");
			AlbumGuncelle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						AlbumC alC=(AlbumC) albumlistSilme.getSelectedValue();
						AlbumC albumC=new AlbumC();
						albumC.setIdalbum(alC.getIdalbum());
						albumC.setAdalbum(guncellealbumad.getText());
						albumC.setSanatciadalbum(comboBox.getSelectedItem().toString());
						albumC.setSarkialbum(sarkiid_txt.getSelectedItem().toString());
						albumC.setTarihalbum(guncellealbumtarih.getText());
						albumC.setTuralbum(guncellealbumatur.getText());
						new AlbumDal().update(albumC);
						sanatcilarJListSilme.setListData(new SanatciDal().tumsanatcilar().toArray());
						sarkilarlistSilme.setListData(new SarkiDal().list().toArray());
						albumlistSilme.setListData(new AlbumDal().list().toArray());
						
					}
				});
			AlbumGuncelle.setForeground(Color.WHITE);
			AlbumGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 20));
			AlbumGuncelle.setBorder(null);
			AlbumGuncelle.setBackground(SystemColor.windowBorder);
			AlbumGuncelle.setBounds(50, 600, 200, 25);
			panel_guncelleme.add(AlbumGuncelle);
			
			
			
			//Lblla			
			JLabel sanatciad = new JLabel("Sanatci Ad");
			sanatciad.setForeground(Color.WHITE);
			sanatciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			sanatciad.setBounds(600, 150, 125, 20);
			panel_guncelleme.add(sanatciad);
			
			JLabel sanatciulke = new JLabel("Sanatci Ulke");
			sanatciulke.setForeground(Color.WHITE);
			sanatciulke.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			sanatciulke.setBounds(600, 200, 125, 20);
			panel_guncelleme.add(sanatciulke);
			
			JLabel albumturg = new JLabel("Album Tur");
			albumturg.setForeground(Color.WHITE);
			albumturg.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			albumturg.setBounds(600, 320, 125, 20);
			panel_guncelleme.add(albumturg);
			
			JLabel sureg = new JLabel("Sure");
			sureg.setForeground(Color.WHITE);
			sureg.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			sureg.setBounds(600, 360, 125, 20);
			panel_guncelleme.add(sureg);
			
			JLabel tarihg = new JLabel("Tarih");
			tarihg.setForeground(Color.WHITE);
			tarihg.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			tarihg.setBounds(600, 400, 125, 20);
			panel_guncelleme.add(tarihg);
			
			JLabel galbumad = new JLabel("Album Ad");
			galbumad.setForeground(Color.WHITE);
			galbumad.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			galbumad.setBounds(600, 550, 125, 20);
			panel_guncelleme.add(galbumad);
			JLabel gsanatciad = new JLabel("Sanatci Ad");
			gsanatciad.setForeground(Color.WHITE);
			gsanatciad.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			gsanatciad.setBounds(600, 580, 125, 20);
			panel_guncelleme.add(gsanatciad);
			JLabel gsarki = new JLabel("Sarkı");
			gsarki.setForeground(Color.WHITE);
			gsarki.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			gsarki.setBounds(600, 610, 125, 20);
			panel_guncelleme.add(gsarki);
			JLabel gtarih = new JLabel("Tarih");
			gtarih.setForeground(Color.WHITE);
			gtarih.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			gtarih.setBounds(600, 640, 125, 20);
			panel_guncelleme.add(gtarih);
			JLabel gtur = new JLabel("Tur");
			gtur.setForeground(Color.WHITE);
			gtur.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
			gtur.setBounds(600, 670, 125, 20);
			panel_guncelleme.add(gtur);
			
			JLabel guncellemebg = new JLabel("");
			guncellemebg.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/images/background.jpg")));
			guncellemebg.setBounds(0, 0, 1066, 768);
			panel_guncelleme.add(guncellemebg);
		}
		
		
		
		
		
		
		
		

		
		//Background
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1366, 768);
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		contentPane.add(background);
	}
	public void Listeler() {
		
	}
}
