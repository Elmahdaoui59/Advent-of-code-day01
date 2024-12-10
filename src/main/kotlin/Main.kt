package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.absoluteValue


fun main() {

    val input = readInput("day01.txt")
    val (left, right) = input.map { it: String ->
        val first: Int = it.substringBefore(" ").toInt()
        val second: Int = it.substringAfterLast(" ").toInt()
        first to second
    }.unzip()
    val distancesSum = left.sorted().zip(right.sorted()).map { it: Pair<Int, Int> ->
        (it.first - it.second).absoluteValue
    }.sum()
    println(distancesSum)
    val similarityScore = left.sumOf { l: Int ->
        val count = right.count { it == l }
        l * count
    }
    println(similarityScore)

}
fun readInput(fileName: String): List<String> {
    return Path("/Users/abdelghani/Downloads/$fileName").readLines()
}