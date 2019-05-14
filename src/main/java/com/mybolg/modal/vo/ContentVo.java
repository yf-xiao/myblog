package com.mybolg.modal.vo;

/**
 * 
 * @author yfxiao
 *  文章
 */
public class ContentVo {

    /**
     * id
     */
    private Integer cid;

    /**
     * 标题
     */
    private String title;

    /**
     * url地址
     */
    private String slug;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 修改时间
     */
    private Integer modified;

    /**
     * 作者ID
     */
    private Integer authorId;

    /**
     * 文章类型
     */
    private String type;

    /**
     * 文章状态
     */
    private String status;

    /**
     * 标签
     */
    private String tags;

    /**
     * 分类
     */
    private String categories;

    /**
     * 缩略图
     */
    private String thumbimg;

    /**
     * 点击数
     */
    private Integer hits;

    /**
     * 评论数
     */
    private Integer commentsNum;

    /**
     * 
     */
    private Boolean allowComment;

    /**
     * 
     */
    private Boolean allowPing;

    /**
     * 
     */
    private Boolean allowFeed;

    /**
     * 内容
     */
    private String content;

    /**
     * id
     */
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    public String getThumbimg() {
        return thumbimg;
    }

    public void setThumbimg(String thumbimg) {
        this.thumbimg = thumbimg == null ? null : thumbimg.trim();
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Boolean getAllowPing() {
        return allowPing;
    }

    public void setAllowPing(Boolean allowPing) {
        this.allowPing = allowPing;
    }

    public Boolean getAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(Boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}