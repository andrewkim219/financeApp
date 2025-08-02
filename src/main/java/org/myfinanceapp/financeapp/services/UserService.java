package org.myfinanceapp.financeapp.services;

import org.myfinanceapp.financeapp.models.User;
import org.myfinanceapp.financeapp.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserById(Long userId) {
        if (userRepo.findUserById(userId).isPresent()) {
            return userRepo.findUserById(userId).get();
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public void addUser(User user) {
        if (userRepo.findUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email taken. Use a different email.");
        }

        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        if (userRepo.findUserById(userId).isEmpty()) {
            throw new IllegalStateException("User with id " + userId + " does not exist.");
        }
        userRepo.deleteById(userId);
    }

    public void updateUser(User user) {
        if (userRepo.findUserById(user.getId()).isPresent()) {
            userRepo.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }
}
