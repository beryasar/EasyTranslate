package translate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel lblText;
	private JTextField textField;
	private JButton btnCevir;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(new Color(199, 242, 246));
		setTitle("Easy Translate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 245, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		
		lblText = new JLabel("Çevirmek istediğiniz kelimeyi/cümleyi yazınız:");
		lblText.setFont(new Font("Laksaman", Font.BOLD, 12));
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.gridx = 3;
		gbc_lblText.gridy = 0;
		contentPane.add(lblText, gbc_lblText);
		
		textField = new JTextField();
		textField.setFont(new Font("Laksaman", Font.PLAIN, 12));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		
		btnCevir = new JButton("Çevir");
		btnCevir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String englishText = textField.getText();
				
				Request request = new Request();
				request.setEnglishText(englishText);
				request.translate();
				String translatedText = request.getTurkishText();
								
				JFrame newFrame = new JFrame();
				newFrame.setTitle("Easy Translate");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newFrame.setBounds(650, 370, 300, 150);
				newFrame.setLayout(new GridBagLayout());
				
				textPane = new JTextPane();
				textPane.setText(translatedText);
				GridBagConstraints gbc_textPane = new GridBagConstraints();
				gbc_textPane.fill = GridBagConstraints.BOTH;
				gbc_textPane.gridx = 4;
				gbc_textPane.gridy = 6;
				contentPane.add(textPane, gbc_textPane);
				
				newFrame.add(textPane);
				
				newFrame.setVisible(true);
			}
		});
		
		btnCevir.setForeground(new Color(255, 255, 224));
		btnCevir.setBackground(new Color(0, 0, 153));
		btnCevir.setFont(new Font("Laksaman", Font.BOLD, 12));
		GridBagConstraints gbc_btnCevir = new GridBagConstraints();
		gbc_btnCevir.gridx = 3;
		gbc_btnCevir.gridy = 3;
		contentPane.add(btnCevir, gbc_btnCevir);
	}

}
