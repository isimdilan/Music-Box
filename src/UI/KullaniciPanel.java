package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KullaniciPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciPanel frame = new KullaniciPanel();
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
	public KullaniciPanel() {
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Music Box");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kullanici = new JLabel("new");
		kullanici.setIcon(new ImageIcon(KullaniciPanel.class.getResource("/images/kullanici2.png")));
		kullanici.setBounds(635, 180, 150, 150);
		
		contentPane.add(kullanici);
		
		JLabel kayit = new JLabel("Üye ol");
		kayit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UyeOlPanel frame = new UyeOlPanel();
				frame.setVisible(true);
			}
		});
		kayit.setHorizontalAlignment(SwingConstants.CENTER);
		kayit.setFont(new Font("Baloo Bhai", Font.BOLD, 20));
		kayit.setForeground(Color.WHITE);
		kayit.setBounds(650, 351, 123, 65);
		kayit.setBackground(new Color(132, 205,242));
		contentPane.add(kayit);
		

		JLabel uye_giris = new JLabel("Üye girişi");
		uye_giris.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GirisYapPanel frame=new GirisYapPanel();
				frame.setVisible(true);
			}
		});
		uye_giris.setHorizontalAlignment(SwingConstants.CENTER);
		uye_giris.setFont(new Font("Baloo Bhai", Font.BOLD, 20));
		uye_giris.setBackground(Color.WHITE);
		uye_giris.setForeground(Color.WHITE);
		uye_giris.setBounds(650, 480, 123, 65);
		contentPane.add(uye_giris);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		background.setBounds(0, 0, 1366, 768);
		contentPane.add(background);
	}

}
