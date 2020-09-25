package com.qubit.blockchain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qubit.blockchain.dao.BlockRepository;
import com.qubit.blockchain.entity.Block;

@Service
public class BlockServiceImpl implements BlockService {

	 @Autowired
	 private BlockRepository blockRepository;

	@Override
	public List<Block> getBlocks() {
		List<Block> blocks = blockRepository.findAll();
		return blocks;
	}

}
