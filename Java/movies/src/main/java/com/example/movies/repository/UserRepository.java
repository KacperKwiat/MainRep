package com.example.movies.repository;


import com.example.movies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return  jdbcTemplate.query("select * from user",BeanPropertyRowMapper.newInstance(User.class) );
    }

    public User getById(Long id){
        return jdbcTemplate.queryForObject("select id, name, surname, email from user where id= ? ",
                BeanPropertyRowMapper.newInstance(User.class),
                id);
    }

    public int save(User user) {
        jdbcTemplate.update("insert into user(name, surname, email) values (?,?,?)",
                user.getName(),
                user.getSurname(),
                user.getEmail()
        );

        return 1;
    }

    public int update(Long id, User user){
        return jdbcTemplate.update("update user set name=?, surname=?, email=? where id=?",
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                id);

    }

    public int delete(Long id){
        return jdbcTemplate.update("delete from user where id=?", id);
    }
}
