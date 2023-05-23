package com.example.hxcom.controller;

import com.example.hxcom.entity.Event;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class Recommend {
    public String getRecommend(){
        return "推荐成功";
    }{
        File file = new File("D:\\test\\test.dat");
        // 实例化DataModel并将数据传入其内
        DataModel dataModel = null;
        try {
            dataModel = new FileDataModel(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 计算相似度
        ItemSimilarity itemSimilarity = null;
        try {
            itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        // 构建推荐器，使用基于物品的协同过滤推荐
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);

        List<RecommendedItem> recommendedItemList = null;
        try {
            // 计算用户2当前浏览的商品2，推荐2个相似的商品
            recommendedItemList = recommender.recommendedBecause(2, 2, 2);
        } catch (TasteException e) {
            e.printStackTrace();
        }

        System.out.println("使用基于物品的协同过滤算法");
        System.out.println("根据用户2当前浏览的商品2，推荐2个相似的商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
        long start = System.currentTimeMillis();
        try {
            recommendedItemList = recommender.recommendedBecause(5, 1, 3);
        } catch (TasteException e) {
            e.printStackTrace();
        }

        System.out.println("使用基于物品的协同过滤算法");
        System.out.println("根据用户5当前浏览的商品1，推荐3个相似的商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
        System.out.println(System.currentTimeMillis() -start);
    }

}
