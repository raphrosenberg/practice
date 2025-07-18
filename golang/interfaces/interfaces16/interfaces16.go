package main

import "fmt"

type formatter interface {
	format() string
}

type plainText struct {
	message string
}

type bold struct {
	message string
}

type code struct {
	message string
}

func (p plainText) format() string {
	return p.message
}

func (b bold) format() string {
	return fmt.Sprintf("**%v**", b.message)
}

func (c code) format() string {
	return fmt.Sprintf("`%v`", c.message)
}

func format(f formatter) string {
	var msg string
	switch v := f.(type) {
	case plainText:
		msg = v.message
	case bold:
		msg = v.message
	case code:
		msg = v.message
	}
	return msg
}

// Don't Touch below this line

func sendMessage(format formatter) string {
	return format.format() // Adjusted to call Format without an argument
}
