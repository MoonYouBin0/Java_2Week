package java_2024_02_homework.java_2week.week2;

import java.util.Random;

public class IntArray {
    int[] numbers;
    Random rand = new Random();

    // 배열 생성
    IntArray(int size) {
        numbers = new int[size];
    }

    // 점수 무작위 생성
    void generate(int lower, int upper) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(upper - lower) + lower;
        }
    }

    // 점수 조정
    void adjust(int lower, int upper) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lower + numbers[i] * (upper - lower) / 100;
        }
    }

    // 점수 출력
    void print() {
        for (int n : numbers) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }

    // 배열에서 특정 인덱스의 점수 가져오기
    public int get(int i) {
        return numbers[i];
    }
}