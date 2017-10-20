import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.Scanner;
import java.util.Set;
import java.io.*;
import java.util.Random;

public class lab1 {

  public static void main(String[] args) {
    lab1 cls = new lab1();
    Graph G = null;
    System.out.println("璇疯緭鍏ユ暟瀛楁寚浠よ繘琛岀浉鍏虫搷浣�:");
    System.out.println("0.鏌ョ湅甯姪鑿滃崟");
    System.out.println("1.璇诲叆鏂囨湰骞剁敓鎴愭湁鍚戝浘");
    System.out.println("2.灞曠ず鏈夊悜鍥�");
    System.out.println("3.鏌ヨ妗ユ帴璇�");
    System.out.println("4.鏍规嵁bridge word鐢熸垚鏂版枃鏈�");
    System.out.println("5.璁＄畻涓や釜鍗曡瘝涔嬮棿鐨勬渶鐭矾寰�");
    System.out.println("6.闅忔満娓歌蛋");
    System.out.println("7.閫�鍑虹▼搴�");
    int op;
    Scanner scan = new Scanner(System.in);
    op = scan.nextInt();
    while (op != 7) {
      switch (op) {
      case 0:
        System.out.println("璇疯緭鍏ユ暟瀛楁寚浠よ繘琛岀浉鍏虫搷浣�:");
        System.out.println("0.鏌ョ湅甯姪鑿滃崟");
        System.out.println("1.璇诲叆鏂囨湰骞剁敓鎴愭湁鍚戝浘");
        System.out.println("2.灞曠ず鏈夊悜鍥�");
        System.out.println("3.鏌ヨ妗ユ帴璇�");
        System.out.println("4.鏍规嵁bridge word鐢熸垚鏂版枃鏈�");
        System.out.println("5.璁＄畻涓や釜鍗曡瘝涔嬮棿鐨勬渶鐭矾寰�");
        System.out.println("6.闅忔満娓歌蛋");
        System.out.println("7.閫�鍑虹▼搴�");
        break;
      case 1:
        System.out.println("璇疯緭鍏ユ枃鏈枃浠跺湴鍧�");
        String input = scan.next();
        G = cls.createDirectedGraph(input);
        System.out.println("鏈夊悜鍥剧敓鎴愭垚鍔�");
        break;
      case 2:
        if (G == null) {
          System.out.println("璇峰厛鐢熸垚鏈夊悜鍥�");
          break;
        }
        cls.showDirectedGraph(G);
        System.out.println("鎴愬姛瀵煎嚭鏈夊悜鍥綝otGraph.pdf");
        break;
      case 3:
        if (G == null) {
          System.out.println("璇峰厛鐢熸垚鏈夊悜鍥�");
          break;
        }
        System.out.println("璇疯緭鍏ュ崟璇峸ord1,word2锛岀敤绌烘牸闅斿紑");
        String word1, word2;
        word1 = scan.next();
        word2 = scan.next();
        String bridge = cls.queryBridgeWords(G, word1, word2);
        System.out.println(bridge);
        break;
      case 4:
        if (G == null) {
          System.out.println("璇峰厛鐢熸垚鏈夊悜鍥�");
          break;
        }
        System.out.println("璇疯緭鍏ヤ竴琛屾柊鏂囨湰");
        scan.nextLine();
        String inputText = scan.nextLine();
        System.out.println(cls.generateNewText(G, inputText));
        break;
      case 5:
        if (G == null) {
          System.out.println("璇峰厛鐢熸垚鏈夊悜鍥�");
          break;
        }
        System.out.println("璇烽�夋嫨杈撳叆鍛戒护鏍囧彿鍜屽搴旀暟閲忓崟璇�(浠ョ┖鏍煎垎鍓�)");
        System.out.println("1.鏌ヨ涓や釜鍗曡瘝闂寸殑鏈�鐭矾寰�,2.鏌ヨ涓�涓崟璇嶅埌鍏朵粬鍗曡瘝鏈�鐭矾寰�");
        int opx = scan.nextInt();
        String word3, word4;
        if (opx == 1) {
          word3 = scan.next();
          word4 = scan.next();
          System.out.println(cls.calcShortestPath(G, word3, word4));
        } else if (opx == 2) {
          word3 = scan.next();
          System.out.println(cls.calcShortestPath(G, word3, ""));
        } else {
          System.out.println("杈撳叆閿欒锛岃閲嶆柊鎿嶄綔");
          break;
        }
        break;
      case 6:
        if (G == null) {
          System.out.println("璇峰厛鐢熸垚鏈夊悜鍥�");
          break;
        }
        System.out.println(cls.randomWalk(G));
        System.out.println("闅忔満娓歌蛋瀹屾瘯");
        break;
      default:
        System.out.println("鎸囦护閿欒锛岃浠庢柊杈撳叆");
        break;
      }
      try {
        op = scan.nextInt();
      } catch (Exception e) {
        System.out.println("鎸囦护鎿嶄綔锛岃閲嶆柊杈撳叆");
        op = scan.nextInt();
      }
    }
    System.out.println("绋嬪簭閫�鍑哄畬姣�");
  }

