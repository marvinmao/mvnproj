package com.llnqdx.mvnproj.topsis;

import java.util.Arrays;

public class TOPSIS3 {

    /**
     * 计算加权标准化决策矩阵
     *
     * @param decisionMatrix 标准化后的决策矩阵
     * @param weights        各属性的权重
     * @return 加权标准化决策矩阵
     */
    public static double[][] calculateWeightedDecisionMatrix(double[][] decisionMatrix, double[] weights) {
        int m = decisionMatrix.length; // 备选方案数量
        int n = decisionMatrix[0].length; // 属性数量
        double[][] weightedMatrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                weightedMatrix[i][j] = decisionMatrix[i][j] * weights[j];
            }
        }

        return weightedMatrix;
    }

    /**
     * 计算理想解和负理想解
     *
     * @param weightedMatrix 加权标准化决策矩阵
     * @return 包含理想解和负理想解的数组
     */
    public static double[][] calculateIdealSolutions(double[][] weightedMatrix) {
        int n = weightedMatrix[0].length;
        double[] idealSolution = new double[n];
        double[] negativeIdealSolution = new double[n];

        Arrays.fill(idealSolution, Double.NEGATIVE_INFINITY);
        Arrays.fill(negativeIdealSolution, Double.POSITIVE_INFINITY);

        for (double[] row : weightedMatrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] > idealSolution[j]) {
                    idealSolution[j] = row[j];
                }
                if (row[j] < negativeIdealSolution[j]) {
                    negativeIdealSolution[j] = row[j];
                }
            }
        }

        return new double[][]{idealSolution, negativeIdealSolution};
    }

    /**
     * 计算每个方案与理想解和负理想解的欧氏距离
     *
     * @param weightedMatrix 加权标准化决策矩阵
     * @param idealSolutions 包含理想解和负理想解的数组
     * @return 每个方案与理想解和负理想解的欧氏距离
     */
    public static double[][] calculateDistances(double[][] weightedMatrix, double[][] idealSolutions) {
        int m = weightedMatrix.length;
        double[][] distances = new double[m][2];

        double[] idealSolution = idealSolutions[0];
        double[] negativeIdealSolution = idealSolutions[1];

        for (int i = 0; i < m; i++) {
            double distToIdeal = 0;
            double distToNegativeIdeal = 0;

            for (int j = 0; j < idealSolution.length; j++) {
                distToIdeal += Math.pow(weightedMatrix[i][j] - idealSolution[j], 2);
                distToNegativeIdeal += Math.pow(weightedMatrix[i][j] - negativeIdealSolution[j], 2);
            }

            distToIdeal = Math.sqrt(distToIdeal);
            distToNegativeIdeal = Math.sqrt(distToNegativeIdeal);

            distances[i][0] = distToIdeal;
            distances[i][1] = distToNegativeIdeal;
        }

        return distances;
    }

    /**
     * 计算每个方案的相对接近度
     *
     * @param distances 每个方案与理想解和负理想解的欧氏距离
     * @return 每个方案的相对接近度
     */
    public static double[] calculateCloseness(double[][] distances) {
        int m = distances.length;
        double[] closeness = new double[m];

        for (int i = 0; i < m; i++) {
            closeness[i] = distances[i][1] / (distances[i][0] + distances[i][1]);
        }

        return closeness;
    }
}