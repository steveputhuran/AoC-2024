fun main() {

    // Test input from the `src/Day00_test.txt` file:
    val testInput = readInput("Day03_test")

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day03")

    val sequence = input.joinToString("") { it }

    part1(sequence).println()
    part2(sequence).println()
}

private fun part1(sequence: String): Int {
    val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val seq = regex.findAll(sequence)
    var tot = 0
    seq.forEach {
        val (x, y) = it.value.split(',')
        val a = x.filter { it.isDigit() }.toInt()
        val b = y.filter { it.isDigit() }.toInt()
        tot += a * b
    }
    return tot
}

private fun part2(sequence: String): Int {
    val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val list = sequence.split("don't()")
    var sent:String = list[0]
    list.forEach {
        if (it.contains("do()") && it != list[0]) {
            sent += it.substringAfter("do()")
        }
    }
    val seq = regex.findAll(sent)
    var tot = 0
    seq.forEach {
        val (x, y) = it.value.split(',')
        val a = x.filter { it.isDigit() }.toInt()
        val b = y.filter { it.isDigit() }.toInt()
        tot += a*b
    }
    return tot
}