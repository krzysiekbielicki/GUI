package pl.edu.pjwstk.s8267.GUI.Lab1;

public class Tree {
	private char[] leaves;
	private int[] branchesL;
	private int[] branchesR;
	private int leftLength = 0;

	public Tree(String branchL, String branchR) {
		this(branchL, branchR, "*");
	}

	public Tree(String branch) {
		this(branch, branch, "*");
	}

	public Tree(String branchL, String branchR, String leaves) {
		setLeaves(leaves);
		branchesL = new int[branchL.length()];
		for(int i = 0; i<branchesL.length; i++) {
			branchesL[i] = Integer.parseInt(branchL.charAt(i)+"");
			leftLength = Math.max(branchesL[i], leftLength);
		}
		
		branchesR = new int[branchR.length()];
		for(int i = 0; i<branchesR.length; i++) {
			branchesR[i] = Integer.parseInt(branchR.charAt(i)+"");
		}
	}

	public static void main(String[] args) {
		Tree d1 = new Tree("2345", "725");
		d1.setLeaves("$#$#");
		System.out.println(d1);
		Tree d2 = new Tree("638");
		Tree d3 = new Tree("24156", "023", "@%@");
		System.out.println(d2);
		System.out.println(d3);
	}

	private void setLeaves(String leaves) {
		this.leaves = leaves.toCharArray();
	}
	
	public String toString() {
		String ret = "";
		String format = "%"+leftLength+"s|%s\n";
		ret+=String.format(format, "", "");
		int len = Math.max(branchesL.length, branchesR.length);
		String bL, bR;
		int leafIndex;
		for(int i = 0; i<len; i++) {
			leafIndex = Math.min(i, leaves.length-1);
			bL = "";
			bR = "";
			if(i<branchesL.length)
				for(int j = 0; j<branchesL[i]; j++)
					bL += leaves[leafIndex];
			if(i<branchesR.length)
				for(int j = 0; j<branchesR[i]; j++)
					bR += leaves[leafIndex];
			ret+=String.format(format, bL, bR);
		}
		ret+=String.format(format, "", "");
		ret+=String.format(format, "", "");
		return ret;
	}
}
