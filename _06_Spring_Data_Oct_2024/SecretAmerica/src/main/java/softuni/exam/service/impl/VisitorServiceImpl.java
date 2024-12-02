package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.VisitorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//ToDo - Implement all the methods

@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String PATH = "src/main/resources/files/xml/visitors.xml";

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public boolean areImported() {
        return this.visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {

        return Files.readString(Path.of(PATH));
    }

    @Override
    public String importVisitors() {
        return null;
    }
}
