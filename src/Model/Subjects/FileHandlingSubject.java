package Model.Subjects;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingSubject {
    protected abstract ArrayList<Subject> readSubjectJsonFile(String file_path);
    protected abstract void writeSubjectJsonFile(String file_path, ArrayList<Subject> subjects) throws IOException;
}

