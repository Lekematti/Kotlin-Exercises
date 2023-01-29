class CoffeeMaker(val coffeeCapacity: Int = 50, val waterCapacity: Int = 150){

    // 'coffeeAmount' is private and can only be read from inside the class
    var coffeeAmount = 0
        private set

    //'waterAmount' is private and can only be read from inside the class
    var waterAmount = 0
        private set

    //'isOn' is mutable and can be read and written from outside the class
    var isOn: Boolean = false
        set(value) {
            field = value
        }

    // Private function to check if there's enough coffee and water to make a drink
    private fun hasEnoughCoffeeAndWater(coffee: Int, water: Int): Boolean {
        // Return true if the coffee maker is on and there's enough coffee and water, otherwise return false
        return isOn && coffeeAmount >= coffee && waterAmount >= water
    }

    // Method to make a double espresso
    fun makeDoubleEspresso() {
        // Check if there's enough coffee and water to make a double espresso
        if (hasEnoughCoffeeAndWater(16, 30)) {
            // Decrease the amount of coffee and water
            coffeeAmount -= 16
            waterAmount -= 30
            // Print a message indicating the coffee was made
            println("made coffee with 16 - 30")
        } else {
            // If there's not enough coffee and water, print a message indicating the state of the coffee maker
            println("coffeemaker is $state with $coffeeAmount coffee and $waterAmount water")
        }
    }

    // Method to make regular coffee
    fun makeRegular() {
        if (hasEnoughCoffeeAndWater(10, 120)) {
            coffeeAmount -= 10
            waterAmount -= 120
            println("made coffee with 10 - 120")
        } else {
            println("coffeemaker is $state with $coffeeAmount coffee and $waterAmount water")
        }
    }

    // Method to fill the coffee and water to their maximum capacity
    fun fillAll() {
        coffeeAmount = coffeeCapacity
        waterAmount = waterCapacity
    }

    // Private property to get the state of the coffee maker, either "on" or "off"
    private val state: String
        get() = if (isOn) "on" else "off"


    // Override the toString method to output the state of the coffee maker
    override fun toString(): String {
        return "coffeemaker is $state with $coffeeAmount coffee and $waterAmount water"
    }
}

//Example main function:
fun main() {
    val cm = CoffeeMaker()
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.isOn = true
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.fillAll()
    println(cm)
    cm.makeRegular()
    println(cm)
    cm.makeDoubleEspresso()
    println(cm)
    cm.makeDoubleEspresso()
    println(cm)
}

/*Produces this output:

coffeemaker is off with 0 coffee and 0 water
coffeemaker is off with 0 coffee and 0 water
coffeemaker is on with 0 coffee and 0 water
coffeemaker is on with 0 coffee and 0 water
coffeemaker is on with 50 coffee and 150 water
made coffee with 10 - 120
coffeemaker is on with 40 coffee and 30 water
made coffee with 16 - 30
coffeemaker is on with 24 coffee and 0 water
coffeemaker is on with 24 coffee and 0 water*/



/*Create a CoffeeMaker class. The class has properties coffeeCapacity and
waterCapacity which can be given values when constructing an instance of CoffeeMaker.
These properties never change during the existence of a CoffeeMaker instance.
If no values are given, default values 50 and 150 should be used.

CoffeeMaker has also three properties whose values may change during the lifetime of the CoffeeMaker instance:
coffeeAmount, waterAmount, and isOn. It should be possible to read and assign the value of isOn outside the class,
but coffeeAmount and waterAmount can only be read from outside.

CoffeeMaker should have three methods: makeDoubleEspresso which uses 16 units of coffee and 30 units of water,
makeRegular which uses 10 units of coffee and 120 units of water, and fillAll that tops up the coffee and water amounts to their maximums.
If the amount of coffee and water is not enough for an espresso or regular coffee,
the make-methods should not change the state of the coffee machine at all.
Consider using a private method to avoid duplicating code and remember to take into account whether the maker is on or not.
Also, override toString method and make it output the CoffeeMaker state
