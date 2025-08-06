package main

import (
	"strings"
)

func removeProfanity(message *string) {
	badWordz := []string{"fubb", "shiz", "witch"}
	for i := 0; i < len(badWordz); i++ {
		*message = strings.ReplaceAll(*message, badWordz[i], strings.Repeat("*", len(badWordz[i])))
	}
}
