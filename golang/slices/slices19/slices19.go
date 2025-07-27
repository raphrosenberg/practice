package main

import "strings"

type sms struct {
	id      string
	content string
	tags    []string
}

func tagMessages(messages []sms, tagger func(sms) []string) []sms {
	for i := range messages {
		messages[i].tags = tagger(messages[i])
	}
	return messages
}

func tagger(msg sms) []string {
	var tags = make([]string, 0, 2)

	msgSplit := strings.Split(msg.content, " ")
	for i := 0; i < len(msgSplit); i++ {
		wordTrimmed := strings.Trim(msgSplit[i], ",.!'")
		wordLower := strings.ToLower(string(wordTrimmed))

		if strings.Contains(wordLower, "urgent") {
			tags = append(tags, "Urgent")
		}
		if strings.Contains(wordLower, "sale") {
			tags = append(tags, "Promo")
		}
	}
	if len(tags) == 2 {
		tags[0] = "Urgent"
		tags[1] = "Promo"
	}
	return tags
}
