package com.ProjetMaBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetMaBanque.entity.Users;



public interface UsersRepository extends JpaRepository<Users, Long> {

}
