package main

import (
	"fmt"
	"sync"
	"time"
)

func simulateDelay(wg *sync.WaitGroup) {
	defer wg.Done()
	// startTime := time.Now()
	// Simulate a delay (100ms)
	time.Sleep(100 * time.Millisecond)
	// endTime := time.Now()
	// fmt.Println("Request took:", endTime.Sub(startTime))
}

func main() {
	numRequests := 1000 // Change this as needed
	var wg sync.WaitGroup

	startTime := time.Now()
	for i := 0; i < numRequests; i++ {
		wg.Add(1)
		go simulateDelay(&wg)
	}

	wg.Wait()
	endTime := time.Now()
	fmt.Println("Total time taken:", endTime.Sub(startTime))
}
