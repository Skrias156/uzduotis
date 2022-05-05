package baigiamasisdarbas;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDatabase {
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("persons.json");
    private List<Person> filePersons = new ArrayList<>();


    public List<Person> getAllPersons() {
        checkIfFileExist();
        if (file.length() != 0) {
            try {
                filePersons = mapper.readValue(file, new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePersons;
    }


    public void addPersonToFile(List<Person> person) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        checkIfFileExist();
        try {
            mapper.writeValue(file, person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void checkIfFileExist() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}