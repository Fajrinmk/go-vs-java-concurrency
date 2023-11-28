import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaConcurrentClient {
    public static void main(String[] args) {
        int numberOfRequests = 1000; // Change this as needed

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // Create an array of CompletableFuture objects
        CompletableFuture<Void>[] futures = new CompletableFuture[numberOfRequests];

        // Log the duration of this operation
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfRequests; i++) {
            // Asynchronously run the simulateDelay function for each request using the custom executor
            futures[i] = CompletableFuture.runAsync(() -> simulateDelay(), executor);
        }

        // Combine all CompletableFuture objects into a single CompletableFuture
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        try {
            // Wait for all CompletableFuture tasks to complete
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor to release resources
            executor.shutdown();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("All requests completed in: " + (endTime - startTime) + "ms");
        System.out.println("All requests completed");
    }

    private static void simulateDelay() {
        // Simulate a delay (100ms)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
