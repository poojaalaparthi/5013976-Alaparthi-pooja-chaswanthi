import java.util.*;
class Order
{
    int orderId;
    String customerName;
    double totalPrice;
    public Order(int orderId,String customerName,double totalPrice)
    {
        this.orderId=orderId;
        this.customerName=customerName;
        this.totalPrice=totalPrice;
    }
}
class CustomerOrders
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of Orders");
        int n=sc.nextInt();
        Order orders[]=new Order[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the details of Order"+(i+1));
            System.out.print("Enter the OrderID: ");
            int id=sc.nextInt();
            System.out.print("Enter the Customer Name: ");
            String name=sc.next();
            System.out.print("Enter the total price of the order: ");
            double p=sc.nextDouble();
            orders[i]=new Order(id, name, p);
            bubbleSort(orders);
            quickSort(orders, 0, n-1);
        }
        sc.close();
    }
    public static void bubbleSort(Order orders[])
    {
        for(int i=0;i<orders.length-1;i++)
            for(int j=0;j<orders.length-i-1;j++)
                if(orders[j].totalPrice>orders[j+1].totalPrice)
                {
                    Order order=orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=order;
                }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot.totalPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}