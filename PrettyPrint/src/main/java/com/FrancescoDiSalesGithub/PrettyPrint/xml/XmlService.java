package com.FrancescoDiSalesGithub.PrettyPrint.xml;

import com.FrancescoDiSalesGithub.PrettyPrint.printer.Printer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;

@Service
public class XmlService implements Printer
{

    @Override
    public String printFromContent(Object content)
    {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlContent = "";
        try
        {
            xmlContent = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(content);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return xmlContent;

    }

    @Override
    public String printFromFile(String filePath)
    {

        XmlMapper mapper = new XmlMapper();
        String prettyFileContent = "";

        try
        {
            File xmlFile = new File(filePath);
            Scanner fileScanner = new Scanner(xmlFile);
            StringBuilder contentFile = new StringBuilder();

            while(fileScanner.hasNext())
                contentFile.append(fileScanner.nextLine());

            String xmlContentFile = contentFile.toString();
            prettyFileContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(xmlContentFile);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return prettyFileContent;
    }
}
