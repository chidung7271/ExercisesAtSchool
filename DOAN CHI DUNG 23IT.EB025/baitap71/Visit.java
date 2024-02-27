package baitap71;

import java.sql.Date;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense, productExpense;

    public Visit(String name, Date date) {
        customer = new Customer(name);
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getproductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        return (serviceExpense - (serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMemberType()))) +
                (productExpense - (productExpense * DiscountRate.getProductDiscountRate(customer.getMemberType())));

    }

    @Override
    public String toString() {
        return "Visit [customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense
                + ", productExpense=" + productExpense + "]";
    }
}
