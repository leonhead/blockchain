package com.qubit.blockchain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.qubit.blockchain.dao.BlockRepository;
import com.qubit.blockchain.entity.Block;

@RunWith(MockitoJUnitRunner.class)
public class BlockServiceTest {

	@InjectMocks
	private BlockServiceImpl blockService;

	@Mock
	private BlockRepository blockRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_list_blocks() {
		List<Block> blocks = createBlocks();
		Mockito.when(blockRepository.findAll()).thenReturn(blocks);

		assertEquals(blocks, blockService.getBlocks());
	}

	private List<Block> createBlocks() {
		Block block1 = new Block("h45h");
		Block block2 = new Block("h4xx");
		List<Block> blocks = Stream.of(block1, block2).collect(Collectors.toList());
		return blocks;
	}

}
