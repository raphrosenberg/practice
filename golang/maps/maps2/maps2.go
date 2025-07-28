package main

import "errors"

func deleteIfNecessary(users map[string]user, name string) (deleted bool, err error) {
	//for _, u := range users {
	_, ok := users[name]
	if !ok {
		err = errors.New("not found")
	}
	if !users[name].scheduledForDeletion {
		deleted = false
	}
	if users[name].scheduledForDeletion {
		deleted = true
		delete(users, users[name].name)
	}
	//}
	return deleted, err
}

type user struct {
	name                 string
	number               int
	scheduledForDeletion bool
}
