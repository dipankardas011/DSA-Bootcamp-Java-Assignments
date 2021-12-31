package Easy;

public class Q15 {
    public boolean isLongPressedName(String name, String typed) {

        int idxName = 0;
        for (int j = 0; j < typed.length(); j++) {
            if (idxName < name.length() && name.charAt(idxName) == typed.charAt(j))
                idxName++;

            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        }
        return idxName == name.length();
    }

    public static void main(String[] args) {
        String name = "saeed", typed = "ssaaedd";
        System.out.println(new Q15().isLongPressedName(name, typed));

        name = "alex";
        typed = "aaaalllex";
        System.out.println(new Q15().isLongPressedName(name, typed));

        name = "leelee";
        typed = "lleeelee";
        System.out.println(new Q15().isLongPressedName(name, typed));

    }
}
