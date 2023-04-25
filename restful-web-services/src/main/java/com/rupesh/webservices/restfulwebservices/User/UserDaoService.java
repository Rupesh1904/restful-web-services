package com.rupesh.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();
    private static int usersCounts=0;

    static {
        users.add(new User( ++usersCounts, "Rupesh",LocalDate.now().minusYears(30)));
        users.add(new User(++usersCounts, "Avni",LocalDate.now().minusYears(30)));
        users.add(new User( ++usersCounts, "Agrawal",LocalDate.now().minusYears(30)));
    }
    public List<User> findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> predicate= user-> user.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User save(User user){
        user.setId(++usersCounts);
        users.add(user);
        return user;
    }

}
