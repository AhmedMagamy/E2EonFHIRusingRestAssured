package tests;


import io.qameta.allure.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.PatientResource;
import utilities.ReportsUtility.TestngListener;
import utilities.apiUtility.ApiActions;

@Epic("FHIRApiTestAutomation")
@Feature("HAPI.FHIR")
@Listeners(TestngListener.class)
public class PatientResourceTests {

    private ApiActions apiObject;
    private PatientResource patientResource;

    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(patientResource.BASE_URL);
        patientResource = new PatientResource(apiObject);
    }

    @Test(description = "Get patient data by id and verify Gender")
    @Description("Get patient data by id and verify Gender")
    @Story("Patient")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void verifyPatientGender() {
     Response response= patientResource.getPatient("1423838");
        Assert.assertTrue(response.jsonPath().get("gender").toString().contains("male"));
    }

    @Test(description = "Get patient data by id and verify Name")
    @Description("Get patient data by id and verify Gender")
    @Story("Patient")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void verifyPatientName() {
        Response response= patientResource.getPatient("1423838");
        Assert.assertTrue(response.jsonPath().get("name[0].text").toString().contains("Brandon Peterson"));

    }

    @Test(description = "Update patient data by id and verify it's updated")
    @Description("Update patient data by id and verify it's updated")
    @Story("Patient")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void updatePatientAndVerifyUpdated() {
        String bodyData= "{\n" +
                "  \"resourceType\": \"Patient\",\n" +
                "  \"id\": \"1683876\",\n" +
                "  \"meta\": {\n" +
                "    \"versionId\": \"1\",\n" +
                "    \"lastUpdated\": \"2020-11-24T14:32:49.507+00:00\",\n" +
                "    \"source\": \"#W4GwC5V6YkMSM5Yl\"\n" +
                "  },\n" +
                "  \"text\": {\n" +
                "    \"status\": \"generated\",\n" +
                "    \"div\": \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><div class=\\\"hapiHeaderText\\\">James Tiberius <b>KIRK </b></div><table class=\\\"hapiPropertyTable\\\"><tbody/></table></div>\"\n" +
                "  },\n" +
                "  \"name\": [ {\n" +
                "    \"family\": \"Agamy\",\n" +
                "    \"given\": [ \"James Tiberius\" ]\n" +
                "  } ]\n" +
                "}";


        patientResource.updatePatient("1683876",bodyData);
        //get patient data and verify it's updated
        Response response =patientResource.getPatient("1683876");
        //Assertion
       Assert.assertTrue(response.jsonPath().get("name[0].family").toString().contains("Agamy"));

    }

    @Test(description = "Create patient data by id and verify it's Created")
    @Description("Create patient data by id and verify it's Created")
    @Story("Patient CRUDs")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void createPatientAndVerifyCreated() {
        String bodyData= "{\n" +
                "  \"resourceType\": \"Patient\",\n" +
                "  \"name\": [ {\n" +
                "    \"family\": \"lebron\",\n" +
                "    \"given\": [ \"lebron james\" ]\n" +
                "  } ]\n" +
                "}";


        patientResource.createPatient(bodyData);
    }

    @Test(description = "delete patient data by id and verify it's deleted")
    @Description("delete patient data by id and verify it's deleted")
    @Story("Patient CRUDs")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void deletePatientAndVerifyDeleted() {


        patientResource.deletePatient("2837265");
    }




}
