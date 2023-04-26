package org.rwaterbury.scaladev

import VarArgs.paramsToListDuplicated

import scala.collection.immutable.Seq

class VarArgsSpec extends FreeSpecStyle {
  "when it is populated directly" - {
    "it works" in {
      paramsToListDuplicated("a", "b") shouldEqual Seq("aa", "bb")
    }
  }
  "when the var args are populated from a Seq of Strings" - {
    "when the parameter is not the same name as the variable containing the sequence of Strings" - {
      "it should work" in {
        val seqOfStrings = Seq("a", "b")
        paramsToListDuplicated(seqOfStrings: _*) shouldEqual Seq("aa", "bb")
      }
    }
    "when the parameter is the same name as the variable containing the sequence of Strings" - {
      "it should work" in {
        val strings = Seq("a", "b")
        paramsToListDuplicated(strings: _*) shouldEqual Seq("aa", "bb")
      }
    }
    "when the parameter is an empty seq exploded" - {
      "it should work" in {
        val strings = Seq.empty
        paramsToListDuplicated(strings: _*) shouldEqual Seq()
      }
    }
    "when the parameter is not set" - {
      "it should work" in {
        paramsToListDuplicated() shouldEqual Seq()
      }
    }
  }
}
