package com.FrancescoDiSalesGithub.PrettyPrint.json;

import com.FrancescoDiSalesGithub.PrettyPrint.printer.Printer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;

@Service
public class JsonService implements Printer
{

    @Override
    public String printFromContent(Object content)
    {
        ObjectMapper mapper = new ObjectMapper();
        String prettyJsonContent = "";
        try
        {
            prettyJsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(content);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return prettyJsonContent;
    }

    @Override
    public String printFromFile(String filePath)
    {
        ObjectMapper mapper = new ObjectMapper();
        String prettyFileContent = "";

        try
        {
            File jsonFile = new File(filePath);
            Scanner fileScanner = new Scanner(jsonFile);
            StringBuilder contentFile = new StringBuilder();

            while(fileScanner.hasNext())
                contentFile.append(fileScanner.nextLine());

            String jsonContentFile = contentFile.toString();
            JSONObject jsonObject = new JSONObject(jsonContentFile);
            prettyFileContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

        }
        catch (Exception e)
        {

        }

        return prettyFileContent;
    }
}
