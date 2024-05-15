import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int[] r1 = {0,1,2,3};
        int[] r2 = {1,2,3,4,5};
        int[] rx = {1,2,3,4};

        int[] a = Operate(r1, r2, '+');
        int[] b = Operate(r1, r2, '*');
        int[] a_rx = Operate(a, rx, '*');
        int[] a_rx_b = Operate(a_rx, b, '+');
        int[] rx_r2 = Operate(rx, r2, '+');
        int[] z = Operate(a_rx_b, rx_r2, '/');
        System.out.println(z.length);

        HashSet<Integer> set = new HashSet<>();
        for (int num : z) {
            if (num >= 1 && num <= 4) {
                set.add(num);
            }
        }

        System.out.println("Уникальные элементы в массиве, совпадающие с элементами Rx:");
        for (int q : set) {
            System.out.print(q + " ");
        }
    }

    public static int[] Operate(int[] arr1, int[] arr2, char operation) {
        int resLength = arr1.length * arr2.length;
        int[] res = new int[resLength];

        int resIndex = 0;

        for (int i : arr1) {
            for (int j : arr2) {
                int result = 0;
                switch (operation) {
                    case '+':
                        result = i + j;
                        break;
                    case '*':
                        result = i * j;
                        break;
                    case '/':
                        if (j != 0) {
                            result = i / j;
                        }
                        break;

                }
                res[resIndex++] = result;
            }
        }
        return res;
    }
}
