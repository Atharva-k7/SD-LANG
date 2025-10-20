package collection;

public class challenges {
    public static void main(String[] args) {
        System.out.println(addingoneshot("hitesh","atharva","rushi"));
        System.out.println(addingoneshot("hithofoqnvdoa"));
    }

    public static String addingoneshot(String... args) {

        StringBuilder sbnew = new StringBuilder();
        for (String actual_string : args) {
            sbnew.append(actual_string).append(" ");
        }return sbnew.toString();
    }
}
