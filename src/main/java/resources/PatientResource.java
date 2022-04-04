package resources;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.apiUtility.ApiActions;
import utilities.filiesUtility.PropertiesReader;

import java.util.HashMap;
import java.util.Map;

public class PatientResource {
    //we use this object to do api actions
    private ApiActions apiObject;
    public static final String BASE_URL = PropertiesReader.getProperty("proj.properties",
            "HAPI.baseuri");

    public PatientResource(ApiActions apiObject) {
        this.apiObject = apiObject;
    }

    ////////////Get PatientResource resource//////////

    @Step("Get patient by his ID --> ID: [{id}]")
    public Response getPatient(String id){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/Patient/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }


    ////////////Update PatientResource resource//////////

    @Step("Update patient data by his ID --> ID: [{id}]")
    public Response updatePatient(String id , Object body){

        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/fhir+json; charset=UTF-8");


        return apiObject.sendRequest(ApiActions.RequestType.PUT
                ,"/Patient/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,body
                ,null);
    }

    ////////////Create PatientResource //////////

    @Step("Create patient")
    public Response createPatient(Object body){

        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/fhir+json; charset=UTF-8");


        return apiObject.sendRequest(ApiActions.RequestType.POST
                ,"/Patient/"
                ,201
                ,header
                ,null
                ,null
                ,null
                ,body
                ,null);
    }

    ////////////Delete PatientResource //////////

    @Step("Delete patient")
    public Response deletePatient(String id){

        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/fhir+json; charset=UTF-8");


        return apiObject.sendRequest(ApiActions.RequestType.DELETE
                ,"/Patient/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,null
                ,null);
    }





}
