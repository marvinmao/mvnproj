package com.llnqdx.mvnproj.enjoy.concurrent01.ch8b.vo;


/**
 * @Auther: marvinmao
 * <p>
 * 类说明：题目在缓存中的实体
 */
public class QuestionInCacheVo {

    private final String questionDetail;
    private final String questionSha;

    public QuestionInCacheVo(String questionDetail, String questionSha) {
        super();
        this.questionDetail = questionDetail;
        this.questionSha = questionSha;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public String getQuestionSha() {
        return questionSha;
    }


}
