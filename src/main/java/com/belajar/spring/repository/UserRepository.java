package com.belajar.spring.repository;

import com.belajar.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from tb_users limit :limit offset :offset", nativeQuery = true)
    public List<User> gPaginateUser(int limit, int offset);

}
