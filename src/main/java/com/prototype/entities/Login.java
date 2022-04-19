package com.prototype.entities;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Audited
@Table(name = "tab_logins")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Login extends AbstractMasterData {

    @Column(length = 255, nullable = true)
    private String password;

    @Column(name = "login_name", length = 255, nullable = false)
    private String loginName;

    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", nullable = true)
    private Date lastLogin;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
