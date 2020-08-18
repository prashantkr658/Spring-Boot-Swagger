import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WelcomeClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8091/welcome");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			int httpRespCd = con.getResponseCode();

			if (httpRespCd == 200) {
				InputStream is = con.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				con.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
