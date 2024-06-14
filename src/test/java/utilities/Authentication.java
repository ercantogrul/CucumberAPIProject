package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.CreateUserBySeleniumStepDefinitions.email;
import static stepdefinitions.CreateUserBySeleniumStepDefinitions.password;

public class Authentication {



    public static String generateToken() {

        Map<String, String> payload = new HashMap<>();

        if (email != null) {//Eğer selenium ile user oluşturulursa email null kalmaz.
            payload.put("email", email);
            payload.put("password", password);
        } else {//User oluşturulmadıysa clarusway kullanıcısı ile token alınacak
            payload.put("email", "clarusway_96@hotmail.com");
            payload.put("password", "Clarusway.1234");
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        //response.prettyPrint();

        try {//Default olarak alınan alınamadığı taktirde exceptiın'ı handle etmek için kullanıyoruz.
            return response.jsonPath().getString("token");
        } catch (Exception e) {
            System.err.println("Token alınamadı");
            return "";
        }

    }

    public static String contactListToken2() { // contactList de token üretmenin ikinci yolu

        if (email != null) {//Eğer user create edilirse bu use'ın direkt token'ı alınabilir

            return email;//Bu user'ın token'ını dön

        } else {
            Map<String, String> payload = new HashMap<>();
            payload.put("email", "clarusway_91@hotmail.com");
            payload.put("password", "Clarusway.1234");

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
            //response.prettyPrint();

            try {//Default olarak alınan alınamadığı taktirde exceptiın'ı handle etmek için kullanıyoruz.
                return response.jsonPath().getString("token");
            } catch (Exception e) {
                System.out.println("Token alınamadı");
                return "Token alınamadı";
            }

        }

    }





}