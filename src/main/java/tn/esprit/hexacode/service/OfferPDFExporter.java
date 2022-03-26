package tn.esprit.hexacode.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.hexacode.Entity.Offers;
public class OfferPDFExporter {

	private List<Offers> listOffers ;
	
	public OfferPDFExporter(List<Offers> listOffers) {
        this.listOffers = listOffers;
    }
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Offer ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("title", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("description", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("location", font));
        table.addCell(cell); 
        
//        cell.setPhrase(new Phrase("nbParticipants", font));
//        table.addCell(cell);
        
    }
	
	
	 private void writeTableData(PdfPTable table) {
	        for (Offers offer : listOffers) {
	            table.addCell(String.valueOf(offer.getId()));
	            table.addCell(offer.getTitle());
	            table.addCell(offer.getDate().toString());
	            table.addCell(offer.getDescription());
	            table.addCell(offer.getLocation());
	           // table.addCell(String.valueOf(offer.getNbParticipants()));
	        }
	    }
	
	 public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Offers", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
	
	
	
	
	
	
	
	
}
