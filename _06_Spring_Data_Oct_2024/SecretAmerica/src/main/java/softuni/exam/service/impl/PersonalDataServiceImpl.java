package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.service.PersonalDataService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//ToDo - Implement all the methods

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    private static final String PATH = "src/main/resources/files/xml/personal_data.xml";

    private final PersonalDataRepository personalDataRepository;

    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    @Override
    public boolean areImported() {
        return this.personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return Files.readString(Path.of(PATH));
    }

    @Override
    public String importPersonalData() {
        return null;
    }
}
