package main

func createMatrix(rows, cols int) [][]int {
	matrix := make([][]int, rows)

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			matrix[i] = append(matrix[i], i*j)
		}
	}
	return matrix
}
