package BACKJOON;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class B1018 {
    static char[][] arr;
    static char[][] tempBoard = new char[8][8];

    static char[][] whiteStartBoard = {  // W로 시작하는 체스판
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static char[][] blackStartBoard = { // B으로 시작하는 체스판
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        arr = new char[x][y];

        for( int i = 0 ; i < x ; i++ ) { // 행 단위로 입력
            String xline = sc.next();
            for( int j = 0 ; j < y ; j++ ) {
                arr[i][j] = xline.charAt(j);
            }
        }

        int min = 64; // 8 x 8 체스판 모든 칸의 개수
        for( int  i = 0 ; i <= (x-8) ; i++ ) {
            for(int  j = 0 ; j <= (y-8) ; j++ ) {
                min = count(i,j,min);
            }

        }
        System.out.println(min);

    }

    static int count(int startX, int startY , int min) {
        int countB =0;
        int countW =0;
        int x=0;
        StringBuilder builder = new StringBuilder("");

        //8x8 임시 체스판 생성
        for(int i = startX ; i < (startX+8) ; i++) {
            builder.setLength(0);

            for(int j= startY ; j< (startY+8) ; j++) {
                builder.append(arr[i][j]);
            }

            for(int j=0 ; j<builder.length() ; j++) {
                tempBoard[x][j] = builder.charAt(j);
            }
            x++; // 체스판 행 증가,

        }

        //비교
        for(int i=0 ; i < tempBoard.length ; i++) {
            for(int j=0 ; j < tempBoard[i].length ; j++) {
                if( tempBoard[i][j] != blackStartBoard[i][j]) { // black의 규칙으로 변환되는 횟수
                    countB++;
                }
                if(tempBoard[i][j] != whiteStartBoard[i][j] ) { // white의 규칙으로 변환되는 횟수
                    countW++;
                }
            }

        }
        return Math.min(Math.min(countB, countW), min);
    }
}
