package main

func updateCounts(messagedUsers []string, validUsers map[string]int) {
	for i := 0; i < len(messagedUsers); i++ {
		if _, ok := validUsers[messagedUsers[i]]; ok {
			validUsers[messagedUsers[i]]++
		}
	}
}
