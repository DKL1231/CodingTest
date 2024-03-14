import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	Node left, right;
	int value;
	public Node(Node left, Node right, int value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	public Node(int value) {
		this.value = value;
	}
	public void addValue(int value) {
		if(value>this.value) {
			if(this.right == null) {
				this.right = new Node(value);
				return;
			}
			this.right.addValue(value);
		}else {
			if(this.left == null) {
				this.left = new Node(value);
				return;
			}
			this.left.addValue(value);
		}
	}
	public void postOrder() {
		if(left != null)
			left.postOrder();
		if(right != null)
			right.postOrder();
		System.out.println(value);
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int root = Integer.parseInt(br.readLine());
		Node r = new Node(root);
		
		String input;
		while((input = br.readLine())!=null && !input.isEmpty()) {
			int next = Integer.parseInt(input);
			r.addValue(next);
		}
		r.postOrder();
		
	}
}
