package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import coffeemaker.exceptions.RecipeException;

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
	@DisplayName("Test 1 - Recipe exists")
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






	// Negative input for integer field

	@Test
	@DisplayName("Test 14 - Negative input for chocolate")
	public void test14() {
		try {
			recipe.setAmtChocolate("-7");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtChocolate(), 0);
	}

	@Test
	@DisplayName("Test 15 - Negative input for coffee")
	public void test15() {
		try {
			recipe.setAmtCoffee("-7");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtChocolate(), 0);
	}

	@Test
	@DisplayName("Test 16 - Negative input for milk")
	public void test16() {
		try {
			recipe.setAmtMilk("-7");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtMilk(), 0);
	}

	@Test
	@DisplayName("Test 17 - Negative input for sugar")
	public void test17() {
		try {
			recipe.setAmtSugar("-7");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtSugar(), 0);
	}

	@Test
	@DisplayName("Test 18 - Negative input for price")
	public void test18() {
		try {
			recipe.setPrice("-7");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getPrice(), 0);
	}






	// Non-numbered input for integer field

	@Test
	@DisplayName("Test 19 - Negative input for chocolate")
	public void test19() {
		try {
			recipe.setAmtChocolate("seven");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtChocolate(), 0);
	}

	@Test
	@DisplayName("Test 20 - Negative input for coffee")
	public void test20() {
		try {
			recipe.setAmtCoffee("seven");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtChocolate(), 0);
	}

	@Test
	@DisplayName("Test 21 - Negative input for milk")
	public void test21() {
		try {
			recipe.setAmtMilk("seven");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtMilk(), 0);
	}

	@Test
	@DisplayName("Test 22 - Negative input for sugar")
	public void test22() {
		try {
			recipe.setAmtSugar("seven");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getAmtSugar(), 0);
	}

	@Test
	@DisplayName("Test 23 - Negative input for price")
	public void tes23() {
		try {
			recipe.setPrice("seven");
		} catch (RecipeException e) {
		}
		assertEquals(recipe.getPrice(), 0);
	}






	// ToString
	
	@Test
	@DisplayName("Test 24 - Recipe prints")
	public void test24() {
		recipe.setName("NewName");
		assertEquals(recipe.toString(), "Recipe{NewName}");
	}
	
	@Test
	@DisplayName("Test 25 - Blank recipe prints")
	public void test25() {
		assertEquals(recipe.toString(), "Recipe{}");
	}






	// Hashcode 

	@Test
	@DisplayName("Test 26 - Same hashcode equal")
	public void test26() {
		Recipe recipe2 = new Recipe();
		recipe.setName("1");
		recipe2.setName("1");
		assertEquals(recipe.hashCode(), recipe2.hashCode());
	}

	@Test
	@DisplayName("Test 27 - Different hashcodes do not equal")
	public void test27() {
		Recipe recipe2 = new Recipe();
		recipe.setName("1");
		recipe2.setName("2");
		assertNotEquals(recipe.hashCode(), recipe2.hashCode());
	}

	@Test
	@DisplayName("Test 28 - hashcode with null name")
	public void test28() {
		assertNotEquals(recipe.hashCode(),0);
	}






	// Equals

	@Test
	@DisplayName("Test 30 - Same recipes equal")
	public void test30() {
		Recipe recipe2 = new Recipe();
		recipe.setName("1");
		recipe2.setName("1");
		assertEquals(true, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 31 - Different recipes do not equal")
	public void test31() {
		Recipe recipe2 = new Recipe();
		recipe.setName("1");
		recipe.setAmtChocolate("10");
		recipe2.setName("2");
		assertEquals(false, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 32 - Null object does not equal")
	public void test32() {
		assertEquals(false, recipe.equals(null));
	}

	@Test
	@DisplayName("Test 33 - Non recipe class does not equal")
	public void test33() {
		RecipeBook rb = new RecipeBook();
		assertEquals(false, recipe.equals(rb));
	}

	@Test
	@DisplayName("Test 34 - Same null recipes equal")
	public void test34() {
		Recipe recipe2 = new Recipe();
		assertEquals(true, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 35 - Same name but different ingredient recipes do not equal")
	public void test35() {
		Recipe recipe2 = new Recipe();
		recipe.setName("flan");
		recipe2.setName("flan");
		recipe.setAmtMilk("20");
		recipe2.setAmtMilk("10");
		assertEquals(false, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 36 - Same name but different price recipes equal")
	public void test36() {
		Recipe recipe2 = new Recipe();
		recipe.setName("tart");
		recipe2.setName("tart");
		recipe.setPrice("20");
		recipe2.setPrice("10");
		assertEquals(true, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 37 - Different names but same stats recipes equal")
	public void test37() {
		Recipe recipe2 = new Recipe();
		recipe.setName("Milk");
		recipe2.setName("Leche");
		recipe.setPrice("10");
		recipe2.setPrice("10");
		recipe.setAmtMilk("100");
		recipe2.setAmtMilk("100");
		assertEquals(true, recipe.equals(recipe2));
	}

	@Test
	@DisplayName("Test 38 - Same recipe equals itself")
	public void test38() {
		recipe.setName("onlyRecipe");
		assertEquals(true, recipe.equals(recipe));
	}

	@Test
	@DisplayName("Test 39 - Recipe name is null do not equal")
	public void test39() {
		Recipe recipe2 = new Recipe();
		recipe.setName(null);
		recipe2.setName("tart");
		assertEquals(recipe,recipe2);
	}


}
