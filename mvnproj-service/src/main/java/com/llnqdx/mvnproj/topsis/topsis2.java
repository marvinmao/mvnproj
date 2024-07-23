package com.llnqdx.mvnproj.topsis;

public class topsis2 {
    public static void main(String[] args) {
        double[][] matrix = {
                {1, 2, 3},
                {2, 2, 1},
                {1, 1, 3},
                {3, 1, 2}
        };

        performTOPSIS(matrix);
    }

    public static void performTOPSIS(double[][] matrix) {
        int m = matrix[0].length; // 特征数量
        int n = matrix.length; // 评价对象数量

        // 计算最小值和最大值
        double[] min = new double[m];
        double[] max = new double[m];
        for (int j = 0; j < m; j++) {
            min[j] = max[j] = matrix[0][j];
            for (int i = 1; i < n; i++) {
                if (matrix[i][j] < min[j]) min[j] = matrix[i][j];
                if (matrix[i][j] > max[j]) max[j] = matrix[i][j];
            }
        }

        // 计算范数（正向与反向）
        double[] positiveDistance = new double[n];
        double[] negativeDistance = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                positiveDistance[i] += Math.pow(matrix[i][j] - max[j], 2);
                negativeDistance[i] += Math.pow(matrix[i][j] - min[j], 2);
            }
            positiveDistance[i] = Math.sqrt(positiveDistance[i]);
            negativeDistance[i] = Math.sqrt(negativeDistance[i]);
        }

        // 计算均方差和
        double sumPositive = 0;
        double sumNegative = 0;
        for (int i = 0; i < n; i++) {
            sumPositive += positiveDistance[i];
            sumNegative += negativeDistance[i];
        }
        double meanPositive = sumPositive / n;
        double meanNegative = sumNegative / n;

        // 计算优劣度
        double[] benefit = new double[n];
        double[] cost = new double[n];
        for (int i = 0; i < n; i++) {
            benefit[i] = meanNegative / negativeDistance[i];
            cost[i] = meanPositive / positiveDistance[i];
        }

        // 评价
        double[] performance = new double[n];
        for (int i = 0; i < n; i++) {
            performance[i] = benefit[i] / (benefit[i] + cost[i]);
        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            System.out.println("第" + (i + 1) + "个对象的评价为: " + performance[i]);
        }
    }
}