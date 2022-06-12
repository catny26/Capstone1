package com.techelevator.model;

import com.techelevator.view.Menu;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private File log = new File("src/main/resources/log");
    private PrintWriter writer = new  PrintWriter(new FileOutputStream(log, true));
    private LocalDateTime presentDateTime = LocalDateTime.now();
    private String date = presentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yy/HH:mm:ss"));
    private VendingMachine vnd;

    public Log() throws FileNotFoundException {
    }

    public Log(String date, PrintWriter writer, File log, VendingMachine vnd) throws FileNotFoundException {
this.date = date;
this.writer = writer;
this.log = log;
this.vnd =vnd;
    }

    public void logGetMoney() {
if (!log.exists())
    try {
        log.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
        writer.print(date + "FEED MONEY:" + vnd.getMoney() + vnd.getBalance());

    }
}





    //vending machine logs all transactions, each purchase must generate a line in a file called Log.txt)
//    public static void log(Menu menu, File file, String itemMsg) {









//        if (!file.exists()) {
//
//            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
//                writer.print(itemMsg);
//            } catch (FileNotFoundException e) {
//                System.out.println(e);
//            }
//        }
//        // (date/time formatting)
////(line.split)
//        //String[] parts = line.split("\\|");
//        //for(String part : parts) {
//        //  soutprintln(part)
//        //}
//
//        //Finish Transaction: give change back
//        //
//
//    }
