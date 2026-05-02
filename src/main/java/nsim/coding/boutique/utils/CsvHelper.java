package nsim.coding.boutique.utils;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.Writer;
// import java.util.ArrayList;
// import java.util.List;

// import org.apache.commons.csv.CSVFormat;
// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVPrinter;
// import org.apache.commons.csv.CSVRecord;

// import nsim.coding.boutique.models.Boutique;

public class CsvHelper {

    // public static List<Boutique> csvToStudents(InputStream is) throws IOException {
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    //     CSVParser parser = new CSVParser(
    //             reader,
    //             CSVFormat.DEFAULT.withFirstRecordAsHeader()
    //     );

    //     List<Boutique> boutiques = new ArrayList<>();

    //     for (CSVRecord record : parser) {
    //         Boutique boutique = new Boutique();
    //         boutique.setDesignation(record.get("Designation"));
    //         boutique.setEmail(record.get("Email"));
    //         boutiques.add(boutique);
    //     }

    //     return boutiques;
    // }

    // public static void boutiquesToCsv(Writer writer, List<Boutique> boutiques)
    //         throws IOException {

    //     CSVPrinter printer = new CSVPrinter(writer,
    //             CSVFormat.DEFAULT.withHeader("ID", "Nom", "Email"));

    //     for (Boutique b : boutiques) {
    //         printer.printRecord(b.getId(), b.getDesignation(), b.getEmail());
    //     }

    //     printer.flush();
    // }
}
