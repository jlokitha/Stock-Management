import java.util.Scanner;

class StockManagement {
    public static Scanner s = new Scanner(System.in);
    public static String[] unAndPw = {"admin", "admin"};
    public static String[][] suppliers = new String[0][0];
    public static String[] category = new String[0];
    public static String[][][] items =  new String[0][0][0];

    public static void main(String[] args){

        logIn();
    }

    public static void logIn() {
        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t  LOGIN PAGE\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        while(true) {
            System.out.print("Enter your username: ");
            String un = s.next();

            if(un .equals(unAndPw[0])) {
                while(true) {
                    System.out.print("\nEnter your password: ");
                    String pw = s.next();

                    if (pw.equals(unAndPw[1])) {
                        homePage();
                        return;

                    } else {
                        System.out.println("Password is incorrect. Please try again!");
                    }
                }
            }else{
                System.out.println("User name is invalid. Please try again!\n");
            }
        }
    }

    public static void homePage() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t WELCOME TO PIGEON STOCK MANAGEMENT SYSTEM\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Change the credentials\t\t[2] Supplier manage\n[3] Stock manage\t\t\t[4] Log out\n[5] Exit the system\n");

        L1:
        while(true){
            System.out.print("Enter an option to continue >  ");
            String option = s.next();

            switch (option) {

                case "1":
                    changeTheCredentials();
                    break L1;
                case "2":
                    supplierManage();
                    break L1;
                case "3":
                    stockManage();
                    break L1;
                case "4":
                    clearConsole();
                    logIn();
                    break L1;
                case "5":
                    clearConsole();
                    System.out.println("━━━━━━━━━━━━━━━\n   Thank you\n━━━━━━━━━━━━━━━");
                    return;
                default:
                    System.out.println("Not an option! try again.\n");
            }
        }
    }

    public static void  changeTheCredentials() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tCREDENTIAL MANAGE\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Please enter the user name to verify it's you: ");
            String un = s.next();

            if (un.equals(unAndPw[0])) {
                System.out.println("\nHey " + unAndPw[0]);

                while(true) {
                    System.out.print("\nEnter your current password: ");
                    String pw = s.next();

                    if (pw.equals(unAndPw[1])) {
                        System.out.print("\nEnter your new password: ");
                        String newPs = s.next();

                        unAndPw[1] = newPs;
                        System.out.print("\nPassword changed successfully! Do you want to go home page (Y/N) : ");
                        String check = s.next();

                        while(true){
                            if(check .equals("Y") || check .equals("y")) {
                                clearConsole();
                                homePage();
                                break L1;
                            }else if(check .equals("N") || check .equals("n")){
                                clearConsole();
                                logIn();
                                break L1;
                            }else{
                                System.out.print("\nInvalid option! try again. Do you want to go home page (Y/N) ? ");
                                check = s.next();
                            }
                        }
                    }else{
                        System.out.println("Incorrect password. try again!");
                    }
                }
            }else{
                System.out.println("Invalid user name. try again!\n");
            }
        }
    }

    public static void supplierManage() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSUPPLIER MANAGE\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Add supplier\t\t[2] Update supplier\n[3] Delete supplier\t\t[4] View suppliers\n[5] Search supplier\t\t[6] Home page\n");
        L1:
        while(true){
            System.out.print("Enter an option to continue >  ");
            String option = s.next();

            switch (option) {

                case "1":
                    addSupplier();
                    break L1;
                case "2":
                    updateSupplier();
                    break L1;
                case "3":
                    deleteSupplier();
                    break L1;
                case "4":
                    viewSuppliers();
                    break L1;
                case "5":
                    searchSupplier();
                    break L1;
                case "6":
                    clearConsole();
                    homePage();
                    break L1;
                default:
                    System.out.println("Not an option! try again.\n");
            }
        }
    }

    public static void addSupplier() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t ADD SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        suppliers = growArray();

        L1:
        while(true) {
            System.out.print("\nSupplier  ID\t: ");
            String Id = s.next();

            if(checkDuplicateId(Id)) {   //Verify that this ID has not been used previously
                System.out.println("Already exists! try another supplier id.");
                continue;
            }else{
                System.out.print("Supplier  Name\t: ");
                String name = s.next();

                suppliers[suppliers.length - 1][0] = Id;
                suppliers[suppliers.length - 1][1] = name;
            }
            System.out.print("\nAdded successfully! Do you want to add another supplier (Y/N) ? ");
            String check = s.next();

            while(true){
                if (check .equals("Y") || check .equals("y")) {
                    clearConsole();
                    addSupplier();
                    break L1;
                } else if (check .equals("N") || check .equals("n")) {
                    clearConsole();
                    supplierManage();
                    break L1;
                }else{
                    System.out.print("\nInvalid option! try again. Do you want to add another supplier (Y/N) ? ");
                    check = s.next();
                }
            }
        }
    }

    public static void updateSupplier() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t UPDATE SUPPLIER\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String ID = s.next();

            int supplierIndex = -1;
            supplierIndex = findSupplier(ID);  //Find the index of specific suppliers in an array

            if (supplierIndex != -1) {
                System.out.println("Supplier Name\t: " + suppliers[supplierIndex][1]);

                System.out.print("\nEnter the new supplier name : ");
                String name = s.next();

                suppliers[supplierIndex][1] = name;
                System.out.print("\nUpdate Successfully! Do you want to update another supplier (Y/N) ? ");
                String check = s.next();

                while(true){
                    if (check .equals("Y") || check .equals("y")) {
                        clearConsole();
                        updateSupplier();
                        break L1;
                    } else if (check .equals("N") || check .equals("n")) {
                        clearConsole();
                        supplierManage();
                        break L1;
                    }else{
                        System.out.print("\nInvalid option! try again. Do you want to update another supplier (Y/N) ? ");
                        check = s.next();
                    }
                }
            } else {
                System.out.println("Can't find supplier  id. try again!\n");
            }
        }
    }

    public static  void deleteSupplier() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t DELETE SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String id = s.next();

            int  supplierIndex = -1;
            supplierIndex = findSupplier(id);  //Find the index of specific suppliers in an array

            if(supplierIndex != -1) {
                suppliers = shrinkArray(supplierIndex);  //Delete specific suppliers from an array
                deleteCopySupplierItem(id);              //Delete items that supplier provide

                System.out.print("\nDelete successfully! Do you want to delete another supplier (Y/N) ? ");
                String check = s.next();

                while(true) {
                    if (check .equals("Y") || check .equals("y")) {
                        clearConsole();
                        deleteSupplier();
                        break L1;
                    } else if (check .equals("N") || check .equals("n")) {
                        clearConsole();
                        supplierManage();
                        break L1;
                    }else{
                        System.out.print("\nInvalid option! try again. Do you want to delete another supplier (Y/N) ? ");
                        check = s.next();
                    }
                }
            }else{
                System.out.println("Can't find supplier id. try again!\n");
            }
        }
    }

    public static void viewSuppliers() {
        clearConsole();

        System.out.print("+-------------------------------------------------------------------------------+\n|\t\t\t\t VIEW SUPPLIERS\t\t\t\t\t|\n+-------------------------------------------------------------------------------+\n\n");

        if(suppliers.length > 0) {
            System.out.printf("%s\n%c%16S%5c%17S%4c\n%s\n", "+--------------------+--------------------+", '|', "SUPPLIER ID", '|', "SUPPLIER NAME", '|', "+--------------------+--------------------+");

            for (int i = 0; i < suppliers.length; i++) {
                System.out.printf("%-8c%-13s%-8c%-13s%c\n", '|', suppliers[i][0], '|', suppliers[i][1], '|');
            }

            System.out.println("+--------------------+--------------------+");

            System.out.print("\nDo you want to go supplier manage page (Y/N) ? ");
            String check = s.next();

            while(true) {
                if (check.equals("Y") || check.equals("y")) {
                    clearConsole();
                    supplierManage();
                    break;
                } else if (check.equals("N") || check.equals("n")) {
                    clearConsole();
                    homePage();
                    break;
                } else {
                    System.out.print("\nInvalid option! try again. Do you want to go supplier manage page (Y/N) ? ");
                    check = s.next();
                }
            }
        }else{
            System.out.print("Can't find any suppliers! Do you want to add suppliers (Y/N) ? ");
            String check = s.next();
            while(true){
                if(check .equals("Y") || check .equals("y")){
                    clearConsole();
                    addSupplier();
                    break;
                }else if(check .equals("N") || check .equals("n")){
                    clearConsole();
                    supplierManage();
                    break;
                }else{
                    System.out.print("\nInvalid option! try again. Do you want to add suppliers (Y/N) ? ");
                    check = s.next();
                }
            }
        }
    }

    public static void searchSupplier() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t SEARCH SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String id = s.next();

            int supplierIndex = -1;
            supplierIndex = findSupplier(id);  //Find the index of specific suppliers in an array

            if (supplierIndex != -1) {
                System.out.println("Supplier Name\t: " + suppliers[supplierIndex][1]);

                System.out.print("\nDo you want to find another supplier (Y/N) ? ");
                String check = s.next();

                while(true) {
                    if (check.equals("Y") || check.equals("y")) {
                        clearConsole();
                        searchSupplier();
                        break L1;
                    } else if (check.equals("N") || check.equals("n")) {
                        clearConsole();
                        supplierManage();
                        break L1;
                    }else{
                        System.out.print("\nInvalid option! try again. Do you want to find another supplier (Y/N) ? ");
                        check = s.next();
                    }
                }
            } else {
                System.out.println("Can't find supplier id! try again.\n");
            }
        }
    }

    public static void stockManage() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSTOCK MANAGEMENT\t\t\t       |\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Manage item categories\t\t[2] Add item\n[3] Get item supplier wise\t\t[4] View items\n[5] Rank item per unit Price\t\t[6] Home page\n");

        L1:
        while(true){
            System.out.print("Enter an option to continue > ");
            String option = s.next();

            switch (option) {
                case "1":
                    manageItemCategories();
                    break L1;
                case "2":
                    addItem();
                    break L1;
                case "3":
                    getItemSupplierWise();
                    break L1;
                case "4":
                    viewItems();
                    break L1;
                case "5":
                    rankItemPerUnitPrice();
                    break L1;
                case "6":
                    clearConsole();
                    homePage();
                    break L1;
                default :
                    System.out.println("Not an option! try again.\n");
            }
        }
    }

    public static void manageItemCategories() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t      MANAGE ITEM CATEGORY\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Add new item category\t\t[2] Delete item category\n[3] Update item category\t\t[4] Stock management\n");

        L1:
        while (true) {
            System.out.print("Enter an option to continue > ");
            String option = s.next();

            switch (option) {
                case "1":
                    addNewItemCategory();
                    break L1;
                case "2":
                    deleteItemCategory();
                    break L1;
                case "3":
                    updateItemCategory();
                    break L1;
                case "4":
                    clearConsole();
                    stockManage();
                    break L1;
                default :
                    System.out.println("Not an option! try again.\n");
            }
        }
    }

    public static void addNewItemCategory() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tADD ITEM CATEGORY\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        category = growArray(category);   //Grow category array to save category type
        items = growArrayCategory(items);  //Grow items array to add items to that category

        L1:
        while(true) {
            System.out.print("Enter the new item category : ");
            String type = s.next();

            int index = -1;
            index = checkCategory(type);   //Make sure category name doesn't duplicate

            if (index != -1) {
                System.out.println("Category already exist!\n");
            }else {
                category[category.length - 1] = type;
                System.out.print("\nAdded successfully! Do you want to add another category (Y/N) ? ");
                String check = s.next();

                while(true) {
                    if (check.equals("Y") || check.equals("y")) {
                        clearConsole();
                        addNewItemCategory();
                        break L1;
                    } else if (check.equals("N") || check.equals("n")) {
                        clearConsole();
                        manageItemCategories();
                        break L1;
                    }else{
                        System.out.print("\nInvalid option! try again. Do you want to add another category (Y/N) ? ");
                        check = s.next();
                    }
                }
            }
        }
    }

    public static void updateItemCategory(){
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t     UPDATE ITEM CATEGORY\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Enter current category name : ");
            String type = s.next();

            int index = -1;
            index = checkCategory(type);    //Find the index of the category

            if(index != -1){
                System.out.print("\nEnter new category name : ");
                String name = s.next();

                category[index] = name;

                System.out.print("\nUpdate Successfully! Do you want to update another category (Y/N) ? ");
                String check = s.next();

                while(true) {
                    if (check.equals("Y") || check.equals("y")) {
                        clearConsole();
                        updateItemCategory();
                        break L1;
                    } else if (check.equals("N") || check.equals("n")) {
                        clearConsole();
                        manageItemCategories();
                        break L1;
                    }else {
                        System.out.print("\nInvalid option! try again. Do you want to update another category (Y/N) ? ");
                        check = s.next();
                    }
                }
            }else{
                System.out.println("Can't find category! try  again.\n");
            }
        }
    }

    public static void deleteItemCategory() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t      DELETE ITEM CATEGORY\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Enter category type : ");
            String type = s.next();

            int index = -1;
            index = checkCategory(type);  //Find the index of the category

            if(index != -1){
                category = removeCategory(index);   //Remove category from category array
                items = removeCategory(items, index);   //Remove items that belong to the category

                System.out.print("\nDelete Successfully! Do you want to delete another category (Y/N) ? ");
                String check = s.next();

                while(true) {
                    if (check.equals("Y") || check.equals("y")) {
                        clearConsole();
                        deleteItemCategory();
                        break L1;
                    } else if (check.equals("N") || check.equals("n")) {
                        clearConsole();
                        manageItemCategories();
                        break L1;
                    } else {
                        System.out.print("\nInvalid option! try again. Do you want to delete another category (Y/N) ? ");
                        check = s.next();
                    }
                }
            }else{
                System.out.println("Can't find category! try  again.\n");
            }
        }
    }

    public static void addItem() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tADD ITEM\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        if(category.length == 0) {  //Make sure system have categories
            System.out.print("Oops! It seems that you don't have any item categories in the system.\nDo you want to add a new item category (Y/N) ? ");
            String check = s.next();

			while(true){
				if(check .equals("Y") || check .equals("y")) {
					clearConsole();
					addNewItemCategory();
					break;
				}else if(check .equals("N") || check .equals("n")) {
					clearConsole();
					stockManage();
					break;
				}else{
					System.out.print("\nInvalid option! try again. Do you want to add a new item category (Y/N) ? ");
					check = s.next();
				}
			}
        }else if(suppliers.length == 0) {  //Make sure system have suppliers
            System.out.print("Oops! It seems that you don't have any suppliers in the system.\nDo you want to add a new supplier (Y/N) ? ");
            String check = s.next();

			while(true){
				if(check .equals("Y") || check .equals("y")){
					clearConsole();
					addSupplier();
					break;
				}else if(check .equals("N") || check .equals("n")){
					clearConsole();
					stockManage();
					break;
				}else{
					System.out.print("\nInvalid option! try again. Do you want to add a new supplier (Y/N) ? ");
					check = s.next();
				}
			}
        }else{
            L1:
            while(true) {
                System.out.print("Item code\t: ");
                String code = s.next();

                if (checkDuplicateItem(code)) {  //Make sure item code doesn't duplicate
                    System.out.println("Item code already exist! try again.\n");
                }else{
                    int sIndex = -1;
                    int cIndex = -1;

                    printSuppliers();

                    while(true){
                        System.out.print("Enter the supplier number > ");
                        String sNumber = s.next();

						if(isNumber(sNumber)){
							sIndex = Integer.parseInt(sNumber);
							if(sIndex > 0 && (sIndex - 1) < suppliers.length){  //Make sure supplier number is valid
								break;
							}else {
								System.out.println("Enter number from table!\n");
							}
                        }else {
                            System.out.println("Enter valid number!\n");
                        }
                    }

                    printCategory();

                    while(true){
                        System.out.print("Enter the category number > ");
                        String cNumber = s.next();

						if(isNumber(cNumber)){
							cIndex = Integer.parseInt(cNumber);
							if(cIndex > 0 && (cIndex - 1) < category.length){   //Make sure category number is valid
								break;
							}else {
								System.out.println("Enter number from table!\n");
							}
                        }else {
                            System.out.println("Enter valid number!\n");
                        }
                    }

                    System.out.print("\nDescription :");
                    String description = s.next();

                    System.out.print("\nUnit price : ");
                    String price = s.next();

                    System.out.print("\nQty on hand : ");
                    String qty = s.next();

                    int index = cIndex - 1;

                    growArrayItem(index);   //Grow array belong to specific category to add item data

                    items[index][items[index].length - 1][0] = suppliers[sIndex - 1][0];
                    items[index][items[index].length - 1][1] = code;
                    items[index][items[index].length - 1][2] = description;
                    items[index][items[index].length - 1][3] = price;
                    items[index][items[index].length - 1][4] = qty;

                    System.out.print("\nAdded successfully! Do you want to add another item (Y/N) ? ");
                    String check = s.next();

                    while(true){
                        if(check .equals("Y") || check .equals("y")){
                            clearConsole();
                            addItem();
                            break L1;
                        }else if(check .equals("N") || check .equals("n")){
                            clearConsole();
                            stockManage();
                            break L1;
                        }else{
                            System.out.print("\nInvalid option! try again. Do you want to add another item (Y/N) ? ");
                            check = s.next();
                        }
                    }
                }
            }
        }
    }

    public static void getItemSupplierWise() {
        clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSEARCH SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        if (suppliers.length != 0) {   //Check whether the system has suppliers
            L1:
            while (true) {
                System.out.print("Enter supplier id\t: ");
                String id = s.next();

                int index = -1;
                index = findSupplier(id);  //Verify the existence of specific suppliers

                if (index != -1) {
                    System.out.println("\nSupplier name\t\t: " + suppliers[index][1] + "\n\n");

                    System.out.printf("%s\n%-6c%-15s%-6c%-15s%-6c%-15s%-6c%-15s%-7c%-14s%c\n%s\n", "+--------------------+--------------------+--------------------+--------------------+--------------------+", '|', "ITEM CODE", '|', "DESCRIPTION", '|', "UNIT PRICE", '|', "QTY ON HAND", '|', "CATEGORY", '|', "+--------------------+--------------------+--------------------+--------------------+--------------------+");

                    for (int i = 0; i < items.length; i++) {
                        for (int j = 0; j < items[i].length; j++) {
                            if (items[i][j] != null && items[i][j][0] != null && items[i][j][0].equals(id)) {
                                System.out.printf("%-7c%-14s%-6c%-15s%-7c%-14s%-7c%-14s%-7c%-14s%c\n", '|', items[i][j][1], '|', items[i][j][2], '|', items[i][j][3], '|', items[i][j][4], '|', category[i], '|');
                            }
                        }
                    }
                    System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+\n");

                    System.out.print("Search successfully! Do you want to search another supplier (Y/N) ? ");
                    String check = s.next();

                    while (true) {
                        if (check.equals("Y") || check.equals("y")) {
                            clearConsole();
                            getItemSupplierWise();
                            break L1;
                        } else if (check.equals("N") || check.equals("n")) {
                            clearConsole();
                            stockManage();
                            break L1;
                        } else {
                            System.out.print("\nInvalid option! try again. Do you want to search another supplier (Y/N) ? ");
                            check = s.next();
                        }
                    }
                } else {
                    System.out.println("Can't find supplier! try again.\n");
                }
            }
        } else {
            System.out.print("It's look like you don't have any suppliers!\nDo you like to add suppliers (Y/N) ? ");
            String check = s.next();

            while (true) {
                if (check.equals("Y") || check.equals("y")) {
                    clearConsole();
                    addSupplier();
                    break;
                } else if (check.equals("N") || check.equals("n")) {
                    clearConsole();
                    stockManage();
                    break;
                }else{
                    System.out.print("\nInvalid option! try again. Do you like to add suppliers (Y/N) ? ");
                    check = s.next();
                }
            }
        }
    }

	public static void viewItems() {
		clearConsole();

		System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tVIEW ITEMS  \t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");
		if(category.length != 0) {  //Ensure that categories are added in the system
			for (int i = 0; i < category.length; i++) {
				if (items[i] != null) {  //Ensure that items are added in the categories
					System.out.printf("%s%c\n%s\n%-9c%-12s%-9c%-12s%-9c%-12s%-8c%-13s%-9c%-12s%c\n%s\n", category[i], ':', "+--------------------+--------------------+--------------------+--------------------+--------------------+", '|', "SID", '|', "CODE", '|', "DESC", '|', "PRICE", '|', "QTY", '|', "+--------------------+--------------------+--------------------+--------------------+--------------------+");

					for (int j = 0; j < items[i].length; j++) {
						System.out.printf("%-8c%-13s%-8c%-13s%-7c%-14s%-8c%-13s%-8c%-13s%c\n", '|', items[i][j][0], '|', items[i][j][1], '|', items[i][j][2], '|', items[i][j][3], '|', items[i][j][4], '|');
					}
					System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+\n");
				}else{
					System.out.println(category[i] + " category doesn't have any items.\n");
				}
			}

			System.out.print("Do you want to go to stock manage page (Y/N) ? ");
			String check = s.next();

			while(true) {
				if (check.equals("Y") || check.equals("y")) {
					clearConsole();
					stockManage();
					break;
				} else if (check.equals("N") || check.equals("n")) {
					clearConsole();
					homePage();
					break;
				} else {
					System.out.print("Invalid option! try again. Do you want to go to stock manage page (Y/N) ? ");
					check = s.next();
				}
			}
		}else{
			System.out.print("There isn't any category in this system! Do you want to add categories (Y/N) ? ");
			String check = s.next();

			while(true) {
				if (check.equals("Y") || check.equals("y")) {
					clearConsole();
					addNewItemCategory();
					break;
				}else if(check.equals("N") || check.equals("n")){
					clearConsole();
					stockManage();
					break;
				}else{
					System.out.print("Invalid option! try again. Do you want to add categories (Y/N) ? ");
					check = s.next();
				}
			}
		}
	}

	public static void rankItemPerUnitPrice() {
		clearConsole();

		System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tRANKED UNIT PRICE\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

		String[][] sortArr = copyArray();  //Copy all the items from 3D array to 2D array
		sortArray(sortArr);                //Sort 2D array

		if(sortArr.length != 0) {
			System.out.printf("%s\n%-9c%-12S%-9c%-12S%-9c%-12S%-9c%-12S%-10c%-12S%-9c%-12S%c\n%s\n", "+--------------------+--------------------+--------------------+--------------------+---------------------+--------------------+", '|', "SID", '|', "CODE", '|', "DESC", '|', "PRICE", '|', "QTY", '|', "CAT", '|', "+--------------------+--------------------+--------------------+--------------------+---------------------+--------------------+");

			for (int i = 0; i < sortArr.length; i++) {

				System.out.printf("%-7c%-14S%-7c%-14S%-7c%-14S%-7c%-14S%-7c%-15S%-7c%-14S%c\n", '|', sortArr[i][0], '|', sortArr[i][1], '|', sortArr[i][2], '|', sortArr[i][3], '|', sortArr[i][4], '|', sortArr[i][5], '|');

			}
			System.out.println("+--------------------+--------------------+--------------------+--------------------+---------------------+--------------------+\n");

			System.out.print("Do you want to go to stock manage page (Y/N) ? ");
			String check = s.next();

			while(true) {
				if (check.equals("Y") || check.equals("y")) {
					clearConsole();
					stockManage();
					break;
				} else if (check.equals("N") || check.equals("n")) {
					clearConsole();
					homePage();
					break;
				} else {
					System.out.print("Invalid option! try again. Do you want to go to stock manage page (Y/N) ? ");
					check = s.next();
				}
			}
		}else{
			System.out.print("Can't find any items! Do you want to add items (Y/N) ? ");
			String check = s.next();

			while(true){
				if(check .equals("Y") || check .equals("y")){
					clearConsole();
					addItem();
					break;
				}else if(check .equals("N") || check .equals("n")){
					clearConsole();
					stockManage();
					break;
				}else{
					System.out.print("Invalid option! try again. Do you want to add items (Y/N) ? ");
					check = s.next();
				}
			}
		}
	}
	
	public static boolean isNumber(String s){
		try{
			int x = Integer.parseInt(s);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

	public static String[][] copyArray() {
		int count = 0;

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {   //Check if category have been added to the system
				for (int j = 0; j < items[i].length; j++) {
					if (items[i][j] != null) {  //Check item data has been added
						count++;
					}
				}
			}
		}
		String[][] temp = new String[count][6];

		int l = 0;

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {   //Check if category have been added to the system
				for (int j = 0; j < items[i].length; j++) {
					if (items[i][j] != null) {   //Check item data has been added
						for (int k = 0; k < items[i][j].length; k++) {
							temp[l][k] = items[i][j][k];
						}
						temp[l][5] = category[i];
						l++;
					}
				}
			}
		}
		return temp;
	}

	public static void sortArray(String[][] ar) {
		for (int i = 0; i < (ar.length - 1); i++) {
			for (int j = 0; j < (ar.length - 1); j++) {
				if (ar[j] != null && ar[j + 1] != null && ar[j][3] != null && ar[j + 1][3] != null) {   //Verify that the item data has been updated
					double num1 = Double.parseDouble(ar[j][3]);
					double num2 = Double.parseDouble(ar[j + 1][3]);
					
					if (num1 > num2) {
						String[] x = ar[j + 1];
						ar[j + 1] = ar[j];
						ar[j] = x;
					}
				}
			}
		}
	}

	public static void deleteCopySupplierItem(String id) {
		int[][] count = new int[items.length][1];

		for(int i = 0;i < items.length;i++){
			for(int j = 0;j < items[i].length;j++){
				if(items[i][j][0] .equals(id)){
					count[i][0] += 1;
				}
			}
		}
		String[][][] temp = new String[category.length][][];

		for(int i = 0;i < items.length;i++){
			for(int j = 0;j < count[i].length;j++){
				temp[i] = new String[count[i].length][5];
			}
		}

		for(int i = 0;i < items.length;i++){
			for(int j = 0,k = 0;j < items[i].length;j++){

				if(items[i][j][0] .equals(id)) continue;

				for(int l = 0;l < items[i][j].length;l++){
					temp[i][k][l] = items[i][j][l];
				}
				k++;
			}
		}
		items = temp;
	}

	public static boolean checkDuplicateItem(String code) {
		boolean flag = false;

		for(int i = 0;i < items.length;i++){
			if(items[i] != null){
				for(int j = 0;j < items[i].length;j++){
					if(items[i][j][1] != null && items[i][j][1] .equals(code)) flag = true;
				}
			}
		}
		return flag;
	}

	public static void printSuppliers(){
		System.out.println("\nSuppliers list : ");

		System.out.printf("%s\n%-8c%-8c%-7c%-17S%-6c%-18S%c\n%s\n", "+---------------+-----------------------+-----------------------+", '|', '#', '|', "SUPPLIER ID", '|', "SUPPLIER NAME", '|', "+---------------+-----------------------+-----------------------+");

		for(int i = 0;i < suppliers.length;i++){
			System.out.printf("%-8c%-8d%-6c%-18S%-6c%-18S%c\n", '|', (i + 1), '|', suppliers[i][0], '|', suppliers[i][1], '|');
		}

		System.out.println("+---------------+-----------------------+-----------------------+\n");
	}

	public static void printCategory() {
		System.out.println("\nItem categories : ");

		System.out.printf("%s\n%-8c%-8c%-7c%-17S%c\n%s\n", "+---------------+-----------------------+", '|', '#', '|', "CATEGORY NAME", '|', "+---------------+-----------------------+");

		for(int i = 0;i < category.length;i++){
			System.out.printf("%-8c%-8d%-6c%-18S%c\n", '|', (i + 1), '|', category[i], '|');
		}

		System.out.println("+---------------+-----------------------+\n");
	}

	public static String[][] growArray() {
		String[][] temp = new String[suppliers.length + 1][2];

		for (int i = 0;i < suppliers.length;i++) {
			for (int j = 0;j < suppliers[i].length;j++) {
				temp[i][j] = suppliers[i][j];
			}
		}
		return  temp;
	}

	public static String[] growArray(String[] category) {
		String[] temp = new String[category.length + 1];

		for(int i = 0;i < category.length;i++) {
			temp[i] = category[i];
		}
		return temp;
	}

	public static String[][][] growArrayCategory(String[][][] items) {
		String[][][] temp = new String[items.length + 1][][];

		for(int i = 0;i < items.length;i++){
			temp[i] = items[i];
		}
		return temp;
	}

	public static void growArrayItem(int category) {
		int currentSize = items[category] == null ? 0 : items[category].length;

		String[][] temp = new String[currentSize + 1][5];

		for (int i = 0; i < currentSize; i++) {
			if (items[category][i] != null) {
				for (int k = 0; k < items[category][i].length; k++) {
					temp[i][k] = items[category][i][k];
				}
			}
		}
		items[category] = temp;
	}

	public static boolean checkDuplicateId(String id) {
		boolean flag = false;

		for (int i = 0;i < suppliers.length;i++) {
			if (id .equals(suppliers[i][0])) flag = true;
		}
		return flag;
	}

	public static int checkCategory(String type) {
		int index = -1;

		for(int i = 0;i < category.length;i++){
			if(type .equals(category[i]))  index = i;
		}
		return index;
	}

	public static int findSupplier(String id) {
		int index = -1;

		for (int i = 0;i < suppliers.length;i++) {
			if (id  .equals(suppliers[i][0])) index = i;
		}
		return index;
	}

	public static String[][] shrinkArray(int index) {
		String[][] temp = new String[suppliers.length - 1][suppliers[0].length];

		int k = 0;

		for (int i = 0;i < suppliers.length;i++) {
			if (i == index) continue;
			for (int j = 0;j < suppliers[i].length;j++) {
				temp[k][j] = suppliers[i][j];
			}
			k++;
		}
		return temp;
	}

	public static String[] removeCategory(int index) {
		String[] temp = new String[category.length - 1];

		for (int i = 0,j = 0;i < category.length;i++){
			if(i != index) {
				temp[j++] = category[i];
			}
		}
		return temp;
	}

	public static String[][][] removeCategory(String[][][] items, int index) {
		String[][][] temp = new String[items.length - 1][][];

		for (int i = 0,j = 0;i < items.length;i++) {
			if(i != index) {
				temp[j++] = items[i];
			}
		}
		return temp;
	}

	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
				System.out.print("\033\143");
			} else if (os.equals("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {

		System.err.println(e.getMessage());
		}
	}
}
