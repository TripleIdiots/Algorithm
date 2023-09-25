package com.algorithm.jeongh00;

import java.util.*;

public class back1181 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.readLine();
        String[] arr = new String[N];
        N.nextLine();

        for (int i=0; i<N; i++) {

            arr[i] = N.nextLine();
        }

        Arrays.sort(
                arr, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {

                        if (s1.length == s2.length) {

                            return s1.compareTo(s2);
                        } else {

                            return s1.length() - s2.length();
                        }
                    }
                }
        );

        System.out.println(arr[0]);

        for (int i=1; i<N; i++) {

            if (arr[i].equals(arr[i-1])) continue;
            System.out.println(arr[i]);
        }

    }

}