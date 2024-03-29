package ru.dust.self

object Gloss {

  val GLOSS_HZ: Map[Char, Int] = Map(
    'т' -> 2,//39,
    'и' -> 1,//30,
    'о' -> 4,//26,
    'с' -> 3,//24,
    'п' -> 5,//23,
    'а' -> 6,//21,
    'ь' -> 12,//20,
    'е' -> 8,//18,
    'х' -> 9,//17,
    'д' -> 10,//16,
    'у' -> 11,//16,
    'м' -> 7,//16,
    'ё' -> 13,//15,
    'ц' -> 15,//15,
    'я' -> 14,//14,
    'н' -> 16,//14,
    'з' -> 23,//14,
    'й' -> 18,//13,
    'г' -> 19,//13,
    'ш' -> 20,//13,
    'л' -> 17,//13,
    'ы' -> 22,//13,
    'ф' -> 21,//12,
    'щ' -> 24,//12,
    'ч' -> 25,//11,
    'ж' -> 26,//10,
    'в' -> 27,//9,
    'б' -> 28,//9,
    'ъ' -> 29,//8,
    'р' -> 30,//8,
    'к' -> 31,//6,
    'э' -> 32,//4,
    'ю' -> 33,//4
    ',' -> 101,
    '.' -> 102,
    '!' -> 103,
    '?' -> 104,
    '-' -> 105,
    ' ' -> 40
  )

//  val GLOSS_HZ: Map[Char, Int] = Map(
//  'т' -> 1,//39,
//  'и' -> 2,//30,
//  'о' -> 3,//26,
//  'с' -> 4,//24,
//  'п' -> 5,//23,
//  'а' -> 6,//21,
//  'ь' -> 7,//20,
//  'е' -> 8,//18,
//  'х' -> 9,//17,
//  'д' -> 10,//16,
//  'у' -> 11,//16,
//  'м' -> 12,//16,
//  'ё' -> 13,//15,
//  'ц' -> 14,//15,
//  'я' -> 15,//14,
//  'н' -> 16,//14,
//  'з' -> 17,//14,
//  'й' -> 18,//13,
//  'г' -> 19,//13,
//  'ш' -> 20,//13,
//  'л' -> 21,//13,
//  'ы' -> 22,//13,
//  'ф' -> 23,//12,
//  'щ' -> 24,//12,
//  'ч' -> 25,//11,
//  'ж' -> 26,//10,
//  'в' -> 27,//9,
//  'б' -> 28,//9,
//  'ъ' -> 29,//8,
//  'р' -> 30,//8,
//  'к' -> 31,//6,
//  'э' -> 32,//4,
//  'ю' -> 33,//4
//  ',' -> 101,
//  '.' -> 102,
//  '!' -> 103,
//  '?' -> 104,
//    '-' -> 105,
//    ' ' -> 40
//  )

  def brutTranslate(str: String): String = {
    var res: Array[String] = Array()
    for (i <- 0 to chars.length) {
      var tmpChars: Array[Char] = chars.tail :+ chars.head

    }
    ""
  }

  val chars: Array[Char] = Array(
    'о',
    'е',
    'а',
    'и',
    'н',
    'т',
    'с',
    'р',
    'в',
    'л',
    'к',
    'м',
    'д',
    'п',
    'у',
    'я',
    'ы',
    'ь',
    'г',
    'з',
    'б',
    'ч',
    'й',
    'х',
    'ж',
    'ш',
    'ю',
    'ц',
    'щ',
    'э',
    'ф',
    'ъ',
    'ё')

}
