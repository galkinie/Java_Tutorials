package com.github.galkinie.javatutorials01.fluentinterface;

public class FluentInterfaceClient {
    private String name;
    private int balance;
    private boolean isActive;

    public FluentInterfaceClient(String name, int sum, boolean isActive) {
        this.name = name;
        this.balance = sum;
        this.isActive = isActive;
    }

    public FluentInterfaceClient() {

    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * @return
     */
//    public void setName(String name) {
    public FluentInterfaceClient setName(String name) {
        this.name = name;
        return this;
    }

    public int getBalance() {
        return balance;
    }

//    public void setBalance(int balance) {
    public FluentInterfaceClient setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

//    public void setActive(boolean active) {
    public FluentInterfaceClient setActive(boolean active) {
        isActive = active;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
