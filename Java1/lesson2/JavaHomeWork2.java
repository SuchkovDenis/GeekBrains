/**
* GeekBrains Java1 HomeWork 2
* @author Suchkov Denis
* @version dated Jan 31, 2018
*/
class JavaHomeWork2 {
    public static void main(String[] args) {
        // Task 1 - invert array [0, 1] -> [1, 0]
        System.out.println("Task 1 - invert array");
        invertArray();
        invertArray();
        System.out.println();

        // Task 2 - create array [0 3 6 9 12 15 18 21]
        System.out.println("Task 2 - create array [0 3 6 9 12 15 18 21]");
        createArray();
        System.out.println();

        // Task 3 - multiply by 2 elements that are less than 6
        System.out.println("Task 3 - multiply by 2 elements that are less than 6");
        changeArray();
        System.out.println();

        // Task 4 - fill diagonal elements 1
        System.out.println("Task 4 - fill diagonal elements 1");
        fillArray(5);
        fillArray(6);

        // Task 5 - find min and max
        System.out.println("Task 5 - find min and max");
        findMinMax(7);
        findMinMax(1);

        // Task 6 - checkBalance
        System.out.println("Task 6 - checkBalance");
        int[] a = {1, 1, 1, 2, 1}, b = {2, 1, 1, 2, 1}, c = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        
        printArray(a);
        System.out.println(checkBalance(a));
        printArray(b);
        System.out.println(checkBalance(b));
        printArray(c);
        System.out.println(checkBalance(c));
        System.out.println();

        // Task 7 - moveArray
        System.out.println("Task 7 - moveArray");
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8};
        int shift;
        System.out.println("Before moving : ");
        printArray(d);

        shift = 3;
        moveArray(d,shift);

        System.out.println("After  moving : (shift = " + shift + " )");
        printArray(d);

        shift = -1;
        moveArray(d,shift);

        System.out.println("After  moving : (shift = " + shift + " )");
        printArray(d);

        shift = -16;
        moveArray(d,shift);

        System.out.println("After  moving : (shift = " + shift + " )");
        printArray(d);

    }
    public static void invertArray() {
        int[] arr = new int[20];

        for (int i = 0; i<arr.length ; i++)
            arr[i] = (int) (Math.random() * 2);

        System.out.println("Before invertion : ");
        printArray(arr);

        for (int i=0; i<arr.length; i++)
            arr[i] = (arr[i] + 1) % 2;

        System.out.println("After  invertion : ");
        printArray(arr);
    }

    public static void createArray() {
        int[] arr = new int[8];

        for (int i = 0; i<arr.length; i++)
            arr[i] = 3 * i;

        printArray(arr);
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Before changes : ");
        printArray(arr);

        for (int i = 0; i<arr.length ; i++) 
            if (arr[i]<6)
                arr[i]*=2;

        System.out.println("After  changes : ");
        printArray(arr);
    }

    public static void fillArray(int N) {
        int[][] arr = new int[N][N];

        for (int i = 0; i<arr.length; i++)
            arr[i][i]=arr[i][arr.length - 1 - i] = 1;

        System.out.println("Array " + N + "x" + N);
        for (int i = 0; i<arr.length ; i++) {
            for (int j = 0; j<arr.length ; j++) 
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void findMinMax(int N) {
        int[] arr = new int[N];

        for (int i = 0; i<arr.length ; i++) 
            arr[i] = (int) (Math.random() * 20);

        System.out.println("Array : ");
        printArray(arr);

        int min = arr[0], max = arr[0];
        for (int i = 0; i<arr.length ; i++) {
            if (arr[i]<min)
                min = arr[i];
            else if (arr[i]>max)
                max = arr[i];
        }
        System.out.println("Max : " + max + "\tMin : " + min + "\n");
    }

    public static boolean checkBalance(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        if (arr.length>1) {
            for (int a: arr)
                sumRight += a;

            for (int a: arr) {
                sumLeft += a;
                sumRight -=a;
                if (sumLeft == sumRight)
                    return true;
            }
            return false;
        }
        else
            return false;
    }

    public static void moveArray(int[] arr, int n) {
        int c, d = arr[0];
        if (n<0)
            n = arr.length + n % arr.length; 
        for (int i = 0; i<arr.length; i++) {
            c = arr[((i + 1) * n ) % arr.length];
            arr[((i + 1) * n) % arr.length] = d;
            d = c;
        }
    }

    public static void printArray(int[] arr) {
        for (int x : arr) 
            System.out.print(x + " ");
        System.out.println();
    }

}