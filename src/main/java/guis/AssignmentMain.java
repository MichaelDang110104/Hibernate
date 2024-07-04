package guis;

import java.util.Date;

import pojos.Account;
import pojos.Car;
import pojos.CarProducer;
import pojos.CarRental;
import pojos.CarRentalKey;
import pojos.Customer;
import pojos.Review;
import pojos.ReviewKey;
import services.AccountService;
import services.CarProducerService;
import services.CarRentalService;
import services.CarService;
import services.CustomerService;
import services.IAccountService;
import services.ICarProducerService;
import services.ICarRentalService;
import services.ICarService;
import services.ICustomerService;
import services.IReviewService;
import services.ReviewService;

public class AssignmentMain {

    public static void main(String[] args) {
        String configFile = "hibernate.cfg.xml";
        IAccountService iAccountService = new AccountService(configFile);
        ICustomerService iCustomerService = new CustomerService(configFile);
        ICarService iCarService = new CarService(configFile);
        ICarProducerService iCarProducerService = new CarProducerService(configFile);
        ICarRentalService iCarRentalService = new CarRentalService(configFile);
        IReviewService iReviewService = new ReviewService(configFile);
        Date date = new Date();
        
//        Account account = new Account("MichaelDang1101", "Admin");
//        iAccountService.save(account); // Save account first to get its ID
//        
//        Customer customer = new Customer("Michael Dang", "0903307685", date, "079204018614", "123456789", date, "Michaeldang1101@gmail.com", "12345", account);
//        iCustomerService.save(customer); // Save customer to get its ID
//        
//        CarProducer carProducer = new CarProducer("Hung Hoang", "ABCXYZ", "VietNam");
//        iCarProducerService.save(carProducer); // Save car producer to get its ID
//        
//        Car car = new Car("BMW", 2024, "Black", 2, "Bla Bla", date,carProducer,3223.22, "Available");
//        car.setProducer(carProducer); // Set the car producer
//        iCarService.save(car); // Save car to get its ID
        
//        CarRental carRental = new CarRental(date, date, 3202.12, "Available");
//        carRental.setCar(car); // Set the car for car rental
//        carRental.setCustomer(customer); // Set the customer for car rental
//        iCarRentalService.save(carRental); // Save car rental to get its ID
//        
//        Review review = new Review(5, "Very Good !");
//        review.setCar(car); // Set the car for review
//        review.setCustomer(customer); // Set the customer for review
//        iReviewService.save(review); // Save review to get its ID
        
        // Add relationship mapping
//        account.setCustomer(customer);
//        carProducer.getCar().add(car);
//        car.getCarRentalList().add(carRental);
//        customer.getCarRentalList().add(carRental);
//        car.getCarReviewList().add(review);
//        customer.getReviewList().add(review);

//        Customer customer = iCustomerService.findByID(1);
//        Car car = iCarService.findByID(1);
////        customer.addCarRental(car, date, date, 1000, "test");
////        customer.addReview(car, 10, configFile);
//       customer.removeCarCarRental(car);
//       customer.removeCarReview(car);
//     iCustomerService.update(customer);
     
//        iCarRentalService.delete(new CarRentalKey(1,1));
     iReviewService.delete(new ReviewKey(1,1));
    }
}
