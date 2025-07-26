package main

func indexOfFirstBadWord(msg []string, badWords []string) int {
	badIndex := -1
outer:
	for i, word := range msg {
		for _, badWord := range badWords {
			if word == badWord {
				badIndex = i
				break outer
			}
		}
	}
	return badIndex
}
