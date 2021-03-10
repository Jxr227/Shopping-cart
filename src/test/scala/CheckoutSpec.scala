import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class CheckoutSpec extends AnyWordSpec with should.Matchers{

  val checkout = new Checkout()

  "checkout()" should {

    "return £0.00 for an empty basket" in {
      val result = checkout.checkout(List())

      result should be("£0.00")
    }

    "return £0.60 for a basket containing only an apple" in {
      val result = checkout.checkout(List("Apple"))

      result should be("£0.60")
    }

    "return £0.25 for a basket containing only an orange" in {
      val result = checkout.checkout(List("Orange"))

      result should be("£0.25")
    }

    "return £0.85 for a basket containing an orange and an apple" in {
      val result = checkout.checkout(List("Orange", "Apple"))

      result should be("£0.85")
    }

    "return £1.20 for a basket containing two apples" in {
      val result = checkout.checkout(List("Apple", "Apple"))

      result should be("£1.20")
    }

    "return £0.50 for a basket containing two oranges" in {
      val result = checkout.checkout(List("Orange", "Orange"))

      result should be("£0.50")
    }

    "return £60.00 for a basket containing 100 apples" in {
      val result = checkout.checkout(List.fill(100)("Apple"))

      result should be("£60.00")
    }

    "return £25.00 for a basket containing 100 oranges" in {
      val result = checkout.checkout(List.fill(100)("Orange"))

      result should be("£25.00")
    }

  }
}
