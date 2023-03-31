package com.sol.algorithm.solution;

/**
 * 2024. 考试的最大困扰度
 */
public class N2024 {

    public static void main(String[] args) {
        String answerKey;
        int k;

        // 4
        answerKey = "TTFF";
        k = 2;
        System.out.println(new N2024().maxConsecutiveAnswers(answerKey, k));

        // 3
        answerKey = "TFFT";
        k = 1;
        System.out.println(new N2024().maxConsecutiveAnswers(answerKey, k));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] keys = answerKey.toCharArray();

        int f = 1, t = 1, fk, tk;
        if (keys[0] == 'F') {
            fk = k;
            tk = k - 1;
        } else {
            fk = k - 1;
            tk = k;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (keys[i] == 'F') {
                f++;
                if (tk > 0) {
                    t++;
                    tk--;
                } else {
                    if (t > max) max = t;
                    t = 1;
                    tk = k - 1;
                }
            } else {
                t++;
                if (fk > 0) {
                    f++;
                    fk--;
                } else {
                    if (f > max) max = f;
                    f = 1;
                    fk = k - 1;
                }
            }
        }
        return Math.max(Math.max(f, t), max);
    }
}
