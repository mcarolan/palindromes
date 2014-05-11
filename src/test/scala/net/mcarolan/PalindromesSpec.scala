package net.mcarolan

import org.specs2.{ScalaCheck, Specification}
import org.scalacheck.Prop._

case class PalindromesSpec() extends Specification with ScalaCheck {

  import Generators._
  import Palindromes.SubPalindromeResult

  def is = s2"""Palindromes
    Longest palindrome of a palindrome should be itself        $longestPalindromeOfPalindrome
    Example 1  - sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop                                                $example1
             """

  def longestPalindromeOfPalindrome = forAllNoShrink(palindromeGen) { palindrome =>
    SubPalindromeResult(palindrome, 0, palindrome.length) must be_==(Palindromes.getLongestSubPalindromes(palindrome, 1).head)
  }

  def example1 = 
    Vector(SubPalindromeResult("hijkllkjih", 23, 10), SubPalindromeResult("defggfed", 13, 8), SubPalindromeResult("ijkllkji", 24, 8)) must be_==(Palindromes.getLongestSubPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop", 3))

}
