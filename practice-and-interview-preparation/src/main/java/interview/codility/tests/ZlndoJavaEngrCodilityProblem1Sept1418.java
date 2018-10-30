package interview.codility.tests;

public class ZlndoJavaEngrCodilityProblem1Sept1418 {

	public static void main(String[] args) {
		ZlndoJavaEngrCodilityProblem1Sept1418 s  = new ZlndoJavaEngrCodilityProblem1Sept1418();
/*		System.out.println(s.solution(1, 1));
		System.out.println(s.solution(0, 1));
		System.out.println(s.solution(1, 0));

		System.out.println(s.solution(2, 2));
		System.out.println(s.solution(2, 1));
		System.out.println(s.solution(1, 2));

		System.out.println(s.solution(3, 3));
		System.out.println(s.solution(3, 2));
		System.out.println(s.solution(2, 3));

		System.out.println(s.solution(4, 4));
		System.out.println(s.solution(4, 3));
		System.out.println(s.solution(3, 4));

		//System.out.println(s.solution(10, 10));
		System.out.println(s.solution(10, 6));
		System.out.println(s.solution(5, 10));
		System.out.println(s.solution(4, 10));*/
		System.out.println(s.solution(15, 20));
	}

    public String solution(int A, int B) {
        // write your code in Java SE 8
    	StringBuilder sb = new StringBuilder();

    	int remainingA = A;
    	int remainingB = B;
    	int greater = A > B ? A : B;
    	int smaller = A > B ? B : A;
    	int singleInsertions = (greater - smaller) > 0 ? (greater - smaller) : 0;

    	while (remainingA > 0 || remainingB  > 0) {
    		if (A == greater) {
        		remainingA = (remainingA - appendA(sb, remainingA, 0));
        		remainingB = (remainingB - appendB(sb, remainingB, singleInsertions));
    		} else {
        		remainingB = (remainingB - appendB(sb, remainingB, 0));
        		remainingA = (remainingA - appendA(sb, remainingA, singleInsertions));
    		}
    		singleInsertions--;
		}

    	return sb.toString();
    }

    public int appendA(StringBuilder sb, int remainingA, int singleInsertions) {
    	if (0 == remainingA)
    		return 0;
    		
    	final String SINGLE_A = "a";
    	final String DOUBLE_A = "aa";

    	int appended = 0;
		if(remainingA == 1 || singleInsertions > 0) {
			sb.append(SINGLE_A);
			appended = 1;
		} else {
			sb.append(DOUBLE_A);
			appended = 2;
		}

		return appended;
    }

    public int appendB(StringBuilder sb, int remainingB, int singleInsertions) {
    	if (0 == remainingB)
    		return 0;

    	final String SINGLE_B = "b";
    	final String DOUBLE_B = "bb";

    	int appended = 0;
		if(remainingB == 1 || singleInsertions > 0) {
			sb.append(SINGLE_B);
			appended = 1;
		} else {
			sb.append(DOUBLE_B);
			appended = 2;
		}

		return appended;
    }

}
