package com.qubit.blockchain.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.qubit.blockchain.entity.Block;
import com.qubit.blockchain.service.BlockService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BlockController.class)
public class BlockControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlockService blockService;

	@Test
	public void test_get_blocks() throws Exception {
		List<Block> blocks = createBlocks();
		Mockito.when(blockService.getBlocks()).thenReturn(blocks);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/blocks/list").accept(MediaType.APPLICATION_JSON);

		String expected = "[{\"id\":1,\"hash\":\"h45h\"},{\"id\":2,\"hash\":\"h4xx\"}]";
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(expected, true));
	}

	private List<Block> createBlocks() {
		Block block1 = new Block("h45h");
		block1.setId(1l);
		Block block2 = new Block("h4xx");
		block2.setId(2l);
		List<Block> blocks = Stream.of(block1, block2).collect(Collectors.toList());
		return blocks;
	}

}
