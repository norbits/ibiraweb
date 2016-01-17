package br.com.ibiraweb.util.report;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellUtil;

 
public class Bean2Excel {
    private HSSFWorkbook workbook;
    private HSSFFont boldFont;
    private HSSFDataFormat format;
    private List<ItensPerfilAlunoExcel> itensPerfilAlunoList;
    
    public Bean2Excel() {
        workbook = new HSSFWorkbook();
        boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        format = workbook.createDataFormat();
    }
 
    
    
    
    
    
    
    
    public void createBeanExl(List<ItensPerfilAlunoExcel> itensPerfilAlunoList){
    	
    	this.itensPerfilAlunoList = (List<ItensPerfilAlunoExcel>)itensPerfilAlunoList;
  
    	
    	try {
			gera();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
    public void gera() throws ParseException {
 
        // Used to create the hire dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");
 
      
           
 
            // Create a list of employee data
            List<Employee> employees = new ArrayList<Employee>();
            employees.add(new Employee(100, "Abe Adams", sdf
                    .parse("2009, 12, 1"), 10000.00));
            employees.add(new Employee(101, "Betty Barnes", sdf
                    .parse("2010, 11, 1"), 11000.00));
            employees.add(new Employee(102, "Caleb Crown", sdf
                    .parse("2011, 10, 1"), 12000.00));
            employees.add(new Employee(103, "Dirk Daniels", sdf
                    .parse("2012, 09, 1"), 13000.00));

            
            
            
            
        	  // Create the report object
              Bean2Excel oReport = new Bean2Excel();
              
              // Create an array of report column objects
              ReportColumn[] reportColumns = new ReportColumn[] {
                      new ReportColumn("cpd", "Cpd", FormatType.TEXT),
                      new ReportColumn("nomeAluno", "Nome do Aluno", FormatType.TEXT),
                      new ReportColumn("formaPgto", "Forma de Pagamento", FormatType.TEXT),
                      new ReportColumn("parcelas", "Total de Parcelas", FormatType.INTEGER),
                      new ReportColumn("valor", "Valor Total Devido", FormatType.MONEY),
                      new ReportColumn("valorrecebido", "Recebido", FormatType.MONEY),
                      new ReportColumn("dataRecebimento", "Data Recebimento", FormatType.DATE)
                      };
              
              ReportColumn[] reportColumns2 = new ReportColumn[] {
                      new ReportColumn("id", "Id", FormatType.INTEGER),
                      new ReportColumn("name", "Last Name", FormatType.TEXT),
                      new ReportColumn("hireDate", "Hire Date", FormatType.DATE),
                      new ReportColumn("salary", "Salary", FormatType.MONEY) };
              
              
              
            
        	  try {  
            
            
            
            
            // Create a worksheet with our employee data and report columns
            oReport.addSheet(itensPerfilAlunoList, reportColumns, "sheet1");
 
            // Set the Hire Date Column text to Bold and background to Green
            reportColumns[2].setColor(HSSFColor.GREEN.index);
 
            // Add a 2nd sheet with the same data.
            oReport.addSheet(employees, reportColumns2, "sheet2");
 
            // Create an output stream to write the report to.
            OutputStream output = new FileOutputStream("c:\\temp\\report1.xls");
 
            // Write the report to the output stream
            oReport.write(output);
 
            // Finally, save the report
            output.close();
            
            Desktop dt = Desktop.getDesktop();
            dt.open(new File("c:\\temp\\report1.xls"));
 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 

    public void addSheet(List<?> data, ReportColumn[] columns, String sheetName) {
 
        HSSFSheet sheet = workbook.createSheet(sheetName);
        int numCols = columns.length;
        int currentRow = 0;
        HSSFRow row;
 
        try {
 
            // Create the report header at row 0
            row = sheet.createRow(currentRow);
            // Loop over all the column beans and populate the report headers
            for (int i = 0; i < numCols; i++) {
                // Get the header text from the bean and write it to the cell
                writeCell(row, i, columns[i].getHeader(), FormatType.TEXT,
                        null, this.boldFont);
            }
 
            currentRow++; // increment the spreadsheet row before we step into
                            // the data
 
            // Write report rows
            for (int i = 0; i < data.size(); i++) {
                // create a row in the spreadsheet
                row = sheet.createRow(currentRow++);
                // get the bean for the current row
                Object bean = data.get(i);
                // For each column object, create a column on the current row
                for (int y = 0; y < numCols; y++) {
                    Object value = PropertyUtils.getProperty(bean,
                            columns[y].getMethod());
                    writeCell(row, y, value, columns[y].getType(),
                            columns[y].getColor(), columns[y].getFont());
                }
            }
 
            // Autosize columns
            for (int i = 0; i < numCols; i++) {
                sheet.autoSizeColumn((short) i);
            }
 
        } catch (Exception e) {
            System.err.println("Caught Generate Error exception: "
                    + e.getMessage());
        }
 
    }
 
    public HSSFFont boldFont() {
        return boldFont;
    }
 
    public void write(OutputStream outputStream) throws Exception {
        workbook.write(outputStream);
    }
 
    private void writeCell(HSSFRow row, int col, Object value,
            FormatType formatType, Short bgColor, HSSFFont font)
            throws Exception {
 
        HSSFCell cell = HSSFCellUtil.createCell(row, col, null);
 
        if (value == null) {
            return;
        }
 
        if (font != null) {
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            cell.setCellStyle(style);
        }
 
        switch (formatType) {
        case TEXT:
            cell.setCellValue(value.toString());
            break;
        case INTEGER:
            cell.setCellValue(((Number) value).intValue());
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.DATA_FORMAT,
                    HSSFDataFormat.getBuiltinFormat(("#,##0")));
            break;
        case FLOAT:
            cell.setCellValue(((Number) value).doubleValue());
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.DATA_FORMAT,
                    HSSFDataFormat.getBuiltinFormat(("#,##0.00")));
            break;
        case DATE:
            cell.setCellValue((Date) value);
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.DATA_FORMAT,
                    HSSFDataFormat.getBuiltinFormat(("m/d/yy")));
            break;
        case MONEY:
            cell.setCellValue(((Number) value).intValue());
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.DATA_FORMAT,
                    format.getFormat("$#,##0.00;$#,##0.00"));
            break;
        case PERCENTAGE:
            cell.setCellValue(((Number) value).doubleValue());
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.DATA_FORMAT,
                    HSSFDataFormat.getBuiltinFormat("0.00%"));
        }
 
        if (bgColor != null) {
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.FILL_FOREGROUND_COLOR, bgColor);
            HSSFCellUtil.setCellStyleProperty(cell, workbook,
                    CellUtil.FILL_PATTERN, HSSFCellStyle.SOLID_FOREGROUND);
        }
 
    }
 
    public enum FormatType {
        TEXT, INTEGER, FLOAT, DATE, MONEY, PERCENTAGE
    }
}


