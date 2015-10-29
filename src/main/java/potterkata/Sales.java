package potterkata;

import java.util.HashMap;

public class Sales {
	HashMap<Integer, Double> percentageOff = new HashMap<Integer, Double>();
	
	Sales() {
		percentageOff.put(0, 0.0);
		percentageOff.put(1, 0.0);
		percentageOff.put(2, .05);
		percentageOff.put(3, .10);
		percentageOff.put(4, .20);
		percentageOff.put(5, .25);
	}

	public double getPercentageOff(int numberOfBooks) {
		return percentageOff.get(numberOfBooks);
	}

}
