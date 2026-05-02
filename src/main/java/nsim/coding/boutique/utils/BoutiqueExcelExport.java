package nsim.coding.boutique.utils;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import nsim.coding.boutique.dtos.BoutiqueDto;

public class BoutiqueExcelExport {

    public void export(List<BoutiqueDto> boutiques,
            HttpServletResponse response) throws Exception {

        /** Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Boutiques");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Designation");
        header.createCell(1).setCellValue("Email");
        header.createCell(2).setCellValue("Proprietaire");
        header.createCell(3).setCellValue("TVA");

        int rowCount = 1;
        for (BoutiqueDto b : boutiques) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(b.getDesignation());
            row.createCell(1).setCellValue(b.getEmail());
            row.createCell(2).setCellValue(b.getNomProprietaire());
            // row.createCell(3).setCellValue(b.getConfigTva());
        }

        workbook.write(response.getOutputStream());
        workbook.close();**/
    }
}
