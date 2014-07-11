public class PrefixCode {

    public static void main(String[] args) {
        System.out.println(new PrefixCode()
                .isOne(new String[]{"6G9Lnpzw", "kA", "SyW9fFaF", "k",
                        "SyW9fFa", "6G", "6", "SyW9f"}));
    }

    public String isOne(String[] words) {

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].startsWith(words[j])) {
                    return ("No, " + j);
                } else if (words[j].startsWith(words[i])) {
                    return "No, " + i;
                }
            }
        }
        return "Yes";
    }
}
