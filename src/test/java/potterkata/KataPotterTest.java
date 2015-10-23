package potterkata;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class KataPotterTest {
	private static final String FIFTH = "order of the phoenix";
	private static final String FOURTH = "goblet of fire";
	private static final String THIRD = "prisoner of azkaban";
	private static final String SECOND = "chamber of secrets";
	private static final String FIRST = "philosopher's stone";
	KataPotter underTest;
	
	@Before
	public void setup() {
		underTest = new KataPotter();
	}

	@Test
	public void oneBookShouldCostEightEuro() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		assertThat(underTest.ringMeUp(books), is(8.00));
	}

	@Test
	public void twoBooksShouldGet5PercentDiscount() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(SECOND);
		assertThat(underTest.ringMeUp(books), is(15.20));
	}
	
	@Test
	public void threeBooksShouldGet10PercentDiscount() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(SECOND);
		books.add(THIRD);
		assertThat(underTest.ringMeUp(books), is(21.6));
	}
	
	@Test
	public void fourBooksShouldGet20PercentDiscount() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(SECOND);
		books.add(THIRD);
		books.add(FOURTH);
		assertThat(underTest.ringMeUp(books), is(25.60));
	}
	
	@Test
	public void fiveBooksShouldGet25PercentDiscount() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(SECOND);
		books.add(THIRD);
		books.add(FOURTH);
		books.add(FIFTH);
		assertThat(underTest.ringMeUp(books), is(30.00));
	}
	
	@Test
	public void twoIdenticalBooksShouldCost16() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(FIRST);
		assertThat(underTest.ringMeUp(books), is(16.00));
	}
	
	@Test @Ignore
	public void shouldCostFiftyOneTwenty() {
		List<String> books = new ArrayList<String>();
		books.add(FIRST);
		books.add(FIRST);
		books.add(SECOND);
		books.add(SECOND);
		books.add(THIRD);
		books.add(THIRD);
		books.add(FOURTH);
		books.add(FIFTH);
		assertThat(underTest.ringMeUp(books), is(51.20));
	}
}
