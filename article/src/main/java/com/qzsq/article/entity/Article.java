package com.qzsq.article.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 14:41
 * 4  文章的实体类
 */
public class Article implements Serializable {


    //文章id
    private int articleId;
    //文章封面
    private String articleCoverImg;
    //文章标题
    private String articleTitle;
    //内容
    private String articleContent;
    //文章状态码
    private String articleStatusCode;
    //发表时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime articlePublishTime;
    //是否置顶
    private String articleIsTop;
    //标签
    private String articleTag;
    //作者
    private String articleAuthor;
    //是否热门
    private String articleIsPopular;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String articleCreateTime;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId( int articleId ) {
        this.articleId = articleId;
    }

    public String getArticleCoverImg() {
        return articleCoverImg;
    }

    public void setArticleCoverImg( String articleCoverImg ) {
        this.articleCoverImg = articleCoverImg;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle( String articleTitle ) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent( String articleContent ) {
        this.articleContent = articleContent;
    }

    public String getArticleStatusCode() {
        return articleStatusCode;
    }

    public void setArticleStatusCode( String articleStatusCode ) {
        this.articleStatusCode = articleStatusCode;
    }


    public String getArticleIsTop() {
        return articleIsTop;
    }

    public void setArticleIsTop( String articleIsTop ) {
        this.articleIsTop = articleIsTop;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag( String articleTag ) {
        this.articleTag = articleTag;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor( String articleAuthor ) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleIsPopular() {
        return articleIsPopular;
    }

    public void setArticleIsPopular( String articleIsPopular ) {
        this.articleIsPopular = articleIsPopular;
    }

    public LocalDateTime getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime( LocalDateTime articlePublishTime ) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime( String articleCreateTime ) {
        this.articleCreateTime = articleCreateTime;
    }

    public Article( int articleId, String articleCoverImg, String articleTitle, String articleContent, String articleStatusCode, LocalDateTime articlePublishTime, String articleIsTop, String articleTag, String articleAuthor, String articleIsPopular, String articleCreateTime ) {
        this.articleId = articleId;
        this.articleCoverImg = articleCoverImg;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleStatusCode = articleStatusCode;
        this.articlePublishTime = articlePublishTime;
        this.articleIsTop = articleIsTop;
        this.articleTag = articleTag;
        this.articleAuthor = articleAuthor;
        this.articleIsPopular = articleIsPopular;
        this.articleCreateTime = articleCreateTime;
    }

    public Article() {
    }

}
