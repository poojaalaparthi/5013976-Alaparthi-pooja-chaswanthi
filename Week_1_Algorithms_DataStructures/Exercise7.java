import java.util.*;
class FinancialForecasting {
    public static double predictFutureValue(double initialValue, double[] growthRates, int years) {
        if(years == 0)
            return initialValue;
        return predictFutureValue(initialValue * (1 + growthRates[years - 1]), growthRates, years - 1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the initital value: ");
        double initialValue = sc.nextDouble();
        System.out.print("Enter the no of past years of which growth rate is available: ");
        int n=sc.nextInt();
        double[] growthRates = new double[n];
        System.out.println("Enter the growth rates");
        for(int i=0;i<n;i++)
            growthRates[i]=sc.nextDouble();
        double futureValue = predictFutureValue(initialValue, growthRates,n);
        System.out.println("Predicted Future Value: " + futureValue);
        sc.close();
    }
}
