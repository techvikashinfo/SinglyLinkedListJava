package com.custom.ds;

import com.custom.ds.list.SinglyLinkedList;
import com.custom.ds.list.operation.ListOperation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class CustomListProjectApplication implements CommandLineRunner {
	Logger logger = Logger.getLogger(CustomListProjectApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(CustomListProjectApplication.class, args);
	}

	private void displayMenu(){
		logger.log(Level.INFO,"*********** Please  select below menu");
		logger.log(Level.INFO,"Press 0 for list traversal");
		logger.log(Level.INFO,"Press 1 for inserting new node");
		logger.log(Level.INFO,"Press 2 for deleting by node position");
		logger.log(Level.INFO,"Press 3 for deleting by node value");
	}


	@Override
	public void run(String... args) throws Exception {
		ListOperation<Integer>  lists=new SinglyLinkedList<Integer>();
		while (true){
			displayMenu();
			Scanner scanner = new Scanner(System.in);
			int response=scanner.nextInt();

			switch(response){
				case 0: lists.traverseList(); break;
				case 1: {
					logger.log(Level.INFO,"Insert the data to be added to list :");
					scanner = new Scanner(System.in);
					Integer data=scanner.nextInt();
					logger.log(Level.INFO,"Insert the position where data has to be inserted in  list :");
					scanner = new Scanner(System.in);
					Integer position=scanner.nextInt();
					lists.insertNewNode(data,position);
					break;
				}
				case 2:{
					logger.log(Level.INFO,"Enter the node position to be deleted:");
					scanner = new Scanner(System.in);
					Integer data=scanner.nextInt();
					lists.deleteByPosition(data);
					break;
				}
				case 3:{
					logger.log(Level.INFO,"Enter the node data to be deleted:");
					scanner = new Scanner(System.in);
					Integer data=scanner.nextInt();
					lists.deleteByValue(data);
					break;
				}
				default: {
					logger.info(" No valid Menu option selected .. exiting ");
					return;
				}
			}






		}


	}
}
