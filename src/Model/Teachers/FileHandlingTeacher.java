package Model.Teachers;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingTeacher {
    protected abstract ArrayList<Teacher> readTeacherJsonFile(String file_path);
    protected abstract void writeTeacherJsonFile(String file_path, ArrayList<Teacher> teachers) throws IOException;
}

