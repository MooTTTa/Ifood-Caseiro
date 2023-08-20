package com.supermarket.supermarket.services;

import com.supermarket.supermarket.entities.User;
import com.supermarket.supermarket.exceptions.DataBaseException;
import com.supermarket.supermarket.exceptions.ResourceNotFoundException;
import com.supermarket.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw  new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
       entity.setName(obj.getName());
       entity.setEmail(obj.getEmail());
       entity.setPhone(obj.getPhone());
    }
}
