fun main() {
    print(
        "Выберите 1 из 6 задач: ".trimIndent()
    )
    when (readln()) {
        "1" -> {
            print("Задача №1: На вход функция принимает строку и возвращает количество подряд идущих одинаковых символов во введенной строке. ")
            print("Введите строку: ")
            println("Количество подряд идущих одинаковых символов во введенной строке: " + zadacha1(readln()))
        }
        "2" -> {
            print("Задача №2: На вход функция принимает строку и возвращает количество различных символов во введенной строке в алфавитном порядке. ")
            print("Введите строку: ")
            println("Количество различных символов во введенной строке в алфавитном порядке: " + zadacha2(readln()))
        }
        "3" -> {
            print("Задача №3: на вход функция принимает число в десятичной системе и возвращает это число в двоичной системе. ")
            print("Введите число: ")
            println("Число в двоичной системе: " + zadacha3(readln().toInt()))
        }
        "4" -> {
            print("Задача №4: На вход функция принимает строку с математическим примером и возвращает результат вычисления. ")
            print("Введите математический пример: ")
            println("Результат вычисления: " + zadacha4(readln()))
        }
        "5" -> {
            print("Задача №5: На вход функция принимает строку, содержащую два числа, n и x, разделенныые пробелом и возвращает показатель степени для которого выполняется равенство x^y = n, если он есть. Иначе - сообщение об ошибке. ")
            print("Введите два числа через пробел: ")
            println("Показатель степени: " + zadacha5(readln()))
        }
        "6" -> {
            print("Задача №6: На вход функция принимает два числа и возвращает созданные из них нечетные числа, если возможно. Иначе - сообщение об ошибке. ")
            print("Введите первое число: ")
            val str1 = readln()
            print("Введите второе число: ")
            val str2 = readln()
            println("Нечетные числа, созданные из двух чисел: " + zadacha6(str1, str2))
        } } }

fun zadacha1(string: String): String {
    var res = ""
    var counter = 1
    var s = string[0]
    for (item in string.substring(1)) {
        if (s != item) {
            if (counter > 1) {
                res += "$s$counter"
            } else {
                res += s
            }
            counter = 1
            s = item
        } else {
            counter++
        } }
    if (counter > 1) {
        res += "$s$counter"
    } else {
        res += s
    }
    return res }

fun zadacha2(string: String): String {
    var res = ""
    val charCount = mutableMapOf<Char, Int>()
    string.forEach { char ->
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }
    charCount.toSortedMap().forEach { (char, count) ->
        res += "$char - $count\n"
    }
    return res }

fun zadacha3(d: Int): Int {
    var d = d
    var bin = 0
    var rank = 1
    var mod: Int
    while (d > 0) {
        mod = d % 2
        d /= 2
        bin += mod * rank
        rank *= 10
    }
    return bin }

fun zadacha4(string: String): Float {
    var num1Str = ""
    var num2Str = ""
    var op = ' '
    var isNum1 = true

    for (char in string.replace(" ", "")) {
        if (char.isDigit() || char == '.') {
            if (isNum1) {
                num1Str += char
            } else {
                num2Str += char
            }
        } else if (char in setOf('+', '-', '*', '/')) {
            op = char
            isNum1 = false
        } }

    val num1 = num1Str.toFloat()
    val num2 = num2Str.toFloat()

    return when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> num1 / num2
        else -> 0.0f
    } }

fun zadacha5(string: String): Any {
    var xStr = ""
    var nStr = ""
    for (char in string) {
        if (char != ' ' && nStr == "") {
            xStr += char
        } else {
            nStr += char
        } }
    val n = nStr.replace(" ", "").toInt()
    val x = xStr.toInt()

    if (x <= 0 || n <= 0) {
        return "Основание степени и число должны быть положительными!"
    }

    var y = 0
    var power = 1
    while (power <= n) {
        if (power == n) {
            return y
        }
        y++
        power *= x
    }
    return "Целочисленного показателя не существует!" }

fun zadacha6(a: String, b: String): String {
    var str1: String? = null
    var str2: String? = null
    if ("$a$b".toInt() % 2 != 0) {
        str1 = "$a$b"
    }
    if ("$b$a".toInt() % 2 != 0) {
        str2 = "$b$a"
    }
    var res = ""
    if (str1 == null && str2 == null) return "Создать нечетное число невозможно!"
    if (str1 != null) res += str1
    if (str2 != null) {
        if (str1 != null) res += " "
        res += str2
    }
    return res }