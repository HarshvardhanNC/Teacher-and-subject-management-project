package Model.Teachers;

import Model.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageTeacher extends FileHandlingTeacher implements Displayable {

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageTeacher(){
        readTeacherJsonFile("src/Model/Teachers/Teachers.json");
    }
    public ArrayList<Teacher> readTeacherJsonFile(String file_path)
    {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int teacher_id = node.get("teacher_id").asInt();
                    String fname = node.get("fname").asText();
                    String lname = node.get("lname").asText();
                    String email = node.get("email").asText();
                    String address = node.get("address").asText();
                    String mobile = node.get("mobile").asText();
                    double cet_percentage = node.get("cet_percentage").asDouble();
                    Teacher stud = new Teacher(teacher_id, cet_percentage, fname, lname, email, address, mobile);
                    teachers.add(stud);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }
    public void writeTeacherJsonFile(String file_path, ArrayList<Teacher> teachers) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Teachers/teachers.json").toFile(), teachers);
        objectMapper.writeValue(Paths.get(file_path).toFile(), teachers);
    }

    public void setTeachersTable(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("First Name");
        headers.add("Last Email");
        headers.add("Email");
        headers.add("Address");
        headers.add("Mobile");
        headers.add("CET Percentage");

        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> teacher_details = new ArrayList<String>();

        teacher_details.add(String.valueOf(teachers.get(line).getTeacher_id()));
        teacher_details.add(teachers.get(line).getFname());
        teacher_details.add(teachers.get(line).getLname());
        teacher_details.add(teachers.get(line).getEmail());
        teacher_details.add(teachers.get(line).getAddress());
        teacher_details.add(teachers.get(line).getMobile());
        teacher_details.add(String.valueOf(teachers.get(line).getCet_percentage()));

        return teacher_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> teachers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            teachers_subset.add(getLine(i));
        }
        return teachers_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Teacher> getTable() {
        return teachers;
    }
}


