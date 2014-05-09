package net.mcarolan

import org.scalacheck._

object Generators {

  val palindromeGen =
    for {
      identifier <- Gen.identifier
    }
      yield identifier + identifier.reverse

  val palindromeListGen = Gen.containerOf[List, String](palindromeGen)

}
