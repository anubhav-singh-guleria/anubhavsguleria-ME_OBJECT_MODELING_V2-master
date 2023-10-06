package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.jukebox.entities.User;



public class UserRepository implements IUserRepository{
    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    

    public UserRepository(Map<String, User> userMap, Integer autoIncrement) {
        this.userMap = userMap;
        this.autoIncrement = autoIncrement;
    }

    public UserRepository(){
        this.userMap = new HashMap<String,User>();
    }
    @Override
    public User save(User entity) {
        // TODO Auto-generated method stub
        if( entity.getId() == null ){
            autoIncrement++;
            User q = new User(Integer.toString(autoIncrement),entity.getName(),entity.getPlaylists());
            userMap.put(q.getId(),q);
            return q;
        }
        userMap.put(entity.getId(),entity);
        return entity;
        // return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        List<User> allUsers = userMap.entrySet().stream()
                                      .map(Map.Entry::getValue).collect(Collectors.toList());
        return allUsers;
    }

    @Override
    public Optional<User> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return userMap.containsKey(id);
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        userMap.remove(id);
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
