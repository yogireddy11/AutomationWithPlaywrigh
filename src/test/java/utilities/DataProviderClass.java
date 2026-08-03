package utilities;

import org.testng.annotations.DataProvider;

import java.util.Properties;

public class DataProviderClass {

    @DataProvider(name = "SignupData")
    public Object[][] signUpData(){
        return ExcelUtils.readExcelData("C:\\Users\\yogireddy\\Downloads\\RegisterData.xlsx","Sheet1");
    }
}
