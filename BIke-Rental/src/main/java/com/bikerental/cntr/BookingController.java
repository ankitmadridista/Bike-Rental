package com.bikerental.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.model.Booking;
import com.bikerental.model.Customer;
import com.bikerental.service.BikeService;
import com.bikerental.service.BookingService;
import com.bikerental.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "admin-booking")
	public List<Booking> getBookingList(){
		return bookingService.getAllBooking();
	}
	
	@GetMapping(value ="cust-booking/{custId}")
	public List<Booking> getCustBooking(@PathVariable long custId){
		return bookingService.getByCustId(custId);
	}
	
	@GetMapping(value = "bike-booking/{bikeId}")
	public List<Booking> getBikeBooking(@PathVariable long bikeId){
		return bookingService.getByCustId(bikeId);
	}
	
	@GetMapping(value="booking/{id}")
	public Booking getBookingDetails(@PathVariable long id){
		return bookingService.getByBookId(id);
	}
	
	@GetMapping(value="prov-booking/{provId}")
	public List<Booking> getProvBooking(@PathVariable long provId)
	{
		return bookingService.getByProvId(provId);
	} 
	
	@DeleteMapping(value="booking/{id}")
	public String deleteBooking(@PathVariable long id) {
		bookingService.deleteBooking(id);
		return "Success";
	}
	@PutMapping(value="booking")
	public String updateBooking(@RequestBody Booking book) {
		if( book.getBookBillAmount() < 0 ) {	
			Customer obj = customerService.getCustomer(book.getCustId());
			double newWallet = obj.getCustWallet() + Math.abs(book.getBookBillAmount()) ;
			book.setBookPaymentStatus("Paid");
			customerService.addRefund( newWallet, book.getCustId());
			book.setBookBillAmount(book.getBookDepositAmount() + book.getBookBillAmount());
			bookingService.modifyBooking(book);
			customerService.modifyCustStatusToFalse(book.getCustId());
		}
		else if( book.getBookBillAmount() == 0 && book.getBookStatus() == "Completed") {
			//System.out.println("in this");
			book.setBookPaymentStatus("Paid");
			bookingService.modifyBooking(book);
			customerService.modifyCustStatusToFalse(book.getCustId());
		}
		else if( book.getBookStatus() == "Completed" ) {
			bikeService.modifyBikeStatusToAvailable(book.getBikeId());
			bookingService.modifyBooking(book);
		}
		else {
			bookingService.modifyBooking(book);
		}
		
		return "Success";
	}
	
	//cust booking req -- added cust status method
	@PostMapping(value ="booking")
	public Booking addBooking(@RequestBody Booking booking) throws Exception {		
			customerService.modifyCustStatusToTrue(booking.getCustId());
			booking.setBookStatus("Pending");
			booking.setBookPaymentStatus("Unpaid");
			long bikeId = booking.getBikeId();
			bikeService.modifyBikeStatusToReserve(bikeId);
			//System.out.println(booking.getBookingStatus());
			return bookingService.addBooking(booking);		
	}
	
	//to update booking status from pending to booked
	@PostMapping(value="update-booking-accepted")
	public String updateBookingStatusToAccepted(@RequestBody Booking booking ) {
		//bikeService.modifyBikeStatusToReserve(booking.getBikeId());
		bookingService.modifyBookingStatusToAccepted(booking.getBookId());
		return "Success";
	}
	
	//to update booking status from pending to rejected
	@PostMapping(value="update-booking-rejected")
	public String updateBookingStatusToRej(@RequestBody Booking booking) {
		bikeService.modifyBikeStatusToAvailable(booking.getBikeId());
		bookingService.modifyBookingStatusToRejected(booking.getBookId());
		customerService.modifyCustStatusToFalse(booking.getCustId());
		return "Success";
	}
	
	
	@GetMapping(value="booking-req")
	public List<Booking> getAllReqBookings(){
		return bookingService.getAllRequestedBooking();
	} 
	
	@GetMapping(value="booking-acc")
	public List<Booking> getAllAccBookings(){
		return bookingService.getAllAcceptedBooking();
	} 
	
	@GetMapping(value="booking-act")
	public List<Booking> getAllActBookings(){
		return bookingService.getAllActiveBooking();
	} 
	
	//get paid bookings by custid
	@GetMapping(value="cust-paid-booking/{custId}")
	public List<Booking> getCustPaidBookingsByCustId(@PathVariable long custId){
		return bookingService.getAllPaidByCustId(custId);
	} 
	
	@GetMapping(value = "cust-curr-booking/{custId}")
	public Booking getCustCurrBookingById(@PathVariable long custId){
		return bookingService.getCustBookByBookId(custId);
	}
	
}
