package com.algorithm.jeongh00;

import java.util.Scanner;

public class back1004 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        in.nextLine();

        for(int i = 0; i < T; i++) {

            String point = in.nextLine();

            String police = "나 경찰";



            ~~ test = police.split("")

                    test.arrest()

            Point { x, y }

            int x1 = Integer.parseInt(point.split(" ")[0]);
            int x2 = Integer.parseInt(point.split(" ")[1]);
            int y1 = Integer.parseInt(point.split(" ")[2]);
            int y2 = Integer.parseInt(point.split(" ")[3]);

            int answerCount = 0;

            int count = in.nextInt();
            in.nextLine();

            for (int j = 0; j < count; j++) {

                String circle = in.nextLine();

                boolean startPoint = false;
                boolean endPoint = false;

                int x = Integer.parseInt(circle.split(" ")[0]);
                int y = Integer.parseInt(circle.split(" ")[1]);
                int r = Integer.parseInt(circle.split(" ")[2]);

                boolean hasStartContain = checkContainYn(x1, y1, x, y, r);
                boolean hasEndContain = checkContainYn(x2, y2, x, y, r);

                if(hasStartContain) {
                    startPoint=true;
                    answerCount++;
                }
                if(hasEndContain) {
                    endPoint=true;
                    answerCount++;
                }

                if(startPoint==true && endPoint==true)
                    answerCount-=2;

            }

            System.out.println(answerCount);
        }

    }

    public static boolean checkContainYn(int xo, int yo, int x, int y, int r) {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) <= r;
    }

}