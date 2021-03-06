package chapter2;

/**
 * <b>Factory methods</b> :
 * <p>Why ?</p>
 * <ul>
 *     <li>They have names -> easier to use, easier to read </li>
 *     <li>Not required to create a new object with each call -> ie : Boolean.valueOf()</li>
 *     <li>Can return any subtype of the object</li>
 *     <li>The returned object can vary depending on given parameters</li>
 *     <li>The class of the returned object does not need to exists when the method is written</li>
 * </ul>
 * <p>Why not ?</p>
 * <ul>
 *     <li>They can be hard to find for programmers using the code </li>
 * </ul>
 */
public final class Item_1_FactoryMethods {
}

class Recipe {

    private static final Recipe EMPTY_RECIPE = new Recipe();

    Recipe() {}

    private Recipe(final Ingredient... ingredients) {}

    //only one parameter
    static Recipe from(Ingredient ingredient) { return new Recipe(ingredient); }

    //multiple parameters
    static Recipe of(Ingredient... ingredients) { return new Recipe(ingredients); }

    //more verbose than from() or of()
    static Recipe valueOf(Ingredient... ingredients) { return new Recipe(ingredients); }

    //or getInstance(), free to create a new instance or not
    static Recipe instance(Ingredient... ingredients) {
        if (ingredients.length == 0)
            return EMPTY_RECIPE;
        return new Recipe();
    }

    //or newInstance(), will create a new instance
    static Recipe create(Ingredient... ingredients) { return new Recipe(ingredients); }
}

class Recipes {
    //like getInstance but in another class than the created object
    static Recipe getRecipe() { return new Recipe(); }

    //like newInstance but in another class than the created object
    static Recipe newRecipe() { return new Recipe(); }

    //more concise than getRecipe or newRecipe
    static Recipe recipe() { return new Recipe(); }
}

class Ingredient {

}
