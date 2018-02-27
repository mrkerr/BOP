package reddit_help;

import java.util.Comparator;

public class CompareCustom implements Comparator<String> {
	
	@Override
	public int compare(String s, String ss){
		double d = Double.parseDouble(s.split(" ")[5]);
		double dd = Double.parseDouble(ss.split(" ")[5]);
		if(d<dd){
			return -1;
		}
		if(dd>d){
			return 1;
		}
		
		return 0;
	}

	}
	


