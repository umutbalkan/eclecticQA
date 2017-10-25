package eclecticQA;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		Elements clues = html_doc.getElementsByClass("Clue-li--1JoPu"); // ACROSS CLUES
		//Element down_clues = html_doc.getElementsByClass("ClueList-list--2dD5-").last(); // DOWN CLUES
		
		System.out.println("\nACROSS");
		for(int i = 0; i < clues.size(); i++) {
			Element temp = clues.get(i);
			if( i == 5) System.out.println("DOWN");
			System.out.println(temp.child(0).text() + ") " + temp.child(1).text());
		}
		
		
		/*
		// WRITE TXT FILE
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter(title + ".txt"));
		    writer.write(clues.text());

		}
		catch ( IOException e) {}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e) {}
		}
		*/
		
		Elements grids = html_doc.select("g[data-group]");
		Elements temp = grids.first().select("rect"); // gets data-group="cells"
		//System.out.println(temp);
		
		for( int i = 0; i < temp.size(); i++) {
			if(i % 5 == 0) System.out.println();
			
			Element t = temp.get(i);
			String cell_type = t.className();
			if(cell_type.equals("Cell-block--1oNaD")) System.out.print("X");
			else if(cell_type.equals("Cell-cell--1p4gH")) System.out.print("0");
			
		}
		
		// Combining ACROSS & DOWN
		//String across_txt = across_clues.text();
		//String down_txt = down_clues.text();
		//String parse = "ACROSS" + across_txt + "\nDOWN" + down_txt;
		
		// print
		//for(int i = 0; i < parse.length(); i++) {
		//	char tmp = parse.charAt(i);
		//	if(tmp <= 57 && tmp >  48) // char is an integer
		//		System.out.print("\n" + parse.charAt(i) + " - "); // print
		//	else
		//		System.out.print(parse.charAt(i)); // concatenate & print
		//}//END_LOOP
		

	}//END_main()

}//END_test
