import java.util.HashMap;
import java.util.Map;

public class Graph {
	int n, m;
	Map<String, Vex> vexs;

	Graph() {
		n = 0;
		m = 0;
		vexs = new HashMap<String, Vex>();
	}
}
class Vex {
	Map<String, Integer> adjEdges;

	Vex() {
		adjEdges = new HashMap<String, Integer>();
	}
}

class Pair {
	String vex;
	int weight;

	Pair(String vex, int weight) {
		this.vex = vex;
		this.weight = weight;
	}
}
class StringPair{
	String s1;
	String s2;
	public StringPair(String s1,String s2) {
		this.s1=s1;
		this.s2=s2;
	}
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(null==obj)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		StringPair temp=(StringPair)obj;
		if(!temp.s1.equals(this.s1)||!temp.s2.equals(this.s2))
			return false;
		return true;
	}
	public int hashCode(){
		return 1;
	}
}
