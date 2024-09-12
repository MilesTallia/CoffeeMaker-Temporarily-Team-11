package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coffeemaker.domain.*;

public class RecipeBookTest {
    
    // component under test
    private RecipeBook recipeBook;

    @BeforeEach
    public void setUp() {
        recipeBook = new RecipeBook(); // making a clean recipe book before each test
    }

    @AfterEach
    public void tearDown() {
        recipeBook = null; // preventing any side effects from testing from spilling over into future tests
    }

    @Test
    @DisplayName("Test 1: Get initial array of recipes")
    public void getRecipesBlank() {
        Recipe[] recipes = recipeBook.getRecipes();
        for (Recipe recipe : recipes) {
            assertNull(recipe); // these should not have been initialized after the object is just constructed
        }
    }

    @Test
    @DisplayName("Test 2: Add a recipe to the initial array of recipes")
    public void addRecipeBlank() {
        Recipe addedRecipe = new Recipe();
        boolean addResult = recipeBook.addRecipe(addedRecipe);
        assertTrue(addResult); // since the RecipeBook array is originally empty this should always be true
        Recipe[] recipes = recipeBook.getRecipes();
        assertEquals(addedRecipe, recipes[0]); // the recipe should be added at the front of the recipes array
    }

    @Test
    @DisplayName("Test 3: Add a recipe to a partially filled array of recipes")
    public void addRecipePartiallyFull() {
        Recipe initialRecipe = new Recipe(); // this will the recipe present in the RecipeBook before we add a second one
        recipeBook.addRecipe(initialRecipe);

        Recipe addedRecipe = new Recipe(); // added to the partially filled array
        addedRecipe.setAmtChocolate("10"); // we need to modify the recipe's ingredients in some way so we aren't adding an already existing recipe
        boolean addResult = recipeBook.addRecipe(addedRecipe); 
        assertTrue(addResult);
        
        Recipe[] recipes = recipeBook.getRecipes();
        assertEquals(initialRecipe, recipes[0]); // this recipe should have been added at the first position
        assertEquals(addedRecipe, recipes[1]); // the added recipe should've been added in the 2nd position in the array
    }

    @Test
    @DisplayName("Test 4: Add a recipe to the recipe book that already exists")
    public void addRecipeAlreadyExists() {
        Recipe addedRecipe = new Recipe(); 
        recipeBook.addRecipe(addedRecipe);

        Recipe duplicateRecipe = new Recipe(); // since this is also a recipe with unmodified fields, it shouldn't be added to the recipe book when we try to
        boolean duplicateAddResult = recipeBook.addRecipe(duplicateRecipe);
        assertFalse(duplicateAddResult); // we shouldn't be able to add the duplicate recipe
    }

    @Test
    @DisplayName("Test 5: Add a recipe to the recipe book when the book is full")
    public void addRecipeFull() {
        // getting the length of the recipe book and filling it so the test doesn't break if the size of the book changes
        int bookLength = recipeBook.getRecipes().length;
        for (int i = 0; i < bookLength; i++) {
            Recipe addedRecipe = new Recipe();
            addedRecipe.setName("Recipe number " + i);
            recipeBook.addRecipe(addedRecipe);
        }
        Recipe fullRecipe = new Recipe();
        boolean fullAddResult = recipeBook.addRecipe(fullRecipe); 
        // all the other recipes have a name defined and this does not, so it should only fail to be added if the book is full
        assertFalse(fullAddResult);
    }

    @Test
    @DisplayName("Test 6: Delete a recipe on the initial recipe book before any changes have been made")
    public void deleteRecipeEmpty() {
        String deleteResult = recipeBook.deleteRecipe(0);
        assertNull(deleteResult); // the recipe in this slot should be null, so nothing should happen
    }

    @Test
    @DisplayName("Test 7: Delete a recipe on an empty slot after a recipe has already been added earlier in the book")
    public void deleteRecipeEmptyAfterAddition() {
        Recipe addedRecipe = new Recipe();
        recipeBook.addRecipe(addedRecipe);
        // now that we've added a recipe, we verify that accessing a later index still returns null
        String deleteResult = recipeBook.deleteRecipe(1); // this index should still be empty and return null
        assertNull(deleteResult);
    }

