package pers.ej.chapter06.item30;

/**
 * 计算薪资，周一至周五工作8小时，按基本工资算，超过8小时有加班工资，双休日都按加班工资计算
 * Created by laigc on 2017/4/30.
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    /**
     * 计算薪资
     *
     * @param hoursWorked 工作时间
     * @param payRate     时薪
     * @return
     */
    double pay(double hoursWorked, double payRate) {
        // 基本工资
        double basePay = hoursWorked * payRate;

        double overTimePay; // 加班工资
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overTimePay = hoursWorked * payRate / 2;
            default:
                overTimePay = hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overTimePay;
    }
}
