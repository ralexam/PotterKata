package potterkata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;



public class KataPotter {

	private Sales sales = new Sales();
		
	public double ringMeUp(List<String> books) {
		HashSet<String> uniqueBooks = new HashSet<String>();
		uniqueBooks.addAll(books);
		
		int numberOfCommonBooks = books.size() - uniqueBooks.size();
		return (numberOfCommonBooks * 8) + (8 * uniqueBooks.size()) * (1 - sales.getPercentageOff(uniqueBooks.size()));
	}

}
