package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        for (int i = 4; i <= 6; i += 1) {
            L1.addLast(i);
            L2.addLast(i);
        }
        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
                //System.out.println("AListNoResizing: addLast(" + randVal + "), BuggyAList: addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = buggyL.size();
                //System.out.println("AListNoResizing size: " + size + " , BuggyAList size: " + buggySize);
            } else if (operationNumber == 2) {
                if (L.size() > 0 && buggyL.size() > 0) {
                    L.getLast();
                    buggyL.getLast();
                //    System.out.println("AListNoResizing getLast: " + L.getLast() + ", BuggyAList getLast: " + buggyL.getLast());
                }
            } else {
                if (L.size() > 0 && buggyL.size() > 0) {
                    L.removeLast();
                    buggyL.removeLast();
                //    System.out.println("AListNoResizing removeLast: " + L.removeLast() + ", BuggyAList removeLast: " + buggyL.removeLast());
                }
            }
        }
    }
}
