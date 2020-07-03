import kotlin.random.Random

/**
 * 大文字アルファベット
 */
const val UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

/**
 * 小文字アルファベット
 */
const val LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz"

/**
 * 数字
 */
const val NUMBER = "0123456789"

/**
 * ランダムな文字列を生成
 *
 * @param length 文字列の長さ
 * @param symbols 文字列のバリエーション
 * @return ランダムな文字列
 */
fun Random.nextString(
    length: Int,
    vararg symbols: String = arrayOf(UPPER_ALPHABET, LOWER_ALPHABET, NUMBER)
): String {
    var randomString = ""
    val symbolString = symbols.joinToString(separator = "")
    for (i in 0 until length) {
        randomString += symbolString[nextInt(symbolString.count())]
    }
    return randomString
}