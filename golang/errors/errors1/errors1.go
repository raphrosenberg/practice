package main

import (
	"fmt"
)

func sendSMSToCouple(msgToCustomer, msgToSpouse string) (int, error) {
	cost1, error := sendSMS(msgToCustomer)
	if error != nil {
		return 0, error
	}
	cost2, error := sendSMS(msgToSpouse)
	if error != nil {
		return 0, error
	}
	return cost1 + cost2, nil
}

// don't edit below this line

func sendSMS(message string) (int, error) {
	const maxTextLen = 25
	const costPerChar = 2
	if len(message) > maxTextLen {
		return 0, fmt.Errorf("can't send texts over %v characters", maxTextLen)
	}
	return costPerChar * len(message), nil
}
