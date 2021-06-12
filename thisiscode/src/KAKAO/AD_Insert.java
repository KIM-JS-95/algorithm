package KAKAO;

public class AD_Insert {

    public static void main(String[] args) {

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int PT = convert(play_time);
        int AT = convert(adv_time);

        int[] LT = new int[100 * 3600];

        for (String log : logs) {
            int start = convert(log.substring(0, 8));
            int end = convert(log.substring(9, 17));

            for (int i = start; i < end; i++) {
                LT[i] += 1;
            }
        }

            long currenttime = 0;
            for (int i = 0; i < AT; i++) {
                currenttime += LT[i];
            }

            long maxsum = currenttime;
            int maxidx = 0;
            for (int i = AT; i < PT; i++) {
                currenttime = currenttime + LT[i] - LT[i - AT];

                if (currenttime > maxsum) {
                    maxsum = currenttime;
                    maxidx = i - AT + 1;
                }
            }

            return String.format("%02d:%02d:%02d", maxidx / 3600, maxidx / 60 % 60, maxidx % 60);
        }


    public static int convert(String time){
        String[] nums = time.split(":");
        return Integer.parseInt(nums[0]) * 60 * 60 +
                Integer.parseInt(nums[1]) * 60 +
                Integer.parseInt(nums[2]);
    }

}

