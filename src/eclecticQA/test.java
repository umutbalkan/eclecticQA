package eclecticQA;


import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class test {

	public static void main(String[] args) throws IOException {
		
		/* Fetch the NYTIMES - Daily Mini homepage, parse it to a DOM */
		Document html_doc = Jsoup.connect("https://www.nytimes.com/crosswords/game/mini").get();
		
		/* Extract data from HTML-doc 
		 * - Finding Elements
		 * - Getting Element data
		 * */
		
		// Display title
		String title = html_doc.title();
		System.out.println(title);
		
		// Get Clues
		Element across_clues = html_doc.getElementsByClass("ClueList-list--2dD5-").first(); // ACROSS CLUES
		Element down_clues = html_doc.getElementsByClass("ClueList-list--2dD5-").last(); // DOWN CLUES
		
		// Combining ACROSS & DOWN
		String across_txt = across_clues.text();
		String down_txt = down_clues.text();
		String parse = "ACROSS" + across_txt + "\nDOWN" + down_txt;
		
		// print
		for(int i = 0; i < parse.length(); i++) {
			char tmp = parse.charAt(i);
			if(tmp <= 57 && tmp >  48) // char is an integer
				System.out.print("\n" + parse.charAt(i) + " - "); // print
			else
				System.out.print(parse.charAt(i)); // concatenate & print
		}//END_LOOP
		

	}//END_main()

}//END_test
