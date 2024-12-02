package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoImportDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class VolcanoServiceImpl implements VolcanoService {

    private static final String VOLCANOES_PATH = "src/main/resources/files/json/volcanoes.json";

    private final VolcanoRepository volcanoRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.volcanoRepository = volcanoRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return Files.readString(Path.of(VOLCANOES_PATH));
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();

        VolcanoImportDto[] volcanoImportDtos = this.gson.fromJson(readVolcanoesFileContent(), VolcanoImportDto[].class);

        for (VolcanoImportDto volcanoImportDto : volcanoImportDtos) {

            if (this.volcanoRepository.findByName(volcanoImportDto.getName()).isPresent() ||
                !this.validationUtil.isValid(volcanoImportDto)) {
                sb.append("Invalid volcano").append(System.lineSeparator());
                continue;
            }

            Volcano volcano = this.modelMapper.map(volcanoImportDto, Volcano.class);


        }

        return sb.toString();
    }

    @Override
    public String exportVolcanoes() {
        return "";
    }
}