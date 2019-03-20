package translate;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Request {

	private String englishText;
	private String turkishText;
	public String getEnglishText() {
		return englishText;
	}
	public void setEnglishText(String englishText) {
		this.englishText = englishText;
	}
	public String getTurkishText() {
		return turkishText;
	}
	public void setTurkishText(String turkishText) {
		this.turkishText = turkishText;
	}
	
	// create a link
	public String createLink() {
		String link = "https://tureng.com/en/turkish-english";
		
		// join home page and user's data
		if (englishText != null && englishText.length() > 0) {
			link += "/" + englishText;
		}
		
		return link;
	}

	// translate user's data
	public void translate() {
		
		String link = createLink();
		
		try {
			// get html data
			Document doc = Jsoup.connect(link).get();
			// parse result translated text
			Element result = doc.select("td.tr.ts a").first();
			// set Turkish text
			turkishText = result.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}




