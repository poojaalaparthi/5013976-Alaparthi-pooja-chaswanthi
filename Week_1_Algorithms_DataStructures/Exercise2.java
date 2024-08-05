import java.util.*;
class Product{
    int productId;
    String productName;
    String productCategory;
    public Product(int productId,String productName,String productCategory){
        this.productId=productId;
        this.productName=productName;
        this.productCategory=productCategory;
    }
}
class ECommerce
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of products");
        int n=sc.nextInt();
        Product[] products =new Product[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the details of Product"+(i+1));
            System.out.print("Enter the ProductID: ");
            int id=sc.nextInt();
            System.out.print("Enter the Product Name: ");
            String p=sc.next();
            System.out.print("Enter the Product Category: ");
            String c=sc.next();
            sc.nextLine();
            products[i]=new Product(id, p, c);
        }
        System.out.print("Enter the ProductID of the Product to search: ");
        int findProductID=sc.nextInt();
        Product[] sortedProducts=products.clone();
        Arrays.sort(sortedProducts,(p1,p2)->Integer.compare(p1.productId,p2.productId));
        System.out.println(linearSearch(products, findProductID));
        System.out.println(binarySearch(sortedProducts, findProductID, 0, n-1));
        sc.close();
    }
    public static String linearSearch(Product[] products,int findProductID)
    {
        for(Product product:products)
            if(product.productId==findProductID)
                return "Product found using linear search\nProduct Name: "+product.productName+"\nProduct Category: "+product.productCategory;
        return "Product not found using linear search";
    }
    public static String binarySearch(Product[] sortedProducts,int findProductID,int low,int high)
    {
        if(low<=high)
        {
            int mid=(low+high)/2;
            if(sortedProducts[mid].productId==findProductID)
                return "Product found using binary search\nProduct Name: "+sortedProducts[mid].productName+"\nProduct Category: "+sortedProducts[mid].productCategory;
            else if(sortedProducts[mid].productId<findProductID)
                return binarySearch(sortedProducts, findProductID, mid+1, high);
            else
                return binarySearch(sortedProducts, findProductID, low, mid-1);
        }
        return "Product not found using binary search";
    }
}