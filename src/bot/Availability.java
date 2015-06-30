package bot;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import data.I6;
import data.Url;

public class Availability {

	public void createIrAvailJson() throws IOException {

		URL url = new URL(Url.WATCH_AVAIL_JSON);
		try (InputStream is = url.openStream();
				JsonReader rdr = Json.createReader(is)) {

			JsonObject obj = rdr.readObject();

			System.out.print(obj.getJsonObject("R485"));

		}

	}

	public void createAosAvailJson() {

		ExecutorService executor = Executors.newFixedThreadPool(30);

		I6.loadPartNum();

		for (String partNum : I6.partNumber) {

			String urlString = Url.DELIVERY_MESSAGE + partNum;
			try {
				URL url = new URL(urlString);
				Runnable getAvail = new GetAosAvailability(url, partNum);
				executor.execute(getAvail);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}
	}

	class GetAosAvailability implements Runnable {
		private URL url;
		private String partNum;

		GetAosAvailability(URL url, String partNum)
				throws MalformedURLException {
			this.url = url;
			this.partNum = partNum;
		}

		@Override
		public void run() {

			try (InputStream is = url.openStream();
					JsonReader rdr = Json.createReader(is)) {

				JsonObject obj = rdr.readObject();
				System.out.println(partNum
						+ ": "
						+ obj.getJsonObject("body").getJsonObject("content")
								.getJsonObject("deliveryMessage")
								.getJsonObject(partNum)
								.getJsonArray("deliveryOptionMessages")
								.getString(0));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
