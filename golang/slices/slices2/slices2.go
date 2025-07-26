package main

import (
	"errors"
)

const (
	planFree = "free"
	planPro  = "pro"
)

func getMessageWithRetriesForPlan(plan string, messages [3]string) ([]string, error) {
	var allowedMessages []string
	var err error
	switch plan {
	case planPro:
		allowedMessages = messages[:]
		err = nil
	case planFree:
		allowedMessages = messages[0:2]
		err = nil
	default:
		allowedMessages = nil
		err = errors.New("unsupported plan")
	}

	return allowedMessages, err
}
