import java.io.FileNotFoundException;

public class Task3v1 {
    public static void main(String[] args) throws Throwable {
        int a = 90;
        int b = 3;
        int[] abc = {1, 2};
        int index = 1;
        printSum(23, 234);

        if (index > abc.length) {
            throw new IndexOutOfBoundsException("Массив выходит за пределы своего размера!");
        }
        abc[index] = 9;

        if (b == 0) {
            throw new Throwable("Что-то пошло не так...");
        }
        System.out.println(a / b);
    }

    public static void printSum(Integer a, Integer b) {
        if (a == null || b == null) throw new NullPointerException("Указатель не может указывать на null!");
        System.out.println(a + b);
    }
}
