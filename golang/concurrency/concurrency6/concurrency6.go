package main

func concurrentFib(n int) []int {
	fibChan := make(chan int)
	fibNumbers := make([]int, 0, n)
	go fibonacci(n, fibChan)
	for item := range fibChan {
		fibNumbers = append(fibNumbers, item)
	}
	return fibNumbers
}

// don't touch below this line

func fibonacci(n int, ch chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		ch <- x
		x, y = y, x+y
	}
	close(ch)
}
