package ui;

import it.sauronsoftware.base64.Base64;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField tfAppleId;
	private JTextField tfPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setTitle("iBot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAppleId = new JLabel("Apple ID:");
		
		tfAppleId = new JTextField();
		tfAppleId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfAppleId.setColumns(15);
		
		JLabel lblPassword = new JLabel("Password:");
		
		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		tfPassword.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textField.setColumns(5);
		
		JLabel lblCaptcha = new JLabel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList list = new JList();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblAppleId)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tfAppleId, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblPassword)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfPassword)))
								.addComponent(lblCaptcha, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(807, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAppleId)
						.addComponent(tfAppleId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(lblCaptcha, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(501, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		String imageDataBytes = "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";
				InputStream stream = new ByteArrayInputStream(
				Base64.decode(imageDataBytes.getBytes()));
		Image image = null;

		try {
			image = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblCaptcha.setIcon(new ImageIcon(image));
		
	}
}
