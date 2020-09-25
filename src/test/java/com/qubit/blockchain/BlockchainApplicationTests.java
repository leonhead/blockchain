package com.qubit.blockchain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.qubit.blockchain.dao.BlockRepository;
import com.qubit.blockchain.entity.Block;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BlockchainApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private BlockRepository blockRepository;

	@Test
	void contextLoads() throws JSONException {
		List<Block> blocks = createBlocks();
		Mockito.when(blockRepository.findAll()).thenReturn(blocks);
		String response = this.restTemplate.getForObject("/blocks/list", String.class);
		String expected = "[{\"id\":1,\"hash\":\"h45h\"},{\"id\":2,\"hash\":\"h4xx\"}]";

		JSONAssert.assertEquals(expected, response, false);

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
