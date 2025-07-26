package main

type cost struct {
	day   int
	value float64
}

func getDayCosts(costs []cost, day int) []float64 {
	totalCost := make([]float64, 0)
	for i := 0; i < len(costs); i++ {
		if costs[i].day == day {
			totalCost = append(totalCost, costs[i].value)
		}
	}
	return totalCost
}
