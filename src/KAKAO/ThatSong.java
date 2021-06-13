package KAKAO;

public class ThatSong {
    public static void main(String[] args) {

        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        System.out.println(solution(m, musicinfos));

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = change(m);
        int temp = 0;

        for (String s : musicinfos) {

            s = change(s);

            String[] Arr1 = s.split(","); // {03:00, 03:30, FOO, CC#B}
            String[] Arr2 = Arr1[0].split(":"); // {03, 03}
            String[] Arr3 = Arr1[1].split(":"); // {00, 30}

            int playH = Integer.parseInt(Arr3[0]) - Integer.parseInt(Arr2[0]);
            int totalplayM = (Integer.parseInt(Arr3[1]) - Integer.parseInt(Arr2[1])) + (playH * 60);

            String music = makeMusic(Arr1[3], totalplayM); // Arr1[3]= CC#B

            if (music.contains(m)) {
                if (temp < totalplayM) {
                    temp = totalplayM;
                    answer = Arr1[2];
                }
            }
        }

        return answer;
    }

    private static String makeMusic(String s, int totalplayM) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalplayM; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    private static String change(String m) {
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");

        return m;
    }
}
