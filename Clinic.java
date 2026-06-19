/*
 * 
 * Names: Auris Espinal, Jaire Bartlett, and Juliana Bruno
 * Semester Long Project
 * Title: Clinic.java
 * Description: user input determines if the program will display, delete, update, or add to the patient info, patient history, or procedures tables at a clinic
 * Date: March 2026
 * 
 */


import java.sql.*;
import java.util.Scanner;
public class Clinic {
  static final String DB_URL = "jdbc:mysql://localhost/clinic";
  static final String USER = "root";
  static final String PASS = "software";
  static String QUERY = "";//removed final bcuz of code errors
  static String QUERY2 = "";
     
     public static void main(String[] args) {
       
  	   
  	   int choice; 
  	   
  	   Scanner k = new Scanner(System.in);
  	   
  	   do {
  			System.out.println("\n<<<<<<<<<<<< Main Menu >>>>>>>>>>>");
  			System.out.println("1 - Patient Info");
  			System.out.println("2 - Patient History");
  			System.out.println("3 - Procedures");
  			System.out.println("4 - EXIT");
  			System.out.println("\nPlease make a selection from the menu:");
  			
  			choice = k.nextInt();

  	//user is modifying the patients info table
  			if(choice == 1) {
  				System.out.println("What do you want to do within the patient info table?");
  				
  				int choice2;
  				
  				do {
  					System.out.println("1 - Display");
  					System.out.println("2 - Delete");
  					System.out.println("3 - Update");
  					System.out.println("4 - Add");
  					System.out.println("5 - Return to Main Menu");
  					
  					choice2 = k.nextInt();
  					
  					if(choice2 == 1) {//Display from Patients Info Table
  						display(1);
  						
  					}else if(choice2 == 2) {//Delete from Patients Info Table
  						delete(1);
  						
  					}else if(choice2 == 3) {//Update from Patients Info Table
  						update(1);
  						
  					}else if(choice2 == 4) {//Add to Patients Info table
  						add(1);
  						
  					}else if(choice2 == 5) {//Returning to main menu
  						
  						System.out.println("\nWelcome back to the main menu!");
  					}else if(choice2 < 1 || choice2 > 5) {
  						
  						System.out.println("ERROR! Please make a valid selection...");
  					}
  					
  				}while(choice2 != 5);
  				
  	
  	//user is modifying the Patient History Table
  			}else if(choice == 2) {
  				System.out.println("What do you want to do within the patient history table?");
  				
  				int choice3;
  					
  				do {
  					System.out.println("1 - Display");
  					System.out.println("2 - Delete");
  					System.out.println("3 - Update");
  					System.out.println("4 - Add");
  					System.out.println("5 - Return to Main Menu");
  					
  					choice3 = k.nextInt();
  					
  					if(choice3 == 1) {//Display from patient history table
  						display(2);
  						
  					}else if(choice3 == 2) {//delete - patient history table
  						delete(2);
  						
  					}else if(choice3 == 3) {//update - patient history table
  						update(2);
  						
  					}else if(choice3 == 4) {//Add to Patients Info table
  						add(2);
  						
  					}else if(choice3 == 5) {//Returning to main menu
  						
  						System.out.println("\nWelcome back to the main menu!");
  					}else if(choice3 < 1 || choice3 > 5) {
  						
  						System.out.println("ERROR! Please make a valid selection...");
  					}
  					
  				
  				}while(choice3 != 5);	
  					
  	//user is modifying the Procedures Table
  			}else if(choice == 3) {
  				System.out.println("What do you want to do within the procedures table?");
  				
  				int choice4;
  				
  				do {
  					System.out.println("1 - Display");
  					System.out.println("2 - Delete");
  					System.out.println("3 - Update");
  					System.out.println("4 - Add");
  					System.out.println("5 - Return to Main Menu");
  					
  					
  					choice4 = k.nextInt();
  					
  					if(choice4 == 1) {
  						display(3);
  						
  					}else if(choice4 == 2) {
  						delete(3);
  						
  					}else if(choice4 == 3) {
  						update(3);
  						
  					}else if(choice4 == 4) {//Add to Patients Info table
  						add(3);
  						
  					}else if(choice4 == 5) {//Returning to main menu
  						
  						System.out.println("\nWelcome back to the main menu!");
  					}else if(choice4 < 1 || choice4 > 5) {
  						
  						System.out.println("ERROR! Please make a valid selection...");
  					}
  					
  					
  				}while(choice4 != 5);
  				
  			}//end of Procedure Table options
  			
  			
  	//user selection error handling 
  			if(choice < 1 || choice > 5) {
  				
  				System.out.println("ERROR! Please make a valid selection...");
  			}
  			
  		}while (choice != 5);//end of outer do while loop
  		
  		System.out.println("Thank you for using PurpleLight Clinic program :)");
  		
  		k.close();
  	   
    }//end main method	   
     
