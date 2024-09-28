package Model.Subjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageSubject extends FileHandlingSubject {

    private ArrayList<Subject> subjects = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public manageSubject() {
        readSubjectJsonFile("src/Model/Subjects/Subjects.json");
    }

    @Override
    public ArrayList<Subject> readSubjectJsonFile(String file_path) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int subject_id = node.get("subject_id").asInt();
                    String subject_name = node.get("subject_name").asText();
                    String subject_duration = node.get("subject_duration").asText();
                    int subject_credits = node.get("subject_credits").asInt();
                    Subject c_temp = new Subject(subject_id, subject_name, subject_duration, subject_credits);
                    subjects.add(c_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return subjects;
    }

    @Override
    public void writeSubjectJsonFile(String file_path, ArrayList<Subject> subjects) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), subjects);
    }

    public ArrayList<Subject> getTable() {
        return subjects;
    }
}


