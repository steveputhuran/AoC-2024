fun main() {

    // Test input from the `src/Day00_test.txt` file:
    val testInput = readInput("Day02_test")

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day02")

    part1(input).println()
    part2(input).println()
}

private fun part1(input: List<String>): Int {
    var tot = 0
    input.forEach {
        val list = it.split(' ').map { it.toInt() }.toMutableList()
        if (flag(list)) {
            tot++
        }
    }
    return tot
}

private fun part2(input: List<String>): Int {
    var tot = 0
    input.forEach {
        val list = it.split(' ').map { it.toInt() }.toMutableList()
        for (i in 0..list.size - 1) {
            val tempList = list.toMutableList()
            tempList.removeAt(i)
            if (flag(tempList)) {
                tot++
                break
            }
        }
    }
    return tot
}

private fun flag(list: MutableList<Int>): Boolean {
    when {
        list[0] < list[1] -> {
            for (i in 0..list.size - 2) {
                if (list[i + 1] - list[i] > 3 || list[i + 1] - list[i] < 1) {
                    return false
                }
            }
        }

        list[0] > list[1] -> {
            for (i in 0..list.size - 2) {
                if (list[i] - list[i + 1] > 3 || list[i] - list[i + 1] < 1) {
                    return false
                }
            }
        }

        list[0] == list[1] -> {
            return false
        }
    }
    return true
}
