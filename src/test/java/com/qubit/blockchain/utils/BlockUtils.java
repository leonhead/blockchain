package com.qubit.blockchain.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.internal.bytebuddy.utility.RandomString;

import com.qubit.blockchain.entity.Block;

public class BlockUtils {

	public static List<Block> createBlocks(int numberOfBlocks) {
		List<Block> blocks = new ArrayList<Block>();
		for (int i = 0; i < numberOfBlocks; i++) {
			Block block = new Block(RandomString.make());
			block.setId(Long.valueOf(i));

			blocks.add(block);
		}
		return blocks;
	}

}
