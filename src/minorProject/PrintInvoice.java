package minorProject;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PrintInvoice {
	String cust_name,cust_ph,items,amount,date;
	public void generateInvoice(){
		try {
			String file_name ="C:\\Users\\ayanp\\Desktop\\Invoice.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			Paragraph para = new Paragraph();
			para.add("Invoice\n");
			para.add("-------------------------------------------------------------------\n");
			para.add("Customer Name:");
			para.add(cust_name);
			para.add("\n");
			para.add("Customer Ph. No:");
			para.add(cust_ph);
			para.add("\n");
			para.add("-------------------------------------------------------------------\n");
			para.add("Items Purchased:");
			para.add(items);
			para.add("\n");
			para.add("Total Amount:");
			para.add(amount);
			para.add("\n");
			para.add("Date of Purchase:");
			para.add(date);
			para.add("\n");
			para.add("-------------------------------------------------------------------");
			
			document.add(para);
			document.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}