package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class StartPanel extends JFrame {

	private JPanel contentPane;
	admingiris admingiris=new admingiris();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPanel frame = new StartPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Admin/Kullanıcı sayfası 
	 */
	public StartPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Music Box");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Profil resmi
		JLabel profile = new JLabel("Profile");
		profile.setIcon(new ImageIcon(StartPanel.class.getResource("/images/icon2.png")));
		profile.setBounds(640, 174, 100, 100);
		contentPane.add(profile);
		
		JLabel musicon = new JLabel("music");
		musicon.setFont(new Font("Baloo Bhai", Font.BOLD, 16));
		musicon.setForeground(Color.WHITE);
		musicon.setBounds(640, 290, 50, 14);
		contentPane.add(musicon);
		
		JLabel worldicon = new JLabel("world");
		worldicon.setFont(new Font("Baloo Bhai", Font.BOLD, 16));
		worldicon.setForeground(Color.WHITE);
		worldicon.setBounds(640, 310, 50, 14);
		contentPane.add(worldicon);
		
		JLabel on = new JLabel("");
		on.setIcon(new ImageIcon(StartPanel.class.getResource("/images/on.png")));
		on.setBounds(688, 291, 45, 14);
		contentPane.add(on);
		
		JLabel off = new JLabel("");
		off.setIcon(new ImageIcon(StartPanel.class.getResource("/images/off.png")));
		off.setBounds(688, 310, 45, 14);
		contentPane.add(off);
		
		JLabel admin = new JLabel("New label");
		admin.setIcon(new ImageIcon(StartPanel.class.getResource("/images/admin.png")));
		admin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) 
			{
				admin.setIcon(new ImageIcon(StartPanel.class.getResource("/images/admin2.png")));
			}
			public void mouseExited(MouseEvent arg0) 
			{
				admin.setIcon(new ImageIcon(StartPanel.class.getResource("/images/admin.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				admingiris.setVisible(true);
				dispose();
			}
		});
		admin.setBounds(402, 412, 150, 150);
		contentPane.add(admin);
		
		
		JLabel admingiristxt = new JLabel("Admin Olarak Giris Yapmak İstiyorum");
		admingiristxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
		admingiristxt.setForeground(Color.WHITE);
		admingiristxt.setBounds(350, 600, 260, 14);
		contentPane.add(admingiristxt);
		
		JLabel kullanici = new JLabel("");
		kullanici.setIcon(new ImageIcon(StartPanel.class.getResource("/images/kullanici1.png")));
		kullanici.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) 
			{
				kullanici.setIcon(new ImageIcon(StartPanel.class.getResource("/images/kullanici2.png")));
			}
			public void mouseExited(MouseEvent arg0) 
			{
				kullanici.setIcon(new ImageIcon(StartPanel.class.getResource("/images/kullanici1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				KullaniciPanel frame=new KullaniciPanel();
				frame.setVisible(true);
				dispose();
			}
			
		});
		kullanici.setBounds(802, 412, 150, 150);
		contentPane.add(kullanici);
		JLabel kullanicigiristxt = new JLabel("Kullanıcı Olarak Giris Yapmak İstiyorum");
		kullanicigiristxt.setFont(new Font("Baloo Bhai", Font.PLAIN, 15));
		kullanicigiristxt.setForeground(Color.WHITE);
		kullanicigiristxt.setBounds(750, 600, 275, 14);
		contentPane.add(kullanicigiristxt);
		
		//Background
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		background.setBounds(0, 0, 1366, 768);
		contentPane.add(background);
		
		
		
		
		
		
		
		
		
	}
}
