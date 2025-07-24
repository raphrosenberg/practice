package main

import "fmt"

func maxMessages(thresh int) int {
	baseCost := 100
	totalCost := 0
	var totalMessages int
	fmt.Printf("Thresh: %v\n", thresh)
	for totalMessages = 1; ; totalMessages++ {
		totalCost = totalCost + baseCost + totalMessages - 1
		fmt.Printf("Total cost: %v\n", totalCost)
		if totalCost > thresh {
			totalMessages--
			break
		}
	}
	return totalMessages
}

func main() {
	messages := maxMessages(1000)
	fmt.Printf("Messages: %v\n", messages)
}
