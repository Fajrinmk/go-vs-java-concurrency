# Go vs Java Concurrency

We run 1000 tasks concurrently and measure the time it takes to complete.

## Go
```bash
Total time taken: 101.431708ms
./main  0.00s user 0.00s system 8% cpu 0.109 total
```

## Java with Platform Thread

1000 ExecutorService threads are created and run concurrently.

```bash
Total time taken:: 179ms
java JavaConcurrentClient  0.23s user 0.34s system 193% cpu 0.296 total
```

## Java with Virtual Thread

Will need JDK 21 or later.

```bash
Total time taken:: 124ms
java JavaConcurrentClient  0.14s user 0.02s system 85% cpu 0.195 total
```
