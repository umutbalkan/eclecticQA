package eclecticQA;


import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
		String yeah = "";
		// Display title
		String title = html_doc.title();
		//System.out.println(title);
		yeah += title;

		// Get Clues
		Elements clues = html_doc.getElementsByClass("Clue-li--1JoPu"); // ACROSS CLUES
		//Element down_clues = html_doc.getElementsByClass("ClueList-list--2dD5-").last(); // DOWN CLUES

		yeah += "\nACROSS\n";
		//System.out.println("\nACROSS");
		for(int i = 0; i < clues.size(); i++) {
			Element temp = clues.get(i);
			if( i == 5)   yeah += "DOWN\n";
			//System.out.println(temp.child(0).text() + ") " + temp.child(1).text());
			yeah += temp.child(0).text() + ") " + temp.child(1).text() + "\n";
		}

		System.out.println(yeah);

		// Fetch & Display grid and cells
		Elements grids = html_doc.select("g[data-group]");
		Elements cells = grids.first().select("rect");
		String board = "";
		for( int i = 0; i < cells.size(); i++) {
			if(i % Math.sqrt(cells.size()) == 0) board += "\n";

			Element t = cells.get(i);
			String cell_type = t.className();
			if (cell_type.equals("Cell-block--1oNaD")) board += "X ";
			else if (cell_type.equals("Cell-cell--1p4gH")) board += "0 ";
			else if (cell_type.equals("Cell-cell--1p4gH Cell-shaded--P5HOI")) board += "O ";

		}
		System.out.println(board);
		
		// solution in url-encoded utf-16 format
		Elements sol = html_doc.select("script");
		String answerEncoded = sol.get(4).data();
		answerEncoded = answerEncoded.substring(10, answerEncoded.length()-2);		

		// WRITE TXT FILE
		FileWriter writer = null;
		try
		{
		    writer = new FileWriter(new File("/Users/umutbalkan/Documents/eclipse_workspace/eclecticQA/db/",title + ".txt"));
		    writer.write(yeah);
		    writer.write(board + "\n\n");	
		    writer.write(answerEncoded);
		    System.out.println("\nCrossword saved with the name: \n" + title + ".txt");
		}
		catch ( IOException e) {} // handle exception
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e) {} // handle exception
		}

	}//END_main()

}//END_test
