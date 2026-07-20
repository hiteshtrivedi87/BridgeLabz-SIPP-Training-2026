interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.startsWith("SAVE") || code.startsWith("OFF");
    }
}

public class CouponSystem {
    public static void main(String[] args) {
        String[] coupons = {"SAVE50", "PROMO", "OFF20", "S", "WELCOME100", "INVALID"};
        ShoppingCart cart = new ShoppingCart();

        System.out.println("=== Coupon Validation Results ===");
        for (String code : coupons) {
            boolean isValid = cart.validateCoupon(code);
            System.out.println("Coupon: " + code + " -> " + (isValid ? "VALID" : "INVALID"));
        }
    }
}