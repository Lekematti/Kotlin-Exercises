fun main() {
    var count = 0
    var sum = 0.0
    var avg = 0.0
    var max = 0.0
    var min = 0.0

    println("Please enter a positive number, every thing else will be ignored.\nEnd the program by typing anything that contains the word quit.")
    do{
        print("Type here: ")
        val input = readLine() // reads user input
        val num = input?.toDoubleOrNull() // checks if input is double or null
        if (input != null)
            if (input.lowercase().contains("quit")) {
                break
            } else if(num != null && num >= 0){
                sum += num
                count++
                avg = sum / count
                if (min == 0.0 || num < min ) min = num
                if (max == 0.0 || num > max ) max = num
                println("average is now $avg")
            }

    } while(true)
    if (count == 0){
        println("Thank you. You gave $count numbers.")
        println("Their min is N/A ")
        println("Their max is N/A ")
        println("Their average is N/A ")
    } else{
        println("Thank you. You gave $count numbers.")
        println("Their min is $min ")
        println("Their max is $max ")
        println("Their average is $avg ")
    }
}
/*
Please enter a positive number, every thing else will be ignored.
End the program by typing anything that contains the word quit.
Type here:
Type here: hello
Type here: 1
average is now 1.0
Type here: 2
average is now 1.5
Type here: 3
average is now 2.0
Type here: Goodbye quit
Thank you. You gave 3 numbers.
Their min is 1.0
Their max is 3.0
Their average is 2.0
*/
/*
Please enter a positive number, every thing else will be ignored.
End the program by typing anything that contains the word quit.
Type here: quit
Thank you. You gave 0 numbers.
Their min is N/A
Their max is N/A
Their average is N/A
*/
