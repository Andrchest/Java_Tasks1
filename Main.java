import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

class Ex1{
    public static void method(long a, long b)
    {
        long tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.printf(a + " " + b);
    }
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        long a, b;
        a = sc.nextLong();
        b = sc.nextLong();
        method(a, b);
    }
}

class Ex2{
    public static int method(char a)
    {
        int b;
        b = (int) a;
        return b;
    }

    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        char a;
        a = sc.next().charAt(0);
        System.out.println(Ex2.method(a));
    }
}

class Ex3{
    public static int method(char a)
    {
        int b = Ex2.method(a);
        if (b < 97)
        {
            b -= 64;
        }
        else
        {
            b -= 96;
        }
        return b;
    }

    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        char a;
        a = sc.next().charAt(0);
        System.out.println(Ex3.method(a));
    }
}

class Ex4{
    public static int method(String a, String b)
    {
        int i = 0;
        while (i < a.length() && i < b.length())
        {
            if (Ex3.method(a.charAt(i)) > Ex3.method(b.charAt(i)))
            {
                return 1;
            }
            i ++;
        }
        return 0;
    }

    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        String a, b;
        a = sc.next();
        b = sc.next();
        if (Ex4.method(a, b) == 1) {
            System.out.println(b);
            System.out.println(a);
        }else {
            System.out.println(a);
            System.out.println(b);
        }
    }
}

class Ex5{
    public static int method(String a)
    {
        int k = 0;
        for (int i = 0; i < a.length(); i++)
        {
            int num = Ex3.method(a.charAt(i));
            if (num == Ex3.method('a') || num == Ex3.method('e') || num == Ex3.method('i') || num == Ex3.method('o') || num == Ex3.method('u')){
                k++;
            }
        }
        return k;
    }

    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        String a;
        a = sc.next();
        System.out.println(Ex5.method(a));
    }
}

class Ex6{
    public static double method(double value)
    {
        return (value - 32) * 5 / 9;
    }

    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        double a;
        a = Double.parseDouble(sc.next());
        System.out.println(Ex6.method(a));
    }
}

class Ex7{
    static class Time
    {
        public int[] date = new int[3];
    }

    public static int[] method(Time a, Time b)
    {
        for (int i = 0; i < 3; i++)
        {
            if (a.date[i] < b.date[i])
            {
                int[] temp = a.date;
                a.date = b.date;
                b.date = temp;
                break;
            }
        }

        int[] result = new int[3];

        if (a.date[2] >= b.date[2])
        {
            result[2] = a.date[2] - b.date[2];
        }
        else
        {
            result[2] = 60 + a.date[2] - b.date[2];
            a.date[2] --;
        }

        if (a.date[1] >= b.date[1])
        {
            result[1] = a.date[1] - b.date[1];
        }
        else
        {
            result[1] = 60 + a.date[1] - b.date[1];
            a.date[1] --;
        }

        result[0] = a.date[0] - b.date[0];

        return result;
    }

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        Time t1 =new Time();
        Time t2 =new Time();
        t1.date[0] = sc.nextInt();
        
        t1.date[1] = sc.nextInt();
        t1.date[2] = sc.nextInt();
        t2.date[0] = sc.nextInt();
        t2.date[1] = sc.nextInt();
        t2.date[2] = sc.nextInt();

        System.out.println(Arrays.toString(Ex7.method(t1, t2)));
    }

}

class Ex8{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("%d, %h, %s", num, num, Integer.toBinaryString(num));
    }
}

class Ex9
{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xs = new int[n];
        double s = 0.0;
        for (int i = 0; i < n; i++)
        {
            xs[i] = sc.nextInt();
            s += xs[i];
        }
        System.out.println(s / n);
    }

}


class Ex10
{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xs = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            xs[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            System.out.println(xs[i]);
        }
        int new_ind = sc.nextInt();
        int new_value = sc.nextInt();

        for (int i = n; i > new_ind; i--)
        {
            xs[i] = xs[i - 1];
        }
        xs[new_ind] = new_value;

        for (int i = 0; i < n + 1; i++)
        {
            System.out.println(xs[i]);
        }
    }

}

class Ex11
{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xs = new int[n];
        int[] was = new int[1000000];
        for (int i = 0; i < n; i++)
        {
            xs[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (was[xs[i]] == 0) {
                was[xs[i]] = 1;
            } else {
                System.out.println(xs[i] + " " + i);
            }
        }
    }
}


class Ex12
{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Exist");
        }
        else {
            System.out.println("Not Exist");
        }
    }
}

class Ex13
{
    public static void solution()
    {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            System.out.println("Directory");
        }
        else if (file.isFile()) {
            System.out.println("File");
        }
    }
}

class Ex14
{
    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        String path1 = sc.nextLine();
        String path2 = sc.nextLine();
        File file1 = new File(path1);
        File file2 = new File(path2);
        Scanner sc1 = new Scanner(file1);
        FileWriter wc2 =new FileWriter(path2);
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            System.out.println(line);
            wc2.write(line + "\n");
        }
        sc1.close();
        wc2.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // to start execution of solution just change number like ExXX.solution()
        Ex14.solution();
    }
}