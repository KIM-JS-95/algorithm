package ThisCoTe;

import java.util.Scanner;

public class KingdomNight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Data = sc.nextLine();
        int row = Data.charAt(1) - '0';
        int col = Data.charAt(0) - 'a'+1;

        int[] dx= {-1,1,2,2,1,-1,-2,-2};
        int[] dy= {2,2,1,-1,-2,-2,-1,1};

        int cnt =0;
        for(int i=0; i< 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx >= 1 && ny<=8 && ny >= 1 && nx<=8)
                cnt++;
        }

        System.out.println(cnt);

    }
}
