package automation.config;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class DataCSV {

    public String readExcel (String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\config.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);

        String data = "";
        for (Row row : sheet) {

            for (Cell cell : row) {
                if(cell.getColumnIndex() == 1){
                    if(cell.getCellType()== CellType.NUMERIC){
                        //System.out.println("int");
                        data = (int)cell.getNumericCellValue()+"";
                    }else{
                        //System.out.println("String");
                        data = cell.getStringCellValue();
                    }
                }
            }
        }
        return data;
    }

    public void writeCSV(String sheetName, String data) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(data);
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\file\\config.xlsx");
        workbook.write(outputStream);
    }

    public void writeExcel(String fileName, String sheetName, String[] data) throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\file\\"+fileName+".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.createRow(Integer.parseInt(data[0]));

        for(int i = 1; i <data.length ; i++){
            Cell cell = row.createCell(i-1);
            cell.setCellValue(data[i]);
        }

        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\file\\config.xlsx");
        workbook.write(outputStream);
    }


    public String getParam (String fileName,String sheetName, String column) throws IOException {

        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\"+fileName+".xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);

        String data = "";

        int j = 0;
        int columnt = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {

                if(cell.getStringCellValue().equalsIgnoreCase(column) && cell.getRowIndex() == 0){

                    columnt = j;
                }
                j++;
            }
        }
        for (Row row : sheet) {
            for (Cell cell : row) {
                if(cell.getRowIndex() == rowUse(sheetName) && cell.getColumnIndex() == columnt){
                    if(cell.getCellType()== CellType.NUMERIC){

                        data = (int)cell.getNumericCellValue()+"";
                    }else{

                        data = cell.getStringCellValue();
                    }
                }
            }
        }
        return data;
    }

    private int rowUse ( String type) throws IOException {
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\config.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("rowUse");
        int j = 0;
        int columnt = 0;
        int data = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if(cell.getRowIndex() == 0){

                    if(cell.getStringCellValue().equalsIgnoreCase(type)){

                        columnt = j;
                    }
                }
                j++;

            }
        }
        for (Row row : sheet) {
            for (Cell cell : row) {
                if(cell.getRowIndex() == 1 && cell.getColumnIndex() == columnt){
                    if(cell.getCellType()== CellType.NUMERIC){

                        data = (int)cell.getNumericCellValue();
                    }
                }
            }
        }
       return data;
    }

    public int getId ( String type) throws IOException {
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\config.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("id");
        int j = 0;
        int columnt = 0;
        int data = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if(cell.getRowIndex() == 0){

                    if(cell.getStringCellValue().equalsIgnoreCase(type)){

                        columnt = j;
                    }
                }
                j++;

            }
        }
        for (Row row : sheet) {
            for (Cell cell : row) {
                if(cell.getRowIndex() == 1 && cell.getColumnIndex() == columnt){
                    if(cell.getCellType()== CellType.NUMERIC){

                        data = (int)cell.getNumericCellValue();
                    }
                }
            }
        }
        return data;
    }

    public void updateId ( String type, int id) throws IOException {

        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\config.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("id");
        int c = 0;
        switch(type) {
            case "Users":
                c = 0;
                break;
            case "Location":
                c = 1;
                break;
            case "Location_categories":
                c = 2;
                break;
            default:

        }
        Cell cell2Update = sheet.getRow(1).getCell(c);
        cell2Update.setCellValue(id);
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\file\\config.xlsx");
        wb.write(outputStream);
    }
    public void rowUpdate ( String type) throws IOException {

        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\file\\config.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("rowUse");
        int c = 0;
        switch(type) {
            case "Users":
                c = 0;
                break;
            case "Location":
                c = 1;
                break;
            case "Location_categories":
                c = 2;
                break;
            default:

        }
        Cell cell2Update = sheet.getRow(1).getCell(c);
        cell2Update.setCellValue(rowUse(type)+1);
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\file\\config.xlsx");
        wb.write(outputStream);
    }
}
