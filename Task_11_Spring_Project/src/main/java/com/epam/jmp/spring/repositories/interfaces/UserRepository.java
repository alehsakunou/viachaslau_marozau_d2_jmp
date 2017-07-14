package com.epam.jmp.spring.repositories.interfaces;

import com.epam.jmp.spring.model.Role;
import com.epam.jmp.spring.model.User;
import com.epam.jmp.spring.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface UserRepository extends CrudRepository<User, Long>
{
    @Query("INSERT INTO users (login, password, role, userInfoId) VALUES (?, ?, ?, ?)")
    User addUser(String login, String password, Role role, long userInfoId);

    @Query("INSERT INTO users (name, surname, email, phone, birthdate) VALUES (?, ?, ?, ?, ?)")
    UserInfo addUserInfo (String name, String surname, String email, String phone, Timestamp birthdate);

    @Query("from User u where p.login = ? and p.password = ? ")
    User getUser (String login, String password);

    @Query("from UserInfo ui where ui.id = user.userInfoId ")
    UserInfo getUserInfo(User user);

    @Query("DELETE FROM users WHERE login = ? AND password = ?")
    void removeUser (String login, String password);
}
