package com.example.movies.service;

import com.example.movies.dto.UserDto;
import com.example.movies.model.User;

import com.example.movies.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Cacheable("Users")
    public List<UserDto> findAll(){
        log.info("UserService: findAll");
        List<User> users = userRepository.getAll();
        List<UserDto> usersDtos = new ArrayList<>();
        for (User user:users){
            UserDto userDtos = new UserDto();
            copyProperties(user, userDtos);
            usersDtos.add(userDtos);
        }
        return usersDtos;
    }

    @Cacheable("User")
    public UserDto findById(Long id){
        log.info("UserService: findById");
        User User = userRepository.getById(id);
        UserDto userDto = new UserDto();
        copyProperties(User,userDto);
        return userDto;
    }

    @Caching(evict = {
            @CacheEvict(value="User", allEntries=true),
            @CacheEvict(value="Users", allEntries=true)})
    public int saveOrUpdate(UserDto userDto){
        log.info("UserService: saveOrUpdate, {}", userDto.getName());
        User user=User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .build();

        if(userDto.getId()!=null){
            user.setId(user.getId());
        }
        return userRepository.save(user);
    }
}