    @Test
    @DisplayName("Test 8: Delete a recipe that exists")
    public void deleteRecipeExists() {
        Recipe deletedRecipe = new Recipe();
        String deletedRecipeName = "Delete Me";
        deletedRecipe.setName(deletedRecipeName);
        recipeBook.addRecipe(deletedRecipe);
        // now we can verify that we get the name when we delete the recipe
        String deleteResult = recipeBook.deleteRecipe(0); // the recipe should be at the start of the array
        assertEquals(deletedRecipeName, deleteResult);
        // and we verify that the resulting slot is now null since no recipe is present
        String secondDeleteResult = recipeBook.deleteRecipe(0);
        assertNull(secondDeleteResult); // this fails - whether this is a defect or part of the requirements isn't clear
    }

    @Test
    @DisplayName("Test 9: Delete a recipe at an index above the range of the recipe book's array")
    public void deleteRecipeAboveBounds() {
        int recipeBookLength = recipeBook.getRecipes().length; // guaranteeing that we go over the bounds of the array
        assertDoesNotThrow(() -> recipeBook.deleteRecipe(recipeBookLength)); // passes as long as an exception isn't raised
    }

    @Test
    @DisplayName("Test 10: Delete a recipe at an index below the range of the recipe book's array")
    public void deleteRecipeBelowBounds() {
        assertDoesNotThrow(() -> recipeBook.deleteRecipe(-1)); // should never be accessing a valid recipe, passes if no exception is raised
    }

    @Test
    @DisplayName("Test 11: Replace a recipe at an index above the range of the recipe book's array")
    public void replaceRecipeAboveBounds() {
        int recipeBookLength = recipeBook.getRecipes().length; // guaranteeing that we go over the bounds of the array
        Recipe replacingRecipe = new Recipe();
        assertDoesNotThrow(() -> recipeBook.replaceRecipe(recipeBookLength, replacingRecipe)); // passes as long as an exception isn't raised
    }

    @Test
    @DisplayName("Test 12: Replace a recipe at an index below the range of the recipe book's array")
    public void replaceRecipeBelowBounds() {
        Recipe replacingRecipe = new Recipe();
        assertDoesNotThrow(() -> recipeBook.replaceRecipe(-1, replacingRecipe)); // should never be accessing a valid recipe, passes if no exception is raised
    }

    @Test
    @DisplayName("Test 13: Replace a recipe when the RecipeBook has just been initialized")
    public void replaceRecipeJustInitialized() {
        Recipe replacingRecipe = new Recipe();
        String replacementResult = recipeBook.replaceRecipe(0, replacingRecipe);
        assertNull(replacementResult); // we shouldn't replace here and should get a value of null
    }

    @Test
    @DisplayName("Test 14: Replace a recipe in an unitialized position after initializing some recipes at the start of the book")
    public void replaceRecipePartiallyInitialized() {
        Recipe existingRecipe = new Recipe();
        existingRecipe.setName("Existing");
        recipeBook.addRecipe(existingRecipe); // part of the book has now been initialized

        Recipe replacingRecipe = new Recipe();
        String replacementResult = recipeBook.replaceRecipe(1, replacingRecipe); // the 2nd array position still hasn't been initialized
        assertNull(replacementResult);
    }

    @Test
    @DisplayName("Test 15: Replace an initialized recipe")
    public void replaceInitializedRecipe() {
        Recipe existingRecipe = new Recipe();
        String existingRecipeName = "Existing";
        existingRecipe.setName(existingRecipeName);
        recipeBook.addRecipe(existingRecipe);  // we can now replace this recipe

        Recipe replacingRecipe = new Recipe();
        String replacingName = "Replacing";
        replacingRecipe.setName(replacingName);
        String replacementResult = recipeBook.replaceRecipe(0, replacingRecipe);
        assertEquals(existingRecipeName, replacementResult); // verifying the method returns the name of the previously existing recipe

        Recipe[] resultingRecipes = recipeBook.getRecipes();
        String resultingRecipeName = resultingRecipes[0].getName(); // getting the name at the location of the replaced recipe
        assertEquals(replacingName, resultingRecipeName); // the recipe at the replaced position should not have had its name modified
        // note that we can't test this by checking object equality because the replacing recipe was passed by reference
    }

}
