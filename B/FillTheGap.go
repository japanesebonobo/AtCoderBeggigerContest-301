package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
)

var sc *bufio.Scanner

func readInt() int {
	sc.Scan()
	i, _ := strconv.Atoi(sc.Text())
	return i
}

func run(stdin io.Reader, out io.Writer) {
	sc = bufio.NewScanner(stdin)
	sc.Split(bufio.ScanWords)

	var N int
	N = readInt()
	C := make([]int, N)
	for i := range C {
		C[i] = readInt()
	}

	for i := 0; i < len(C)-1; i++ {
		if int(math.Abs(float64(C[i]-C[i+1]))) != 1 {
			C = insert(C[i], C[i+1], C, i)
		}
	}
	for i := 0; i < len(C); i++ {
		fmt.Println(C[i])
	}
}

func main() {
	run(os.Stdin, os.Stdout)
}

func insert(first int, second int, C []int, firstIndex int) []int {
	head := make([]int, firstIndex+1)
	copy(head, C)
	tail := make([]int, len(C)-(firstIndex+1))
	copy(tail, C[firstIndex+1:])
	if first < second {
		var plus int = second - first - 1
		mid := make([]int, plus)
		for i := 0; i < plus; i++ {
			if first+(i+1) == second {
				break
			}
			mid[i] = first + (i + 1)
		}
		head = append(head, mid...)
		head = append(head, tail...)

	} else if first > second {
		var minus int = first - second - 1
		mid := make([]int, minus)
		for i := 0; i < minus; i++ {
			if first-(i+1) == second {
				break
			}
			mid[i] = first - (i + 1)
		}
		head = append(head, mid...)
		head = append(head, tail...)
	}
	return head
}
