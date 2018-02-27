package reddit_help;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOP {
	
	private static String[] toSort = new String[30];
	
	public static void main(String[] args){
		try {
			String[] statsOne = readFile("C:/Users/Mitch/Desktop/MLBStats1.txt");
			String[] statsTwo = readFile("C:/Users/Mitch/Desktop/MLBStats2.txt");
			String theCalc = calculate(statsOne, statsTwo);
			String[] splitArray = theCalc.split(",");
			int rank = 1;
			for(int i = 29; i>=0; i--){
			System.out.println(rank + ":" + splitArray[i]);
			rank++;
			}
			
			
			
			
		} 
		catch (FileNotFoundException e) { // Catches file not found exception
			System.out.println("FileNotFoundException");
		}
		
		
		
		
	
	

}

public static String[] readFile(String filename) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File (filename));		//creates new scanner for the indicated file
		List<String> lines = new ArrayList<String>();		//Creates new string array list
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());			//adds every line from file to new array list
		}
		sc.close();

		String[] arr = lines.toArray(new String[0]);		//Converts the array list to an array for processing ease
		return arr;
		}






public static String calculate(String[] statOne, String[] statTwo){
	
	String teamName = " ";
	double atBats = 0;
	double hits = 0;
	double runs = 0;
	double homers = 0;
	double rbi = 0;
	double avg = 0;
	double obp = 0;
	double so = 0;
	double walks = 0;
	double finalScore = 0;
	
	int index = 0;
	for(int k = 1; k < 31; k++){
	StringTokenizer st = new StringTokenizer(statOne[k]);	//Removes all whitespace
	st.nextToken();
	teamName = st.nextToken();
	st.nextToken();
	atBats = Double.parseDouble(st.nextToken());
	runs = Double.parseDouble(st.nextToken());
	hits = Double.parseDouble(st.nextToken());
	st.nextToken();
	st.nextToken();
	homers = Double.parseDouble(st.nextToken());
	st.nextToken();
	
	rbi = Double.parseDouble(st.nextToken());
	
	String test = st.nextToken();
	String avgCalc = test.substring(1);
	avg = Double.parseDouble(avgCalc);
	
	
	String obpCalc = st.nextToken().substring(1);
	obp = Double.parseDouble(obpCalc);
	
	
	
	
	
		StringTokenizer sts = new StringTokenizer(statTwo[k]);
		sts.nextToken();
		sts.nextToken();
		so = Double.parseDouble(sts.nextToken());
		walks = Double.parseDouble(sts.nextToken());
		finalScore = avg + obp + rbi + homers + hits + runs - ((so/atBats)*1000) + ((walks/atBats) * 500);
	finalScore = finalScore/100;
		finalScore = finalScore - 7;
		finalScore = Math.floor(finalScore * 1000) / 1000;
		String forPrinting = "The BOP for " + teamName + " is " + finalScore;
		toSort[index] = forPrinting;
		index++;
		
		
	}
	
	String toReturn = sorter(toSort);
	
	return toReturn;
	}




public static String sorter(String[] toSort){
	List<String> list = new ArrayList<String>(30);
	for(int i = 0; i<30; i++){
		list.add(toSort[i]);
		}
	CompareCustom comparator = new CompareCustom();
	Collections.sort(list, comparator);
	String newList = Arrays.toString(list.toArray());
	return newList;
	
}
	

	
	
	
	
	
	
	
	
	
	
}