     public static void display(int i) {//select option from menu
  	 
     //select for patients info table
  	  if(i == 1) {
  	   QUERY = "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  	
  	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	         Statement stmt = conn.createStatement();
  	         ResultSet rs = stmt.executeQuery(QUERY);) {
  	         // Extract data from result set
  	    	  
  	    	 System.out.println("Patient ID    First Name     Last Name     Sex   Pronouns      DOB               Address            Phone Num.         Insurance Information");
  	         System.out.println("----------   ------------   ------------   ---   --------   ----------   -----------------------   ------------   --------------------------------");
  	            
  	         while (rs.next()) {
  	            
  	        	//Old version of print statements
  	        	/**System.out.println("Patient ID: " + rs.getInt("patient_id"));
  	            System.out.println(", First Name: " + rs.getString("first"));
  	            System.out.println(", Last Name: " + rs.getString("last"));
  	            System.out.println(", Sex: " + rs.getString("sex"));
  	            System.out.println(", Pronouns: " + rs.getString("pronouns"));
  	            System.out.println(", DOB: " + rs.getString("dob"));
  	            System.out.println(", Address: " + rs.getString("address"));
  	            System.out.println(", Phone: " + rs.getString("phone"));
  	            System.out.println(", Insurance Info: " + rs.getString("insurance_info"));
  	            **/
  	        	 
  	            System.out.printf("%-13s%-15s%-15s%-6s%-11s%-13s%-26s%-15s%-32s%n", 
  	            		rs.getInt("patient_id"), rs.getString("first"), rs.getString("last"), rs.getString("sex"),
  	            		rs.getString("pronouns"), rs.getString("dob"), rs.getString("address"), rs.getString("phone"), rs.getString("insurance_info"));
  	            System.out.println();   
  	         }
  	         
  	      }catch (SQLException e) {
  	         e.printStackTrace();
  	      }//end try-catch method
  	  
     //select for patients history table
  	  }else if(i == 2) {
  		  QUERY = "SELECT patient_history_id, dop, patient_id, procedure_id FROM Pt_history";
  		  
  		  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  			  Statement stmt = conn.createStatement();
  			  ResultSet rs = stmt.executeQuery(QUERY);) {
  	         // Extract data from result set
  			  System.out.println("Patient History ID   Patient ID   Procedure ID   Date of Procedure");
  	          System.out.println("------------------   ----------   ------------   -----------------");
  	            
  	         while (rs.next()) {
  	            
  	        	 //Old version of print statements
  	        	/**System.out.print("Patient History ID: " + rs.getInt("patient_history_id"));
  	        	System.out.print(", Patient ID: " + rs.getInt("patient_id"));
  	        	System.out.print(", Procedure ID: " + rs.getInt("procedure_id"));
  	            System.out.println(", Date of Procedure: " + rs.getString("dop"));
  	            **/
  	            System.out.printf("%-21s%-13s%-15s%-17s%n", rs.getInt("patient_history_id"), rs.getInt("patient_id"),
  	            					rs.getInt("procedure_id"), rs.getString("dop"));
  	            System.out.println();
  	         }
  	         
  	      }catch (SQLException e) {
  	         e.printStackTrace();
  	      }//end of try-catch  
  	  
