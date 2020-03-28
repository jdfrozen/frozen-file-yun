package com.frozen.frozenfileyun.dao;

import com.frozen.frozenfileyun.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
