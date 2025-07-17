package main

import "fmt"

func (e email) cost() int {
	var cost int
	if e.isSubscribed {
		cost = 2
	} else {
		cost = 5
	}
	return len(e.body) * cost
}

func (e email) format() string {
	var sub_status string
	content := e.body
	if e.isSubscribed {
		sub_status = "Subscribed"
	} else {
		sub_status = "Not Subscribed"
	}

	return fmt.Sprintf("'%v' | %v", content, sub_status)
}

type expense interface {
	cost() int
}

type formatter interface {
	format() string
}

type email struct {
	isSubscribed bool
	body         string
}
