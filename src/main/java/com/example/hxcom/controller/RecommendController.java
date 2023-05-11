package com.example.hxcom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {
    @GetMapping("/recommend")

    public String getRecommend(){
        return "推荐成功";
    }

    public class ItemBasedCF {
        // 用户-物品评分矩阵
        private static int[][] matrix = {
                {3, 4, 0, 3},
                {4, 3, 4, 0},
                {0, 4, 5, 3},
                {5, 0, 3, 4},
                {3, 4, 0, 5}
        };

        // 用户收藏列表
        private static int[][] collectList = {
                {1, 3},
                {0, 2},
                {1, 2},
                {0},
                {1, 3}
        };

        // 相似度矩阵
        private static double[][] similarityMatrix;

        // 推荐列表长度
        private static final int RECOMMEND_LIST_LENGTH = 2;

        public static void main(String[] args) {
            // 计算相似度矩阵
            similarityMatrix = calculateSimilarityMatrix(matrix);

            // 为用户1推荐帖子
            int[] recommendList = recommend(matrix, similarityMatrix, collectList, 0);

            // 输出推荐列表
            System.out.println("为用户1推荐的帖子是：");
            for (int i = 0; i < recommendList.length; i++) {
                System.out.println("帖子" + recommendList[i]);
            }
        }

        /**
         * 计算相似度矩阵
         *
         * @param matrix 用户-物品评分矩阵
         * @return 相似度矩阵
         */
        private static double[][] calculateSimilarityMatrix(int[][] matrix) {
            int userCount = matrix.length;
            int itemCount = matrix[0].length;
            double[][] similarityMatrix = new double[itemCount][itemCount];

            for (int i = 0; i < itemCount; i++) {
                for (int j = i + 1; j < itemCount; j++) {
                    double similarity = 0;
                    for (int k = 0; k < userCount; k++) {
                        similarity += matrix[k][i] * matrix[k][j];
                    }
                    similarityMatrix[i][j] = similarity;
                    similarityMatrix[j][i] = similarity;
                }
            }

            return similarityMatrix;
        }

        /**
         * 为用户推荐帖子
         *
         * @param matrix           用户-物品评分矩阵
         * @param similarityMatrix 相似度矩阵
         * @param collectList      用户收藏列表
         * @param userId           用户编号
         * @return 推荐列表
         */
        private static int[] recommend(int[][] matrix, double[][] similarityMatrix, int[][] collectList, int userId) {
            int itemCount = matrix[0].length;
            double[] scores = new double[itemCount];
            int[] recommendList = new int[RECOMMEND_LIST_LENGTH];

            // 计算每个帖子的得分
            for (int i = 0; i < itemCount; i++) {
                if (matrix[userId][i] == 0) {
                    double score = 0;
                    for (int j = 0; j < itemCount; j++) {
                        if (matrix[userId][j] != 0 && similarityMatrix[i][j] != 0) {
                            score += matrix[userId][j] * similarityMatrix[i][j];
                        }
                    }
                    scores[i] = score;
                }
            }

            // 对收藏列表中的帖子加权
            for (int i = 0; i < collectList[userId].length; i++) {
                int itemId = collectList[userId][i];
                for (int j = 0; j < itemCount; j++) {
                    scores[j] += matrix[userId][itemId] * similarityMatrix[j][itemId];
                }
            }

            // 获取得分最高的帖子编号
            for (int i = 0; i < RECOMMEND_LIST_LENGTH; i++) {
                int maxIndex = 0;
                for (int j = 0; j < itemCount; j++) {
                    if (scores[j] > scores[maxIndex]) {
                        maxIndex = j;
                    }
                }
                recommendList[i] = maxIndex;
                scores[maxIndex] = 0;
            }

            return recommendList;
        }
    }
}
