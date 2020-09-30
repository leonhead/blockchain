package com.qubit.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qubit.blockchain.entity.Block;
import com.qubit.blockchain.service.BlockService;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:4200")
public class BlockController {

	@Autowired
	private BlockService blockService;

	@GetMapping("blocks")
	public List<Block> listBlocks() {
		List<Block> blocks = blockService.getBlocks();
		return blocks;
	}
	
	@GetMapping("blocks/{hash}")
	public Block getBlock(@PathVariable String hash) {
		Block block = blockService.getBlockByHash(hash);
		return block;
	}
}
