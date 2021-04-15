package TitleCaseDemo;

public class TitleCaseDemo {
    public static void main(String[] args) {
        String s = "four scores and seven years ago";
        System.out.println(titleCase(s));
        System.out.println(titleCase2(s));
        s = "birth of a new nation";
        System.out.println(titleCase(s));
        System.out.println(titleCase2(s));
    }

    public static String titleCase(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            sb.append(Character.toUpperCase(words[i].charAt(0)))
                .append(words[i].substring(1))
                .append(" ");
        }
        return sb.toString().trim();
    }

    public static String titleCase2(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            sb.append(words[i].substring(0, words[i].length()-1))
                .append(Character.toUpperCase(words[i].charAt(words[i].length()-1)))
                .append(" ");
        }
        return sb.toString().trim();
    }
}
