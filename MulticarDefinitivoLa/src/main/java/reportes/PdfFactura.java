/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Modelo.Alquiler;
import Modelo.FormatoEntradaException;
import Persistencia.AlquilerDao;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.EncodeHintType;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class PdfFactura {
    
    private static String UBICACION_REPORTE_FACTURA;
    private static Document document = null;
    private static PdfWriter pdfWriter;
    private static PdfPCell celda;
    private static PdfPTable tabla;
    private static Font font;
    
    public static void generarFacturaPdf(Alquiler alquiler) {
        
        try {
            document = new Document(PageSize.LETTER);
            UBICACION_REPORTE_FACTURA = System.getProperty("user.dir") + "/" + alquiler.getNumeroRecibo() + ".pdf";
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File(UBICACION_REPORTE_FACTURA)));
            document.open();
            
            float cantAnchoColumnas[] = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            
            crearTabla(10, cantAnchoColumnas);
            
            Image image = Image.getInstance("src/main/java/Imagenes/LogoDefinitivo.jpg");
            //primera fila
            crearCelda(3, image, 100, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, new BaseColor(19, 46, 87), 2f);
            celda.setPaddingBottom(0);
            tabla.addCell(celda);
            
            Map<EncodeHintType, Object> qrParametro = new HashMap<>();
            qrParametro.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BarcodeQRCode qrCode = new BarcodeQRCode(
                    String.valueOf("Recibo " + alquiler.getNumeroRecibo()) + " \n"
                    + "Cliente " + alquiler.getCliente().getNombre() + "\nHecho Por Laura Camacho\n" + "Fecha " + alquiler.getFecha().convertirFechaEntregaString(), 175, 175, qrParametro);
            image = qrCode.getImage();
            crearCelda(2, "", Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(5, image, 30, BaseColor.WHITE, Element.ALIGN_CENTER, BaseColor.WHITE, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            //segunda fila
            crearCelda(5, "MULTICAR S.A.\nBogota, Colombia\nE-mail multicar@correo.co\nTelefono 308590303\n",
                    new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK), BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            celda.setPadding(10f);
            tabla.addCell(celda);
            
            crearCelda(2, "", Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(3, "Factura " + alquiler.getNumeroRecibo() + "\nFecha " + alquiler.getFecha().convertirFechaEntregaString() + " "
                    + alquiler.getHora().getHoraEntrega() + " HRS\nFecha de Pago " + alquiler.getFecha().convertirFechaDevueltaString(),
                    new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK), BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(4, "DATOS DEL CLIENTE",
                    new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.WHITE), new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            celda.setPaddingTop(0);
            celda.setPaddingBottom(10f);
            tabla.addCell(celda);
            
            crearCelda(6, "", Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(10, alquiler.getCliente().toString()+"\n",
                    new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK), BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            celda.setPaddingBottom(10f);
            tabla.addCell(celda);
            
            document.add(tabla);
            
            float cantAnchoColumnas1[] = {2, 12, 10, 10, 10, 10, 10, 10};
            crearTabla(8, cantAnchoColumnas1);
            
            tabla.setHeaderRows(1);
            
            font = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.WHITE);
            
            crearCelda(0, "#", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Descripcion", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Dias Alquilados", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Valor/Dia", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Seguro", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Fecha/Hora Entrega", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "Fecha/Hora Devuelta", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, "SubTotal", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            llenarFactura(alquiler);
            document.add(tabla);
            
            PdfContentByte cb = pdfWriter.getDirectContent();
            Barcode128 code128 = new Barcode128();
            code128.setCode(String.valueOf(alquiler.getNumeroRecibo() + " " + String.valueOf(alquiler.getCliente().getIdCliente() + " " + alquiler.getFecha().convertirFechaEntregaString())));
            code128.setCodeType(Barcode128.CODE128);
            
            image = code128.createImageWithBarcode(cb, BaseColor.BLACK, BaseColor.WHITE);
            image.setWidthPercentage(100);
            
            tabla = new PdfPTable(1);
            tabla.setWidthPercentage(100);
            
            font = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.WHITE);
            
            crearCelda(1, "Gracias por Su Preferencia", font, new BaseColor(19, 46, 87), Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(1, "", Rectangle.NO_BORDER);
            tabla.addCell(celda);            
            
            crearCelda(1, image, 30, BaseColor.WHITE, Element.ALIGN_MIDDLE, BaseColor.WHITE, Rectangle.NO_BORDER);
            celda.setPaddingTop(4f);
            tabla.addCell(celda);
            document.add(tabla);
            
            document.close();
            Desktop.getDesktop().open(new File(UBICACION_REPORTE_FACTURA));
        } catch (DocumentException | IOException ex) {
            System.out.println(ex);
        }
    }
    
    private static void crearTabla(int tamanioColumnas, float[] anchoColumnas) {
        try {
            tabla = null;
            tabla = new PdfPTable(tamanioColumnas);
            tabla.setTotalWidth(anchoColumnas);
            tabla.setWidthPercentage(100);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void crearCelda(int nCeldasAbarca, String texto, int borde) {
        celda = null;
        celda = new PdfPCell();
        celda.setBorder(borde);
        if (nCeldasAbarca > 0) {
            celda.setColspan(nCeldasAbarca);
        }
        celda.setPhrase(new Paragraph(texto));
        
    }
    
    private static void crearCelda(int nCeldasAbarca, String texto, Font fuente, BaseColor fondo, int alineacion, float anchoBorde) {
        
        celda = null;
        celda = new PdfPCell();
        celda.setBackgroundColor(fondo);
        celda.setHorizontalAlignment(alineacion);
        celda.setVerticalAlignment(Element.ALIGN_TOP);
        celda.setBorderWidth(anchoBorde);
        if (nCeldasAbarca > 0) {
            celda.setColspan(nCeldasAbarca);
        }
        Paragraph parrafo = new Paragraph(texto);
        parrafo.setFont(fuente);
        
        if (alineacion == Element.ALIGN_RIGHT) {
            parrafo.setAlignment(alineacion);
            celda.setHorizontalAlignment(alineacion);
        }
        
        celda.addElement(parrafo);
        
    }
    
    private static void crearCelda(int nCeldasAbarca, Image image, int tamanio, BaseColor fondo, int alineacion, BaseColor colorBorde, float anchoBorde) {
        celda = null;
        celda = new PdfPCell();
        celda.setBackgroundColor(fondo);
        celda.setHorizontalAlignment(alineacion);
        celda.setBorderColor(colorBorde);
        celda.setBorderWidth(anchoBorde);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda.setPaddingBottom(0);
        celda.setPaddingTop(0);
        image.setWidthPercentage(tamanio);
        image.setAlignment(alineacion);
        if (nCeldasAbarca > 0) {
            celda.setColspan(nCeldasAbarca);
        }
        celda.addElement(image);
    }
    
    private static void crearCelda(int nCeldasAbarca, Image image) {
        celda = null;
        celda = new PdfPCell();
        if (nCeldasAbarca > 0) {
            celda.setColspan(nCeldasAbarca);
        }
        celda.addElement(image);
    }
    
    private static void llenarFactura(Alquiler alquiler) {
        
        font = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL, BaseColor.BLACK);
        
        for (int i = 0; i < alquiler.getListaVehiculos().size(); i++) {
            alquiler.setValorAlquiler(alquiler.getListaVehiculos().get(i));
            alquiler.getRecaudo().setValorSubtotalRecaudo(alquiler.getDIAS_ALQUILER(), alquiler.calcularValorSeguro(), alquiler.getValorAlquiler());
            
            crearCelda(0, String.valueOf(i+1), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, alquiler.getListaVehiculos().get(i).getDescripcionVehiculo() + " " + alquiler.getListaVehiculos().get(i).getDescripcionGeneralVehiculo(), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, String.valueOf(alquiler.getDIAS_ALQUILER()), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, String.valueOf(alquiler.getValorAlquiler()), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, String.valueOf(alquiler.calcularValorSeguro()), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, alquiler.getFecha().convertirFechaEntregaString() + alquiler.getHora().getHoraEntrega(), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, alquiler.getFecha().convertirFechaDevueltaString() + alquiler.getHora().getHoraDevuelta(), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
            crearCelda(0, String.valueOf(alquiler.getRecaudo().getValorSubtotalRecaudo()), font, BaseColor.WHITE, Element.ALIGN_CENTER, Rectangle.NO_BORDER);
            tabla.addCell(celda);
            
        }
        crearCelda(7, "Total", font, BaseColor.WHITE, Element.ALIGN_RIGHT, Rectangle.NO_BORDER);
        tabla.addCell(celda);
        crearCelda(1, String.valueOf(alquiler.getRecaudo().getValorTotalRecuado()), font, BaseColor.WHITE, Element.ALIGN_CENTER, 1f);
        tabla.addCell(celda);
        
    }
}
