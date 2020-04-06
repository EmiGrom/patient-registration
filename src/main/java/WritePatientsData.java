import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class WritePatientsData {
    private static final String FILE_NAME = "src/main/resources/Patients.xlsx";

    public void createFile(List<Patient>  patientList) {
        System.out.println("Creating excel");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Patients");
        creatingDataExcel(sheet, patientList);

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

    private void creatingDataExcel(XSSFSheet sheet, List<Patient> patientList) {
        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Imię");
        row.createCell(1).setCellValue("Nazwisko");
        row.createCell(2).setCellValue("Pesel");
        row.createCell(3).setCellValue("Portfel");
        row.createCell(4).setCellValue("Koronowirus");
        for (Patient patient : patientList) {
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(patient.getName());
            row.createCell(1).setCellValue(patient.getSurname());
            row.createCell(2).setCellValue(patient.getPesel());
            row.createCell(3).setCellValue(patient.getPrice());
            row.createCell(4).setCellValue(patient.getKoronowirus());
        }
    }
}
