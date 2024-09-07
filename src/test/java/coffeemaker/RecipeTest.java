package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import coffeemaker.exceptions.RecipeException;
import coffeemaker.domain.*;

/**
 * Sample component test suite.
 */
public class RecipeTest {

	/**
	 * Component under Test.
	 */
	private Recipe recipe;

	@BeforeEach
	public void setUp() {
		recipe = new Recipe();
	}

	@AfterEach
	public void tearDown() {
		recipe = null;
	}




	

	// Basic

	@Test
	@DisplayName("Test 1 - Recipe Exists")
	public void test1() {
		assertTrue(recipe != null);
	}






	//Blanks

	@Test
	@DisplayName("Test 2 - New recipe name is blank")
	public void test2() {
		assertEquals(recipe.getName(), "");
	}

	@Test
	@DisplayName("Test 3 - New recipe chocolate is blank")
	public void test3() {
		assertEquals(recipe.getAmtChocolate(), 0);
	}

	@Test
	@DisplayName("Test 4 - New recipe coffee is blank")
	public void test4() {
		assertEquals(recipe.getAmtCoffee(), 0);
	}

	@Test
	@DisplayName("Test 5 - New recipe milk is blank")
	public void test5() {
		assertEquals(recipe.getAmtMilk(), 0);
	}

	@Test
	@DisplayName("Test 6 - New recipe sugar is blank")
	public void test6() {
		assertEquals(recipe.getAmtSugar(), 0);
	}

	@Test
	@DisplayName("Test 7 - New recipe price is blank")
	public void test7() {
		assertEquals(recipe.getPrice(), 0);
	}






	//Changes

	@Test
	@DisplayName("Test 8 - Recipe change name")
	public void test8() {
		recipe.setName("NewName");
		assertEquals(recipe.getName(), "NewName");
	}

	@Test
	@DisplayName("Test 9 - Recipe change chocolate")
	public void test9() {
		recipe.setAmtChocolate("7");
		assertEquals(recipe.getAmtChocolate(), 7);
	}

	@Test
	@DisplayName("Test 10 - Recipe change coffee")
	public void test10() {
		recipe.setAmtCoffee("7");
		assertEquals(recipe.getAmtCoffee(), 7);
	}

	@Test
	@DisplayName("Test 11 - Recipe change milk")
	public void test11() {
		recipe.setAmtMilk("7");
		assertEquals(recipe.getAmtMilk(), 7);
	}

	@Test
	@DisplayName("Test 12 - Recipe change sugar")
	public void test12() {
		recipe.setAmtSugar("7");
		assertEquals(recipe.getAmtSugar(), 7);
	}

	@Test
	@DisplayName("Test 13 - Recipe change price")
	public void test13() {
		recipe.setPrice("7");
		assertEquals(recipe.getPrice(), 7);
	}

}
