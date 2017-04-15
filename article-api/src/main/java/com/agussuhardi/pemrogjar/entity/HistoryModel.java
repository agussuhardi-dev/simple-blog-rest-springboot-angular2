package com.agussuhardi.pemrogjar.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by agussuhardi on 26/11/16.
 */
@Entity
@Table(name = "history")
public class HistoryModel{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String oldTitle;
    private String newTitle;
    @Type(type = "text")   private String oldArticle;
    @Type(type = "text")   private String newArticle;


    private String browserChange;
    private String hostNameChange;
    private String informationChange;
    private String localIpChange;
    private String publicIpChange;
    private String operatingSystemChange;
    private String userNameChange;

//    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")//psql
    @Temporal(TemporalType.TIMESTAMP) private Date updateDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ArticleModel article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getOldArticle() {
        return oldArticle;
    }

    public void setOldArticle(String oldArticle) {
        this.oldArticle = oldArticle;
    }

    public String getNewArticle() {
        return newArticle;
    }

    public void setNewArticle(String newArticle) {
        this.newArticle = newArticle;
    }

    public String getBrowserChange() {
        return browserChange;
    }

    public void setBrowserChange(String browserChange) {
        this.browserChange = browserChange;
    }

    public String getHostNameChange() {
        return hostNameChange;
    }

    public void setHostNameChange(String hostNameChange) {
        this.hostNameChange = hostNameChange;
    }

    public String getInformationChange() {
        return informationChange;
    }

    public void setInformationChange(String informationChange) {
        this.informationChange = informationChange;
    }

    public String getLocalIpChange() {
        return localIpChange;
    }

    public void setLocalIpChange(String localIpChange) {
        this.localIpChange = localIpChange;
    }

    public String getPublicIpChange() {
        return publicIpChange;
    }

    public void setPublicIpChange(String publicIpChange) {
        this.publicIpChange = publicIpChange;
    }

    public String getOperatingSystemChange() {
        return operatingSystemChange;
    }

    public void setOperatingSystemChange(String operatingSystemChange) {
        this.operatingSystemChange = operatingSystemChange;
    }

    public String getUserNameChange() {
        return userNameChange;
    }

    public void setUserNameChange(String userNameChange) {
        this.userNameChange = userNameChange;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }
}


