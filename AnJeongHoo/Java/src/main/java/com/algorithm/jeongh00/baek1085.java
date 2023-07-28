package com.algorithm.jeongh00;

import java.util.*;

public class baek1085 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int dis_x = w - x;
        int dis_y = h - y;
        int x_min = 0;
        int y_min = 0;

        x_min = dis_x > x ? x : dis_x;
        y_min = dis_y > y ? y : dis_y;

        System.out.println(x_min > y_min ? y_min : x_min);

    }

}