package pers.ej.chapter06.item30;

/**
 * 将加班工资计算移到一个私有的嵌套枚举中，将这个策略枚举的实例传到PayrollDay枚举的构造器中。
 * 之后PayrollDay枚举就加加班工资的计算委托给策略枚举了。
 * Created by laigc on 2017/4/30.
 */
public enum PayrollDay2 {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay2(PayType payType) {
        this.payType = payType;
    }


    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    // 私有嵌套枚举
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;

            }
        }, WEEKEND {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hours, double payRate);

        double pay(double hoursWorked, double payRate) {
            // 基本工资
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
