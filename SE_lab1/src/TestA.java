import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestA {
	lab1 test=new lab1();
	Graph graph=test.createDirectedGraph("input.txt");
	@Test
	public void test1() {
		assertEquals("No word1 or word2 in the graph!",test.queryBridgeWords(graph,
				"apple","kid"));
	}
	@Test
	public void test2() {
		assertEquals("",test.queryBridgeWords(graph,
				"new","explore"));
	}
	@Test
	public void test3() {
		assertEquals("life civilizations ",test.queryBridgeWords(graph,
				"new","and"));
	}
	

}
