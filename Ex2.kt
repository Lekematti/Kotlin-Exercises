import java.util.*

// Exercise 2

// All the code bellow, except commented code is used to play a lotto game.

/*
fun pickNumber(low: Int = 1, high: Int = 40): Int {
    return (low..high).random()
}
*/

// The function pickNDistinct() takes in three parameters,
// low, high and n, and returns a list of n distinct numbers between low and high.
fun pickNDistinct(low: Int, high: Int, n: Int): List<Int> {
    val nums = (low..high).toMutableList()
    nums.shuffle()
    return nums.subList(0, n).sorted()
}

// The function numDistinct() takes in a list and returns the number of distinct elements in the list.
fun numDistinct(list: List<Int>): Int {
    return list.toSet().size
}

// The function numCommon() takes in two lists and returns the number of common elements between them.
fun numCommon(list1: List<Int>, list2: List<Int>): Int {
    return list1.intersect(list2.toSet()).size
}

// The function readNDistinct() takes in three parameters, low, high and n, and prompts the user to input seven numbers from 1 to 40 separated by commas.
// It then checks if the input is valid (distinct, in range 1-40, total of 7 numbers) and returns it as a sorted list if it is valid.
fun readNDistinct(low: Int, high: Int, n: Int): List<Int> {
    while (true) {
        println("Give seven numbers from 1 to 40 separated by commas: ")
        val input = readLine()?.split(",")
            ?.map { it.toIntOrNull() }
            ?.filterNotNull()
            ?.filter { it in low..high }
            ?.distinct()
        if (input?.size == n) return input.sorted()
        println("Numbers must be distinct, in range $low to $high, and total of $n numbers")
    }
}

// lottoResult is a function that takes in two lists of 7 distinct integers between 1 and 40 as arguments.
// It then checks if both lists contain only 7 distinct integers between 1 and 40, and if so,
// returns the number of common elements between them. Otherwise, it returns null.
fun lottoResult(guess: List<Int>, lotto: List<Int>) =
    if (numDistinct(guess) == 7 && numDistinct(lotto) == 7 && (guess + lotto).all { it in (1..40) }) {
        numCommon(guess, lotto)
    } else {
        null
    }

// findLotto is a function that takes in a list of 7 distinct integers between 1 and 40 as an argument.
// It then generates a random list of 7 distinct integers between 1 and 40 and checks if the two lists are equal using the lottoResult function.
// If they are not equal, it will generate another random list and check again until it finds a match.
// It returns a pair containing the number of tries it took to find the correct numbers and the correct numbers themselves.
fun findLotto(lotto: List<Int>): Pair<Int, List<Int>> {
    var steps = 0
    var guess = pickNDistinct(1, 40, 7)
    while (lottoResult(guess, lotto) != 7) {
        guess = pickNDistinct(1, 40, 7)
        steps++
    }
    return Pair(steps, guess)
}

// The function playLotto() uses the above functions to generate a secret lotto combination using pickNDistinct(),
// prompt the user for their guess using readNDistinct(), check how many numbers are correct using numCommon(),
// find out how many tries it took to find the correct combination using findLotto(), and prints out the result.
fun playLotto() {
    while (true) {
        val secret = pickNDistinct(1, 40, 7)
        val guess = readNDistinct(1, 40, 7)
        val correct = numCommon(secret, guess)
        println("lotto numbers were: $secret, you got $correct correct.")
        println("Waiting for the statistics (This might take up to 2 minutes).")
        val result = findLotto(guess)
        println("It took ${result.first} tries to find all the correct lotto numbers:$secret.")
        println("More? (Y/N): ")
        if (readLine()?.uppercase(Locale.getDefault()) != "Y") return
    }
}

fun main() {
    playLotto() // starts the game

    /*println("Give seven numbers from 1 to 40")
    val sampleLotto = listOf(1,2,3,4,5,6,7)
    val result = findLotto(sampleLotto)
    println("It took ${result.first} steps to find the correct numbers: ${result.second}")*/
}
