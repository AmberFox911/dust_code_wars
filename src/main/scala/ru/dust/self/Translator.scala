package ru.dust.self

import Const.RUS_CHAR_HZ
import ScaredRoom.ROOM_HZ
import Knowledge.KNOW_HZ

object Translator {

  val data: Array[String] = Array("Цёятчко бат ябщче атд фыцчео",
    "Пеб фббулч ыячче эмэбч-аыуёцо ъфтйчаыч",
    "Дчяс унюб вбдчсаб",
    "Бат детфбфыедс дтябефчгчаабь ф пебя иыэюч",
    "Пеб ач фтя гчктео",
    "Ен вгтфт Ян фтуюрцтечюы",
    "Цтфть фячдеч вбдябегыя этэ бат дюбятчедс",
    "Дючцерлыь дютьц ябь юруыянь",
    "Ы ябь ебщч ",
    "Этцг ыъ юейкыз цачь",
    "Дютфодс",
    "Тз этэ йецчдаб унэо ябюбцбь",
    "Бат эгтдыфчч фбхцт дыцые ф эгчдюч",
    "Ен етэтс ыъфгтлчаэт")

  val data2: Array[String] = Array("тсйгоцмфхгб рзх",
  "прз"  ,
  "ругелхфв"  ,
  "ахс хсоянс ргъгос. жгояыз дцжзх хсоянс шцйз"  ,
  "рз фпсхул рг ахс ргтувпцб. рз фпсхул рг ахс ессдьз."  ,
  "зес уцнл - чгояыленг. зес еогкг - чгояыленг. жсезувм хсоянс феслп фсдфхезррюп"  ,
  "дсег рзх. дсе цпзу. сфхголфя чсоянс пю"  ,
  "ам. ам. тсфпсхул рг пзрв. хю жсезувзыя прз? хю ескяпзыя пзрв кг уцнц? хю дцжзыя фоцыгчя пзрв, жгйз зфол фспрзегзыяфв? тсйгоцмфхг. тсйгоцмфхг. ам",
  "фнгйл ъхс-рлдцжя. фнгйл ъчс-рлдцжя.")

  val data3: Array[String] = Array("вбйчяё ё ябчхб цгёхтс жбгят", "С ач вбфыятр", "Ябч ечюб дегтааб дчус блелтче",
    "Яат дегткаб", "Ябщаб с вбьце цбябь", "йеб с цбющчя цчютео", "с вгбдеб збйё йебун пеб вгчэгтеыюбдо")

  val bonusData: Array[String] = Array("схфхцтлфя")

  val goodNightData: Array[String] = Array("эьетъб пяу сьщфыь эюцецымфй фншбл оьщй")

  val jonData: Array[String] = Array("тжт ыта ыта ыта ыта ыта ыта", "ыт эюц ытч", "ыт юныйёт, етъ ьын")

  val glossData: Array[String] = Array("ЫЕЗУШЦОЧНЯО ШТСБД"
    ,"АЫ ЁМВЁФТША ПХ РНТ ПИХЛЗ ТТМ, ЛЕ СИМ М ПТХЪЫИЩ ТИЁЛ САОЛВИЖЦЬ?"
    ,"СУРУЛЬЬ, КТТ ФЧМБЩИЛНЩ ЦЕОЯ ОУ УСЕ?"
    ,"ЭОЁЙЧИЯЬ, ЗНЩГ"
    ,"ЭОЖХЪЛИЯЬ Ё УЗЮЯАИГ ЧХЖО, ШОРШ ФИ ПЮИСЕКПЕФИЬБ"
    ,"ЫЕХН ЗФЕЪЯ! СЙШМ ЕРО ЦДНИСАЬ!"
    ,"ЭОЫШИХТПУН, ПЖО ЕРО ЖШШЦАМ, ЛМФСДЯ ЯПИХУД КНПДЙЩ МЗ АВТЙР УИХДЯ! ФХЫУПСЦЖЪН СЩЕЗ, ПХЦОЮЫН УФД ОЯТДЖТГЕА!"
    ,"АОПБСТ ТЬГЗЕ Ё ЕУСУ ПГЗМТЙ ТИЁЁ"
    ,"АОПБСТТЬГЗЕ ЩЁОЦ УХНТМЯ ОУЗШЩ ЫТЬ-ТТ МФДЧЦТА"
    ,"АЫ ЫШИХТПУИЭГ БТЬ, ДМЧЁ?"
    ,"ЪОВ ТЛСАЯЫЦТЪВ ПЬХТЧГ?"
    ,"ЫЕФЖВ Ё ТПОИО ИЧЛЁВИ ФЧВТ, ШАО ЪХФ ЦЦКДИ?"
    ,"ЮАЛИИМНЙ ИЩ, ЫЩТБИ ОС СХЖ ВЬЙЦН! ХЦДНЙ ИСЪ ЁСЛ СИЁЁ!"
    ,"АОПБСТ ТЬГЗЕ ЩА ПЬЙРЙЯА, ДЦТГ"
    ,"АОПБСТ ТЬГЗЕ ЩА ПЬЙРЙЯА, ПЬЧИСЬ Г МЬГЧ ЛКДТЙ ТДП, СДК М ЖЗШ")

  def main(args: Array[String]): Unit = {
    val res1: Map[Char, Int] = hzNum(charCounts(true, data:_*))

    val chCounts: Map[Char, Int] = charCounts(false, glossData:_*)

    println(translateGloss(glossData))

  }

  def caesarMove(str: String): String = {
    str.map(ch => ch match {
      case 'Я' => 'А'
      case 'я' => 'а'
      case ' ' => ' '
      case ',' => ','
      case '?' => '?'
      case '.' => '.'
      case '!' => '!'
      case '-' => '-'
      case _ => (ch.toInt + 1).toChar
    })
  }

  def charCounts(unique: Boolean, str: String*): Map[Char, Int] = {
    val inputData: String =
      if (unique) str.mkString(" ").split(" ").distinct.mkString(" ")
      else str.mkString(" ")

    inputData
      .toLowerCase
      .groupMapReduce(ch => ch)(ch => 1)(_ + _)
  }

  def hzNum(chMap: Map[Char, Int]): Map[Char, Int] = {
    var cnt: Int = 0
    chMap
      .map(pair => s"${pair._1} -> ${pair._2}")
      .toArray
      .sortBy(_.split(" -> ").last.toInt).reverse
      .filter(str => !str.startsWith(" ") && !str.startsWith("-"))
      .map(ch => {cnt += 1; (ch.split(" -> ").head.head, cnt)}).toMap
  }

  def translateRoom(inData: Array[String]): String = {
    inData.mkString(" ").toLowerCase.map(ch => RUS_CHAR_HZ(ROOM_HZ.getOrElse(ch, 100)))
  }

  def translateKnow(inData: Array[String]): String = {
    inData.mkString(" ").toLowerCase.map(ch => RUS_CHAR_HZ(KNOW_HZ.getOrElse(ch, 100)))
  }

  def translateGloss(inData: Array[String]): String = {
    inData.mkString("     ").toLowerCase.map(ch => RUS_CHAR_HZ(Gloss.GLOSS_HZ.getOrElse(ch, 100)))
  }

}
