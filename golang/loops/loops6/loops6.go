package main

func countConnections(groupSize int) int {
	var connections int
	for i := 0; i < groupSize; i++ {
		if i == 0 {
			continue
		}
		connections += i
	}
	return connections
}
