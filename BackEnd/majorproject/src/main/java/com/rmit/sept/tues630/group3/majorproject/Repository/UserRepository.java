package com.rmit.sept.tues630.group3.majorproject.Repository;


import com.rmit.sept.tues630.group3.majorproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
        User findByUsername(String username);

}