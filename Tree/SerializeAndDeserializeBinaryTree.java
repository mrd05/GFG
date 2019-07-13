package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SerializeAndDeserializeBinaryTree {

	static class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = right = null;
		}
	}

	static class SND {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				Tree root = null;
				if (n == 1) {
					System.out.println(sc.nextInt());
					n--;
				}
				while (n-- > 0) {
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char lr = sc.next().charAt(0);
					if (root == null) {
						root = new Tree(n1);
						switch (lr) {
						case 'L':
							root.left = new Tree(n2);
							break;
						case 'R':
							root.right = new Tree(n2);
							break;
						}
					} else {
						insert(n1, n2, lr, root);
					}
				}
				ArrayList<Integer> aa = new ArrayList<Integer>();
				GfG g = new GfG();
				String s = g.serialize(root, aa);
				Tree root1 = g.deSerialize(s);
				inorder(root1);
				System.out.println();
			}
		}

		public static void inorder(Tree root) {
			if (root == null)
				return;
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}

		public static void insert(int n1, int n2, char lr, Tree root) {
			if (root == null) {
				return;
			}
			if (root.data == n1) {
				switch (lr) {
				case 'L':
					root.left = new Tree(n2);
					break;
				case 'R':
					root.right = new Tree(n2);
					break;
				}
			}
			insert(n1, n2, lr, root.left);
			insert(n1, n2, lr, root.right);
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * Complete the given function Node is as follows: class Tree{ int data;
	 * Tree left,right; Tree(int d){ data=d; left=right=null; } }
	 */
	static class GfG {
		public String serialize(Tree root, ArrayList<Integer> aa) {
			if (root == null)
				return "#";

			StringBuilder sb = new StringBuilder();
			Queue<Tree> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				Tree n = q.poll();
				if (n == null)
					sb.append('#').append(' ');
				else {
					sb.append(n.data).append(' ');
					q.add(n.left);
					q.add(n.right);
				}
			}
			// System.out.println(sb.substring(0,sb.length()-1).toString());
			return sb.substring(0, sb.length() - 1).toString();
		}

		public Tree deSerialize(String data) {
			String str[] = data.split(" ");
			if (str[0] == "#")
				return null;

			Queue<Tree> q = new LinkedList<>();
			Tree head = new Tree(Integer.parseInt(str[0]));
			q.add(head);
			int i = 1;
			while (!q.isEmpty()) {
				Tree n = q.poll();
				if (n != null) {
					Tree l = null;
					if (!str[i].equals("#"))
						l = new Tree(Integer.parseInt(str[i]));
					i++;
					n.left = l;
					q.add(l);

					Tree r = null;
					if (!str[i].equals("#"))
						r = new Tree(Integer.parseInt(str[i]));
					i++;
					n.right = r;
					q.add(r);
				}
			}
			return head;
		}
	}

}
