import kotlin.math.abs

fun main() {

    // Test input from the `src/Day00_test.txt` file:
    val testInput = readInput("Day01_test")

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day01")

    val (list1, list2) = input.map {  it.split("   ").map { it.toInt() } }

    part1(list1.sorted(), list2.sorted()).println()
    part2(list1.groupingBy { it }.eachCount(), list2.groupingBy { it }.eachCount()).println()
}

private fun part1(list1: List<Int>, list2: List<Int>): Int {
    var tot: Int = 0
    for (i in 0..list1.size - 1) {
        abs(list1[i] - list2[i])
    }
    return tot
}

private fun part2(map1: Map<Int, Int>, map2: Map<Int, Int>): Int {
    var tot = 0
    for (i in 0..map1.size - 1) {
        tot += map1.keys.elementAt(i) * (map2[map1.keys.elementAt(i)] ?: 0)
    }
    return tot
}
