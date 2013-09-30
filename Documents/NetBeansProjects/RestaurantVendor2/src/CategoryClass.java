
public class CategoryClass 
{
    
    public String mCategoryName;
    LinkedList<FoodItemClass> mFoodItems;
	
    public CategoryClass() //constructor
    {
	mFoodItems = new LinkedList<FoodItemClass>();
    }
    
    public CategoryClass(String newCategoryName) //constructor to set category name
    {
        mCategoryName = newCategoryName;
    }
    
    public boolean equals(CategoryClass y) //compares category names
    {
        return y.mCategoryName.equals(this.mCategoryName);
    }
}
