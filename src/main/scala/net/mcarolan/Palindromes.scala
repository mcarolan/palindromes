package net.mcarolan

object Palindromes extends App {

  type PalindromeLength = Int
  type PalindromeOffset = Int

  private[this] def isPalindrome(s: String) = s == s.reverse

  def getLongestSubPalindromes(s: String, n: Int): Seq[(String, PalindromeLength, PalindromeOffset)] = {
    def palindromesFromPosition(startAt: Int) = {
      val subStringsFromPosition = (startAt + 2 to s.length).map(s.substring(startAt, _))

      for {
        p <- subStringsFromPosition if isPalindrome(p)
      }
        yield (p, p.length, startAt)
    }

    val allPalindromes = (0 until s.length - 1).flatMap(palindromesFromPosition)
    allPalindromes.sortBy(- _._2) take n
  }

  println("Hello, palindromes")
}