     //select for procedures table  
  	  }else if (i == 3) {
  		  QUERY = "SELECT procedure_id, procedure_name, pr_region FROM Procedures";
  		  
  		  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	         Statement stmt = conn.createStatement();
  	         ResultSet rs = stmt.executeQuery(QUERY);) {
  	         
  			  // Extract data from result set
  			  System.out.println("Procedure ID              Procedure                        Procedure Region"); 
  	          System.out.println("------------   --------------------------------   -------------------------------------");
  	            
  	         while (rs.next()) {
  	            
  	        	 //Old version of print statements
  	        	/**System.out.print("Procedure ID: " + rs.getInt("procedure_id"));
  	            System.out.print(", Procedure: " + rs.getString("procedure_name"));
  	            System.out.println(", Procedure Region: " + rs.getString("pr_region"));
  	            **/
  	            
  	            System.out.printf("%-15s%-35s%-37s%n", rs.getInt("procedure_id"),
  	            					rs.getString("procedure_name"), rs.getString("pr_region")); 
  	            System.out.println();
  	         }
  	         
  	      }catch (SQLException e) {
  	         e.printStackTrace();
  	      }//end of try-catch
  		  
  	  }//end of choice if statement
  	  
     }//end of display static method
     
    
     public static void delete(int i) {
  	 Scanner j = new Scanner(System.in);
  	 
     //delete from patient's info table
  	 if(i == 1) {
  		 
  		 boolean isValid = false;
  		 int id = 0;

  		 do {
  		     System.out.println("Enter ID of the patient you want to delete:");
  		     id = j.nextInt();

  		     String checkQuery = "SELECT patient_id FROM Patient WHERE patient_id = " + id;

  		     try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		          Statement stmt = conn.createStatement();
  		          ResultSet rs = stmt.executeQuery(checkQuery)) {

  		         if (rs.next()) {
  		             isValid = true;
  		         } else {
  		             System.out.println("\nInvalid ID. Please try again.");
  		         }

  		     } catch (SQLException e) {
  		         e.printStackTrace();
  		     }

  		 } while (!isValid);

  		 // Only after the ID is confirmed valid:
  		 QUERY = "DELETE FROM Patient WHERE patient_id = " + id;
  		 QUERY2 = "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  	
  	   
  	   
  	    //Open a connection
  	      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	         Statement stmt = conn.createStatement();
  	      ) {

  	         stmt.executeUpdate(QUERY);
  	         ResultSet rs=stmt.executeQuery(QUERY2);
  	     
  	      } catch (SQLException e) {
  	         e.printStackTrace();
  	      }
  	      
     //delete from patient history table
  	 }else if(i == 2) {
  		 
  		 boolean isValid = false;
  		 int hisId = 0;

  		 do {
  		     System.out.println("Enter ID of the history record to delete:");
  		     hisId = j.nextInt();

  		     String checkQuery = "SELECT patient_history_id FROM Pt_history WHERE patient_history_id = " + hisId;

  		     try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		          Statement stmt = conn.createStatement();
  		          ResultSet rs = stmt.executeQuery(checkQuery)) {

  		         if (rs.next()) {
  		             isValid = true;
  		         } else {
  		             System.out.println("\nInvalid ID. Please try again.");
  		         }

  		     } catch (SQLException e) {
  		         e.printStackTrace();
  		     }

  		 } while (!isValid);

  		 QUERY = "DELETE FROM Pt_history WHERE patient_history_id = " + hisId;
  		 QUERY2 = "SELECT patient_history_id, dop, patient_id, procedure_id FROM Pt_history";
  			  
  		// Open a connection
  	      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	         Statement stmt = conn.createStatement();
  	      ) {

  	         stmt.executeUpdate(QUERY);
  	         ResultSet rs=stmt.executeQuery(QUERY2);
  	     
  	      } catch (SQLException e) {
  	         e.printStackTrace();
  	      }
  	
     //delete from procedure table	 
  	 }else if(i == 3) {
  		 
  		 boolean isValid = false;
  		 int proID = 0;

  		 do {
  		     System.out.println("Enter ID of the procedure to delete:");
  		     proID = j.nextInt();

  		     String checkQuery = "SELECT procedure_id FROM Procedures WHERE procedure_id = " + proID;

  		     try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		          Statement stmt = conn.createStatement();
  		          ResultSet rs = stmt.executeQuery(checkQuery)) {

  		         if (rs.next()) {
  		             isValid = true;
  		         } else {
  		             System.out.println("\nInvalid ID. Please try again.");
  		         }

  		     } catch (SQLException e) {
  		         e.printStackTrace();
  		     }

  		 } while (!isValid);
  		 
  		 QUERY = "Delete FROM Procedures WHERE procedure_id = " + proID;
  		 QUERY2 = "SELECT procedure_id, procedure_name, pr_region FROM Procedures";
  		 
  		 
  		// Open a connection
  	      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	         Statement stmt = conn.createStatement();
  	      ) {

  	         stmt.executeUpdate(QUERY);
  	         ResultSet rs=stmt.executeQuery(QUERY2);
  	     
  	      } catch (SQLException e) {
  	         e.printStackTrace();
  	      }
  	
  	 }//end of choice if statement
  	 
     }//end of delete static method
     
     
     public static void update(int i) {
  	   Scanner g = new Scanner(System.in);
  	   
     //update for patient's info table 
  	   if(i == 1) {
  		   // Variable that keeps track of whether the entered patient ID exists
  		   boolean isValid = false;

  		   // Variable to store the patient's ID
  		   int patID = 0;

  		   // Keep asking until the user enters an existing patient ID
  		   do {
  			   
  		       // Ask the user which patient they want to update
  		       System.out.println("Enter ID of the patient to update:");

  		       // Read the ID entered by the user
  		       patID = g.nextInt();

  		       // SQL query to check whether that patient ID exists in the Patient table
  		       String checkQuery = "SELECT patient_id FROM Patient WHERE patient_id = " + patID;

  		       try (

  		           // Connect to the database
  		           Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

  		           // Create a Statement object to run the query
  		           Statement stmt = conn.createStatement();

  		           // Execute the query and store the result
  		           ResultSet rs = stmt.executeQuery(checkQuery)
  		       ) {
  		           // If a row is returned, the patient ID exists
  		           if (rs.next()) {
  		               isValid = true;
  		           }

  		           // Otherwise, tell the user the ID is invalid
  		           else {
  		               System.out.println("\nInvalid ID. Please try again.");
  		           }

  		       } catch (SQLException e) {

  		           // Print any SQL errors
  		           e.printStackTrace();
  		       }

  		   // Continue looping until a valid ID is entered
  		   } while (!isValid);

  		   // Now continue with update menu 
  		   System.out.println("\nChoose what to update about the patient:");
  		   
  		   int selection;
  		   
  		   do {
  			    System.out.println("1 - First Name");
  				System.out.println("2 - Last Name");
  				System.out.println("3 - Sex");
  				System.out.println("4 - Pronouns");
  				System.out.println("5 - Date of Birth");
  				System.out.println("6 - Address");
  				System.out.println("7 - Phone Number");
  				System.out.println("8 - Insurance Info");
  				System.out.println("9 - Return");
  				
  				selection = g.nextInt();
  				
  			  //modifying first name
  				if(selection == 1) {
  					System.out.println("Enter new first name:");
  					
  					String name;
  					
  					name = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Patient SET first = '" + name + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      } 
  			   
  			  //modifying last name 
  				}else if(selection == 2) {
  					System.out.println("Enter new last name:");
  					
  					String name;
  					
  					name = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Patient SET last = '" + name + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      } 
  					 
  			  //modifying sex
  				}else if(selection == 3) {
  					System.out.println("Enter new sex:");
  					
  					String sex;
  					
  					sex = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Patient SET sex = '" + sex + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  			  //modifying pronouns
  				}else if(selection == 4) {
  					System.out.println("Enter new pronouns:");
  					
  					String prns;
  					
  					prns = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Patient SET pronouns = '" + prns + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  			  //modifying date of birth
  				}else if(selection == 5) {
  					System.out.println("Enter date of birth: ");
  					
  					String dob;
  					
  					dob = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Patient SET dob = '" + dob + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  			  //modifying address
  				}else if(selection == 6) {
  					System.out.println("Enter address:");
  					
  					String address;
  					
  					g.nextLine(); // clear leftover newline from previous nextInt()
  					address = g.nextLine(); // read FULL line including spaces
  					QUERY = "UPDATE Patient SET address = '" + address + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {

  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  				
  			  //modifying phone number
  				}else if(selection == 7) {
  					System.out.println("Enter phone number:");
  					
  					String phoneNum;
  					
  					g.nextLine(); // clear leftover newline from previous nextInt()
  					phoneNum = g.nextLine(); // read FULL line including spaces
  					QUERY = "UPDATE Patient SET phone = '" + phoneNum + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  	
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  			
  		      //modifying insurance info
  			    }else if(selection == 8) {
  			    	System.out.println("Enter insurance info:");
  					
  					String insurInfo;
  					
  					g.nextLine(); // clear leftover newline from previous nextInt()
  					insurInfo = g.nextLine(); // read FULL line including spaces
  					QUERY = "UPDATE Patient SET insurance_info = '" + insurInfo + "' WHERE patient_id = " + patID;
  					QUERY2= "SELECT patient_id, first, last, sex, pronouns, dob, address, phone, insurance_info FROM Patient";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  		
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }	
  			  //error modifying user's choice   
  			    }else if(selection < 1 || selection > 9) {
  					
  					System.out.println("ERROR! Please make a valid selection...");
  				}
  				
     
        
  		   }while(selection != 9);
     
     //update for patient history table
  	   }else if(i == 2) {//main else
     
  		    boolean isValid = false;
  		    int patID = 0;
  	
  		    do {
  		        System.out.println("Enter patient history ID for update:");
  	
  		        patID = g.nextInt();
  	
  		        String checkQuery =
  		            "SELECT patient_history_id FROM Pt_history WHERE patient_history_id = " + patID;
  	
  		        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		             Statement stmt = conn.createStatement();
  		             ResultSet rs = stmt.executeQuery(checkQuery)) {
  	
  		            if (rs.next()) {
  		                isValid = true;
  		                
  		            }else{
  		                System.out.println("\nInvalid ID. Please try again.");
  		            }
  	
  		        } catch (SQLException e) {
  		            e.printStackTrace();
  		        }
  	
  		    }while(!isValid);
  		    //end do-while
  	
  		   System.out.println("\nChoose what to update about this history:");
  		   
  		   int selection;
  	   
  		   do {
  			    System.out.println("1 - Date of Procedure");
  				System.out.println("2 - Patient ID");
  				System.out.println("3 - Procedure ID");
  				System.out.println("4 - Return");
  			
  				selection = g.nextInt();
  				
  			  //update date of procedure
  				if(selection == 1) {
  					System.out.println("Enter new date of procedure:");
  					
  					String dop;
  					
  					dop = g.next();
  					g.nextLine();
  					QUERY = "UPDATE Pt_history SET dop = '" + dop + "' WHERE patient_history_id = " + patID;
  					QUERY2 = "SELECT patient_history_id, dop, patient_id, procedure_id FROM Pt_history";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  	
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  			  //update new patient ID
  				}else if(selection == 2) {
  					System.out.println("Enter new patient ID:");
  					
  					int patID2;
  					
  					patID2 = g.nextInt();
  					g.nextLine();
  					QUERY = "UPDATE Pt_history SET patient_id = '" + patID2 + "' WHERE patient_history_id = " + patID;
  					QUERY2 = "SELECT patient_history_id, dop, patient_id, procedure_id FROM Pt_history";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  	
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  	          //update new procedure ID
  				}else if(selection == 3) {
  					System.out.println("Update new procedure id:");
  					
  					int proID;
  					
  					proID = g.nextInt();
  					g.nextLine();
  					QUERY = "UPDATE Pt_history SET procedure_id = '" + proID + "' WHERE patient_history_id = " + patID;
  					QUERY2 = "SELECT patient_history_id, dop, patient_id, procedure_id FROM Pt_history";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  	
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      } 
  	
  				}else if(selection < 1 || selection > 4) {
  					
  					System.out.println("ERROR! Please make a valid selection...");
  				}//end of if stmt
  				
  	
  		   	}while(selection != 4);//end do-while
  		
     //update procedures table
  	   	}else if(i == 3) {
  	
  	   	    // Variable to track whether the procedure ID exists
  	   		boolean isValid = false;
  	
  	   	    // Variable to store the procedure ID entered by the user
  	   	    int proID = 0;
  	
  	   	    // Keep asking until a valid procedure ID is entered
  	   	    do {
  	
  	   	        System.out.println("Enter procedure ID to update:");
  	
  	   	        proID = g.nextInt();
  	
  	   	        // Query to check whether the entered procedure ID exists
  	   	        String checkQuery =
  	   	            "SELECT procedure_id FROM Procedures WHERE procedure_id = " + proID;
  	
  	   	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	   	             Statement stmt = conn.createStatement();
  	   	             ResultSet rs = stmt.executeQuery(checkQuery)) {
  	
  	   	            // If a record is found, the ID is valid
  	   	            if (rs.next()) {
  	   	                isValid = true;
  	   	            } else {
  	   	                System.out.println("\nInvalid ID. Please try again.");
  	   	            }
  	
  	   	        } catch (SQLException e) {
  	   	            e.printStackTrace();
  	   	        }
  	
  	   	    }while(!isValid);//end do-while loop
  	
  	   	    System.out.println("Choose what to update about this procedure:");
  	
  	   	    int selection;
  	 	   
  	   	    do {
  			    System.out.println("1 - Procedure Name");
  				System.out.println("2 - Procedure Region");
  				System.out.println("3 - Return");
  	
  				selection = g.nextInt();
  				
  			  //update new procedure name
  				if(selection == 1) {
  					System.out.println("Enter new procedure name:");
  					
  					String proName;
  					
  					g.nextLine();              // clear leftover newline from nextInt()
  					proName = g.nextLine();    // read full input including spaces
  					QUERY = "UPDATE Procedures SET procedure_name = '" + proName + "' WHERE procedure_id = " + proID;
  					QUERY2 = "SELECT procedure_id, procedure_name, pr_region FROM Procedures";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  	
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      }catch(SQLException e) {
  					         e.printStackTrace();
  					      }
  					 
  	 	      //update new procedure region
  			   	}else if(selection == 2) {
  			   		System.out.println("Enter new procedure region:");
  					
  					String proReg;
  					
  					g.nextLine();
  					proReg = g.nextLine();
  					QUERY = "UPDATE Procedures SET pr_region = '" + proReg + "' WHERE procedure_id = " + proID;
  					QUERY2 = "SELECT procedure_id, procedure_name, pr_region FROM Procedures";
  					
  					 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  					         Statement stmt = conn.createStatement();
  					      ) {
  			
  					         stmt.executeUpdate(QUERY);
  					         ResultSet rs=stmt.executeQuery(QUERY2);
  					      
  					      } catch (SQLException e) {
  					         e.printStackTrace();
  					      }
  			   	}else if(selection < 1 || selection > 4) {
  					
  					System.out.println("ERROR! Please make a valid selection...");
  				}//end of if statement
  	
  	   	    }while(selection != 3);
  	    
  	   	}//end of choice if statement
  	   
     }//end of update static method 
     
     public static void add(int i) {
  	 Scanner a = new Scanner(System.in);
  	 
  	   
  	   if(i == 1) {//add to patient info table
  		   boolean exists = false;
  		   int id;

  		   do {
  		       System.out.print("Enter Patient ID: ");
  		       id = a.nextInt();

  		       String checkQuery = "SELECT patient_id FROM Patient WHERE patient_id = " + id;

  		       try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		            Statement stmt = conn.createStatement();
  		            ResultSet rs = stmt.executeQuery(checkQuery)) {

  		           if (rs.next()) {
  		               // ID already exists → NOT allowed
  		               exists = true;
  		               System.out.println("\nERROR: That Patient ID already exists. Try a different ID.");
  		           } else {
  		               // ID does NOT exist → OK to use
  		               exists = false;
  		           }

  		       } catch (SQLException e) {
  		           e.printStackTrace();
  		       }

  		   } while (exists);
  		   a.nextLine(); // clear buffer

  		   System.out.print("First Name: ");
  		   String first = a.nextLine();

  	        System.out.print("Last Name: ");
  	        String last = a.nextLine();

  	        System.out.print("Sex: ");
  	        String sex = a.nextLine();

  	        System.out.print("Pronouns: ");
  	        String pronouns = a.nextLine();

  	        System.out.print("DOB: ");
  	        String dob = a.nextLine();

  	        System.out.print("Address: ");
  	        String address = a.nextLine();

  	        System.out.print("Phone: ");
  	        String phone = a.nextLine();

  	        System.out.print("Insurance Info: ");
  	        String insurance = a.nextLine();

  	        QUERY = "INSERT INTO Patient VALUES (" + id + ", '" + first + "', '" + last + "', '" +
  	                sex + "', '" + pronouns + "', '" + dob + "', '" + address + "', '" +
  	                phone + "', '" + insurance + "')";

  	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  	             Statement stmt = conn.createStatement()) {

  	            stmt.executeUpdate(QUERY);
  	            System.out.println("Patient added successfully.");

  	        } catch (SQLException e) {
  	            e.printStackTrace();
  	        }
     }
   }//end of if statement   
  }//end of class
     

