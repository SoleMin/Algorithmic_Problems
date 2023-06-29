

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoSets<V> {

    private static int n;

    private static int a;

    private static int b;

    private static List<Node<Integer>> nodes = new LinkedList<Node<Integer>>();

    private static Map<Integer, Node<Integer>> datas = new HashMap<Integer, Node<Integer>>();

    private static Node<Integer> first;

    private static Node<Integer> second;

    private static TwoSets<Integer> sets = new TwoSets<Integer>();

    private static class Node<V> {

	V node;

	Node<V> parent;

	int rank;

	int color = -1;

	boolean inprogress;

	public Node() {
	    this.parent = this;
	}

	@Override
	public String toString() {
	    return String.format("{node: %s, parent: %s, rank: %s, color:%s}",
		    node, parent.node, rank, color);
	}
    }

    public Node<V> makeSet(V x) {

	Node<V> node = new Node<V>();

	node.node = x;
	node.parent = node;
	node.rank = 0;

	return node;
    }

    public void link(Node<V> x, Node<V> y) {

	if (x.rank > y.rank) {
	    y.parent = x;
	} else {
	    x.parent = y;
	    if (x.rank == y.rank) {
		y.rank++;
	    }
	}
    }

    public Node<V> findSet(Node<V> x) {

	if (x.parent != x) {
	    x.parent = findSet(x.parent);
	}

	return x.parent;
    }

    public void union(Node<V> x, Node<V> y) {

	Node<V> rtX = findSet(x);
	Node<V> rtY = findSet(y);
	if (rtX.parent != rtY.parent) {
	    link(rtX, rtY);
	}
    }

    public V getNode(Node<V> x) {
	return x.node;
    }

    private int getColor(Node<V> node) {

	int color;
	Node<V> parent = findSet(node);
	color = parent.color;

	return color;
    }

    private void setColor(Node<V> node, int color) {
	Node<V> parent = findSet(node);
	parent.color = color;
    }

    private static Node<Integer> getOrInitNode(Integer key) {

	Node<Integer> node = datas.get(key);

	if (node == null) {
	    node = sets.makeSet(key);
	    datas.put(key, node);
	}

	return node;
    }

    private static void initNodes(Scanner scanner) {

	int key;
	Node<Integer> node;
	for (int i = 0; i < n; i++) {
	    key = scanner.nextInt();
	    node = getOrInitNode(key);
	    nodes.add(node);
	}
    }

    private static void unionAll(Node<Integer> value) {

	int color = sets.getColor(value);
	if (color == 0) {
	    if (first == null) {
		first = value;
	    } else {
		sets.union(first, value);
	    }
	} else if (color == 1) {
	    if (second == null) {
		second = value;
	    } else {
		sets.union(second, value);
	    }
	}
    }

    private static int getKey(Node<Integer> value, int color) {

	int key = value.node;

	if (color == 0) {
	    key = a - key;
	} else {
	    key = b - key;
	}

	return key;
    }

    private static boolean checkOpposite(Node<Integer> value, int color) {

	boolean valid;

	if (value.inprogress) {
	    valid = Boolean.TRUE;
	} else {
	    value.inprogress = Boolean.TRUE;
	    int opColor = 1 - color;
	    int key = getKey(value, opColor);
	    Node<Integer> node = datas.get(key);
	    valid = (value.node.equals(key)) || (node == null);
	    if (!valid) {
		key = getKey(node, color);
		Node<Integer> child = datas.get(key);
		valid = (child != null);
		if (valid) {
		    valid = checkOpposite(child, color);
		    if (valid) {
			sets.union(value, node);
			sets.union(value, child);
			value.inprogress = Boolean.FALSE;
		    }
		}
	    }
	    value.inprogress = Boolean.FALSE;
	}

	return valid;
    }

    private static boolean checkNodes(Node<Integer> value, int color) {

	boolean valid;

	int key = getKey(value, color);
	int opColor = 1 - color;
	Node<Integer> node = datas.get(key);
	valid = (value.node.equals(key)) || (node != null);
	if (valid) {
	    valid = checkOpposite(value, color);
	    if (valid) {
		sets.union(value, node);
		sets.setColor(value, color);
	    } else if (color == 0) {
		valid = checkNodes(value, opColor);
	    }
	} else if (color == 0) {
	    valid = checkNodes(value, opColor);
	}

	return valid;
    }

    private static void format(StringBuilder builder, int i) {

	if (i > 0) {
	    builder.append(' ');
	}
    }

    private static String printNodes() {

	String text;

	StringBuilder builder = new StringBuilder();
	Iterator<Node<Integer>> iterator = nodes.iterator();
	int i = 0;
	Node<Integer> node;
	while (iterator.hasNext()) {
	    format(builder, i);
	    node = iterator.next();
	    builder.append(sets.getColor(node));
	    i++;
	}
	text = builder.toString().trim();

	return text;
    }

    private static boolean checkNodes(int color) {

	boolean valid = Boolean.TRUE;

	for (Node<Integer> value : nodes) {
	    if (sets.getColor(value) == -1) {
		valid = checkNodes(value, color);
		if (valid) {
		    unionAll(value);
		} else {
		    break;
		}
	    }
	}

	return valid;
    }

    private static void calculate() {

	int color = 0;
	boolean valid = checkNodes(color);
	String message = "NO";
	if (valid) {
	    message = "YES";
	    String array = printNodes();
	    System.out.println(message);
	    System.out.println(array);
	} else {
	    System.out.println(message);
	}
    }

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	try {
	    n = scanner.nextInt();
	    a = scanner.nextInt();
	    b = scanner.nextInt();
	    initNodes(scanner);
	    calculate();
	} finally {
	    scanner.close();
	}
    }
}
