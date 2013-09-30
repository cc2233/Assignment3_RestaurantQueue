
public class Driver 
{
    LinkedList<CategoryClass> mCategories;
    public String mLastError; //stores possible error messages


    public static void main(String[] args) 
    {
                VendorGUI v1 = new VendorGUI();
                Driver d1 = new Driver();
                v1.setDriver(d1);
                v1.setVisible(true);
             
    }
    
    public boolean addCategory(String newCategoryName)
    {
        CategoryClass newCategory = new CategoryClass(newCategoryName);
        
        if(mCategories.contains(newCategory)) //if there's a duplicate, category won't be added
        {
            mLastError = "Category name already exists!";
            return false;
        }
        
        mCategories.add(newCategory);
        return true;
    }
}