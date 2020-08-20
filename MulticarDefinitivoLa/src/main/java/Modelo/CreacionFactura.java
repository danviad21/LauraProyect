package Modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreacionFactura {

    private static final String RUTA = System.getProperty("user.dir") + "/firstPdf.pdf";//RUTA POR DEFECTO DONDE SE GUARDA EL DOCUMENTO

    public CreacionFactura() {

    }

    public static void main(String[] args) {
        try {
            Document document = new Document();//INSTANCIA DE DOCUMENTO NUEVO

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(CreacionFactura.RUTA));//INICIALIZA LA ESCRITURA DEL DOC. Y SE OBTIENE UNA INSTANCIA

            document.open();

            /**
             * *********ENCABEZADO***********
             */
            float[] cantColumnasAnchuraTabla = {10,10,10,10,10,10,10,10,10,10};
            PdfPTable table = new PdfPTable(10);
            table.setTotalWidth(cantColumnasAnchuraTabla);
            table.setWidthPercentage(100);

            //CREA UNA INSTANCIA DE UNA CELDA PARA UNA TABLA Y SE DEFINEN CARACTERISTICAS PARA LA CELDA
            PdfPCell celda = new PdfPCell();

            //celda.setBorderColor(new BaseColor(19, 46, 87));
            celda.setBackgroundColor(new BaseColor(19, 46, 87));
            Image logo = Image.getInstance("src/main/java/Imagenes/logo6.jpeg");
            logo.setWidthPercentage(100);
            logo.setAlignment(Element.ALIGN_CENTER);
            celda.addElement(logo);
            celda.setColspan(3);
            table.addCell(celda);
            celda = new PdfPCell();
            celda.setColspan(7);
            table.addCell(celda);
            document.add(table);
  //          celda.setBackgroundColor(BaseColor.WHITE);
//            celda.setPhrase(new Paragraph("MULTICAR INC.", new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD)));
//            table.addCell(celda);
/*            celda.setPhrase(new Paragraph("FACTURA", new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD)));
            table.addCell(celda);
            celda.addElement(new Paragraph("Colombia, Bogota\nBogota, 01001\nTel. 54764105\nE-mail danviad21@gmail.com\nProgamacion I"));
            celda.setColspan(2);
            table.addCell(celda);
            celda.addElement(new Paragraph("Colombia, Bogota\nBogota, 01001\nTelefono 54764105\nE-mail danviad21@gmail.com\nProgamacion I"));
            table.addCell(celda);
            document.add(table);

            /*            float[] pointColumnsWith = {25, 150};

            PdfPTable table = new PdfPTable(pointColumnsWith);
            table.setWidthPercentage(100);

            PdfPCell celda1 = new PdfPCell();
            celda1.setBorder(PdfPCell.BOX);
            celda1.setBorderColor(new BaseColor(48, 113, 193));
            Image logo = Image.getInstance("src/main/java/Imagenes/logo6.jpeg");
            
            table.addCell(new PdfPCell(logo));
            PdfPCell celda = new PdfPCell(new Paragraph("INVOICE", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)));
          

celda.setBackgroundColor(new BaseColor(48, 113, 193));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(celda);

            PdfPCell celda = new PdfPCell();
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.WHITE);

            logo.setWidthPercentage(10);
            Paragraph paragraph = new Paragraph("INVOICE",font);
            celda.addElement(logo);
            celda.addElement(paragraph);
            celda.setBackgroundColor(BaseColor.BLACK);
            table.addCell(celda);
            table.setTotalWidth(350f);
            document.add(table);
            
            PdfPTable table = new PdfPTable(2);
            PdfPCell celda1 =  new PdfPCell(new Paragraph("PRIMERA FRASE"));
            PdfPCell celda2 =  new PdfPCell(new Paragraph("SEGUNDA FRASE"));
            Image logo = Image.getInstance("src/main/java/Imagenes/logo6.jpeg");
            logo.setWidthPercentage(2);
            
            logo.setAbsolutePosition(10, 650f);
            
            celda1.setBorder(Rectangle.BOTTOM);
            celda2.setBorder(Rectangle.BOTTOM);
            celda2.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
            
            table.addCell(celda1);
            table.addCell(celda2);            
            
            table.setTotalWidth(350f); 
            
            PdfContentByte cb = writer.getDirectContent();
            String mensaje = "hola mundo";
            Map<EncodeHintType, Object> qrParametro = new HashMap<>();
            qrParametro.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            BarcodeQRCode qrCode = new BarcodeQRCode(mensaje,100,100,qrParametro);
            Barcode128 code128 = new Barcode128();
            
            code128.setCode("14785236987541");
            code128.setCodeType(Barcode128.CODE128);
            Image qr = qrCode.getImage();
            Image code128Image = code128.createImageWithBarcode(cb, null, null);
            document.add(code128Image);
            document.add(qr);
            document.add(logo);
            document.add(table);*/
            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CreacionFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreacionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
