package deque;
import edu.princeton.cs.algs4.Stopwatch;

public class TimeAd {
    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
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
        System.out.println("Time taken for the AD to construct");
        timeArrayDequeConstruction();
        System.out.println("\n\n\n Time taken for the AD to destruct");
        timeArrayDequeDeconstruction();
    }

    public static void timeArrayDequeConstruction() {
        // TODO: YOUR CODE HERE
        ArrayDeque<Integer> Ns = new ArrayDeque<>();
        ArrayDeque<Double> times = new ArrayDeque<>();
        ArrayDeque<Integer> tempList = new ArrayDeque<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < i; j++) {
                // add any random number
                tempList.addLast(21);
            }
            double timeInSeconds = sw.elapsedTime();
            tempList = new ArrayDeque<>();
            Ns.addLast(i);
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, Ns);
    }

    public static void timeArrayDequeDeconstruction() {
        // TODO: YOUR CODE HERE
        ArrayDeque<Integer> Ns = new ArrayDeque<>();
        ArrayDeque<Double> times = new ArrayDeque<>();
        ArrayDeque<Integer> tempList = new ArrayDeque<>();
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
