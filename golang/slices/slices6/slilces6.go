package main

func getMessageCosts(messages []string) []float64 {
	var messageCosts = make([]float64, len(messages))

	for i := 0; i < len(messageCosts); i++ {
		messageCosts[i] = float64(len(messages[i])) * .01
	}
	return messageCosts
}
