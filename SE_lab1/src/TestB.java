import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestB {
	lab1 test=new lab1();
	Graph graph=test.createDirectedGraph("input.txt");
	@Test
	final void testCalcShortestPath() {
		Graph graph=test.createDirectedGraph("input.txt");
		assertEquals("label=\"distance=2\";new->worlds[label=\"1\"];new->civilizations[color=\"red\",label=\"1\"];"
				+ "new->life[label=\"1\"];worlds->to[label=\"1\"];explore->strange[label=\"1\"];and->new[label=\"1\"];"
				+ "to->explore[label=\"1\"];to->seek[label=\"1\"];civilizations->and[color=\"red\",label=\"1\"];"
				+ "seek->out[label=\"1\"]"
				+ ";strange->new[label=\"1\"];life->and[label=\"1\"];out->new[label=\"1\"];",
				test.calcShortestPath(graph, "new", "and"));
	}
	@Test
	final void test2()
	{
		assertEquals("最短路径打印完毕",test.calcShortestPath(graph, "strange",""));
	}
	@Test
	final void test3()
	{
		assertEquals("label=\"distance=3\";new->worlds[label=\"1\"];"
				+ "new->civilizations[label=\"1\"];new->life[label=\"1\"];"
				+ "worlds->to[color=\"red\",label=\"1\"];explore->strange[label=\"1\"];"
				+ "and->new[label=\"1\"];to->explore[label=\"1\"];"
				+ "to->seek[color=\"red\",label=\"1\"];civilizations->and[label=\"1\"];"
				+ "seek->out[color=\"red\",label=\"1\"];strange->new[label=\"1\"];life->and[label=\"1\"];"
				+ "out->new[label=\"1\"];",test.calcShortestPath(graph, "worlds","out"));
	}
	@Test
	final void test4(){
		assertEquals("最短路径打印完毕",test.calcShortestPath(graph, "and explore","life"));
	}

}
