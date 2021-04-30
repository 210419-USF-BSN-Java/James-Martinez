package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class FrontController {

	private static Logger log=Logger.getLogger(FrontController.class);

	public static void main(String[] args) {
		
		int outerOption = 0;
		Scanner scan=new Scanner(System.in);
		
		do {
			log.info("\n==============================================");
			log.info("Welcome to the Radioctive Reptiles App V1.0!");  //MAIN MENU
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
					                                                             
					int subOption=0;
					do{
					log.info("\n=====================================");
					log.info("Welcome back to Radioactive Reptiles!");                         //MAIN CUSTOMER MENU
					log.info("What are you looking for today?");
					log.info("=====================================");
					log.info("1) Available Mutations");
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
							log.info("\n============================================================================");  //BROWSE WITH ACCOUNT BIDDING/BUYING 
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
							
							switch(subOption1) {
							case 1:
								log.info("This is for the Reptilian Mutations Menu CHOOSE MUTATION BY ID"); // CHOOSE MUTATIONS BY ID
								// CHOOSE ID TO MAKE PURCHASE USE IF ELSE TO CONFIRM YES OR NO
								break;
							case 2:
								log.info("This is for the Amphibious Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 3:
								log.info("This is for the Aquatic Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 4:
								log.info("This is for the Plant Mutations Menu CHOOSE MUTATION BY ID");
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
							log.info("Choose from the following options");                        //CUSTOMER LOGIN SUB MENU
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
								log.info("This is for viewing my purchases");
								break;
							case 2:
								log.info("This is for viewing my payment history");
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
						log.info("Logging out thank you for supporting the RR family!");
						
						break;

					default:
						log.warn("Please choose only an option between 1-3");
						
						break;
					}
					
					}while(subOption!= 3);
					
					break;
				case 2:
					log.info("\nRegistering for an account");  //CREATE NEW CUSTOMER ACCOUNT
					
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
				

				int empOption=0;
				
				do{
				log.info("\n=============================================");
				log.info("Welcome back! What will you be doing today?"); //EMPLOYEE MAIN MENU
				log.info("=============================================");
				log.info("1) Manage Mutation Inventory");
				log.info("2) View and Manage Customer Offers");
				log.info("3) View Customer Purchases");
				log.info("4) View Customer Payments");
				log.info("5) Manager Operations");
				log.info("6) Log Out");
				log.info("=============================================");
				try {
					empOption=Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {}
					 
				switch (empOption) {
						case 1:
							int mutOption = 0;
							do{
								log.info("\n==============================================");
								log.info("Select from the following to manage Mutations:");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
								log.info("==============================================");
								log.info("1) List all Mutations");
								log.info("2) Add Mutations");
								log.info("3) Remove Mutations");
								log.info("4) Edit Mutations");
								log.info("5) Return");
								log.info("======================================");
								try {
									mutOption=Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}

								switch (mutOption) {
								case 1:
									log.info("This is to List all Mutations");
									break;
								case 2:
									log.info("This is to add Mutations");
									break;
								case 3:
									log.info("This is to remove Mutations");
									break;
								case 4:
									log.info("This is to edit Mutations");
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
					log.info("This is to view and approve bids");

					break;
				case 3:
					log.info("This is to view customer purchases");

					break;
				case 4:
					log.info("This is to view customer payments");

					break;
				case 5:
					log.info("This is to Enter Mananger Privileges");
					//HAVE TO CHECK IF EMPLOYEE IS MANAGER
					int manOption = 0;
					do{
						log.info("\n=============================================");
						log.info("Welcome Manager! What will you be doing today?");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
						log.info("=============================================");
						log.info("1) Create Employee");
						log.info("2) Terminate Employee");
						log.info("3) Return");
						log.info("======================================");
						try {
							manOption=Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}

						switch (manOption) {
						case 1:
							log.info("This is to Create Employee");
							break;
						case 2:
							log.info("This is to Terminate Employee");
							break;
						case 3:
							log.info("Returning to Employee Menu");
							break;
						default:
							log.info("Please only choose an option 1-3");
							break;
						}
					}while(manOption!=3);  
					

					break;
				case 6:
					log.info("Logging Out");

					break;
					
				default:
					log.warn("Please only enter a number 1-6");
					break;
				}
				}while(empOption!=6);
				
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