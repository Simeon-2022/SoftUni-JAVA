package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();
        String currentUrl = scanner.nextLine();

        while (!"Home".equalsIgnoreCase(currentUrl)) {


            if ("back".equalsIgnoreCase(currentUrl)) {

                if (urls.size() <= 1) {

                    System.out.println("no previous URLs");
                } else {
                    urls.pop();
                    System.out.println(urls.peek());
                }
            } else {
                urls.push(currentUrl);
                System.out.println(urls.peek());
            }

            currentUrl = scanner.nextLine();
        }
    }
}
