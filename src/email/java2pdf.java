
package email;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.lowagie.text.Element;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import rfid_based_smartshoppingsystem.ItemList;

public class java2pdf {
    
    public void convert(String filename,String name,String CCNo,String total,javax.swing.JTable Table) throws Exception{
        Document document= new Document();

        PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream("C:\\RFID_Based_SmartShoppingSystem\\pdfFiles\\"+filename+".pdf"));
        document.open();
        Image img=Image.getInstance("C:\\RFID_Based_SmartShoppingSystem\\images\\Title.png");
        document.add(img);
        document.add(new Paragraph(new Date().toString()));
        document.add(new Paragraph("\n"+name,FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.LIGHT_GRAY)));
        String c="";
        for(int i=0;i<4;i++){
            c+=CCNo.charAt(i);
        }for(int i=4;i<8;i++){
            c+="X";
        }
        for(int i=8;i<12;i++){
            c+="X";
        }
        for(int i=12;i<16;i++){
            c+=CCNo.charAt(i);
        }
            
        document.add(new Paragraph("CREDIT CARD NO.: "+c,FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.LIGHT_GRAY)));
        document.add(new Paragraph("--------------------------------------------------------------------------------------",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.LIGHT_GRAY)));
        document.add(new Paragraph("\n\nDear Customer, you've made a purchase from our branch of Smart Shopping System. Here we  attach the bill of your purchase with us."));
        document.add(new Paragraph("\nOrder Date: ",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.LIGHT_GRAY)));
        document.add(new Paragraph("\b"+new Date().toString()));
        document.add(new Paragraph("\n\n"));
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell=new PdfPCell(new Paragraph("BILL"));
        cell.setColspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(2);
        table.addCell(cell);
        cell=new PdfPCell(new Paragraph("SR NO."));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(2);
        table.addCell(cell);
        cell=new PdfPCell(new Paragraph("ITEM LIST"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(2);
        table.addCell(cell);
        cell=new PdfPCell(new Paragraph("ITEM LIST"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setBorderWidth(2);
        table.addCell(cell);
        DefaultTableModel model;
        model = (DefaultTableModel)Table.getModel();
        String [] row=new String[3];
        int rowCount=Table.getRowCount();
        
        for(int i=0;i<rowCount;i++){
        
            row[0]=model.getValueAt(i, 0).toString();
            row[1]=model.getValueAt(i, 1).toString();
            row[2]=model.getValueAt(i, 2).toString();
            table.addCell(row[0]);
            table.addCell(row[1]);
            table.addCell(row[2]);
            
        }
          document.add(table);

//        List list =new List(true ,20);
//        list.add("1st Item");
//        list.add("2nd Item");
//        list.add("3rd Item");
//        list.add("4th Item");
//        document.add(list);
        
        document.add(new Paragraph("\n                                                             Total Bill Ammount : "+total+" Rs.",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK)));
        for(int i=rowCount;i<12;i++){
            document.add(new Paragraph("\n"));
        }
        document.add(new Paragraph("                                                                   **** Thank You ****"
                + "\n                              This is a computer generated reciept does not require any authentication",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.NORMAL,BaseColor.LIGHT_GRAY)));

        document.close();
    }
  // public static void main(String[] args) throws Exception{
     //   java2pdf ex=new java2pdf();
      //  ex.convert("@kvin04","Mr. Kevin Patel","500","3456534245667776",new ItemList().getTable());
    //}
}
