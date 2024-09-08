package coffeemaker;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.InventoryException;

import coffeemaker.domain.*;

public class InventoryTest {
    /**
	 * Inventory Component under test.
	 */
	private Inventory inventory;
    private Recipe recipe;

	@BeforeEach
	public void setUp() {
		inventory = new Inventory();
        recipe  = new Recipe();
	}

	@AfterEach
	public void tearDown() {
		inventory = null;
	}

    
    @Test
    @DisplayName ("Test 1: Inventory exists")
    public void test1(){
        assertTrue(inventory != null);
    }


    // Test Get Methods

    @Test
    @DisplayName ("Test 2: Get Initial Coffee Amount")
    public void test2(){
        assertEquals(inventory.getCoffee(),15);
    }

    @Test
    @DisplayName ("Test 3: Get Initial Milk Amount")
    public void test3(){
        assertEquals(inventory.getMilk(),15);
    }

    @Test
    @DisplayName ("Test 4: Get Initial Chocolate Amount")
    public void test4(){
        assertEquals(inventory.getChocolate(),15);
    }

    @Test
    @DisplayName ("Test 5: Get Initial Sugar Amount")
    public void test5(){
        assertEquals(inventory.getSugar(),15);
    }

    //Test Setters
    
    @Test
    @DisplayName ("Test 6: Set Coffee")
    public void test6(){
        inventory.setCoffee(25);
        assertEquals(inventory.getCoffee(),25);
    }
    
    @Test
    @DisplayName ("Test 7: Set Milk")
    public void test7(){
        inventory.setMilk(25);
        assertEquals(inventory.getMilk(),25);
    }

    @Test
    @DisplayName ("Test 8: Set Chocolate")
    public void test8(){
        inventory.setChocolate(25);
        assertEquals(inventory.getChocolate(),25);
    }

    @Test
    @DisplayName ("Test 9: Set Sugar")
    public void test9(){
        inventory.setSugar(25);
        assertEquals(inventory.getSugar(),25);
    }

    // Test Set if amount is negative
    @Test
    @DisplayName ("Test 10: Set negative amount of Coffee ")
    public void test10(){
        inventory.setCoffee(-1);
        assertEquals(inventory.getCoffee(),15);
    }

    @Test
    @DisplayName ("Test 11: Set negative amount of Milk")
    public void test11(){
        inventory.setMilk(-1);
        assertEquals(inventory.getMilk(),15);
    }

    @Test
    @DisplayName ("Test 12: Set negative amount of Chocolate")
    public void test12(){
        inventory.setChocolate(-1);
        assertEquals(inventory.getChocolate(),15);
    }

    @Test
    @DisplayName ("Test 13: Set negative amount of Sugar")
    public void test13(){
        inventory.setSugar(-1);
        assertEquals(inventory.getSugar(),15);
    }
    // Test Adding Methods

    @Test
    @DisplayName ("Test 14: Add Coffee")
    public void test14(){
        inventory.addCoffee("14");
        assertEquals(inventory.getCoffee(),29);
    }

    @Test
    @DisplayName ("Test 15: Add Milk")
    public void test15(){
        inventory.addMilk("14");
        assertEquals(inventory.getMilk(),29);
    }

    @Test
    @DisplayName ("Test 16: Add Chocolate")
    public void test16(){
        inventory.addChocolate("14");
        assertEquals(inventory.getChocolate(),29);
    }

    @Test
    @DisplayName ("Test 17: Add Sugar")
    public void test17(){
        inventory.addSugar("14");
        assertEquals(inventory.getSugar(),29);
    }

    
    // Testing Negative Amounts 


    @Test
    @DisplayName ("Test 18: Add Coffee if amount is < 0")
    public void test18(){
        String expectedMessage = "Units of coffee must be a positive integer";
        try{
            inventory.addCoffee("-1");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 19: Add Milk if amount is < 0")
    public void test19(){
        String expectedMessage = "Units of milk must be a positive integer";
        try{
            inventory.addMilk("-1");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 20: Add Chocolate if amount is < 0")
    public void test20(){
        String expectedMessage = "Units of chocolate must be a positive integer";
        try{
            inventory.addChocolate("-1");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 21: Add Sugar if amount is < 0")
    public void test21(){
        String expectedMessage = "Units of sugar must be a positive integer";
        try{
            inventory.addSugar("-1");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }


    // Format Testing


    @Test
    @DisplayName ("Test 22: Add Coffee (amount is properly formatted)")
    public void test22(){
        String expectedMessage = "Units of coffee must be a positive integer";
        try{
            inventory.addCoffee("/'12'/");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 23: Add Milk (amount is properly formatted)")
    public void test23(){
        String expectedMessage = "Units of milk must be a positive integer";
        try{
            inventory.addMilk("/'12'/");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 24: Add Chocolate (amount is properly formatted)")
    public void test24(){
        String expectedMessage = "Units of chocolate must be a positive integer";
        try{
            inventory.addChocolate("/'12'/");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    @Test
    @DisplayName ("Test 25: Add Sugar (amount is properly formatted)")
    public void test25(){
        String expectedMessage = "Units of sugar must be a positive integer";
        try{
            inventory.addSugar("/'12'/");
        }
        catch(InventoryException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }


    // Testing toString method
    @Test
    @DisplayName ("Test 26: Testing toString method output")
    public void test26(){
        String actualString = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(inventory.toString(),actualString);
        
    }

   

}
