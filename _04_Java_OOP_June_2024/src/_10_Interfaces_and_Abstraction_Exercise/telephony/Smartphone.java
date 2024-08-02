package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {


    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    private Boolean numberValidator(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

/*    private Boolean urlValidator(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }*/

    @Override
    public String browse() {


        String action = "Browsing: ";

        StringBuilder output = new StringBuilder();

        for (String url : urls) {

         //   if (urlValidator(url)) {

            if (!url.matches("\\b[\\D]+\\b")) {
                output.append("Invalid URL!").append(System.lineSeparator());

            } else {
                output.append(action).append(url).append("!").append(System.lineSeparator());
            }
        }

        return output.toString();
    }


    @Override
    public String call() {

        String action = "Calling... ";

        StringBuilder output = new StringBuilder();

        for (String number : numbers) {

           // if (numberValidator(number)) {
                if (!number.matches("\\b[0-9]+\\b")) {//"\\b(\\d+)\\b")) {

                    output.append("Invalid number!").append(System.lineSeparator());

                } else {
                    output.append(action).append(number).append(System.lineSeparator());
            }
        }

        return output.toString();
    }


}
