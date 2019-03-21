/**
 * Translate text from English to Turkish. 
 * @author Busra Nur Eryasar
 */

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
	
	/**
	 * Create a link
	 */
	public String createLink() {
		String link = "https://tureng.com/en/turkish-english";
		
		/* Join home page and user's data. */
		if (englishText != null && englishText.length() > 0) {
			link += "/" + englishText;
		}
		
		return link;
	}

	/**
	 * Translate user's text.
	 */
	public void translate() {
		
		String link = createLink();
		
		try {
			/* Get html data. */
			Document doc = Jsoup.connect(link).get();
			/* Parse translated text. */
			Element result = doc.select("td.tr.ts a").first();
			
			if (result != null) {
				/* Set Turkish text. */
				turkishText = result.text();
			} else {
				/* Parse other text's suggestion list. */
				Element option = doc.select("ul.suggestion-list li").first();
				turkishText = "Bunu mu demek istediniz: \n\n" + option.text();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}




