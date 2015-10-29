package potterkata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class KataPotter {

	private Sales sales = new Sales();

	public double ringMeUp(List<String> books) {
		double price1 = ringMeUpNoFours(books);
		double price2 = ringMeUpFours(books);
		if (price1 < price2) {
			return price1;
		} else {
			return price2;
		}
	}
	
	private double ringMeUpFours(List<String> books) {
		if (books.size() == 0) {
			return 0;
		}
		HashSet<String> uniqueBooksV2 = uniqueBooksV2(books);
		List<String> remainderBooksV2 = removeUniqueBooks(books, uniqueBooksV2);
		double discountV2 = (8 * uniqueBooksV2.size() * (1-sales.getPercentageOff(uniqueBooksV2.size())));
		
		return ringMeUpFours(remainderBooksV2) + discountV2;		
	}

	public double ringMeUpNoFours(List<String> books) {
		
		if (books.size() == 0) {
			return 0;
		}
		HashSet<String> uniqueBooks = uniqueBooks(books);
		List<String> remainderBooks = removeUniqueBooks(books, uniqueBooks);
		double discount = (8 * uniqueBooks.size() * (1-sales.getPercentageOff(uniqueBooks.size())));
		
		return ringMeUpNoFours(remainderBooks) + discount;
	}
	
	

	private HashSet<String> uniqueBooksV2(List<String> books) {
		HashSet<String> uniqueBooks = new HashSet<String>();
		
		for (String book : books) {
			if (uniqueBooks.size() < 4) {
				uniqueBooks.add(book);
			}
		}
		//AFTER REMOVING THE FIRST 4, SORT LIST BY NUMBER OF OCCURENCES. EXAMPLE:
		//     1 | 1 | 1 | 2 | 2 | 2 | 3 | 3 | 4 | 4 | 5 | 5  -- Original List
		//     x | 1 | 1 | x | 2 | 2 | x | 3 | x | 4 | 5 | 5  -- Remove first 4 unique
		//     1 | 1 | 2 | 2 | 5 | 5 | 3 | 4 |                -- Reorder based on number of occurences
		//     x | 1 | x | 2 | x | 5 | x | 4 |                -- Remove first 4 unique
		//     1 | 2 | 5 | 4                                  -- Base Case GREAT SUCCESS!!
		return uniqueBooks;
	}

	private List<String> removeUniqueBooks(List<String> books,
			HashSet<String> uniqueBooks) {
		List<String> remainderBooks = new ArrayList<String>();
		remainderBooks.addAll(books);
		
		for(String book : uniqueBooks) {
			remainderBooks.remove(book);
		}
		return remainderBooks;
	}

	private HashSet<String> uniqueBooks(List<String> books) {
		HashSet<String> uniqueBooks = new HashSet<String>();
		uniqueBooks.addAll(books);
		return uniqueBooks;
	}

}
