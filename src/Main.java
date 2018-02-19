import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select task:>");
        System.out.println("1. Приветствовать любого пользователя при вводе его имени через командную строку.");
        System.out.println("2. Отобразить в окне консоли аргументы командной строки в обратном порядке.");
        System.out.println("3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
        System.out.println("4. Ввести пароль из командной строки и сравнить его со строкой-образцом.");
        System.out.println("5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.");
        System.out.println("6.Ввести с консоли n целых чисел. На консоль вывести:");
        System.out.println("6.1. Четные и нечетные числа.");
        System.out.println("6.2. Наибольшее и наименьшее число.");
        System.out.println("6.3. Числа, которые делятся на 3 или на 9.");
        System.out.println("6.4. Числа, которые делятся на 5 и на 7.");
        System.out.println("6.5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        System.out.println("6.6. «Счастливые» числа.");
        System.out.println("6.7. Элементы, которые равны полусумме соседних элементов.");

        Scanner scanChoose = new Scanner(System.in);
        String choose = scanChoose.next();

        switch (choose) {
            case "1":
                helloUser();
                break;
            case "2":
                 for (int i = args.length; i > 0 ; i--) {
                    System.out.println("args = " + args[i-1]);
                }
                break;
            case "3":
                outputNumbers();
                break;
            case "4":
                comparePassword();
                break;
            case "5":
                int rezSum = 0, rezProiz = Integer.parseInt(args[0]);
                for (int i = 0; i < args.length; i++) {
                    rezSum += Integer.parseInt(args[i]);
                    rezProiz *= Integer.parseInt(args[i]);
                }
                argsSumProiz(rezSum, rezProiz);
                break;
            case "6":
                differentVariantOutputNumbers();
                break;
            default:
                System.out.println("Something go wrong");
        }
    }

    public static void helloUser() {
        System.out.println("Input your name and press <Enter> button:>");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        scan.close();
        System.out.println("Hello "+ name + "!");
    }

    public static void outputNumbers() {
//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.
        System.out.println("Input the size of massive:>");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        int arg = Integer.parseInt(name);
        int[] massive = new int [arg];
        System.out.println("Input the numbers:>");
        for (int i = 0; i < arg; i++) {
            scanner = new Scanner(System.in);
            name = scanner.next();
            massive[i] = Integer.parseInt(name);
        }
        for (int i = 0; i < arg; i++) {
            if (i%2 == 0)
                System.out.println(massive[i]);
            else
                System.out.print(massive[i] + " ");
        }
    }

    public static void comparePassword() {
//4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
        System.out.println("Input password for checking");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        if (name.equals("password"))
            System.out.println("Password correct");
        else
            System.out.println("Password incorrect");
    }

    public static void argsSumProiz(int rezSum, int rezProiz) {
//5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
        System.out.println("Sum of numbers of command line - " + rezSum);
        System.out.println("Product of numbers of command line - " + rezProiz);
    }

    public static void differentVariantOutputNumbers() {
//6.Ввести с консоли n целых чисел. На консоль вывести:
//6.1. Четные и нечетные числа.
        System.out.println("Input the number:>");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        int count = Integer.parseInt(name);
        int[] massive = new int [count];
        int[] even = new int [count];
        int[] uneven = new int [count];

        System.out.println("Input the numbers:>");
        for (int i = 0; i < count; i++) {
            scanner = new Scanner(System.in);
            name = scanner.next();
            massive[i] = Integer.parseInt(name);
        }
        int i_even = 0, i_uneven = 0;
        for (int i = 0; i < count; i++) {
            if (massive[i]%2 == 0){
                even[i_even] = massive[i];
                i_even++;
            }
            else{
                uneven[i_uneven] = massive[i];
                i_uneven++;
            }
        }
        System.out.println("Even massive");
        for (int i = 0; i < i_even; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println("\nUneven massive");
        for (int i = 0; i < i_uneven; i++) {
            System.out.print(uneven[i] + " ");
        }

//6.2. Наибольшее и наименьшее число.
        int min = massive[0];
        int max = massive[0];

        for (int i = 0; i < count; i++) {
            if (max < massive[i])
                max = massive[i];
        }

        for (int i = 0; i < count; i++) {
            if (min > massive[i])
                min = massive[i];
        }

        System.out.println("\nMax = " + max + ", Min = " + min);

//6.3. Числа, которые делятся на 3 или на 9.
        int[] rezDev3_9 = new int [count];
        int countDevision = 0;
        for (int i = 0; i < count; i++) {
            if ((massive[i]%3 == 0) || (massive[i]%9 == 0)){
                rezDev3_9[countDevision] = massive[i];
                countDevision++;
            }
        }

        if (countDevision != 0){
            System.out.println("Numbers which division by 3 or 9");
            for (int i = 0; i < countDevision; i++) {
                System.out.print(rezDev3_9[i] + " ");
            }
        }
        else
            System.out.println("No numbers which division by 3 or 9");

//6.4. Числа, которые делятся на 5 и на 7.
        int[] rezDev5_7 = new int [count];
        countDevision = 0;
        for (int i = 0; i < count; i++) {
            if ((massive[i]%5 == 0) && (massive[i]%7 == 0)){
                rezDev5_7[countDevision] = massive[i];
                countDevision++;
            }
        }

        if (countDevision != 0){
            System.out.println("\nNumbers which division by 5 and 7");
            for (int i = 0; i < countDevision; i++) {
                System.out.print(rezDev5_7[i] + " ");
            }
            System.out.println();
        }
        else
            System.out.println("\nNo numbers which division by 5 and 7");

//6.5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        int[] threeDigitNumbers = new int [count];
        countDevision = 0;
        String promValue;
        for (int i = 0; i < count; i++) {
            promValue = Integer.toString(massive[i]);
            if (promValue.length() == 3 && promValue.charAt(0) != promValue.charAt(1) &&
                    promValue.charAt(1) != promValue.charAt(2) && promValue.charAt(0) != promValue.charAt(2)){
                threeDigitNumbers[countDevision] = massive[i];
                countDevision++;
            }
        }

        System.out.println("No the same digits");
        for (int i = 0; i < countDevision; i++) {
            System.out.print(threeDigitNumbers[i] + " ");
        }
        System.out.println();

//6.6. «Счастливые» числа.
        int[] luckyNumbers = new int [count];
        int countLucky = 0;
        String luckyValue;
        for (int i = 0; i < count; i++) {
            luckyValue = Integer.toString(massive[i]);
            if (luckyValue.length() == 4 && luckyValue.charAt(0) + luckyValue.charAt(1) ==
                    luckyValue.charAt(2) + luckyValue.charAt(3)){
                luckyNumbers[countLucky] = massive[i];
                countLucky++;
            }
        }

        System.out.println("Lucky number");
        for (int i = 0; i < countLucky; i++) {
            System.out.print(luckyNumbers[i] + " ");
        }
        System.out.println();

//6.7. Элементы, которые равны полусумме соседних элементов.
        int[] halfSum = new int [count];
        int countHalfSum = 0;
        if (count < 3){
            System.out.println("Array contains less than 3 elements, it is impossible to complete the task");
        }
        else{
            for (int i = 1; i < count-1; i++) {
                if (massive[i] == (massive[i-1] + massive[i+1]) / 2){
                    halfSum[countHalfSum] = massive[i];
                    countHalfSum++;
                }
            }
            if (countHalfSum!=0){
                System.out.println("Elements that are equal to the half-sum of neighboring elements");
                for (int i = 0; i < countHalfSum; i++) {
                    System.out.print(halfSum[i] + " ");
                }
                System.out.println();
            }
            else{
                System.out.println("No elements that are equal to the half-sum of neighboring elements");
            }

        }
    }

}