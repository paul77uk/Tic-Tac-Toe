import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    // put your code here
    val scanner = input.nextLine()

    val x = mutableListOf<Char>()
    val y = mutableListOf<Char>()

    for (i in '1'..'5') {
        if (scanner[0] == i || scanner[4] == i || scanner[8] == i) {
            continue
        }
        x.add(i)
        x.add(' ')
    }

    x.removeAt(x.lastIndex)

    for (i in '1'..'5') {
        if (scanner[2] == i || scanner[6] == i || scanner[10] == i) {
            continue
        }
        y.add(i)
        y.add(' ')
    }

    y.removeAt(y.lastIndex)

    for (i in x) {
        print(i)
    }

    println()

    for (i in y) {
        print(i)
    }

}
