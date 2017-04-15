package com.agussuhardi.pemrogjar.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by agus on 15/10/16.
 */
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    private String userName;
    private String password;
    private String description;
    private boolean login;

    private String macAddressChange;
    private String localIpChange;
    //    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")//psql
    @Temporal(TemporalType.TIMESTAMP)
    private Date startLogin;
    //    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")//psql
    @Temporal(TemporalType.TIMESTAMP)
    private Date stopLogin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Date getStartLogin() {
        return startLogin;
    }

    public void setStartLogin(Date startLogin) {
        this.startLogin = startLogin;
    }

    public Date getStopLogin() {
        return stopLogin;
    }

    public void setStopLogin(Date stopLogin) {
        this.stopLogin = stopLogin;
    }

    public String getMacAddressChange() {
        return macAddressChange;
    }

    public void setMacAddressChange(String macAddressChange) {
        this.macAddressChange = macAddressChange;
    }


    public String getLocalIpChange() {
        return localIpChange;
    }

    public void setLocalIpChange(String localIpChange) {
        this.localIpChange = localIpChange;
    }
}
