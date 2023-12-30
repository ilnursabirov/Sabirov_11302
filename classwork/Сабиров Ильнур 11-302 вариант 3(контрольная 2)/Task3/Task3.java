public class Task3 {
    public static void main(String[] args) {
        int n = 4;
        String lowAlf = "abcdefghigklmnopqrstuvwxyz";
        String highAlf = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        int l = highAlf.length();

        String[] strings = {"asduy", "qweree", "intel", "nvidia"};

        int[] count = new int[26];

        for (int t = 0; t < n; t++) {
            String s = strings[t];
            int x = s.length();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < l; j++) {
                    if (s.charAt(i) == lowAlf.charAt(j) || s.charAt(i) == highAlf.charAt(j)) {
                        count[j]++;
                    }
                }
            }
        }

        
        for (int k = 0; k < l; k++) {
            System.out.printf("Буква " + lowAlf[k] + " встречается " + count[k] + " раз(а)");
        } 

    }
}