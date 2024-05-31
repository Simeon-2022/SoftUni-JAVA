package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backUrls = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();
        String currentUrl = scanner.nextLine();

        while (!"Home".equalsIgnoreCase(currentUrl)) {


            if ("back".equalsIgnoreCase(currentUrl)) {

                if (backUrls.size() <= 1) {

                    System.out.println("no previous URLs");
                } else {
                    forwardUrls.offerFirst(backUrls.pop());
                    System.out.println(backUrls.peek());
                }
            } else if ("forward".equalsIgnoreCase(currentUrl.trim())) {
                if (forwardUrls.isEmpty()) {

                    System.out.println("no next URLs");
                } else {
                    //backUrls.pollLast();
                    backUrls.push(forwardUrls.peek());
                    System.out.println(forwardUrls.pollFirst());
                }

            } else {
                backUrls.push(currentUrl);
                forwardUrls.clear();
                System.out.println(backUrls.peek());
            }

            currentUrl = scanner.nextLine();
        }
    }
}
