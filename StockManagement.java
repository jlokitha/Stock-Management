import java.util.Scanner;

class UnAndPw {
    private String userName = "admin";
    private String parssword = "admin";
    
    public UnAndPw() {
		
	}
	
	public UnAndPw(String userName, String parssword) {
		this.userName = userName;
		this.parssword = parssword;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setParssword(String parssword) {
		this.parssword = parssword;
	}
	public String getParssword() {
		return parssword;
	}
}

class Suppliers {
    private String id;
    private String name;
    
    public Suppliers() {
		
	}
	
	public Suppliers(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class Categories {
    private String name;
    
    public Categories() {
		
	}
	
	public Categories(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class Items {
    private String sid;
    private String code;
    private String desc;
    private String price;
    private String qty;
    private String cate;
    
    public Items() {
		
	}
	
	public Items(String sid, String code, String desc, String price, String qty, String cate) {
		this.sid = sid;
		this.code = code;
		this.desc = desc;
		this.price = price;
		this.qty = qty;
		this.cate = cate;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSid() {
		return sid;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice() {
		return price;
	}
	
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getQty() {
		return qty;
	}
	
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCate() {
		return cate;
	}
}
class StockManagement {
    private static Scanner s = new Scanner(System.in);
    private static UnAndPw u1 = new UnAndPw();
    private static Suppliers[] sList = new Suppliers[0];
    private static Categories[] cList = new Categories[0];
    private static Items[][] iList = new Items[0][0];

    public static void main(String[] args) {

        logIn();
    }

    public static void logIn() {
        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t  LOGIN PAGE\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        while (true) {
            System.out.print("Enter your username: ");
            String un = s.next();

            if (un.equals(u1.getUserName())) {
                while (true) {
                    System.out.print("\nEnter your password: ");
                    String pw = s.next();

                    if (pw.equals(u1.getParssword())) {
                        homePage();
                        return;

                    } else {
                        System.out.println("Password is incorrect. Please try again!");
                    }
                }
            } else {
                System.out.println("User name is invalid. Please try again!\n");
            }
        }
    }

    public static void homePage() {
		clearConsole();

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t WELCOME TO PIGEON STOCK MANAGEMENT SYSTEM\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Change the credentials\t\t[2] Supplier manage\n[3] Stock manage\t\t\t[4] Log out\n[5] Exit the system\n");

        L1:
        while (true) {
            System.out.print("Enter an option to continue >  ");
            String option = s.next();

            switch (option) {

                case "1":
					clearConsole();
                    changeTheCredentials();
                    break L1;
                case "2":
					clearConsole();
                    supplierManage();
                    break L1;
                case "3":
					clearConsole();
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

    public static void changeTheCredentials() {

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tCREDENTIAL MANAGE\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while (true) {
            System.out.print("Please enter the user name to verify it's you: ");
            String un = s.next();

            if (un.equals(u1.getUserName())) {
                System.out.println("\nHey " + u1.getUserName());

                while (true) {
                    System.out.print("\nEnter your current password: ");
                    String pw = s.next();

                    if (pw.equals(u1.getParssword())) {
                        System.out.print("\nEnter your new password: ");
                        String newPs = s.next();

                        u1.setParssword(newPs);
                        System.out.print("\nPassword changed successfully! Do you want to go home page (Y/N) : ");
                        String check = s.next();

                        while (true) {
                            if (check.equals("Y") || check.equals("y")) {
                                clearConsole();
                                homePage();
                                break L1;
                            } else if (check.equals("N") || check.equals("n")) {
                                clearConsole();
                                logIn();
                                break L1;
                            } else {
                                System.out.print("\nInvalid option! try again. Do you want to go home page (Y/N) ? ");
                                check = s.next();
                            }
                        }
                    } else {
                        System.out.println("Incorrect password. try again!");
                    }
                }
            } else {
                System.out.println("Invalid user name. try again!\n");
            }
        }
    }

    public static void supplierManage() {

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSUPPLIER MANAGE\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Add supplier\t\t[2] Update supplier\n[3] Delete supplier\t\t[4] View suppliers\n[5] Search supplier\t\t[6] Home page\n");
        L1:
        while (true) {
            System.out.print("Enter an option to continue >  ");
            String option = s.next();

            switch (option) {

                case "1":
					clearConsole();
                    addSupplier();
                    break L1;
                case "2":
					clearConsole();
                    updateSupplier();
                    break L1;
                case "3":
					clearConsole();
                    deleteSupplier();
                    break L1;
                case "4":
					clearConsole();
                    viewSuppliers();
                    break L1;
                case "5":
					clearConsole();
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t ADD SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        sList = growArrayS();

        L1:
        while(true) {
            System.out.print("\nSupplier  ID\t: ");
            String id = s.next();

            if(checkDuplicateId(id)) {   //Verify that this ID has not been used previously
                System.out.println("Already exists! try another supplier id.");
                continue;
            }else{
                System.out.print("Supplier  Name\t: ");
                String name = s.next();

                Suppliers temp = new Suppliers();
                temp.setId(id);
                temp.setName(name);

                sList[sList.length - 1] = temp;
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t UPDATE SUPPLIER\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String ID = s.next();

            int supplierIndex = -1;
            supplierIndex = findSupplier(ID);  //Find the index of specific suppliers in an array

            if (supplierIndex != -1) {
                System.out.println("Supplier Name\t: " + sList[supplierIndex].getName());

                System.out.print("\nEnter the new supplier name : ");
                String name = s.next();

                sList[supplierIndex].setName(name);
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t DELETE SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String id = s.next();

            int  supplierIndex = -1;
            supplierIndex = findSupplier(id);  //Find the index of specific suppliers in an array

            if(supplierIndex != -1) {
                sList = shrinkArray(supplierIndex);  //Delete specific suppliers from an array
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

        System.out.print("+-------------------------------------------------------------------------------+\n|\t\t\t\t VIEW SUPPLIERS\t\t\t\t\t|\n+-------------------------------------------------------------------------------+\n\n");

        if(sList.length > 0) {
            System.out.printf("%s\n%c%16S%5c%17S%4c\n%s\n", "+--------------------+--------------------+", '|', "SUPPLIER ID", '|', "SUPPLIER NAME", '|', "+--------------------+--------------------+");

            for (int i = 0; i < sList.length; i++) {
                System.out.printf("%-8c%-13s%-8c%-13s%c\n", '|', sList[i].getId(), '|', sList[i].getName(), '|');
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\t SEARCH SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Supplier ID\t: ");
            String id = s.next();

            int supplierIndex = -1;
            supplierIndex = findSupplier(id);  //Find the index of specific suppliers in an array

            if (supplierIndex != -1) {
                System.out.println("Supplier Name\t: " + sList[supplierIndex].getName());

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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSTOCK MANAGEMENT\t\t\t       |\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Manage item categories\t\t[2] Add item\n[3] Get item supplier wise\t\t[4] View items\n[5] Rank item per unit Price\t\t[6] Home page\n");

        L1:
        while(true){
            System.out.print("Enter an option to continue > ");
            String option = s.next();

            switch (option) {
                case "1":
					clearConsole();
                    manageItemCategories();
                    break L1;
                case "2":
					clearConsole();
                    addItem();
                    break L1;
                case "3":
					clearConsole();
                    getItemSupplierWise();
                    break L1;
                case "4":
					clearConsole();
                    viewItems();
                    break L1;
                case "5":
					clearConsole();
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t      MANAGE ITEM CATEGORY\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Add new item category\t\t[2] Delete item category\n[3] Update item category\t\t[4] Stock management\n");

        L1:
        while (true) {
            System.out.print("Enter an option to continue > ");
            String option = s.next();

            switch (option) {
                case "1":
					clearConsole();
                    addNewItemCategory();
                    break L1;
                case "2":
					clearConsole();
                    deleteItemCategory();
                    break L1;
                case "3":
					clearConsole();
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tADD ITEM CATEGORY\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        cList = growArrayC();   //Grow category array to save category type
        iList = growArrayCategory();  //Grow items array to add items to that category

        L1:
        while(true) {
            System.out.print("Enter the new item category : ");
            String type = s.next();

            int index = -1;
            index = checkCategory(type);   //Make sure category name doesn't duplicate

            if (index != -1) {
                System.out.println("Category already exist!\n");
            }else {
                Categories temp = new Categories();
                temp.setName(type);

                cList[cList.length - 1] = temp;

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

                cList[index].setName(name);

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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t      DELETE ITEM CATEGORY\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        L1:
        while(true) {
            System.out.print("Enter category type : ");
            String type = s.next();

            int index = -1;
            index = checkCategory(type);  //Find the index of the category

            if(index != -1){
                cList = removeCategory(index);   //Remove category from category array
                iList = removeItemCategory(index);   //Remove items that belong to the category

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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tADD ITEM\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        if(cList.length == 0) {  //Make sure system have categories
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
        }else if(sList.length == 0) {  //Make sure system have suppliers
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
                            if(sIndex > 0 && (sIndex - 1) < sList.length){  //Make sure supplier number is valid
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
                            if(cIndex > 0 && (cIndex - 1) < cList.length){   //Make sure category number is valid
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

                    Items temp = new Items();
                    temp.setSid(sList[sIndex - 1].getId());
                    temp.setCode(code);
                    temp.setDesc(description);
                    temp.setPrice(price);
                    temp.setQty(qty);

                    iList[index][iList[index].length - 1] = temp;

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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tSEARCH SUPPLIER\t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        if (sList.length != 0) {   //Check whether the system has suppliers
            L1:
            while (true) {
                System.out.print("Enter supplier id\t: ");
                String id = s.next();

                int index = -1;
                index = findSupplier(id);  //Verify the existence of specific suppliers

                if (index != -1) {
                    System.out.println("\nSupplier name\t\t: " + sList[index].getName() + "\n\n");

                    System.out.printf("%s\n%-6c%-15s%-6c%-15s%-6c%-15s%-6c%-15s%-7c%-14s%c\n%s\n", "+--------------------+--------------------+--------------------+--------------------+--------------------+", '|', "ITEM CODE", '|', "DESCRIPTION", '|', "UNIT PRICE", '|', "QTY ON HAND", '|', "CATEGORY", '|', "+--------------------+--------------------+--------------------+--------------------+--------------------+");

                    for (int i = 0; i < iList.length; i++) {
                        for (int j = 0; j < iList[i].length; j++) {
                            if (iList[i][j] != null && iList[i][j].getSid() != null && iList[i][j].getSid() .equals(id)) {
                                System.out.printf("%-7c%-14s%-6c%-15s%-7c%-14s%-7c%-14s%-7c%-14s%c\n", '|', iList[i][j].getCode(), '|', iList[i][j].getDesc(), '|', iList[i][j].getPrice(), '|', iList[i][j].getQty(), '|', cList[i].getName(), '|');
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tVIEW ITEMS  \t\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");
        if(cList.length != 0) {  //Ensure that categories are added in the system
            for (int i = 0; i < cList.length; i++) {
                if (iList[i] != null) {  //Ensure that items are added in the categories
                    System.out.printf("%s%c\n%s\n%-9c%-12s%-9c%-12s%-9c%-12s%-8c%-13s%-9c%-12s%c\n%s\n", cList[i].getName(), ':', "+--------------------+--------------------+--------------------+--------------------+--------------------+", '|', "SID", '|', "CODE", '|', "DESC", '|', "PRICE", '|', "QTY", '|', "+--------------------+--------------------+--------------------+--------------------+--------------------+");

                    for (int j = 0; j < iList[i].length; j++) {
                        System.out.printf("%-8c%-13s%-8c%-13s%-7c%-14s%-8c%-13s%-8c%-13s%c\n", '|', iList[i][j].getSid(), '|', iList[i][j].getCode(), '|', iList[i][j].getDesc(), '|', iList[i][j].getPrice(), '|', iList[i][j].getQty(), '|');
                    }
                    System.out.println("+--------------------+--------------------+--------------------+--------------------+--------------------+\n");
                }else{
                    System.out.println(cList[i] + " category doesn't have any items.\n");
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

        System.out.print("+------------------------------------------------------------------------------+\n|\t\t\t\tRANKED UNIT PRICE\t\t\t\t|\n+------------------------------------------------------------------------------+\n\n");

        Items[] sortArr = copyArray();  //Copy all the items from 3D array to 2D array
        sortArr = sortArray(sortArr);                //Sort 2D array


        if(sortArr.length != 0) {
            System.out.printf("%s\n%-9c%-12S%-9c%-12S%-9c%-12S%-9c%-12S%-10c%-12S%-9c%-12S%c\n%s\n", "+--------------------+--------------------+--------------------+--------------------+---------------------+--------------------+", '|', "SID", '|', "CODE", '|', "DESC", '|', "PRICE", '|', "QTY", '|', "CAT", '|', "+--------------------+--------------------+--------------------+--------------------+---------------------+--------------------+");

            for (int i = 0; i < sortArr.length; i++) {

                System.out.printf("%-7c%-14S%-7c%-14S%-7c%-14S%-7c%-14S%-7c%-15S%-7c%-14S%c\n", '|', sortArr[i].getSid(), '|', sortArr[i].getCode(), '|', sortArr[i].getDesc(), '|', sortArr[i].getPrice(), '|', sortArr[i].getQty(), '|', sortArr[i].getCate(), '|');

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

    public static Items[] copyArray() {
        int count = 0;

        for (int i = 0; i < iList.length; i++) {
            if (iList[i] != null) {   //Check if category have been added to the system
                for (int j = 0; j < iList[i].length; j++) {
                    if (iList[i][j] != null) {  //Check item data has been added
                        count++;
                    }
                }
            }
        }
        Items[] temp = new Items[count];

        int l = 0;

        for (int i = 0; i < iList.length; i++) {
            if (iList[i] != null) {   //Check if category have been added to the system
                for (int j = 0; j < iList[i].length; j++) {
                    if (iList[i][j] != null) {   //Check item data has been added
                        temp[l] = iList[i][j];
                        temp[l].setCate(cList[i].getName());
                        l++;
                    }
                }
            }
        }
        return temp;
    }

    public static Items[] sortArray(Items[] ar) {
        for (int i = 0; i < (ar.length - 1); i++) {
            for (int j = 0; j < (ar.length - 1); j++) {
                if (ar[j] != null && ar[j + 1] != null && ar[j].getPrice() != null && ar[j + 1].getPrice() != null) {   //Verify that the item data has been updated
                    double num1 = Double.parseDouble(ar[j].getPrice());
                    double num2 = Double.parseDouble(ar[j + 1].getPrice());

                    if (num1 > num2) {
                        Items x = ar[j + 1];
                        ar[j + 1] = ar[j];
                        ar[j] = x;
                    }
                }
            }
        }
        return ar;
    }

    public static void growArrayItem(int category) {
        int currentSize = iList[category] == null ? 0 : iList[category].length;

        Items[] temp = new Items[currentSize + 1];

        for (int i = 0,j = 0; i < currentSize; i++) {
            if (iList[category][i] != null) temp[j++] = iList[category][i];
        }
        iList[category] = temp;
    }

    public static boolean isNumber(String s){
        try{
            int x = Integer.parseInt(s);
        }catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public static boolean checkDuplicateItem(String code) {
        boolean flag = false;

        for(int i = 0;i < iList.length;i++){
            if(iList[i] != null){
                for(int j = 0;j < iList[i].length;j++){
                    if(iList[i][j].getCode() != null && iList[i][j].getCode() .equals(code)) flag = true;
                }
            }
        }
        return flag;
    }

    public static void printSuppliers(){
        System.out.println("\nSuppliers list : ");

        System.out.printf("%s\n%-8c%-8c%-7c%-17S%-6c%-18S%c\n%s\n", "+---------------+-----------------------+-----------------------+", '|', '#', '|', "SUPPLIER ID", '|', "SUPPLIER NAME", '|', "+---------------+-----------------------+-----------------------+");

        for(int i = 0;i < sList.length;i++){
            System.out.printf("%-8c%-8d%-6c%-18S%-6c%-18S%c\n", '|', (i + 1), '|', sList[i].getId(), '|', sList[i].getName(), '|');
        }

        System.out.println("+---------------+-----------------------+-----------------------+\n");
    }

    public static void printCategory() {
        System.out.println("\nItem categories : ");

        System.out.printf("%s\n%-8c%-8c%-7c%-17S%c\n%s\n", "+---------------+-----------------------+", '|', '#', '|', "CATEGORY NAME", '|', "+---------------+-----------------------+");

        for(int i = 0;i < cList.length;i++){
            System.out.printf("%-8c%-8d%-6c%-18S%c\n", '|', (i + 1), '|', cList[i].getName(), '|');
        }

        System.out.println("+---------------+-----------------------+\n");
    }

    public static Categories[] removeCategory(int index) {
        Categories[] temp = new Categories[cList.length - 1];

        for (int i = 0,j = 0;i < cList.length;i++){
            if(i != index) {
                temp[j++] = cList[i];
            }
        }
        return temp;
    }

    public static Items[][] removeItemCategory(int index) {
        Items[][] temp = new Items[iList.length - 1][];

        for (int i = 0,j = 0;i < iList.length;i++) {
            if(i != index) {
                temp[j++] = iList[i];
            }
        }
        return temp;
    }

    public static int checkCategory(String type) {
        int index = -1;

        for(int i = 0;i < cList.length;i++){
            if(cList[i] != null && type .equals(cList[i].getName()))  index = i;
        }
        return index;
    }

    public static Items[][] growArrayCategory() {
        Items[][] temp = new Items[iList.length + 1][];

        for(int i = 0;i < iList.length;i++){
            temp[i] = iList[i];
        }
        return temp;
    }

    public static void deleteCopySupplierItem(String id) {
        int[][] count = new int[iList.length][1];

        for(int i = 0;i < iList.length;i++){
            for(int j = 0;j < iList[i].length;j++){
                if(!(iList[i][j].getSid()) .equals(id)){
                    count[i][0] += 1;
                }
            }
        }
        Items[][] temp = new Items[cList.length][];

        for(int i = 0;i < iList.length;i++){
            temp[i] = new Items[count[i].length];
        }

        for(int i = 0;i < iList.length;i++){
            for(int j = 0,k = 0;j < iList[i].length;j++){

                if(iList[i][j].getSid() .equals(id)) continue;

                temp[i][k] = iList[i][j];

                k++;
            }
        }
        iList = temp;
    }

    public static Suppliers[] shrinkArray(int index) {
        Suppliers[] temp = new Suppliers[sList.length - 1];

        int k = 0;

        for (int i = 0;i < sList.length;i++) {
            if (i == index) continue;
            temp[k++] = sList[i];
        }
        return temp;
    }

    public static int findSupplier(String id) {
        int index = -1;

        for (int i = 0;i < sList.length;i++) {
            if (id  .equals(sList[i].getId())) index = i;
        }
        return index;
    }

    public static boolean checkDuplicateId(String id) {
        boolean flag = false;

        for (int i = 0;i < sList.length;i++) {
            if (sList[i] != null && id .equals(sList[i].getId())) flag = true;
        }
        return flag;
    }

    public static Suppliers[] growArrayS() {
        Suppliers[] temp = new Suppliers[sList.length + 1];

            for (int i = 0;i < sList.length;i++) {
                temp[i] = sList[i];
            }
        return  temp;
    }

    public static Categories[] growArrayC() {
        Categories[] temp = new Categories[cList.length + 1];

        for (int i = 0;i < cList.length;i++) {
            temp[i] = cList[i];
        }
        return  temp;
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

