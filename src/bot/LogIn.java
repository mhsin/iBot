package bot;

import it.sauronsoftware.base64.Base64;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import data.Url;

public class LogIn {

	private HttpHelper client;
	private String captchaInput;
	private String path;
	private String appIdKey;

	JFrame frame = new JFrame();

	JLabel lblimage = null;

	public LogIn(HttpHelper client) {
		this.client = client;
	}

	public void prepareLogInPage(Map<String, String> inputParams) {

		try {
			String response = client.httpGetUrl(Url.WATCH_IR + "?"
					+ client.paramsToString(inputParams));
			System.out.println(Url.WATCH_IR + "?"
					+ client.paramsToString(inputParams));
			System.out.println(response);

			Map<String, String> urlParams = new HashMap<String, String>();
			urlParams = client.getUrlParamas(response);
			System.out.println(urlParams);

			logInToSms(urlParams);

		} catch (IllegalArgumentException e) {
			System.err.println("iReserve URL incorrect.");
		}

	}

	public void getCaptcha(String captcha) {

		InputStream stream = new ByteArrayInputStream(Base64.decode(captcha
				.getBytes()));
		Image image = null;

		try {
			image = ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblimage = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(lblimage, BorderLayout.CENTER);
		frame.setSize(300, 400);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(lblimage);

		frame.add(mainPanel);
		frame.setVisible(true);
	}

	public void logInToSms(Map<String, String> inputParams) {
		Map<String, String> params = new HashMap<String, String>();

		Scanner in = new Scanner(System.in);
		String post = "";
		do {

			String captchaImg = client.httpGetBody(Url.GET_CAPTCHA);
			System.out.println("Check Captcha: " + captchaImg);

			getCaptcha(captchaImg);

			captchaInput = in.nextLine();
			path = inputParams.get("path");
			appIdKey = inputParams.get("appIdKey");

			params.put("appleId", "mhsin.seb@gmail.com");
			params.put("accountPassword", "Nescafe7");
			params.put("captchaInput", captchaInput);
			params.put("captchaAudioInput:", "");
			params.put("captchaType", "image");
			params.put("captchaToken:", "");
			params.put("appIdKey", appIdKey);
			params.put("accNameLocked", "false");
			params.put("language", "HK-EN");
			params.put("path", path);
			params.put("view", "3");
			params.put("Env", "PROD");

			// System.out.println(params);

			post = client.httpPost(Url.AUTHENTICATE, params);
			System.out.println(post);

		} while (post.equals(Url.AUTHENTICATE) == true);

		// System.out.println(client.httpPost(Url.AUTHENTICATE, params));

		System.out.println("Log in SUCCESSFUL.");

		client.httpGetUrl(Url.E1S1 + inputParams.get("p_left"));

		System.out.println("Check: " + client.httpGetBody(Url.E1S2));

		URL test = null;
		try {
			test = new URL(Url.E1S2);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (InputStream is = test.openStream();
				JsonReader rdr = Json.createReader(is)) {

			JsonObject obj = rdr.readObject();

			System.out.println(obj.getString("ABC"));
			String string = obj.getString("ABC");
			String[] parts = string.split(",");

			System.out.println("Get SMS image SUCCESSFUL.");
			getSms(parts[1]);
			String string2 = obj.getString("keyword");
			parts = string.split(",");
			getSms(parts[1]);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonException e) {
			System.err.println("Get json ERROR.");
		}

	}

	public void getSms(String sms) {

		// String test =
		// "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";

		InputStream stream = new ByteArrayInputStream(Base64.decode(sms
				.getBytes()));

		Image image = null;

		try {
			image = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JFrame frame = new JFrame();

		JLabel lblimage = new JLabel(new ImageIcon(image));
		// lblimage = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(lblimage, BorderLayout.CENTER);
		frame.setSize(300, 400);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(lblimage);
		// add more components here
		frame.add(mainPanel);
		frame.setVisible(true);

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(image, 0, 0, null);
		bGr.dispose();

		Tesseract1 instance = new Tesseract1();

		String whiteList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		instance.setTessVariable("tessedit_char_whitelist", whiteList);

		try {
			String result = instance.doOCR(bimage);
			System.out.println(result);
			System.out.println(result.replaceAll("\\s", ""));

		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

	}

}
