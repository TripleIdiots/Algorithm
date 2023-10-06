package com.algorithm.jeongh00;

import java.util.Scanner;

public class back1055 {
    static final int MAX = 31;
    static String s, input;
    static int dollar, nonDollar;
    static int repeat, start, finish;
    // cache[i] = i번 반복했을 때 길이
    static long[] cache = new long[MAX]; // 2 ^ 30 = 1,073,741,824
    static boolean found;

    static void searchChar(int level, int idx) { // level = 반복 횟수
        long pos = 0;
        for (long i = 0; !found && i < input.length(); i++) {
            if (input.charAt((int) i) == '$') {
                // 반복 횟수 기준으로 나눔
                if (level == 1) {
                    if (idx <= pos + cache[level] - 1) {
                        found = true;
                        System.out.print(s.charAt(idx - (int) pos));
                    } else
                        pos += cache[level];
                } else if (level > 1) {
                    if (idx <= pos + cache[level] - 1)
                        searchChar(level - 1, idx - (int) pos);
                    else
                        pos += cache[level];
                }
            } else {
                if (pos == idx) {
                    found = true;
                    System.out.print(input.charAt((int) i));
                    return;
                } else
                    pos++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        input = sc.next();
        repeat = sc.nextInt();
        start = sc.nextInt();
        finish = sc.nextInt();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '$')
                dollar++;
            else
                nonDollar++;
        }

        // $가 하나이면 길이가 천천히 증가하여 따로 처리
        if (dollar < 2) {
            for (int i = start - 1; i < finish; i++) {
                if (i < s.length())
                    System.out.print(s.charAt(i));
                else if (i >= s.length() + (input.length() - 1) * repeat)
                    System.out.print("-");
                    // s.length() <= i < s.length() + (input.length() - 1) * repeat
                else
                    System.out.print(input.charAt((i - s.length()) % (input.length() - 1) + 1));
            }
            System.out.println();
        }
        // $가 2개부터이면 지수 비례하여 증가하므로 도중에 중단 가능
        else {
            cache[1] = s.length();
            for (int i = 2; i <= repeat; i++) {
                cache[i] = cache[i - 1] * dollar + nonDollar;
                // 구하고자 하는 인덱스 범위를 초과시 break
                if (cache[i] > finish) {
                    repeat = i;
                    break;
                }
            }

            for (int i = start - 1; i < finish; i++) {
                int temp = repeat;
                // 범위 초과시
                if (i >= cache[temp] * dollar + nonDollar) {
                    System.out.print("-");
                    continue;
                }

                while (temp > 1 && cache[temp] > i)
                    temp--;

                found = false;
                searchChar(temp, i);
            }
            System.out.println();
        }

        sc.close();
    }
}
