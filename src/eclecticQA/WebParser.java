/*
 * author@ s. umut balkan
 * CS 461 Artifical Intelligence term project - eclecticQA
 * ID: 21401911
 * 
 *********************************
 * WebParser.java
 * date: OCT/18/17
 * 	Fetches data from NYTimes - Daily Mini Crossword Puzzle homepage. Extracts clues and grid cells.
 */
package eclecticQA;

import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebParser {

	// Properties
	private Document html_doc;
	private String webTitle, acrossText, downText, gridText;
	private Element across_clues, down_clues, grid;
	
	// Constructor
	WebParser(String url) throws IOException{
		
		// Fetch the NYTIMES - Daily Mini homepage, parse it to a DOM (Document-Object-Model)
		html_doc = Jsoup.connect(url).get();
		
		// Fetch title
		setWebTitle(html_doc.title());
		
		// Fetch html element of clues
		setAcross_clues(html_doc.getElementsByClass("ClueList-list--2dD5-").first()); // ACROSS CLUES
		setDown_clues(html_doc.getElementsByClass("ClueList-list--2dD5-").last()); // DOWN CLUES
				
		// Generate text of clues
		setDownText(down_clues.text());
		setAcrossText(across_clues.text());
		
	}//End_WebParser(...)


	
	// Getters & Mutators
	public String getWebTitle() {
		return webTitle;
	}


	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}


	public Element getAcross_clues() {
		return across_clues;
	}


	public void setAcross_clues(Element across_clues) {
		this.across_clues = across_clues;
	}


	public Element getDown_clues() {
		return down_clues;
	}


	public void setDown_clues(Element down_clues) {
		this.down_clues = down_clues;
	}


	public String getAcrossText() {
		return acrossText;
	}


	public void setAcrossText(String acrossText) {
		this.acrossText = acrossText;
	}


	public String getDownText() {
		return downText;
	}


	public void setDownText(String downText) {
		this.downText = downText;
	}
	
}//END_WebParser

