package com.qubit.blockchain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.blockchain.entity.Block;

public interface BlockRepository extends JpaRepository<Block, String> {

}
