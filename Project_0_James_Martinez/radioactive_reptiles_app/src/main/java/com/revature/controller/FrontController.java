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
			log.info("1) Browse as Guest");
			log.info("2) Customer Login & Registration");
			log.info("3) Employee Login");
			log.info("4) Exit App");
			log.info("==============================================");
			try {
				outerOption=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {}
			
			switch (outerOption) {
			case 1:
				int option0 = 0;
				do{
					log.info("\n====================================================================");
					log.info("Here you can browse and learn more about available mutations.");                        //BROWSE AS GUEST NO BIDDING/BUYING 
					log.info("In order to be eligible to bid on mutations, purchase Habitats, and"
							+ "\npurchase Feeders an account must be created with Radioactive Reptiles");
					log.info("=====================================================================");
					log.info("Choose to browse from the following mutations:");
					log.info("==============================================");
					log.info("1) Reptilian Mutations");
					log.info("2) Amphibious Mutations");
					log.info("3) Aquatic Mutations");
					log.info("4) Hybrid Mutations");
					log.info("5) Flora Mutations");
					log.info("6) Exit");
					log.info("==============================================");
					try {
						option0=Integer.parseInt(scan.nextLine());
					}catch(NumberFormatException e) {}
					
					switch(option0) {
					case 1:
						log.info("This is for the Reptilian Mutations Menu"); // CHOOSE MUTATIONS BY ID
						break;
					case 2:
						log.info("This is for the Amphibious Mutations Menu");
						break;
					case 3:
						log.info("This is for the Aquatic Mutations Menu");
						break;
					case 4:
						log.info("This is for the Hybrid Mutations Menu");
						break;
					case 5:
						log.info("This is for the Flora Mutations Menu");
						break;
					case 6:
						log.info("Exiting Browse as Guest");
						break;
					default:
						log.info("Please only choose an option between 1-6");
						break;
					}
				}while(option0 !=6);
				
				break;
				
			case 2:
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
					log.info("1) Mutations");
					log.info("2) Habitats");
					log.info("3) Feeders");
					log.info("4) My Purchases");
					log.info("5) Log out");
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
							log.info("4) Hybrid Mutations");
							log.info("5) Flora Mutations");
							log.info("6) Exit");
							log.info("==============================================");
							try {
								subOption1=Integer.parseInt(scan.nextLine());
							}catch(NumberFormatException e) {}
							
							switch(subOption1) {
							case 1:
								log.info("This is for the Reptilian Mutations Menu CHOOSE MUTATION BY ID"); // CHOOSE MUTATIONS BY ID
								break;
							case 2:
								log.info("This is for the Amphibious Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 3:
								log.info("This is for the Aquatic Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 4:
								log.info("This is for the Hybrid Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 5:
								log.info("This is for the Flora Mutations Menu CHOOSE MUTATION BY ID");
								break;
							case 6:
								log.info("Exiting to Inventory Menu");
								break;
							default:
								log.info("Please only choose an option between 1-6");
								break;
							}
						}while(subOption1 !=6);
						
						break;
						 
					case 2:
						log.info("CHOOSED FROM LIST OF HABITATS BY ID");
//						int subOption2= 0;
//						do{
//							log.info("\n===============================================");  //BROWSE WITH ACCOUNT BIDDING/BUYING 
//							log.info("Choose from the Habitats below to learn more:");
//							log.info("==============================================");
//							log.info("1) Dragon Habitats");
//							log.info("2) Amphibious Habitats");
//							log.info("3) Aquatic Habitats");
//							log.info("4) Mutation Garden");
//							log.info("5) Exit");
//							log.info("==============================================");
//							try {
//								subOption2=Integer.parseInt(scan.nextLine());
//							}catch(NumberFormatException e) {}
//							
//							switch(subOption2) {
//							case 1:
//								log.info("This is for the Dragon Habitats Menu"); // CHOOSE MUTATIONS BY ID
//								break;
//							case 2:
//								log.info("This is for the Amphibious Habitats Menu");
//								break;
//							case 3:
//								log.info("This is for the Aquatic Habitats Menu");
//								break;
//							case 4:
//								log.info("This is for the Mutation Garden Menu");
//								break;
//							case 5:
//								log.info("Exiting to Inventory Menu");
//								break;
//							default:
//								log.info("Please only choose an option between 1-5");
//								break;
//							}
//						}while(subOption2 !=5);
						
						break;
					case 3:
						log.info("CHOOSED FROM LIST OF FEEDERS BY ID");
//						int subOption3= 0;
//						do{
//							log.info("\n==============================================");  //BROWSE WITH ACCOUNT BIDDING/BUYING 
//							log.info("Choose from the Feeders below to learn more:");
//							log.info("==============================================");
//							log.info("1) Dragon Feed");
//							log.info("2) Aquatic Feed");
//							log.info("3) Special Mutation Fertilizer");
//							log.info("4) Exit");
//							log.info("==============================================");
//							try {
//								subOption3=Integer.parseInt(scan.nextLine());
//							}catch(NumberFormatException e) {}
//							
//							switch(subOption3) {
//							case 1:
//								log.info("This is for the Dragon Feeders Menu"); // CHOOSE MUTATIONS BY ID
//								break;
//							case 2:
//								log.info("This is for the Aquatic Feeders Menu");
//								break;
//							case 3:
//								log.info("This is for the Special Mutation Fertilizer  Menu");
//								break;
//							case 4:
//								log.info("Exiting to Inventory Menu");
//								break;
//							default:
//								log.info("Please only choose an option between 1-4");
//								break;
//							}
//						}while(subOption3 !=4);
						
						break;
						
					case 4:
						log.info("This is to view my purchases and make payments");
						break;
						
					case 5:
						log.info("Logging out thank you for supporting the RR family!");
						break;

					default:
						log.warn("Please choose only an option between 1-5");
						break;
					}
					
					}while(subOption!= 5);
					
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
			case 3:
				log.info("\n===========================");
				log.info("Welcome to Employee Login");                         //EMPLOYEE LOGIN
				log.info("===========================");
				

				int subOption=0;
				
				do{
				log.info("\n=============================================");
				log.info("Welcome back! What will you be doing today?"); //EMPLOYEE MAIN MENU
				log.info("=============================================");
				log.info("1) Manage Inventory");
				log.info("2) View Mutation Bids");
				log.info("3) Manager Operations");
				log.info("4) Log Out");
				log.info("=============================================");
				try {
					subOption=Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {}
					 
				switch (subOption) {
				case 1:
					int subOption2 = 0;
					do{
						log.info("\n======================================");
						log.info("Welcome to the Inventory Management Menu");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
						log.info("======================================");
						log.info("1) Mutations");
						log.info("2) Habitats");
						log.info("3) Feeders");
						log.info("4) Return");
						log.info("======================================");
						try {
							subOption2=Integer.parseInt(scan.nextLine());
						}catch(NumberFormatException e) {}
					
						switch (subOption2) {
						case 1:
							int subOption3 = 0;
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
									subOption3=Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}

								switch (subOption3) {
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
									log.info("Returning to Inventory Management Menu");
									break;
								default:
									log.info("Please only choose an option 1-5");
									break;
								}
							}while(subOption3!=5);
							break;
						case 2:
							int subOption4 = 0;
							do{
								log.info("\n=============================================");
								log.info("Select from the following to manage Habitats:");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
								log.info("=============================================");
								log.info("1) List all Habitats");
								log.info("2) Add Habitats");
								log.info("3) Remove Habitats");
								log.info("4) Edit Habitats");
								log.info("5) Return");
								log.info("======================================");
								try {
									subOption4=Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}

								switch (subOption4) {
								case 1:
									log.info("This is to List all Habitats");
									break;
								case 2:
									log.info("This is to add Habitats");
									break;
								case 3:
									log.info("This is to remove Habitats");
									break;
								case 4:
									log.info("This is to edit Habitats");
									break;
								case 5:
									log.info("Returning to Inventory Management Menu");
									break;
								default:
									log.info("Please only choose an option 1-5");
									break;
								}
							}while(subOption4!=5);               
							break;
						case 3:
							int subOption5 = 0;
							do{
								log.info("\n=============================================");
								log.info("Select from the following to manage Feeders:");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
								log.info("=============================================");
								log.info("1) List all Feeders");
								log.info("2) Add Feeders");
								log.info("3) Remove Feeders");
								log.info("4) Edit Feeders");
								log.info("5) Return");
								log.info("======================================");
								try {
									subOption5=Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}

								switch (subOption5) {
								case 1:
									log.info("This is to List all Feeders");
									break;
								case 2:
									log.info("This is to add Feeders");
									break;
								case 3:
									log.info("This is to remove Feeders");
									break;
								case 4:
									log.info("This is to edit Feeders");
									break;
								case 5:
									log.info("Returning to Inventory Management Menu");
									break;
								default:
									log.info("Please only choose an option 1-5");
									break;
								}
							}while(subOption5!=5);           
														
							break;
						case 4:                                                             //EMPLOYEE CREATE NEW CUSTOMER ACCOUNT
							log.info("Returning to Employee Menu");                              
							break;

						default:
							log.warn("Only choose between options 1-4");
							break;
						}
					} while (subOption2 != 4);

					break;
				case 2:
					log.info("This is to view and approve bids");

					break;
				case 3:
					log.info("This is to Enter Mananger Privileges");
					//HAVE TO CHECK IF EMPLOYEE IS MANAGER
					int subOption3 = 0;
					do{
						log.info("\n=============================================");
						log.info("Welcome Manager! What will you be doing today?");  //EMPLOYEE MANAGE CUSTOMER ACCOUNTS SUB MENU
						log.info("=============================================");
						log.info("1) Create Employee");
						log.info("2) Terminate Employee");
						log.info("3) Sales History");
						log.info("4) Return");
						log.info("======================================");
						try {
							subOption3=Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}

						switch (subOption3) {
						case 1:
							log.info("This is to Create Employee");
							break;
						case 2:
							log.info("This is to Terminate Employee");
							break;
						case 3:
							log.info("This is to View Sales History");
							break;
						case 4:
							log.info("Returning to Employee Menu");
							break;
						default:
							log.info("Please only choose an option 1-5");
							break;
						}
					}while(subOption3!=4);  
					

					break;
				case 4:
					log.info("Logging Out");

					break;
					
				default:
					log.warn("Please only enter a number 1-4");
					break;
				}
				}while(subOption!=4);
				
				break;
			case 4:
				log.info("Thank you for Supporting the Radioactive Reptiles Family!");

				break;

			default:
				log.warn("Please only enter a number 1-4");
				break;
			}

		} while (outerOption!= 4);
		
		scan.close();

	}

}
