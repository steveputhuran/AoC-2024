fun main() {

    // Test input from the `src/Day00_test.txt` file:
    val testInput = readInput("Day04_test")

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day04")

    part1(input).println()
    part2(input).println()
}

private fun part1(list: List<String>): Int {
    val xmas = listOf("XMAS", "SAMX")
    var tot = 0
    for (i in 0..list.size - 1) {
        for (j in 0..list[0].length - 1) {
            if (xmas.contains(
                    list[i][j].toString() + list[i].getOrNull(j + 1) + list[i].getOrNull(j + 2) + list[i].getOrNull(
                        j + 3
                    )
                )
            ) tot++
            if (xmas.contains(
                    list[i][j].toString() + list.getOrNull(i + 1)?.getOrNull(j) + list.getOrNull(i + 2)
                        ?.getOrNull(j) + list.getOrNull(i + 3)?.getOrNull(j)
                )
            ) tot++
            if (xmas.contains(
                    list[i][j].toString() + list.getOrNull(i + 1)?.getOrNull(j + 1) + list.getOrNull(i + 2)
                        ?.getOrNull(j + 2) + list.getOrNull(i + 3)?.getOrNull(j + 3)
                )
            ) tot++
            if (xmas.contains(
                    list[i].getOrNull(j + 3).toString() + list.getOrNull(i + 1)
                        ?.getOrNull(j + 2) + list.getOrNull(i + 2)?.getOrNull(j + 1) + list.getOrNull(i + 3)
                        ?.getOrNull(j)
                )
            ) tot++
        }
    }
    return tot
}

private fun part2(list: List<String>): Int {
    val xmas = listOf("MMASS", "MSAMS", "SSAMM", "SMASM")
    var tot = 0
    for (i in 0..list.size - 1) {
        for (j in 0..list[0].length - 1) {
            if (xmas.contains(
                    list[i][j].toString() + list.getOrNull(i)?.getOrNull(j + 2) + list.getOrNull(i + 1)
                        ?.getOrNull(j + 1) + list.getOrNull(i + 2)?.getOrNull(j) + list.getOrNull(i + 2)
                        ?.getOrNull(j + 2)
                )
            ) tot++
        }
    }
    return tot
}