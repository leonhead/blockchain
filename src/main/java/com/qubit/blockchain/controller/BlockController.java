package com.qubit.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qubit.blockchain.entity.Block;
import com.qubit.blockchain.service.BlockService;

@RestController
@RequestMapping("blocks")
@CrossOrigin("http://localhost:4200")
public class BlockController {

	@Autowired
	private BlockService blockService;

	@GetMapping("list")
	public List<Block> listBlocks() {
		List<Block> blocks = blockService.getBlocks();
		return blocks;
	}
}
