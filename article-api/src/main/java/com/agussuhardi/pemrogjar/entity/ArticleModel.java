package com.agussuhardi.pemrogjar.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by agussuhardi on 26/11/16.
 */
@Entity
@Table(name = "article")
public class ArticleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    @Type(type = "text") private String article;
    private String status;
    private boolean active;
    private boolean onEdit;
    private String userNameChange;
    private String localIpChange;
    private String publicIpChange;
    private String operatingSystemChange;
    private String informationChange;
    private String hostNameChange;
    private String browserChange;

//    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")//psql
    @Temporal(TemporalType.TIMESTAMP)  private Date createDate;
//    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")//psql
    @Temporal(TemporalType.TIMESTAMP)  private Date updateDate;

    @ManyToOne @JoinColumn(nullable = false, name = "user_name")  private UserModel userName;

    @ManyToMany
    @JoinTable(
            name = "list_access",
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "user_name")
    )
    private List<UserModel> userAccessList = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "article"
    )
    private List<HistoryModel> history = new ArrayList<>();

    public List<UserModel> getUserAccessList() {
        return userAccessList;
    }

    public void setUserAccessList(List<UserModel> userAccessList) {
        this.userAccessList = userAccessList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOnEdit() {
        return onEdit;
    }

    public void setOnEdit(boolean onEdit) {
        this.onEdit = onEdit;
    }

    public String getUserNameChange() {
        return userNameChange;
    }

    public void setUserNameChange(String userNameChange) {
        this.userNameChange = userNameChange;
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

    public String getInformationChange() {
        return informationChange;
    }

    public void setInformationChange(String informationChange) {
        this.informationChange = informationChange;
    }

    public String getHostNameChange() {
        return hostNameChange;
    }

    public void setHostNameChange(String hostNameChange) {
        this.hostNameChange = hostNameChange;
    }

    public String getBrowserChange() {
        return browserChange;
    }

    public void setBrowserChange(String browserChange) {
        this.browserChange = browserChange;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public UserModel getUserName() {
        return userName;
    }

    public void setUserName(UserModel userName) {
        this.userName = userName;
    }
}