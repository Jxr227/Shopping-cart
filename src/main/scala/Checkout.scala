class Checkout(){

  private val prices: Map[String, BigDecimal] = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )


  private val offerDeductions: List[List[String] => BigDecimal] = List(
    basket => Math.floor(basket.count(item => item.equals("Apple")) / 2.0) * prices.getOrElse[BigDecimal]("Apple", 0.0),
    basket => Math.floor(basket.count(item => item.equals("Orange")) / 3.0) * prices.getOrElse[BigDecimal]("Orange", 0.0)
  )

  def checkout(basket: List[String]): String = {
    val basketTotal = basket.flatMap(prices.get).sum
    val deductions = offerDeductions.foldRight[BigDecimal](0.0)((offer, value) => offer(basket) + value)
    s"£${(basketTotal - deductions).setScale(2)}"
  }
}