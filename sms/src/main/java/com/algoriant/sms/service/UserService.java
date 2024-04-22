package com.algoriant.sms.service;

import com.algoriant.sms.entity.UserDTO;
import com.algoriant.sms.repository.UserRepository;
import com.algoriant.sms.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUerByUserName(String userName) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(userName).get();
        if (user ==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public User save(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder obj = new BCryptPasswordEncoder();
        System.out.println(obj.encode("hello"));

    }

    public UserDTO update(UserDTO userDTO) {
        User user = findByUsername(userDTO.getUserName());
        if (user != null) {
            BeanUtils.copyProperties(userDTO, user, "password");
            userRepository.save(user);
        }
        return userDTO;
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    public User findOne(String userName) {
        return userRepository.findByUsername(userName).get();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
