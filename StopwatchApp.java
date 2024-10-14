import java.util.Scanner;

public class StopwatchApp {


    private static long startTime = 0;
    private static long endTime = 0;
    private static boolean running = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Stopwatch Application");
        System.out.println("Commands: start, stop, reset, exit");

        do {
            System.out.print("Enter command: ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "start":
                    start();
                    break;
                case "stop":
                    stop();
                    break;
                case "reset":
                    reset();
                    break;
                case "exit":
                    System.out.println("Exiting stopwatch...");
                    break;
                default:
                    System.out.println("Unknown command. Please enter start, stop, reset, or exit.");
            }
        } while (!input.equals("exit"));

        scanner.close();
    }

    public static void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("Stopwatch started...");
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    public static void stop() {
        if (running) {
            endTime = System.currentTimeMillis();
            running = false;
            long elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Stopwatch stopped. Elapsed time: " + elapsedTime + " seconds.");
        } else {
            System.out.println("Stopwatch is not running. Use 'start' to begin timing.");
        }
    }

    public static void reset() {
        startTime = 0;
        endTime = 0;
        running = false;
        System.out.println("Stopwatch reset.");
    }
}