  public void testQueryBridgeWords(lab1 cls, Graph g) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      String word1, word2;
      word1 = scan.next();
      word2 = scan.next();
      if (word1.equals("*") || word2.equals("*"))
        break;
      System.out.println(cls.queryBridgeWords(g, word1, word2));
    }
    scan.close();
  }

  public Graph createDirectedGraph(String filename) {
    Graph g = new Graph();
    String pre = "", now = "";
    try {
      FileReader in = new FileReader(filename);
      int c = 0;
      c = in.read();
      while (c != -1) {
        if (c >= 'a' && c <= 'z') {
          now += (char) c;

        } else if (c >= 'A' && c <= 'Z') {
          now += (char) (c + 32);
        } else if ((c == ' ' || c == '\t' || c == '\n') && !now.equals("")) // now闈炵┖璺宠繃澶氫釜绌烘牸
        {
          if (!g.vexs.containsKey(now)) // 褰撳墠涓叉湭鍑虹幇鍦ㄥ浘涓�
          {
            g.vexs.put(now, new Vex());
            g.n++;
          }
          if (!pre.equals("")) {
            Vex v = g.vexs.get(pre);
            if (v.adjEdges.containsKey(now))
              v.adjEdges.put(now, v.adjEdges.get(now) + 1);
            else {
              v.adjEdges.put(now, 1);
              g.m++;
            }
          }
          pre = now;
          now = "";
        }
        c = in.read();
      }
      in.close();
      if (!now.equals("")) // 澶勭悊鏈�鍚庣殑涓�
      {
        if (!g.vexs.containsKey(now)) // 褰撳墠涓叉湭鍑虹幇鍦ㄥ浘涓�
        {
          g.vexs.put(now, new Vex());
          g.n++;
        }
        if (!pre.equals(null)) {
          Vex v = g.vexs.get(pre);
          if (v.adjEdges.containsKey(now))
            v.adjEdges.put(now, v.adjEdges.get(now) + 1);
          else {
            v.adjEdges.put(now, 1);
            g.m++;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return g;
  }

  void showDirectedGraph(Graph g) {
    try {
      String dotFormat = "";

      for (Map.Entry<String, Vex> m : g.vexs.entrySet()) {
        Vex v = m.getValue();
        for (Map.Entry<String, Integer> t : v.adjEdges.entrySet()) {
          dotFormat += m.getKey() + "->" + t.getKey() + "[label=\"" + t.getValue() + "\"];";
          // System.out.println(m.getKey() + "->" + t.getKey() + "->"
          // + t.getValue());
        }
      }
      GraphViz.createDotGraph(dotFormat, "DotGraph");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  String queryBridgeWords(Graph G, String word1, String word2) {
    if (!G.vexs.containsKey(word1) || !G.vexs.containsKey(word2))
      return "No word1 or word2 in the graph!";
    Vex v1 = G.vexs.get(word1);
    String words = "", pre = "", now = "";
    for (Map.Entry<String, Integer> m : v1.adjEdges.entrySet()) {
      Vex v3 = G.vexs.get(m.getKey());
      if (v3.adjEdges.containsKey(word2)) {
        pre = now;
        now = m.getKey();
        if (!pre.equals(""))
          words += pre + ", ";
      }
    }
    if (words.equals("") && now.equals(""))
      return "No bridge words from \"" + word1 + "\" to \"" + word2 + "\"!";
    else if (words.equals(""))
      return "The bridge words from \"" + word1 + "\" to \"" + word2 + "\" is: " + now;
    else
      return "The bridge words from \"" + word1 + "\" to \"" + word2 + "\" are: " + words + "and " + now;
  }

  String generateNewText(Graph G, String inputText) {
    String result = "";
    String pre = "", now = "";
    for (int pos = 0; pos < inputText.length(); pos++) {
      char c = inputText.charAt(pos);
      if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
        now += c;
      else if (c == ' ' || c == '\t') {
        if (pre != "")
          result += pre + " ";
        if (!pre.equals("") && G.vexs.containsKey(pre.toLowerCase())) {
          Vex v1 = G.vexs.get(pre.toLowerCase());
          for (Map.Entry<String, Integer> m : v1.adjEdges.entrySet()) {
            Vex v3 = G.vexs.get(m.getKey());
            if (v3.adjEdges.containsKey(now)) {
              result += m.getKey() + " ";
              break;
            }
          }
        }
        pre = now;
        now = "";
      }

    }
    if (!now.equals("")) // 澶勭悊鏈�鍚庣殑涓�
    {
      result += pre + " ";
      if (!pre.equals("") && G.vexs.containsKey(pre.toLowerCase())) {
        Vex v1 = G.vexs.get(pre.toLowerCase());
        for (Map.Entry<String, Integer> m : v1.adjEdges.entrySet()) {
          Vex v3 = G.vexs.get(m.getKey());
          if (v3.adjEdges.containsKey(now)) {
            result += m.getKey() + " ";
            break;
          }
        }
      }
    }
    result += now + " ";
    return result;
  }

  String calcShortestPath(Graph G, String word1, String word2) {
    if (!G.vexs.containsKey(word1))
      return "word1涓嶅瓨鍦�";
    Map<String, String> pre = new HashMap<String, String>(); // 璁板綍鍓嶇疆椤剁偣
    Map<String, Integer> dist = new HashMap<String, Integer>(); // 璁板綍鍒版簮鐐圭殑璺濈
    Map<String, Boolean> mark = new HashMap<String, Boolean>();
    // 鍒濆鍖�
    Vex v0 = G.vexs.get(word1);
    for (Map.Entry<String, Integer> m : v0.adjEdges.entrySet()) {
      dist.put(m.getKey(), m.getValue());
      pre.put(m.getKey(), word1);
    }
    mark.put(word1, true);
    pre.put(word1, word1);
    for (int i = 1; i < G.vexs.size(); i++) {
      String u = word1;
      int Mindist = Integer.MAX_VALUE;
      for (Map.Entry<String, Integer> m : dist.entrySet()) // 瀵绘壘鏈姞鍏ョ殑鏈�鐭窛绂荤偣
      {
        if (!mark.containsKey(m.getKey()) && Mindist > dist.get(m.getKey())) {
          u = m.getKey();
          Mindist = dist.get(m.getKey());
        }
      }
      // 灏嗘湭鍔犲叆鐨勬渶鐭窛绂荤偣鍔犲叆
      mark.put(u, true);
      Vex v1 = G.vexs.get(u);
      for (Map.Entry<String, Integer> m : v1.adjEdges.entrySet())
        if (!dist.containsKey(m.getKey()) || dist.get(m.getKey()) > dist.get(u) + m.getValue()) {
          dist.put(m.getKey(), dist.get(u) + m.getValue());
          pre.put(m.getKey(), u);
        }
    }

    if (!word2.equals("")) {

      Stack<String> path = new Stack<String>();
      String p = word2;
      while (!p.equals(word1)) {
        path.push(p);
        p = pre.get(p);
      }
      try {
        String dotFormat;
        if (word2.equals(word1))
          dotFormat = "label=\"distance=0\";";
        else
          dotFormat = "label=\"distance=" + dist.get(word2) + "\";";

        for (Map.Entry<String, Vex> m : G.vexs.entrySet()) {
          Vex v = m.getValue();
          for (Map.Entry<String, Integer> t : v.adjEdges.entrySet()) {
            if (path.contains(t.getKey()) && m.getKey().equals(pre.get(t.getKey())))
              dotFormat += m.getKey() + "->" + t.getKey() + "[color=\"red\"," + "label=\"" + t.getValue()
                  + "\"];";
            else
              dotFormat += m.getKey() + "->" + t.getKey() + "[label=\"" + t.getValue() + "\"];";
          }
        }
        GraphViz.createDotGraph(dotFormat, word1 + "_" + word2);
      } catch (Exception e) {
        e.printStackTrace();
      }

    } else {
      for (Map.Entry<String, Vex> m : G.vexs.entrySet()) {
        Stack<String> path = new Stack<String>();
        String p = m.getKey();
        while (!p.equals(word1)) {
          path.push(p);
          p = pre.get(p);
        }
        try {
          String dotFormat;
          if (word1.equals(m.getKey()))
            dotFormat = "label=\"distance=0\";";
          else
            dotFormat = "label=\"distance=" + dist.get(m.getKey()) + "\";";
          for (Map.Entry<String, Vex> m1 : G.vexs.entrySet()) {
            Vex v = m1.getValue();
            for (Map.Entry<String, Integer> t : v.adjEdges.entrySet()) {
              if (path.contains(t.getKey()) && m1.getKey().equals(pre.get(t.getKey())))
                dotFormat += m1.getKey() + "->" + t.getKey() + "[color=\"red\"," + "label=\""
                    + t.getValue() + "\"];";
              else
                dotFormat += m1.getKey() + "->" + t.getKey() + "[label=\"" + t.getValue() + "\"];";
            }
          }
          GraphViz.createDotGraph(dotFormat, word1 + "_" + m.getKey());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return "鏈�鐭矾寰勬墦鍗板畬姣�";
  }

  String randomWalk(Graph G) {
    Map<Integer, String> index = new HashMap<Integer, String>();
    Set<StringPair> set = new HashSet<StringPair>();
    int i = 0;
    for (Map.Entry<String, Vex> m : G.vexs.entrySet())
      index.put(i++, m.getKey());
    int randNum = new Random().nextInt(G.vexs.size());
    String s = index.get(randNum);
    String path = "";
    // Scanner scan=new Scanner(System.in);
    // int times=0;
    // System.out.println("璇疯緭鍏ラ亶鍘嗗瓧绗︿釜鏁帮紝杈撳叆0鍒欏叏閮ㄩ亶鍘�");
    // times=scan.nextInt();

    while (true) {
      path += s + " ";
      Vex v = G.vexs.get(s);
      if (v.adjEdges.isEmpty())
        break;
      Map<Integer, String> vexIndex = new HashMap<Integer, String>();
      int j = 0;
      for (Map.Entry<String, Integer> m : v.adjEdges.entrySet())
        vexIndex.put(j++, m.getKey());
      int rand_vex_Num = new Random().nextInt(v.adjEdges.size());
      String temp = vexIndex.get(rand_vex_Num);
      if (set.contains(new StringPair(s, temp))) {
        path += temp;
        break;
      }
      set.add(new StringPair(s, temp));
      s = temp;
    }
    return path;
  }
  // String randomWalk(Graph G)
  // {
  // Map<Integer,String> index=new HashMap<Integer,String>();
  // Set<StringPair> set=new HashSet<StringPair>();
  // int i=0;
  // for(Map.Entry<String, Vex> m:G.vexs.entrySet())
  // index.put(i++,m.getKey());
  // int randNum=new Random().nextInt(G.vexs.size());
  // String s=index.get(randNum);
  // String path="";
  //// Scanner scan=new Scanner(System.in);
  //// int times=0;
  //// System.out.println("璇疯緭鍏ラ亶鍘嗗瓧绗︿釜鏁帮紝杈撳叆0鍒欏叏閮ㄩ亶鍘�");
  //// times=scan.nextInt();
  //
  // while(true)
  // {
  // path+=s+" ";
  // Vex v=G.vexs.get(s);
  // if(v.adjEdges.isEmpty())
  // break;
  // Map<Integer,String> vexIndex=new HashMap<Integer,String>();
  // int j=0;
  // for(Map.Entry<String, Integer> m:v.adjEdges.entrySet())
  // vexIndex.put(j++,m.getKey());
  // int rand_vex_Num=new Random().nextInt(v.adjEdges.size());
  // String temp=vexIndex.get(rand_vex_Num);
  // if(set.contains(new StringPair(s,temp)))
  // {
  // path+=temp;
  // break;
  // }
  // set.add(new StringPair(s,temp));
  // s=temp;
  // }
  // return path;
  // }
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

class StringPair {
  String s1;
  String s2;

  public StringPair(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StringPair temp = (StringPair) obj;
    if (!temp.s1.equals(this.s1) || !temp.s2.equals(this.s2))
      return false;
    return true;
  }

  public int hashCode() {
    return 1;
  }
}

class Graph {
  int n, m;
  Map<String, Vex> vexs;

  Graph() {
    n = 0;
    m = 0;
    vexs = new HashMap<String, Vex>();
  }
}
