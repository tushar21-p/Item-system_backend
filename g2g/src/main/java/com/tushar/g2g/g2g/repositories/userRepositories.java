package com.tushar.g2g.g2g.repositories;

import com.tushar.g2g.g2g.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepositories extends JpaRepository<User, Long> {
}
