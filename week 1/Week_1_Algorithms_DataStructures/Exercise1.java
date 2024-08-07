import java.util.*;
class Product
{
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    public Product(int productId,String productName,int quantity,double price)
    {
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }
    public int getProductId()
    {
        return this.productId;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public void setProductName(String newProductName)
    {
        this.productName=newProductName;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int newQuantity)
    {
        this.quantity=newQuantity;
    }
    public double getPrice()
    {
        return this.price;
    }
    public void setPrice(double newPrice)
    {
        this.price=newPrice;
    }
}
class InventoryManagementSystem
{
    private Map<Integer,Product> products;
    public InventoryManagementSystem()
    {
        this.products=new HashMap<>();
    }
    public void add(Product product)
    {
        if(products.containsKey(product.getProductId()))
            throw new IllegalArgumentException("Product already exists");
        products.put(product.getProductId(),product);
        System.out.println("Product added to Inventory successfully");
    }
    public void update(int productId,String productName,int quantity,double price)
    {
        if(!products.containsKey(productId))
            throw new IllegalArgumentException("Product doesn't exists");
        Product product=products.get(productId);
        product.setProductName(productName);
        product.setPrice(price);
        product.setQuantity(quantity);
        System.out.println("Product updated successfully");
    }
    public void delete(int productId)
    {
        if(!products.containsKey(productId))
            throw new IllegalArgumentException("Product doesn't exist");
        products.remove(productId);
        System.out.println("Product deleted successfully");
    }
    public static void main(String[] args) {
        InventoryManagementSystem ims=new InventoryManagementSystem();
        Scanner sc=new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1:ADD PRODUCT\n2.UPDATE PRODUCT\n3.DELETE PRODUCT\n4:EXIT");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1: System.out.println("Enter ProductID");
                        int id=sc.nextInt();
                        System.out.println("Enter Product Name");
                        String name=sc.next();
                        System.out.println("Enter Product Quantity");
                        int q=sc.nextInt();
                        System.out.println("Enter Product Price");
                        double p=sc.nextDouble();
                        try
                        {
                        ims.add(new Product(id, name, q, p));
                        }
                        catch(IllegalArgumentException e)
                        {
                            System.out.println(e.toString());
                        }
                    break;
                case 2: System.out.println("Enter ProductID");
                        id=sc.nextInt();
                        System.out.println("Enter Product Name");
                        name=sc.next();
                        System.out.println("Enter Product Quantity");
                        q=sc.nextInt();
                        System.out.println("Enter Product Price");
                        p=sc.nextDouble();
                        try 
                        {
                            ims.update(id, name, q, p);
                        } 
                        catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.toString());
                        }
                        break;
                case 3: System.out.println("Enter ProductID");
                        try 
                        {
                            ims.delete(sc.nextInt());
                        } 
                        catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.toString());
                        }        
                        break;
                case 4: System.out.println("Thank you for using Inventory System");
                        break;
                default:System.out.println("Invalid Choice\nPlease Try again");
                    break;
            }
        }while(choice!=4);
        sc.close();
    }
}