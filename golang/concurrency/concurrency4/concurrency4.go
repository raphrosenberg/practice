package main

func addEmailsToQueue(emails []string) chan string {
	emailChan := make(chan string, len(emails))
	for i := 0; i < len(emails); i++ {
		emailChan <- emails[i]
	}
	return emailChan
}
