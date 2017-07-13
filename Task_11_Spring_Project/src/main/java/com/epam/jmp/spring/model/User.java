package com.epam.jmp.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User
{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "USERINFOID")
    private long userInfoId;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User()
    {
        super();
    }

    public User(long id, String login, long userInfoId, Role role)
    {
        this.id = id;
        this.login = login;
        this.userInfoId = userInfoId;
        this.role = role;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public long getUserInfoId()
    {
        return userInfoId;
    }

    public void setUserInfoId(long userInfoId)
    {
        this.userInfoId = userInfoId;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
