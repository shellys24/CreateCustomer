package part3.factorymethod;

interface Customer {
    void type();

    void typeCreated();
}

class StandardCustomer implements Customer {

    public void typeCreated() {

        System.out.println("Creating Standard Customer...");
    }

    public void type() {

        System.out.println("**Customer**::StandardCustomer");
    }
}

class PreferredCustomer implements Customer {
    public void typeCreated() {

        System.out.println("Creating Preferred Customer...");
    }

    public void type() {

        System.out.println("**Customer**::PreferredCustomer");
    }
}

class BusinessCustomer implements Customer {
    public void typeCreated() {
        System.out.println("Creating Business Customer...");
    }

    public void type() {
        System.out.println("**Customer**::BusinessCustomer");

    }
}

abstract class CustomerFactory {

    public abstract Customer createCustomer();
}

class StandardCustomerFactory extends CustomerFactory {
    public Customer createCustomer() {
        //Creating a standard customer
        return new StandardCustomer();
    }
}

class PreferredCustomerFactory extends CustomerFactory {
    public Customer createCustomer() {
        //creating a preferred customer
        return new PreferredCustomer();
    }
}

class BusinessCustomerFactory extends CustomerFactory {
    public Customer createCustomer() {
        //creating a business customer
        return new BusinessCustomer();
    }
}

// main

class FactoryMethodPattern {

    public static void main(String[] args) {
        System.out.println("Part3 Second version using FactoryMethod");

        // Creating a standard customer factory
        CustomerFactory standardCustomerFactory = new StandardCustomerFactory();

        // Creating a standard customer using the factory method
        Customer aStandardCustomer = standardCustomerFactory.createCustomer();
        doSomething(aStandardCustomer);

        // Creating a preferred customer factory
        CustomerFactory preferredCustomerFactory = new PreferredCustomerFactory();

        // Creating a preferred customer using the Factory Method
        Customer aPreferredCustomer = preferredCustomerFactory.createCustomer();
        doSomething(aPreferredCustomer);

        // Creating a business customer factory
        CustomerFactory businessCustomerFactory = new BusinessCustomerFactory();

        // Creating a business customer using the factory Method
        Customer aBusinessCustomer = businessCustomerFactory.createCustomer();
        doSomething(aBusinessCustomer);
    }


    private static void doSomething(Customer customer) {
        customer.typeCreated();
        customer.type();
    }
}


