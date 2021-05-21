package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.CustomerDAO;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.MutationDAO;
import com.revature.dao.PurchaseAndBidDAO;
import com.revature.dao.impl.CustomerDAOImpl;
import com.revature.dao.impl.EmployeeDAOImpl;
import com.revature.dao.impl.MutationDAOImpl;
import com.revature.dao.impl.PurchaseAndBidDAOImpl;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.InventoryException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Mutation;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;
import com.revature.service.MutationService;
import com.revature.service.PurchaseAndBidService;
import com.revature.service.impl.CustomerServiceImpl;
import com.revature.service.impl.EmployeeServiceImpl;
import com.revature.service.impl.MutationServiceImpl;
import com.revature.service.impl.PurchaseAndBidImpl;

public class FrontController {

	private static Logger log=Logger.getLogger(FrontController.class);

	public static void main(String[] args) {
		
		CustomerDAO custDAO = new CustomerDAOImpl();
		EmployeeDAO empDAO = new EmployeeDAOImpl(); 
		MutationDAO muteDAO = new MutationDAOImpl();
		PurchaseAndBidDAO purDAO = new PurchaseAndBidDAOImpl();
		MutationService muteService = new MutationServiceImpl();
		CustomerService custService = new CustomerServiceImpl();
		EmployeeService empService = new EmployeeServiceImpl();
		PurchaseAndBidService purService = new PurchaseAndBidImpl();
		
		int outerOption = 0;
		Scanner scan=new Scanner(System.in);
		
		do {
			log.info("\n==============================================");
			log.info("Welcome to the Radioctive Reptiles App V1.0!");  //MAIN MENU
			log.info("Radioactive Reptiles the Company with a Rad Rep!");
			log.info("=============================================================================================");
			log.info("Disclaimer: The Radioactive Reptiles Company does not harm or modify living Fauna And Flora.");
			log.info("All of our mutations are safetly lab grown using patented state of the art technology");
			log.info("=============================================================================================");
			log.info("Proceed by selecting one of the options below:");
			log.info("==============================================");
			log.info("1) Customer Login & Registration");
			log.info("2) Employee Login");
			log.info("3) Exit App");
			log.info("==============================================");
			try {
				outerOption=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {}
			
			switch (outerOption) {
				
			case 1:
				int option=0;
				
				do{
				log.info("\n===========================================");
				log.info("Welcome to Customer Login and Registration");                        //CUSTOMER LOGIN SUB MENU
				log.info("Please choose one of the following options");
				log.info("===========================================");
				log.info("1) Login");
				log.info("2) Register for an Account");
				log.info("3) Exit");
				log.info("===========================================");
				try {
					option=Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {}
				
				switch (option) {
				case 1:
					log.info("\nPlease enter your user email address");        //CUSTOMER LOGIN
					String email=scan.nextLine();
					log.info("Please enter your password");
					String password=scan.nextLine();
					
					if(custDAO.custLogin(email, password) == false) {
						log.warn("Email and Password do not match please try again");
						break;
					}
					
					int customerId = custDAO.getIdByEmailPassword(email, password);
					                                                             
					int subOption=0;
					do{
					log.info("\n=====================================");
					log.info("Welcome back to Radioactive Reptiles!");                         //MAIN CUSTOMER MENU
					log.info("What are you looking for today?");
					log.info("=====================================");
					log.info("1) Available Mutations");             //THIS COULD BE MORE EFFIECIENT!!!! BUT I DO NOT WANT TO MESS UP THE APP 
					log.info("2) Purchases and Payments");
					log.info("3) My Mutation Offers"); 
					log.info("4) Log out");
					log.info("==================================");
					try {
						subOption=Integer.parseInt(scan.nextLine());
					}catch(NumberFormatException e) {}
					
					switch (subOption) {
					case 1:
						int subOption1= 0;
						do{
							log.info("\n============================================================================");  
							log.info("Choose to browse from the following mutations to learn more annd place bids:");
							log.info("============================================================================");
							log.info("1) Reptilian Mutations");
							log.info("2) Amphibious Mutations");
							log.info("3) Aquatic Mutations");
							log.info("4) Plant Mutations");
							log.info("5) Exit");
							log.info("==============================================");
							try {
								subOption1=Integer.parseInt(scan.nextLine());
							}catch(NumberFormatException e) {}
							List<Mutation> muteList;
							String mutationId = null;
							switch(subOption1) {
							case 1:
								mutationId = "MR";
								try {
									log.info("\nDisplaying Reptilian Mutations:");    
									log.info("==============================================================================================================================");
									muteList = muteDAO.listMutationByType(mutationId);
									for(int i=0;i<muteList.size();i++) {
										log.info(muteList.get(i));;
									}
									log.info("==============================================================================================================================");
									log.info("\nPlease enter the Mutation ID to learn more");
									String getId = scan.nextLine();
									Mutation getMutation = muteService.getMutationById(getId);
									
									log.info("==============================================================================================================================");
									log.info(getMutation);
									
									String description = muteDAO.getMutationDescription(getId);
									log.info("Description: "+description);
									log.info("==============================================================================================================================");
									if(getMutation.getAvailability().equals("Unavailable")) {
										log.info("This Mutation is currently unavailable, offer could not be made.");
										break;
									}
									log.info("\nWould you like to make an offer?\n1)Yes\n2)Exit");
									int offerChoice = Integer.parseInt(scan.nextLine());
									if(offerChoice == 1) {
										Offer offer = new Offer();                                       //MAKE OFFER
										offer.setCustomerId(customerId);
										offer.setName(getMutation.getName());
										log.info("Enter the Offer Amount note that the ask price is the general value of the mutation");
										log.info("You may offer less than the ask price but approval chances will drop significantly");
										offer.setAmount(Integer.parseInt(scan.nextLine()));
										
										try {
											purService.makeOffer(offer);
											log.info("Offer successfully made, you may find it in your offers");
										} catch (OfferException e) {
											e.printStackTrace();
										}
									}else if(offerChoice == 2) {
										log.info("Exiting to Mutations Menu");
									}else {
										log.info("Please only choose from the above options");
									}
											
								} catch (InventoryException e) {
									log.error(e);
								}
								break;
							case 2:
								mutationId = "MB";
								try {
									log.info("\nDisplaying Amphibious Mutations:");    
									log.info("==============================================================================================================================");
									muteList = muteDAO.listMutationByType(mutationId);
									for(int i=0;i<muteList.size();i++) {
										log.info(muteList.get(i));;
									}
									log.info("==============================================================================================================================");
									log.info("\nPlease enter the Mutation ID to learn more");
									String getId = scan.nextLine();
									Mutation getMutation = muteService.getMutationById(getId);
								
									log.info("==============================================================================================================================");
									log.info(getMutation);
									
									String description = muteDAO.getMutationDescription(getId);
									log.info("Description: "+description);
									log.info("==============================================================================================================================");
									if(getMutation.getAvailability().equals("Unavailable")) {
										log.info("This Mutation is currently unavailable, offer could not be made.");
										break;
									}
									log.info("\nWould you like to make an offer?\n1)Yes\n2)Exit");
									int offerChoice = Integer.parseInt(scan.nextLine());
									if(offerChoice == 1) {
										Offer offer = new Offer();                                       //MAKE OFFER
										offer.setCustomerId(customerId);
										offer.setName(getMutation.getName());
										log.info("Enter the Offer Amount note that the ask price is the general value of the mutation");
										log.info("You may offer less than the ask price but approval chances will drop significantly");
										offer.setAmount(Integer.parseInt(scan.nextLine()));
										
										try {
											purService.makeOffer(offer);
											log.info("Offer successfully made, you may find it in your offers");
										} catch (OfferException e) {
											e.printStackTrace();
										}
									}else if(offerChoice == 2) {
										log.info("Exiting to Mutations Menu");
									}else {
										log.info("Please only choose from the above options");
									}
								} catch (InventoryException e) {
									log.error(e);
								}
								break;
							case 3:
								mutationId = "MA";
								try {
									log.info("\nDisplaying Aquatic Mutations:");    
									log.info("==============================================================================================================================");
									muteList = muteDAO.listMutationByType(mutationId);
									for(int i=0;i<muteList.size();i++) {
										log.info(muteList.get(i));;
									}
									log.info("==============================================================================================================================");
									log.info("\nPlease enter the Mutation ID to learn more");
									String getId = scan.nextLine();
									Mutation getMutation = muteService.getMutationById(getId);
									log.info("==============================================================================================================================");
									log.info(getMutation);
									
									String description = muteDAO.getMutationDescription(getId);
									log.info("Description: "+description);
									log.info("==============================================================================================================================");
									if(getMutation.getAvailability().equals("Unavailable")) {
										log.info("This Mutation is currently unavailable, offer could not be made.");
										break;
									}
									log.info("\nWould you like to make an offer?\n1)Yes\n2)Exit");
									int offerChoice = Integer.parseInt(scan.nextLine());
									if(offerChoice == 1) {
										Offer offer = new Offer();                                       //MAKE OFFER
										offer.setCustomerId(customerId);
										offer.setName(getMutation.getName());
										log.info("Enter the Offer Amount note that the ask price is the general value of the mutation");
										log.info("You may offer less than the ask price but approval chances will drop significantly");
										offer.setAmount(Integer.parseInt(scan.nextLine()));
										
										try {
											purService.makeOffer(offer);
											log.info("Offer successfully made, you may find it in your offers");
										} catch (OfferException e) {
											e.printStackTrace();
										}
									}else if(offerChoice == 2) {
										log.info("Exiting to Mutations Menu");
									}else {
										log.info("Please only choose from the above options");
									}
								} catch (InventoryException e) {
									log.error(e);
								}
								break;
							case 4:
								mutationId = "MP";
								try {
									log.info("\nDisplaying Plant Mutations:");   
									log.info("==============================================================================================================================");
									muteList = muteDAO.listMutationByType(mutationId);
									for(int i=0;i<muteList.size();i++) {
										log.info(muteList.get(i));;
									}
									log.info("==============================================================================================================================");
									log.info("\nPlease enter the Mutation ID to learn more");
									String getId = scan.nextLine();
									Mutation getMutation = muteService.getMutationById(getId);
									log.info("==============================================================================================================================");
									log.info(getMutation);
									
									String description = muteDAO.getMutationDescription(getId);
									log.info("Description: "+description);
									log.info("==============================================================================================================================");
									if(getMutation.getAvailability().equals("Unavailable")) {
										log.info("This Mutation is currently unavailable, offer could not be made.");
										break;
									}
									log.info("\nWould you like to make an offer?\n1)Yes\n2)Exit");
									int offerChoice = Integer.parseInt(scan.nextLine());
									if(offerChoice == 1) {
										Offer offer = new Offer();                                       //MAKE OFFER
										offer.setCustomerId(customerId);
										offer.setName(getMutation.getName());
										log.info("Enter the Offer Amount note that the ask price is the general value of the mutation");
										log.info("You may offer less than the ask price but approval chances will drop significantly");
										offer.setAmount(Integer.parseInt(scan.nextLine()));
										
										try {
											purService.makeOffer(offer);
											log.info("Offer successfully made, you may find it in your offers");
										} catch (OfferException e) {
											e.printStackTrace();
										}
									}else if(offerChoice == 2) {
										log.info("Exiting to Mutations Menu");
									}else {
										log.info("Please only choose from the above options");
									}
								} catch (InventoryException e) {
									log.error(e);
								}
								break;
							case 5:
								log.info("Exiting to Customer Menu");
								break;
							default:
								log.info("Please only choose an option between 1-5");
								break;
							}
						}while(subOption1 !=5);
						
						break;
						
					case 2:
						log.info("This is to view my purchases and make payments");
						int payOption = 0;
						do {
							log.info("\n==================================");
							log.info("Choose from the following options");           //CUSTOMER PAYMENTS/PURCHASES SUB MENU
							log.info("==================================");
							log.info("1) View My Purchases");
							log.info("2) View My Payment History");
							log.info("3) Return");
							log.info("==================================");
							try {
							     payOption=Integer.parseInt(scan.nextLine());
							}catch(NumberFormatException e) {}
							
							switch(payOption) {
							case 1:
								try {
									List<Purchase> purList;
									log.info("==============================================================================================================================");
									purList = purService.viewPurchaseByCustomer(customerId);
									for(int i=0;i<purList.size();i++) {
										log.info(purList.get(i));;
									}
									log.info("==============================================================================================================================");
								} catch (EntryNotFoundException e) {
									log.error(e);
								}
								log.info("Would you like to make a Payment\n1)Yes\n2)Cancel");
								int payChoice = Integer.parseInt(scan.nextLine());
								if(payChoice == 1) {
									log.info("Enter the Purchase ID of the purchase you will make a payment for");
									int purchaseId = Integer.parseInt(scan.nextLine());
									Purchase payPur = new Purchase();
									try {
										payPur = purService.getPurchaseById(purchaseId);
										log.info("Displaying the chosen purchase:");
										log.info(payPur);
									} catch (EntryNotFoundException e) {
										log.error(e);
									}
									Payment payment = new Payment();
									log.info("Enter the amount you will be paying");
									payment.setAmount(Float.parseFloat(scan.nextLine()));
									if(payment.getAmount() > payPur.getBalance()) {
										log.info("We appreciate your generosity however payment amount cannot be more than your balance!");
										break;
									}
									payment.setCustomerId(customerId);
									payment.setName(payPur.getName());
									try {
										purService.makePayment(payment, purchaseId);
										log.info("Payment succesfully made");
									} catch (PaymentException e) {
										log.error(e);
									}
								}else if(payChoice == 2) {
									log.info("Exiting");
								}else {
									log.info("Please on choose from the above options");
								}
								break;
							case 2:
								log.info("Displaying your payment history:");
								
								try {
									List<Payment> payList;
									log.info("==============================================================================================================================");
									payList = purService.viewPaymentByCustomer(customerId);
									for(int i=0;i<payList.size();i++) {
										log.info(payList.get(i));;
									}
									log.info("==============================================================================================================================");
								} catch (EntryNotFoundException e) {
									log.error(e);
								}
								break;
							case 3:
								log.info("Returning to the Customer Menu");
								break;
							default:
								log.info("Please only choose from options 1-3");
								break;
							}
						}while(payOption!=3);
						break;
						
					case 3:
						log.info("Displaying your Mutation Offers:");
						try {
							List<Offer> offList;
							log.info("==============================================================================================================================");
							offList = purService.viewOfferByCustomer(customerId);
							for(int i=0;i<offList.size();i++) {
								log.info(offList.get(i));;
							}
							log.info("==============================================================================================================================");
						} catch (EntryNotFoundException e) {
							log.error(e);
						}
						break;
					case 4:
						log.info("Logging out thank you for supporting the RR family!");
						
						break;

					default:
						log.warn("Please choose only an option between 1-4");
						
						break;
					}
					
					}while(subOption!= 4);
					
					break;
				case 2:
					log.info("\nWould you like to register for a customer account?\n1)Register\n2)Cancel");  //CREATE NEW CUSTOMER ACCOUNT
					int regChoice = Integer.parseInt(scan.nextLine());
					if(regChoice == 1) {
						Customer newCustomer = new Customer();
						log.info("Enter your name");
						newCustomer.setName(scan.nextLine());
						log.info("Enter your Email Address");
						newCustomer.setEmail(scan.nextLine());
						log.info("Enter a Password");
						newCustomer.setPassword(scan.nextLine());
						log.info("Enter your Location");
						newCustomer.setLocation(scan.nextLine());
						try {
							custService.createNewCustomer(newCustomer);
							log.info("Account registration successful");
						} catch (RegistrationException e) {
							log.error(e);
						}
					}else if(regChoice == 2) {
						log.info("Returning to Main Menu");
						break;
					}else {
						log.info("Please only choose from the provided options");
					}
					break;
				case 3:
					log.info("Exiting to Main Menu");   //EXIT
					
					break;

				default:
					log.warn("Please enter a number 1-3 ONLY");
					break;
				}
				}while(option!=3);

				break;
			case 2:
				log.info("\n===========================");
				log.info("Welcome to Employee Login");                         //EMPLOYEE LOGIN
				log.info("===========================");
				log.info("\nPlease enter your user email address");        
				String email=scan.nextLine();
				log.info("Please enter your password");
				String password=scan.nextLine();
				
				if(empDAO.empLogin(email, password) == false) {
					log.warn("Email and Password do not match please try again");
					break;
				}
				
				String manager = empDAO.getManagerByEmailPassword(email, password); 

				int empOption=0;
				
				do{
				log.info("\n=============================================");
				log.info("Welcome back! What will you be doing today?"); //EMPLOYEE MAIN MENU
				log.info("=============================================");
				log.info("1) Manage Mutation Inventory");
				log.info("2) View Customer Accounts");
				log.info("3) View and Manage Customer Offers");
				log.info("4) Manager Operations");
				log.info("5) Log Out");
				log.info("=============================================");
				try {
					empOption=Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {}
					 
				switch (empOption) {
						case 1:
							int mutOption = 0;
							do{
								log.info("\n===============================================");
								log.info("Select from the following to manage Mutations:");  //EMPLOYEE MANAGE MUTATIONS SUB MENU
								log.info("===============================================");
								log.info("1) List all Mutations");
								log.info("2) Add Mutations");
								log.info("3) Remove Mutations");
								log.info("4) Edit Mutations");    //REMEMBER TO ADD DESCRIPTION
								log.info("5) Return");
								log.info("===============================================");
								try {
									mutOption=Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}

								switch (mutOption) {
								case 1:
									List<Mutation> muteList;
									String mutationId = "ALL";
									try {
										log.info("\nDisplaying All Mutations:");   
										log.info("==============================================================================================================================");
										muteList = muteDAO.listMutationByType(mutationId);
										for(int i=0;i<muteList.size();i++) {
											log.info(muteList.get(i));;
										}
										log.info("==============================================================================================================================");
									} catch (InventoryException e) {
										log.error(e);
									}
									break;
								case 2:
									log.info("Would you like to add a new mutation?\n1)Yes\n2)Cancel");
									int addChoice = Integer.parseInt(scan.nextLine());
									if(addChoice==1) {
									Mutation addMutation = new Mutation();
									log.info("Enter the Mutation ID be sure to use the correct code(MR/MB/MA/MP)");
									String addId = scan.nextLine();
									addMutation.setMutationId(addId);
									log.info("Enter the Mutation name");
									addMutation.setName(scan.nextLine());
									log.info("Enter the Mutation Height");
									addMutation.setHeight(scan.nextLine());
									log.info("Enter the Mutation Weight");
									addMutation.setWeight(scan.nextLine());
									log.info("Enter the ask price");
									addMutation.setAskPrice(Float.parseFloat(scan.nextLine()));
									log.info("Enter a description");
									String description = scan.nextLine(); //sdfghj
									try {
										muteService.addMutation(addMutation, description);
										log.info("Mutation successfully added");
									} catch (InventoryException e) {
										log.error(e);
									}
									
									}else if(addChoice==2) {
										log.info("Exiting to Manage Mutations");
									}else {
										log.info("Only choose from the provided options");
									}
									break;
								case 3:
									log.info("Enter the Mutation ID of the Mutation want to remove:");   
									String idDelete =  scan.nextLine(); 
									try {
									    Mutation mutationDelete = muteService.getMutationById(idDelete);
									    log.info("The following Mutation will be deleted:");
									    log.info(mutationDelete);
										log.info("Confirm deletion\n1)Delete\n2)Cancel");
										int confirmD = Integer.parseInt(scan.nextLine());
										if(confirmD == 1) {
											muteService.deleteMutationById(idDelete);
											log.info("Mutation successfully deleted");
										}else if(confirmD == 2) {
											log.info("Deletion canceled");
										}
										
									} catch (InventoryException e) {
										log.error(e);
									}
									
									break;
								case 4:
									log.info("Enter the Mutation ID of the Mutation want to edit:");   //UNTESTED
									String idEdit =  scan.nextLine(); 
									try {
										Mutation mutationEdit = muteService.getMutationById(idEdit);
										String description = muteDAO.getMutationDescription(idEdit);
										log.info("The following Mutation will be edited:");
										log.info(mutationEdit);
										log.info("Description:"+description);
										log.info("\n================================");
										log.info("What would you like to update");
										log.info("================================");
										log.info("1) Name");
										log.info("2) Height");
										log.info("3) Weight");
										log.info("4) Ask Price");
										log.info("5) Description");
										log.info("6) Availability");
										log.info("7) Cancel");
										log.info("================================");
										int editChoice=Integer.parseInt(scan.nextLine());
										if(editChoice == 7) {
											break;
										}
										log.info("Please enter the updated information");
										String update = scan.nextLine();
										
										muteService.editMutationById(idEdit, editChoice, update);
										log.info("Update successful");

									} catch (InventoryException e) {
										log.error(e);
									}
									break;
								case 5:
									log.info("Returning to employee Menu");
									break;
								default:
									log.info("Please only choose an option 1-5");
								}
							}while(mutOption != 5);

					break;
				case 2:
					log.info("\n=========================================");
					log.info("Displaying all customer accounts");
					log.info("================================================================================================");
					List<Customer> custList;
					try {
						custList = custDAO.listAllCustomerAccounts();
						for(int i=0;i<custList.size();i++) {
							log.info(custList.get(i));;
						}
						log.info("===============================================================================================");
					} catch (EmptyDatabaseException e1) {
						log.error(e1);
					}

					break;
				case 3:
					log.info("\n=============================================");
					log.info("Displaying Customer offers:");
					
					try {
						log.info("===============================================================================================");
						List<Offer> offList;
						offList = purDAO.viewAllOffers();
						for(int i=0;i<offList.size();i++) {
							log.info(offList.get(i));;
						}
						log.info("===============================================================================================");
					} catch (EmptyDatabaseException e2) {
						log.error(e2);
					}
					log.info("Would you like to manage offers?\n1)Yes\n2)Cancel");
					int offChoice = Integer.parseInt(scan.nextLine());
					if(offChoice == 1) {
						log.info("Enter the Offer ID of the Offer you would like to manage");
						int offerId = Integer.parseInt(scan.nextLine());
						Offer offer = new Offer();
						try {
							offer = purService.getOfferById(offerId);
							log.info("You have selected the following offer:");
							log.info(offer);
							log.info("1)Approve Offer\n2)Decline Offer");
							int statChoice = Integer.parseInt(scan.nextLine());
							if(statChoice == 1) {
								String status = "Approved";
								String availability = "Available";
								log.info("Is "+offer.getName()+" still available?\n1)Yes\n2)No");
								int avaChoice = Integer.parseInt(scan.nextLine());
								if(avaChoice == 2) {
									availability = "Unavailable";
								}
								Purchase purchase = new Purchase();
								purchase.setAmount(offer.getAmount());
								purchase.setBalance(offer.getAmount());
								purchase.setName(offer.getName());
								purchase.setCustomerId(offer.getCustomerId());
								
								purService.makePurchase(purchase, availability);
								purDAO.approveOffer(status, offerId);
								
								log.info("Offer approved and purchase added to customer with ID: "+purchase.getCustomerId());
							
							}else if(statChoice == 2) {
								String status = "Declined";
								purDAO.approveOffer(status, offerId);
								log.info("Offer Declined");
							}else {
								log.warn("Only choose from the available options");
							}
						} catch (EntryNotFoundException | PaymentException e) {
							log.error(e);
						}
					}else if(offChoice == 2) {
						log.info("Exiting");
					}else {
						log.info("Choose only from the available options");
					}

					break;
				case 4:
					if(manager.equals("N")) {
						log.info("You do not have access to Manager Operations contact Management");
						break;
					}
					int manOption = 0;
					do{
						log.info("\n=============================================");
						log.info("Welcome Manager! What will you be doing today?");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
						log.info("=============================================");
						log.info("1) View All Employees");
						log.info("2) Create Employee");
						log.info("3) Terminate Employee");
						log.info("4) View Customer Accounts");
						log.info("5) View Customer Purchases");
						log.info("6) View Customer Payments");
						log.info("7) Return");
						log.info("======================================");
						try {
							manOption=Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}

						switch (manOption) {
						case 1:
							log.info("\n=============================================");
							log.info("Displaying all employees");
							log.info("===============================================================================================");
							List<Employee> empList;
							try {
								empList = empDAO.listAllEmployeeAccounts();
								for(int i=0;i<empList.size();i++) {
									log.info(empList.get(i));;
								}
								log.info("===============================================================================================");
							} catch (EmptyDatabaseException e1) {
								log.error(e1);
							}
							break;
						case 2:
							log.info("\nWould you like to register a new employee?\n1)Register\n2)Cancel");  //CREATE NEW EMPLOYEE
							int regChoice = Integer.parseInt(scan.nextLine());
							if(regChoice == 1) {
								Employee newEmployee = new Employee();
								log.info("Enter employee name");
								newEmployee.setName(scan.nextLine());
								log.info("Enter your Email Address");
								newEmployee.setEmail(scan.nextLine());
								log.info("Enter a Password");
								newEmployee.setPassword(scan.nextLine());
								try {
									empService.createNewEmployee(newEmployee);
									log.info("Employee registration successful");
								} catch (RegistrationException e) {
									log.error(e);
								}
							}else if(regChoice == 2) {
								log.info("Returning to Manager Menu");
							}else {
								log.info("Only choose from the provided options");
							}
							break;
						case 3:
							log.info("Enter the Employee ID of the Employee you want to terminate");   
							int idDelete =  Integer.parseInt(scan.nextLine()); 
							Employee employeeDelete;
							try {
								employeeDelete = empService.getEmployeeById(idDelete);
								log.info("The following Mutation will be deleted:");
								log.info(employeeDelete);
								log.info("Confirm deletion\n1)Delete\n2)Cancel");
								int confirmD = Integer.parseInt(scan.nextLine());
								if (confirmD == 1) {
									empService.deleteEmployeeById(idDelete);
									log.info("Employee successfully deleted");
								} else if (confirmD == 2) {
									log.info("Deletion canceled");
								}
							} catch (EntryNotFoundException e) {
								log.error(e);
							}	
							
							break;
						case 4:
							log.info("\n=============================================");
							log.info("Displaying all customer accounts");
							log.info("===============================================================================================");
							try {
								custList = custDAO.listAllCustomerAccounts();
								for(int i=0;i<custList.size();i++) {
									log.info(custList.get(i));;
								}
								log.info("===============================================================================================");
							} catch (EmptyDatabaseException e1) {
								log.error(e1);
							}

							break;
						case 5:
							log.info("Enter a customer ID to view that customers purchases");
							int custId = Integer.parseInt(scan.nextLine());
							List<Purchase> purList;
							log.info("\n=============================================");
							try {
								log.info("Displaying purchases for customer with ID: "+custId);
								log.info("===============================================================================================");
								purList = purService.viewPurchaseByCustomer(custId);
								for(int i=0;i<purList.size();i++) {
									log.info(purList.get(i));;
								}
								log.info("===============================================================================================");
							} catch (EntryNotFoundException e) {
								log.error(e);
							}
							break;
						case 6:
							log.info("Enter a customer ID to view that customers payments");
							int custId2 = Integer.parseInt(scan.nextLine());
							List<Payment> payList;
							log.info("\n=============================================");
							try {
								log.info("Displaying payments for customer with ID: "+custId2);
								log.info("===============================================================================================");
								payList = purService.viewPaymentByCustomer(custId2);
								for(int i=0;i<payList.size();i++) {
									log.info(payList.get(i));;
								}
								log.info("===============================================================================================");
							} catch (EntryNotFoundException e) {
								log.error(e);
							}
							break;
						case 7:
							log.info("Returning to Employee Menu");
							break;
						default:
							log.info("Please only choose an option 1-7");
							break;
						}
					}while(manOption!=7);  
					

					break;
				case 5:
					log.info("Logging Out");

					break;
					
				default:
					log.warn("Please only enter a number 1-5");
					break;
				}
				}while(empOption!=5);
				
				break;
			case 3:
				log.info("Thank you for Supporting the Radioactive Reptiles Family!");

				break;

			default:
				log.warn("Please only enter a number 1-3");
				break;
			}

		} while (outerOption!= 3);
		
		scan.close();

	}
}