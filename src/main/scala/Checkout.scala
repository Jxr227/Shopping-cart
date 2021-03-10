class Checkout(){

  private val prices: Map[String, BigDecimal] = Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  def checkout(basket: List[String]): String = {
    s"£${basket.flatMap(prices.get).sum.setScale(2)}"
  }
}