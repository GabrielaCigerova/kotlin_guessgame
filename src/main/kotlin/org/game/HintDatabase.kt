package org.game

val hintDatabase = mutableListOf<Hint>()
fun generateHints(){
    hintDatabase.add(Hint("Science","Pi", 3.14159265359f, "I would like some pi-e..."))
    hintDatabase.add(Hint("Science","Speed of light (m/s)", 299792458f, "Seems unbelievable!"))
    hintDatabase.add(Hint("Science","Atomic number of magnesium", 12f, "How many months in a year was too easy."))
    hintDatabase.add(Hint("Science","Distance between earth and moon (in km)", 384400f, "Almost 10x Earth's circumference, crazy."))
    hintDatabase.add(Hint("Science","Neutral pH", 7f, "It's pH of water, drink some."))
    hintDatabase.add(Hint("Nature","Altitude of Mont Blanc (in m)", 4805.59f, "If you got this exactly right, you googled it."))
    hintDatabase.add(Hint("Nature","Length of amazon river (in km)", 6400f, "It's the longest river, duh."))
    hintDatabase.add(Hint("Nature","Liters of water in 60kg human body", 36f, "Human body consists of 60% of water. In average. Drink water, you dry raisin."))
    hintDatabase.add(Hint("Nature","Number of teeth of the garden snail", 14000f, "Snails have the most teeth in animal kingdom. New definition of scary: snails."))
    hintDatabase.add(Hint("Informatics", "Year the first iPhone was released", 2007f, "The revolutionary device that changed the mobile phone industry forever."))
    hintDatabase.add(Hint("Informatics", "Number of bits in a byte", 8f, "A classic computer science trivia question."))
    hintDatabase.add(Hint("Informatics", "Approximate number of transistors in modern CPUs (in billions)", 10f, "Modern processors are marvels of miniaturization."))
    hintDatabase.add(Hint("Informatics", "Year ARPANET, the precursor to the Internet, went live", 1969f, "The birth of the internet! It all started here."))
    hintDatabase.add(Hint("Informatics", "Max storage capacity of a standard CD (in MB)", 700f, "Remember burning CDs? Feels like a lifetime ago!"))
    hintDatabase.add(Hint("Food", "Average number of seeds in a pomegranate", 613f, "Some ancient cultures believed the number of seeds had symbolic meaning!"))
    hintDatabase.add(Hint("Food", "Number of calories in a large banana", 121f, "A perfect snack, though the calories can vary by size."))
    hintDatabase.add(Hint("Food", "Approximate amount of water (in %) in a cucumber", 96f, "Cucumbers are basically water with a crunch!"))
    hintDatabase.add(Hint("Food", "Number of taste buds on the human tongue", 10000f, "Your tongue's ability to taste depends on these tiny taste receptors."))
    hintDatabase.add(Hint("Food", "World record for the most expensive pizza (in dollars)", 12000f, "Yes, $12,000 for a pizza! It had caviar, lobster, and 24k gold flakes."))
}
fun getRandomHint(): Hint? {
    if (hintDatabase.isNotEmpty()){
        val hint = hintDatabase.random()
        hintDatabase.remove(hint)
        return hint
    }
    else {
        println("No more hints available :(")
     return null
    }
}
