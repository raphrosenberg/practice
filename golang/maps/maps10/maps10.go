package main

func getNameCounts(names []string) map[rune]map[string]int {
	mappyMap := make(map[rune]map[string]int)
	for i := 0; i < len(names); i++ {
		r := []rune(names[i])
		if _, ok := mappyMap[r[0]]; !ok {
			mappyMap[r[0]] = map[string]int{}
		}
		mappyMap[r[0]][names[i]]++
	}
	return mappyMap
}
