package main

import "strings"

func countDistinctWords(messages []string) int {
	distinctWords := make(map[string]struct{})
	for i := 0; i < len(messages); i++ {
		fields := strings.Fields(messages[i])
		for j := 0; j < len(fields); j++ {
			low := strings.ToLower(fields[j])
			distinctWords[low] = struct{}{}
		}
	}
	return len(distinctWords)
}
