package main

import (
	"fmt"
	"strings"
)

func main() {
	var N int
	var S string
	fmt.Scan(&N, &S)

	s := strings.Split(S, "")

	var takahashi int = 0
	var aoki int = 0
	for i := 0; i < N; i++ {
		if s[i] == "T" {
			takahashi++
		}
		if s[i] == "A" {
			aoki++
		}
	}

	if takahashi == aoki {
		if s[N-1] == "T" {
			fmt.Println("A")
		} else if s[N-1] == "A" {
			fmt.Println("T")
		}
	} else if takahashi > aoki {
		fmt.Println("T")
	} else if aoki > takahashi {
		fmt.Println("A")
	}
}
