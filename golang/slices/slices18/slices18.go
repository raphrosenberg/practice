package main

func isValidPassword(password string) bool {
	// >=5 <=12 chars
	// >1 uppercase char
	// >1 digit
	hasUpper := false
	hasDigit := false

	if len(password) < 5 || len(password) > 12 {
		return false
	}

	for _, c := range password {
		if c >= 65 && c <= 90 {
			hasUpper = true
		}
		if c >= 48 && c <= 57 {
			hasDigit = true
		}
	}
	if hasDigit && hasUpper {
		return true
	} else {
		return false
	}

}
