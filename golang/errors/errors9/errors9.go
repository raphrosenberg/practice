package main

import (
	"errors"
)

func validateStatus(status string) error {
	var err error
	if status == "" {
		err = errors.New("status cannot be empty")
	}
	if len(status) > 140 {
		err = errors.New("status exceeds 140 characters")
	}
	return err
}
