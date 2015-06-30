package testing;

import it.sauronsoftware.base64.Base64;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;




public class Tesstest {

	public static void main(String[] args) {

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

		JFrame frame = new JFrame();

		JLabel lblimage = new JLabel(new ImageIcon(image));
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


		//Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
		Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping

		String whiteList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		instance.setTessVariable("tessedit_char_whitelist", whiteList);

		try {
			String result = instance.doOCR(bimage);
			System.out.println(result);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}

}
