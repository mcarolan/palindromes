package net.mcarolan

object Palindromes extends App {

  type PalindromeLength = Int
  type PalindromeOffset = Int

  private[this] def isPalindrome(s: String) = s == s.reverse

  case class SubPalindromeResult(palindrome: String, index: Int, length: Int) {
    override def toString = s"Text: $palindrome, Index: $index, Length: $length"
  }

  def getLongestSubPalindromes(s: String, n: Int): Seq[SubPalindromeResult] = {
    def palindromesFromPosition(startAt: Int) = {
      val subStringsFromPosition = (startAt + 2 to s.length).map(s.substring(startAt, _))

      for {
        p <- subStringsFromPosition if isPalindrome(p)
      }
        yield SubPalindromeResult(p, startAt, p.length)
    }

    val allPalindromes = (0 until s.length).flatMap(palindromesFromPosition)
    allPalindromes sortBy(- _.length) take n
  }

  val argsMap = args.zipWithIndex.map(_.swap).toMap

  val input = argsMap.getOrElse(0, "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop")
  val numberToReturn = argsMap.getOrElse(1, "3").toInt

  println(getLongestSubPalindromes(input, numberToReturn).mkString("\n"))
}
