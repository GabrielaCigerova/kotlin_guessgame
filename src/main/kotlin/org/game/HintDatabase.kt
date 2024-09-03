package org.game

val hintDatabase = mutableListOf<Hint>()
fun generateHints(){
    hintDatabase.add(Hint("Science","Pi", 3.14f, "I would like some pi-e..."))
    hintDatabase.add(Hint("Science","Speed of light (m/s)", 299792458f, "Seems unbelievable!"))
    hintDatabase.add(Hint("Science","Atomic number of magnesium", 12f, "How many months in a year was too easy."))
    hintDatabase.add(Hint("Science","Distance between earth and moon (in km)", 384400f, "Almost 10x Earth's circumference, crazy."))
    hintDatabase.add(Hint("Science","Neutral pH", 7f, "It's pH of water, drink some."))
    hintDatabase.add(Hint("Nature","Altitude of Mont Blanc (in m)", 4805.59f, "If you got this exactly right, you googled it."))
    hintDatabase.add(Hint("Nature","Length of amazon river (in km)", 6400f, "It's the longest river, duh."))
    hintDatabase.add(Hint("Nature","Liters of water in 60kg human body", 36f, "Human body consists of 60% of water. In average. Drink water, you dry raisin."))
    hintDatabase.add(Hint("Nature","Number of teeth of the garden snail", 14000f, "Snails have the most teeth in animal kingdom. New definition of scary: snails."))
}
fun getRandomHint(): Hint? {
    return hintDatabase.random()
}
