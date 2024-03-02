package kdima90.openschool.school.service;

import kdima90.openschool.school.entity.School;
import kdima90.openschool.school.repository.SchoolRepository;
import kdima90.openschool.school.request.entity.SchoolRequestEntity;
import kdima90.openschool.school.response.SchoolResponseEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolServiceImpl implements SchoolService{
  private final ConversionService conversionService;
  private final SchoolRepository schoolRepository;

  public SchoolServiceImpl(ConversionService conversionService, SchoolRepository schoolRepository) {
    this.conversionService = conversionService;
    this.schoolRepository = schoolRepository;
  }

  @Transactional
  @Override
  public SchoolResponseEntity save(SchoolRequestEntity schoolRequestEntity) {
    School entity = conversionService.convert(schoolRequestEntity, School.class);
    schoolRepository.save(entity);
    return conversionService.convert(schoolRepository.save(entity), SchoolResponseEntity.class);
  }
}