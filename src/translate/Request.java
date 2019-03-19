package translate;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Request {
	
	public String homePage;
	public String data;
	
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
	
	public String createLink(String url, String args) {
		String link = homePage;
		if (args != null && args.length() > 0) {
			link += "/" + args;
		}
		return link;
	}
	
}
	
	
	
	
