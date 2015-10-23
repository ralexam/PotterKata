package potterkata;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SalesTest {

	@Test
	public void test() {
		Sales underTest = new Sales();
		assertThat(underTest.getPercentageOff(1), is(0.0));
	}

}
