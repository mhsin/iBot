package ui;

import it.sauronsoftware.base64.Base64;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField tfAppleId;
	private JTextField tfPassword;
	private JTextField tfCaptInput;
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
		String imageDataBytes2 = "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";
		InputStream stream2 = new ByteArrayInputStream(
				Base64.decode(imageDataBytes2.getBytes()));
		Image image2 = null;

		try {
			image2 = ImageIO.read(stream2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("iBot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("trdtdt");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel pWatchReserve = new JPanel();
		tabbedPane.addTab("New tab", null, pWatchReserve, null);
		pWatchReserve.setLayout(null);

		JPanel pWatchLogIn = new JPanel();
		pWatchLogIn.setBorder(new TitledBorder(null, "Log In Info",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pWatchLogIn.setBounds(10, 10, 280, 80);
		pWatchLogIn.setAlignmentX(Component.LEFT_ALIGNMENT);
		pWatchLogIn.setAlignmentY(Component.TOP_ALIGNMENT);
		pWatchReserve.add(pWatchLogIn);
		GridBagLayout gbl_pWatchLogIn = new GridBagLayout();
		gbl_pWatchLogIn.columnWidths = new int[] { 60, 180, 0 };
		gbl_pWatchLogIn.rowHeights = new int[] { 24, 24, 0 };
		gbl_pWatchLogIn.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pWatchLogIn.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pWatchLogIn.setLayout(gbl_pWatchLogIn);

		JLabel lblAppleId = new JLabel("Apple ID:");
		GridBagConstraints gbc_lblAppleId = new GridBagConstraints();
		gbc_lblAppleId.fill = GridBagConstraints.BOTH;
		gbc_lblAppleId.insets = new Insets(0, 0, 5, 5);
		gbc_lblAppleId.gridx = 0;
		gbc_lblAppleId.gridy = 0;
		pWatchLogIn.add(lblAppleId, gbc_lblAppleId);

		tfAppleId = new JTextField();
		GridBagConstraints gbc_tfAppleId = new GridBagConstraints();
		gbc_tfAppleId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAppleId.insets = new Insets(0, 0, 5, 0);
		gbc_tfAppleId.gridx = 1;
		gbc_tfAppleId.gridy = 0;
		pWatchLogIn.add(tfAppleId, gbc_tfAppleId);
		tfAppleId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfAppleId.setColumns(15);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		pWatchLogIn.add(lblPassword, gbc_lblPassword);

		tfPassword = new JTextField();
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPassword.gridx = 1;
		gbc_tfPassword.gridy = 1;
		pWatchLogIn.add(tfPassword, gbc_tfPassword);
		tfPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		tfPassword.setColumns(10);

		JPanel pWatchCaptcha = new JPanel();
		pWatchCaptcha.setBounds(10, 100, 280, 175);
		pWatchCaptcha.setToolTipText("test");
		pWatchCaptcha.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u9A57\u8B49\u78BC",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pWatchReserve.add(pWatchCaptcha);
		GridBagLayout gbl_pWatchCaptcha = new GridBagLayout();
		gbl_pWatchCaptcha.columnWidths = new int[] { 175, 84, 0 };
		gbl_pWatchCaptcha.rowHeights = new int[] { 75, 75, 0 };
		gbl_pWatchCaptcha.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pWatchCaptcha.rowWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		pWatchCaptcha.setLayout(gbl_pWatchCaptcha);

		JLabel lblCaptImg = new JLabel(new ImageIcon(image));
		GridBagConstraints gbc_lblCaptImg = new GridBagConstraints();
		gbc_lblCaptImg.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaptImg.gridx = 0;
		gbc_lblCaptImg.gridy = 0;
		pWatchCaptcha.add(lblCaptImg, gbc_lblCaptImg);

		JButton btnNewImg = new JButton("New Image");
		btnNewImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewImg = new GridBagConstraints();
		gbc_btnNewImg.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewImg.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewImg.gridx = 1;
		gbc_btnNewImg.gridy = 0;
		pWatchCaptcha.add(btnNewImg, gbc_btnNewImg);

		tfCaptInput = new JTextField();
		tfCaptInput.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tfCaptInput.setColumns(5);
		GridBagConstraints gbc_tfCaptInput = new GridBagConstraints();
		gbc_tfCaptInput.insets = new Insets(0, 0, 0, 5);
		gbc_tfCaptInput.gridx = 0;
		gbc_tfCaptInput.gridy = 1;
		pWatchCaptcha.add(tfCaptInput, gbc_tfCaptInput);

		JButton btnCaptEnter = new JButton("ENTER");
		GridBagConstraints gbc_btnCaptEnter = new GridBagConstraints();
		gbc_btnCaptEnter.fill = GridBagConstraints.BOTH;
		gbc_btnCaptEnter.gridx = 1;
		gbc_btnCaptEnter.gridy = 1;
		pWatchCaptcha.add(btnCaptEnter, gbc_btnCaptEnter);

		JPanel pWatchSms = new JPanel();
		pWatchSms.setToolTipText("test");
		pWatchSms.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u9A57\u8B49\u78BC",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pWatchSms.setBounds(10, 286, 280, 173);
		pWatchReserve.add(pWatchSms);
		GridBagLayout gbl_pWatchSms = new GridBagLayout();
		gbl_pWatchSms.columnWidths = new int[] { 200, 66, 0 };
		gbl_pWatchSms.rowHeights = new int[] { 40, 75, 0 };
		gbl_pWatchSms.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_pWatchSms.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pWatchSms.setLayout(gbl_pWatchSms);

		JLabel label = new JLabel(new ImageIcon(image2));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		pWatchSms.add(label, gbc_label);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textField.setColumns(5);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		pWatchSms.add(textField, gbc_textField);

	}
}
