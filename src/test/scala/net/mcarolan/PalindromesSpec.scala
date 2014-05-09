package net.mcarolan

import org.specs2.{ScalaCheck, Specification}
import org.scalacheck.Prop._

case class PalindromesSpec() extends Specification with ScalaCheck {

  import Generators._

  def is = s2"""Palindromes
    Longest palindrome of a palindrome should be itself        $longestPalindromeOfPalindrome
    Example 1                                                  $example1
             """

  def longestPalindromeOfPalindrome = forAllNoShrink(palindromeGen) { palindrome =>
    (palindrome, palindrome.length, 0) must be_==(Palindromes.getLongestSubPalindromes(palindrome, 1).head)
  }

}
