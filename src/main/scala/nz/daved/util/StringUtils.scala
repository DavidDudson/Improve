package nz.daved.util

object StringUtils {

  implicit class StringImplicits(s: String) {
    def sentenceToCamelCase = splitOnWhiteSpace.map(_.capitalize).mkString
    def sentenceToUpperCamelCase = splitOnWhiteSpace.map(_.toLowerCase.capitalize).mkString
    def sentenceToLowerCamelCase = sentenceToUpperCamelCase.lowerFirstLetter
    def sentenceToSnakeCase = splitOnWhiteSpace.mkString("_")
    def sentenceToScreamingSnakeCase = sentenceToSnakeCase.toUpperCase
    def sentenceToLowerSnakeCase = sentenceToSnakeCase.toLowerCase

    def splitOnWhiteSpace: Array[String] = s.split("\\s+")
    def lowerFirstLetter = {
      val array: Array[Char] = s.toCharArray
      array(0) = array(0).toLower
      new String(array)
    }

  }
}
