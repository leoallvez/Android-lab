package leoallvez.com.br.androidlab.Activity;

import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.Toast;

import leoallvez.com.br.androidlab.Model.Address;
import leoallvez.com.br.androidlab.Model.Employee;
import leoallvez.com.br.androidlab.R;
import android.support.v7.app.AppCompatActivity;
import leoallvez.com.br.androidlab.Model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainActivity extends AppCompatActivity {

    private Employee employee;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void jsonToObject(View v) {

        try {
            /**
            String personJsonStr = "{\"firstname\":\"John\",\"lastname\":\"Doe\"}";
            Person person = mapper.readValue(personJsonStr, Person.class);
             */

            String employeeJsonStr = "{\"id\": 123,\"name\":\"Pankaj\"" +
                    ",\"permanent\": true,\"address\": {\"street\": \"Albany Dr\"" +
                    ",\"city\": \"San Jose\",\"zipcode\": 95129 },\"phoneNumbers\"" +
                    ": [ 123456, 987654 ],\"role\": \"Manager\", \"cities\"" +
                    ": [ \"Los Angeles\",\"New York\" ],\"properties\"" +
                    ": {\"age\": \"29 years\",\"salary\": \"1000 USD\"}}";

            employee = mapper.readValue(employeeJsonStr, Employee.class);

            Toast.makeText(this,"Employee: " + employee.toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee createEmployee() {

        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] { 123456, 987654 });
        emp.setRole("Manager");

        Address add = new Address();
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List<String> cities = new ArrayList<String>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map<String, String> props = new HashMap<String, String>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);

        return emp;
    }
}
