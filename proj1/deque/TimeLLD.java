package deque;
import edu.princeton.cs.algs4.Stopwatch;

public class TimeLLD {
    private static void printTimingTable(LinkedListDeque<Integer> Ns, LinkedListDeque<Double> times, LinkedListDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        System.out.println("Time taken for the LL to construct");
        timeLinkedListDequeConstruction();
        System.out.println("\n\n\n Time taken for the LL to destruct");
        timeLinkedListDequeDeconstruction();
    }

    public static void timeLinkedListDequeConstruction() {
        // TODO: YOUR CODE HERE
        LinkedListDeque<Integer> Ns = new LinkedListDeque<>();
        LinkedListDeque<Double> times = new LinkedListDeque<>();
        LinkedListDeque<Integer> tempList = new LinkedListDeque<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < i; j++) {
                // add any random number
                tempList.addLast(21);
            }
            double timeInSeconds = sw.elapsedTime();
            tempList = new LinkedListDeque<>();
            Ns.addLast(i);
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, Ns);
    }

    public static void timeLinkedListDequeDeconstruction() {
        // TODO: YOUR CODE HERE
        LinkedListDeque<Integer> Ns = new LinkedListDeque<>();
        LinkedListDeque<Double> times = new LinkedListDeque<>();
        LinkedListDeque<Integer> tempList = new LinkedListDeque<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            for (int j = 0; j < i; j++) {
                // add any random number
                tempList.addLast(21);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < i; j++) {
                // add any random number
                tempList.removeLast();
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(i);
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, Ns);
    }
}
