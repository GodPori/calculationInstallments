import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERSENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("مقدار وام مورد نظر از بازه 100 میلیون تا 500 میلیون؟: ");
        int principal = scanner.nextInt();
        if (principal < 100 || principal > 500) {
            throw new RuntimeException("لطفا بازه وام مورد نظر را بین 100 میلیون تا 500 میلیون انتخاب کنید!!!");
        }

        System.out.println("مقدار نرخ بهره سالانه را بین 4 درصد یا 16 درصد انتخاب کنید؟:");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERSENT / MONTH_IN_YEAR;
        if (annualInterest == 4) {
            System.out.println("شما نرخ بهره سالانه 4 درصد را انتخاب کردید!");
        } else if (annualInterest == 16) {
            System.out.println("شما نرخ بهره سالانه 16 درصد را انتخاب کردید!");
        }else {
            throw new RuntimeException("لطفا نرخ بهره سالانه را یا 4  و یا 16 درصد انتخاب بکنید!");
        }

        System.out.println("میزان 'سال' مورد نظر برای بازپرداخت وام بین 1 تا 5 سال انتخاب کنید");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTH_IN_YEAR;
        if (years < 1 || years > 5) {
            throw new RuntimeException("لطفا میزان سال مد نظر برای باز پرداخت وام بین 1 تا 5 سال باشد");
        }

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest , numberOfPayments))/
                (Math.pow(1 + monthlyInterest , numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("میزان اقساط هر ماه" + mortgageFormatted);
    }
}