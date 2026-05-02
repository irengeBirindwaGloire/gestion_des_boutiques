package nsim.coding.boutique.utils;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import nsim.coding.boutique.dtos.BoutiqueDto;

public class BoutiquePdfExport {

    public void export(List<BoutiqueDto> boutiques,
            HttpServletResponse response) throws Exception {

        /**
         * Document document = new Document(PageSize.A4);
         * PdfWriter.getInstance(document, response.getOutputStream());

         *          *document.open();

         *          *Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD); Paragraph
         * title = new Paragraph("Liste des boutiques", titleFont);
         * title.setAlignment(Paragraph.ALIGN_CENTER);

         *          *document.add(title); document.add(new Paragraph(" "));

         *          *PdfPTable table = new PdfPTable(3); table.setWidthPercentage(100);

         *          *table.addCell("Designation"); table.addCell("Email");
         * table.addCell("Proprietaire");

         *          *for (BoutiqueDto b : boutiques) { table.addCell(b.getDesignation());
         * table.addCell(b.getEmail()); table.addCell(b.getNomProprietaire()); }

         *          *document.add(table);*
         */
    }
}
