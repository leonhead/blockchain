package com.qubit.blockchain.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qubit.blockchain.entity.Block;

@DataJpaTest
public class BlockRepositoryTest {

	@Autowired
	private BlockRepository blockRepository;

	@Test
	public void test_findall() {
		pesist();
		List<Block> blocks = blockRepository.findAll();
		assertEquals(2, blocks.size());

	}

	private void pesist() {
		Block block1 = new Block("h45h");
		block1.setId(1l);
		Block block2 = new Block("h4xx");
		block2.setId(2l);
		
		blockRepository.save(block1);
		blockRepository.save(block2);
	}

}
