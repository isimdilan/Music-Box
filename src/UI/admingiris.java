package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dal.AdminDal;
import classes.AdminC;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

public class admingiris extends JFrame {

	private JPanel contentPane;
	private JTextField adminemail;
	private JLabel txtadmin1;
	private JLabel txtadminsifre;
	private JPasswordField adminsifre;
	private String adminemails;
	private String adminsifres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admingiris frame = new admingiris();
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
	public admingiris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Exo 2.0 Extra Light", Font.BOLD, 12));
		setTitle("Admin Giriş");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartPanel.class.getResource("/images/icon.jpg")));
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel admingirisicon = new JLabel("New label");
		admingirisicon.setIcon(new ImageIcon(admingiris.class.getResource("/images/admin2.png")));
		admingirisicon.setBounds(633, 180, 150, 150);
		contentPane.add(admingirisicon);
		
		txtadmin1 = new JLabel("E-mail");
		txtadmin1.setForeground(SystemColor.window);
		txtadmin1.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		txtadmin1.setBounds(600, 355, 150, 14);
		contentPane.add(txtadmin1);
		
		//Txtfield Admin e-mail
		adminemail = new JTextField();
		adminemail.setHorizontalAlignment(SwingConstants.LEFT);
		adminemail.setBackground(SystemColor.windowBorder);
		adminemail.setForeground(SystemColor.control);
		adminemail.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		adminemail.setBounds(600, 380, 220, 25);
		contentPane.add(adminemail);
		adminemail.setColumns(10);
		//Get e-mail
		adminemails=adminemail.getText();
		//
		txtadminsifre = new JLabel("Şifre");
		txtadminsifre.setForeground(Color.WHITE);
		txtadminsifre.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		txtadminsifre.setBounds(600, 429, 150, 14);
		contentPane.add(txtadminsifre);
		//Txtfield Admin Şifre
		adminsifre = new JPasswordField();
		adminsifre.setHorizontalAlignment(SwingConstants.LEFT);
		adminsifre.setForeground(SystemColor.control);
		adminsifre.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		adminsifre.setBackground(SystemColor.windowBorder);
		adminsifre.setBounds(600, 454, 220, 25);
		contentPane.add(adminsifre);
		//Get Passaword
		adminsifres=adminsifre.getText();
		
		JButton giris = new JButton("Giriş");
		
		giris.setForeground(SystemColor.controlShadow);
		giris.setFont(new Font("Baloo Bhai", Font.PLAIN, 16));
		giris.setBounds(661, 509, 89, 23);
		giris.setBackground(new Color(255,243,157));
		giris.setBorder(null);
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminC adminC=new AdminC();
				adminC.setEmailadmin(adminemail.getText());
				adminC.setSifreadmin(adminsifre.getText());
				AdminDal adminDal=new AdminDal();
				if(adminDal.giris(adminC)==1) 
				{
					JOptionPane.showMessageDialog(giris, "Giris basarili");
					AdminArayuz girisyapAdminArayuz=new AdminArayuz();
					girisyapAdminArayuz.setVisible(true);
					
				}
				else 
				{
					JOptionPane.showMessageDialog(giris, "Giris basarisiz");
				}
				
			}
		});
		contentPane.add(giris);
		
		
		
		//Background
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StartPanel.class.getResource("/images/background.jpg")));
		background.setBounds(0, 0, 1366, 768);
		contentPane.add(background);
	}
	public void AdminArayuz() 
	{
		
	}
}
